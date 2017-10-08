package com.example.dhadotid.recycleview.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dhadotid.recycleview.Adapter.ViewHolder.EvaluasiViewHolder;
import com.example.dhadotid.recycleview.Adapter.ViewHolder.RecycleViewAdapterViewHolder;
import com.example.dhadotid.recycleview.Adapter.ViewHolder.SubmitViewHolder;
import com.example.dhadotid.recycleview.Adapter.listener.BodyListener;
import com.example.dhadotid.recycleview.Adapter.listener.SubmitButtonListener;
import com.example.dhadotid.recycleview.Model.EvaluasiModel;
import com.example.dhadotid.recycleview.R;
import com.example.dhadotid.recycleview.constant.Constant;

import java.util.ArrayList;

/**
 * Created by dhadotid on 08/10/2017.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<EvaluasiModel> data;
    SubmitButtonListener listener;
    BodyListener bodyListener;

    public RecycleViewAdapter(Context context, ArrayList<EvaluasiModel> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == data.size()) {
            return Constant.TAG_FOOTER;
        }
        else {
            return Constant.TAG_BODY;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == Constant.TAG_BODY) {
            View view = LayoutInflater.from(context).inflate(R.layout.custom_soal, null);
            return new EvaluasiViewHolder(view, bodyListener);
        }
        else {
            View view = LayoutInflater.from(context).inflate(R.layout.custom_button, null);
            return new SubmitViewHolder(view, listener);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof EvaluasiViewHolder){
            EvaluasiModel dataModel = data.get(position);

            ((EvaluasiViewHolder) holder).setupUI(dataModel);
        }
    }

    @Override
    public int getItemCount() {
        return data.size() + 1;
    }

    public void buttonListener(SubmitButtonListener listener) {
        this.listener = listener;
    }

    public void itemListener(BodyListener bodyListener) {
        this.bodyListener = bodyListener;
    }
}
