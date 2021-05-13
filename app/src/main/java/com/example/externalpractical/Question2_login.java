package com.example.externalpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Question2_login extends AppCompatActivity {

    EditText q2Username, q2Password;
    Button q2btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2_login);

        q2Username = findViewById(R.id.q2Username);
        q2Password = findViewById(R.id.q2Password);
        q2btnLogin = findViewById(R.id.q2btnLogin);

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        q2btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (q2Username.getText().toString().equals("") || q2Password.getText().toString().equals("")) {
                    Toast.makeText(Question2_login.this, "Enter values to login.", Toast.LENGTH_SHORT).show();
                } else {
                    if (q2Username.getText().toString().equals("1") && q2Password.getText().toString().equals("1")) {
                        myEdit.putString("user", q2Username.getText().toString());
                        myEdit.apply();
                        startActivity(new Intent(getApplicationContext(), Question2_Dashboard.class));
                        Toast.makeText(Question2_login.this, "Welcome User!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Question2_login.this, "Invalid Username and Password.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}