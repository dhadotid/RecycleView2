package com.example.dhadotid.recycleview.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dhadotid.recycleview.Adapter.ViewHolder.RecycleViewAdapterViewHolder;
import com.example.dhadotid.recycleview.Model.DataModel;
import com.example.dhadotid.recycleview.R;

import java.util.ArrayList;

/**
 * Created by dhadotid on 08/10/2017.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<DataModel> data;

    public RecycleViewAdapter(Context context, ArrayList<DataModel> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_todo, null);


        return new RecycleViewAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof RecycleViewAdapterViewHolder){
            DataModel dataModel = data.get(position);

            ((RecycleViewAdapterViewHolder) holder).setUI(dataModel);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
