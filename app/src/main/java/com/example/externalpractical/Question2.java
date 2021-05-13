package com.example.externalpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class Question2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                String sp = sharedPreferences.getString("user", "");
                if (sp.equals("")) {
                    startActivity(new Intent(getApplicationContext(), Question2_login.class));
                } else {
                    startActivity(new Intent(getApplicationContext(), Question2_Dashboard.class));
                }
                finish();
            }
        }, 300);
    }
}