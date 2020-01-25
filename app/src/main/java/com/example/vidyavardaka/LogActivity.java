package com.example.vidyavardaka;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class LogActivity extends AppCompatActivity {
    EditText editTextUserName, editTextPassword;
    String userName,password;
    Context context;
    Button signButton,signupButton;
    String url="http://192.168.1.16:8080/VidyaVardaka2/Res/SampleResponse.jsp";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        init();
        eventListener();
    }

    private void init() {
        context=this;
        editTextPassword=findViewById(R.id.editTextPassword);
        editTextUserName=findViewById(R.id.editTextName);
        signButton=findViewById(R.id.buttonLogIn);
        signupButton=findViewById(R.id.buttonRegister);
    }

    private void eventListener() {

        signButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                userName=editTextUserName.getText().toString();
                password=editTextPassword.getText().toString();
                if(validate(userName,password))
                {
                    checkCredentials(userName,password);
                }
                else
                {
                    Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LogActivity.this, RecylerActivity.class));

            }
        });
    }

    private void checkCredentials(final String userName, final String password) {
        final ProgressDialog dialog = ProgressDialog.show(LogActivity.this, null, "LOADING..");

        StringRequest strReq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(LogActivity.this, response, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    int rs = jsonObject.getInt("status");
                    Log.d("Response:",rs+"");
                    if(Integer.parseInt(rs+"".trim())==1) {
                        int userId = jsonObject.getInt("userId");
                        processResponse(userId);

                    }
                    else
                    {
                        Toast.makeText(LogActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ErrorInVolley",error.getMessage());
                Toast.makeText(getApplicationContext(),
                        "Network error! Check your internet connection!" + error.getMessage(),
                        Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("user_name", userName);
                params.put("password", password);

                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(strReq);
    }

    private void processResponse(int rs) {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("StudentDetails", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("student_id",Integer.parseInt(rs+"".trim()));
        editor.commit();
            startActivity(new Intent(LogActivity.this, RecylerActivity.class));
            finish();




}

    private boolean validate(String userName,String password) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern ptr = Pattern.compile(emailRegex);
        boolean flag=false;
        if(userName!=null &&password.length()>5)
        {
          if(!ptr.matcher(userName).matches())
          {
              editTextUserName.setError("Invalid mail id");
          }
          else
          {
              flag=true;
          }
        }
        return  flag;

    }

}
