package com.example.vidyavardaka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CheckCacheActivity extends AppCompatActivity {
   public  static  String URL="http://192.168.1.16:8080/HealthCare/user/Sample.jsp";
   Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_cache);
        button=findViewById(R.id.buttonRequest);

    }

    public void requestVolley(View view) {
        Toast.makeText(this, "Button ", Toast.LENGTH_SHORT).show();
        requestVolleyLib();
    }

    private void requestVolleyLib() {
        Toast.makeText(this, "Button1 ", Toast.LENGTH_SHORT).show();

        StringRequest strReq = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(CheckCacheActivity.this,"Responsed"+ response, Toast.LENGTH_SHORT).show();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ErrorInVolley",error.getMessage());
                Toast.makeText(getApplicationContext(),
                        "Network error! Check your internet connection!" + error.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        }) ;

        RequestQueue resRequestQueue= Volley.newRequestQueue(this);
        resRequestQueue.start();
        resRequestQueue.add(strReq);
    }
}
