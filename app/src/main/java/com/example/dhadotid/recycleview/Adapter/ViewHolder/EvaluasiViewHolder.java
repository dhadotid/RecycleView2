package com.example.dhadotid.recycleview.Adapter.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.dhadotid.recycleview.Adapter.listener.BodyListener;
import com.example.dhadotid.recycleview.Model.EvaluasiModel;
import com.example.dhadotid.recycleview.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dhadotid on 08/10/2017.
 */

public class EvaluasiViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.evaluasi_activity_custom_tvsoal)TextView soal;
    @BindView(R.id.evaluasi_activity_custom_rbjawabana)RadioButton jawabana;
    @BindView(R.id.evaluasi_activity_custom_rbjawabanb)RadioButton jawabanb;
    @BindView(R.id.evaluasi_activity_custom_rbjawabanc)RadioButton jawabanc;
    @BindView(R.id.evaluasi_activity_custom_rg)RadioGroup rg;

    BodyListener listener;

    EvaluasiModel data;

    public EvaluasiViewHolder(View view, BodyListener listener){
        super(view);
        ButterKnife.bind(this, view);

        this.listener = listener;
    }

    public void setupUI(EvaluasiModel data){
        this.data = data;

        soal.setText("" + data.getPertanyaan());
        jawabana.setText("" + data.getJawabana());
        jawabanb.setText("" + data.getJawabanb());
        jawabanc.setText("" + data.getJawabanc());
    }

    @OnClick(R.id.evaluasi_activity_custom_rbjawabana)
    void rbJawabanAClicked() {
        sendDataToUI(jawabana.getText().toString());
    }

    @OnClick(R.id.evaluasi_activity_custom_rbjawabanb)
    void rbJawabanBClicked() {
        sendDataToUI(jawabanb.getText().toString());
    }

    @OnClick(R.id.evaluasi_activity_custom_rbjawabanc)
    void rbJawabanCClicked() {
        sendDataToUI(jawabanc.getText().toString());
    }

    private void sendDataToUI(String jawaban) {
        listener.onRadioButtonClicked(data.getIdevaluasi(), jawaban);
    }
}
