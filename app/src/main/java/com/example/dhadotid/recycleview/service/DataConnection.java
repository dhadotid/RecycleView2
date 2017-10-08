package com.example.dhadotid.recycleview.service;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dhadotid.recycleview.Model.EvaluasiModel;
import com.example.dhadotid.recycleview.service.listener.DataListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by HateLogcatError on 10/8/2017.
 */

public class DataConnection {

    Context context;

    ArrayList<EvaluasiModel> data = new ArrayList<>();

    public DataConnection(Context context) {
        this.context = context;
    }

    public void onRequestDataConnection(final DataListener listener) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://komandro.com/k-aus/service.php?pilihan=4&id=1", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray arr = new JSONArray(response);
                    for (int a = 0; a < arr.length(); a++) {
                        JSONObject job = arr.getJSONObject(a);
                        int idevaluasi = job.getInt("id_evaluasi");
                        int idinformasi = job.getInt("id_informasi");
                        String pertanyaan = job.getString("pertanyaan");
                        String jawabana = job.getString("jawaban_a");
                        String jawabanb = job.getString("jawaban_b");
                        String jawabanc = job.getString("jawaban_c");
                        String jawabanbenar = job.getString("jawaban_benar");

                        data.add(new EvaluasiModel(idevaluasi, idinformasi, pertanyaan, jawabana, jawabanb, jawabanc, jawabanbenar));
                    }

                    if(data.size() > 0) {
                        listener.onDataSuccessLoaded(data);
                    }
                    else {
                        listener.onDataFailedLoaded();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onError(error.getMessage());
            }
        });
        requestQueue.add(stringRequest);
    }
}
