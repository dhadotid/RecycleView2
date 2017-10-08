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
import com.example.dhadotid.recycleview.Model.DataModel;

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
    ArrayList<DataModel> data = new ArrayList<>();
    RecycleViewAdapter recycleViewAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);

        ButterKnife.bind(this);

        getData();
    }

    private void setAdapter(){
        recycleViewAdapter = new RecycleViewAdapter(this, data);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        rcv.setItemAnimator(new DefaultItemAnimator());
        rcv.setAdapter(recycleViewAdapter);
    }

    private void getData(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://apitodolist.rsypj.com/getalldata", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray arr = new JSONArray(response);
                    if (arr.length() > 0) {
                        for (int a = 0; a < arr.length(); a++) {
                            JSONObject obj = arr.getJSONObject(a);

                            int id = obj.getInt("id");
                            String task = obj.getString("task");
                            long deadline = obj.getLong("deadline");
                            long createdTime = obj.getLong("created_time");
                            int status = obj.getInt("status");

                            data.add(new DataModel(id, task, deadline, createdTime, status));
                        }
                        setAdapter();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if(error instanceof TimeoutError){
                    Toast.makeText(getApplicationContext(), "Timeout. Check your connection", Toast.LENGTH_LONG).show();
                } else if (error instanceof NoConnectionError) {
                    Toast.makeText(getApplicationContext(), "Please turn on your connectivity", Toast.LENGTH_LONG).show();
                } else if (error instanceof AuthFailureError) {
                    Toast.makeText(getApplicationContext(), "Authentication Error", Toast.LENGTH_LONG).show();
                } else if (error instanceof ServerError) {
                    Toast.makeText(getApplicationContext(), "Server Error", Toast.LENGTH_LONG).show();
                } else if (error instanceof NetworkError) {
                    Toast.makeText(getApplicationContext(), "Network Error", Toast.LENGTH_LONG).show();
                } else if (error instanceof ParseError) {
                    Toast.makeText(getApplicationContext(), "Parse Error", Toast.LENGTH_LONG).show();
                }
            }
        });
        requestQueue.add(stringRequest);
    }
}
