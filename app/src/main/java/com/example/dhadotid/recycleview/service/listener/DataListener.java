package com.example.dhadotid.recycleview.service.listener;

import com.example.dhadotid.recycleview.Model.EvaluasiModel;

import java.util.ArrayList;

/**
 * Created by HateLogcatError on 10/8/2017.
 */

public interface DataListener {
    void onDataSuccessLoaded(ArrayList<EvaluasiModel> data);
    void onDataFailedLoaded();
    void onError(String message);
}
