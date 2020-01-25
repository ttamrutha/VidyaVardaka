package com.example.vidyavardaka;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText editTextUserMail,editTextUserPwd;
ImageView imageView;
Button buttonLog;
SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        editTextUserMail=findViewById(R.id.editTextEmailId);
        editTextUserPwd=findViewById(R.id.editTextPassword);
        buttonLog=findViewById(R.id.buttonLog);
        buttonLog.setOnClickListener(this);
        imageView=findViewById(R.id.imageView);
        sharedPreferences=getSharedPreferences("userLogData",MODE_PRIVATE);
       /* buttonLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail=editTextUserMail.getText().toString();
                String userPwd=editTextUserPwd.getText().toString();
                if(userEmail.indexOf("@")!=-1&&userPwd.length()>5)
                {
                    Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });*/
    }

    @Override
    public void onClick(View v) {
      /*  String userEmail = editTextUserMail.getText().toString();
        String userPwd = editTextUserPwd.getText().toString();

        if(userEmail.indexOf("@")!=-1&&userPwd.length()>5)
        {
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putBoolean("isLog",true);
            editor.apply();
            Intent intent=new Intent(MainActivity.this,HomeActivity.class);
           intent.putExtra("userName",userEmail.substring(0,userEmail.indexOf("@")));
            startActivity(intent);
            finish();
        }
        else
        {
            Toast.makeText(this, "Invalid data's", Toast.LENGTH_SHORT).show();
        }*/
       /* Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);*/


   /* public void checkLogData(View view) {
        String userEmail=editTextUserMail.getText().toString();
        String userPwd=editTextUserPwd.getText().toString();
        if(userEmail.indexOf("@")!=-1&&userPwd.length()>5)
        {
            Intent intent=new Intent(MainActivity.this,HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }*/

       Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, 1);   
    }

 @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==RESULT_OK)
        {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show();

    }
}
