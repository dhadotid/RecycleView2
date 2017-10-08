package com.example.dhadotid.recycleview.Adapter.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dhadotid.recycleview.Adapter.listener.SubmitButtonListener;
import com.example.dhadotid.recycleview.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by HateLogcatError on 10/8/2017.
 */

public class SubmitViewHolder extends RecyclerView.ViewHolder {

    SubmitButtonListener listener;

    public SubmitViewHolder(View itemView, SubmitButtonListener listener) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        this.listener = listener;
    }

    @OnClick(R.id.evaluasi_activity_custom_btnsubmit)
    void onSubmit() {
        listener.onButtonClicked();
    }
}