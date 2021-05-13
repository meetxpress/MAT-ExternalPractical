package com.example.externalpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Question1_dashboard extends AppCompatActivity {
    Button q1ViewProfile, q1ViewBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1_dashboard);

        q1ViewProfile = findViewById(R.id.q1ViewProfile);
        q1ViewBooks = findViewById(R.id.q1ViewBooks);

        q1ViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Question1_Viewprofile.class));
            }
        });

        q1ViewBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Question1_ViewBooks.class));
            }
        });
    }
}