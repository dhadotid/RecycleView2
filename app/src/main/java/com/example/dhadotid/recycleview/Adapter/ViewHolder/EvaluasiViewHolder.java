package com.example.dhadotid.recycleview.Adapter.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.dhadotid.recycleview.Model.EvaluasiModel;
import com.example.dhadotid.recycleview.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dhadotid on 08/10/2017.
 */

public class EvaluasiViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.evaluasi_activity_custom_tvsoal)TextView soal;
    @BindView(R.id.evaluasi_activity_custom_rbjawabana)RadioButton jawabana;
    @BindView(R.id.evaluasi_activity_custom_rbjawabanb)RadioButton jawabanb;
    @BindView(R.id.evaluasi_activity_custom_rbjawabanc)RadioButton jawabanc;
    @BindView(R.id.evaluasi_activity_custom_rg)RadioGroup rg;

    public EvaluasiViewHolder(View view){
        super(view);
        ButterKnife.bind(this, view);
    }

    public void setupUI(EvaluasiModel data){
        soal.setText("" + data.getPertanyaan());
        jawabana.setText("" + data.getJawabana());
        jawabanb.setText("" + data.getJawabanb());
        jawabanc.setText("" + data.getJawabanc());
    }
}
