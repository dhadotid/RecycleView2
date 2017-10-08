package com.example.dhadotid.recycleview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dhadotid.recycleview.Adapter.RecycleViewAdapter;
import com.example.dhadotid.recycleview.Adapter.listener.BodyListener;
import com.example.dhadotid.recycleview.Adapter.listener.SubmitButtonListener;
import com.example.dhadotid.recycleview.Model.EvaluasiModel;
import com.example.dhadotid.recycleview.service.DataConnection;
import com.example.dhadotid.recycleview.service.listener.DataListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dhadotid on 08/10/2017.
 */

public class RecycleViewActivity extends AppCompatActivity {

    @BindView(R.id.recycleview_activity_rv)
    RecyclerView rcv;

    ArrayList<EvaluasiModel> data = new ArrayList<>();
    RecycleViewAdapter recycleViewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);

        ButterKnife.bind(this);

        setAdapter();

        DataConnection connection = new DataConnection(this);
        connection.onRequestDataConnection(new DataListener() {
            @Override
            public void onDataSuccessLoaded(ArrayList<EvaluasiModel> data) {
                RecycleViewActivity.this.data.addAll(data);

                recycleViewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onDataFailedLoaded() {

            }

            @Override
            public void onError(String message) {

            }
        });
    }

    private void setAdapter(){
        recycleViewAdapter = new RecycleViewAdapter(this, data);
        recycleViewAdapter.buttonListener(new SubmitButtonListener() {
            @Override
            public void onButtonClicked() {
                Toast.makeText(RecycleViewActivity.this, "Yoi bro", Toast.LENGTH_SHORT).show();
            }
        });
        recycleViewAdapter.itemListener(new BodyListener() {
            @Override
            public void onRadioButtonClicked(int idSoal, String jawaban) {
                Toast.makeText(RecycleViewActivity.this, "" + jawaban, Toast.LENGTH_SHORT).show();
            }
        });

        rcv.setLayoutManager(new LinearLayoutManager(this));
        rcv.setItemAnimator(new DefaultItemAnimator());
        rcv.setAdapter(recycleViewAdapter);
    }
}
