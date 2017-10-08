package com.example.dhadotid.recycleview.Adapter.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.dhadotid.recycleview.Model.EvaluasiModel;
import com.example.dhadotid.recycleview.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dhadotid on 08/10/2017.
 */

public class RecycleViewAdapterViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.todo_custom_task)
    TextView task;
    @BindView(R.id.todo_custom_createdat)
    TextView createdat;
    @BindView(R.id.todo_custom_deadline)
    TextView deadline;

    public RecycleViewAdapterViewHolder(View view){
        super(view);
        ButterKnife.bind(this, view);
    }

    private String getTanggal(long tanggal){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MMMM/yyyy", Locale.US);
        return simpleDateFormat.format(new Date(tanggal));
    }

    public void setUI(EvaluasiModel data){

    }
}
