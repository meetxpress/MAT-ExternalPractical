package com.example.externalpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Question1_login extends AppCompatActivity {

    EditText q1LoginUsername, q1LoginPassword;
    Button q1btnLogin;
    DatabaseReference databaseStudent;
    private static final String sId = "com.example.externalpractical.sId";
    private static final String sName = "com.example.externalpractical.sName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1_login);

        q1LoginUsername = findViewById(R.id.q1LoginUsername);
        q1LoginPassword = findViewById(R.id.q1LoginPassword);
        q1btnLogin = findViewById(R.id.q1btnLogin);
        databaseStudent = FirebaseDatabase.getInstance().getReference("students");

        q1btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (q1LoginUsername.getText().toString().equals("") || q1LoginPassword.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter Details", Toast.LENGTH_SHORT).show();
                } else {
                    //DatabaseReference logstd = databaseStudent.child("sId");
                    startActivity(new Intent(getApplicationContext(), Question1_dashboard.class));
                }
            }
        });
    }
}