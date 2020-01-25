package com.example.vidyavardaka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
TextView textView;
SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textView=findViewById(R.id.textViewUserName);
        sharedPreferences=getSharedPreferences("userLogData",MODE_PRIVATE);

       /* Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            String userName=bundle.getString("userName");
            textView.setText(userName);
        }
        else
        {
            Toast.makeText(this, "No Data found", Toast.LENGTH_SHORT).show();
        }*/

    }

    @Override
    protected void onStart() {
        super.onStart();
        boolean flag=sharedPreferences.getBoolean("isLog",false);
        if(!flag)
        {
            Intent intent=new Intent(HomeActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
