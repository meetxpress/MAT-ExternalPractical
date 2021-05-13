package com.example.externalpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Question1 extends AppCompatActivity {
    EditText q1name, q1email, q1pass, q1book;
    Button q1btnRegister, q1btnNav;
    ArrayList<Student> students;
    DatabaseReference databaseStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        q1name = findViewById(R.id.q1name);
        q1email = findViewById(R.id.q1email);
        q1pass = findViewById(R.id.q1pass);
        q1book = findViewById(R.id.q1book);
        q1btnRegister = findViewById(R.id.q1btnRegister);
        q1btnNav = findViewById(R.id.q1btnNav);

        students = new ArrayList<Student>();
        databaseStudent = FirebaseDatabase.getInstance().getReference("students");

        q1btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stname = q1name.getText().toString();
                String stemail = q1email.getText().toString();
                String stpass = q1pass.getText().toString();
                String stbook = q1book.getText().toString();

                if (!TextUtils.isEmpty(stname)) {
                    String stid = databaseStudent.push().getKey();
                    Student student = new Student(stid, stname, stemail, stpass, stbook);

                    databaseStudent.child(stid).setValue(student);
                    q1name.setText("");
                    q1email.setText("");
                    q1pass.setText("");
                    q1book.setText("");
                    Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), Question1_login.class));
                } else{
                    Toast.makeText(getApplicationContext(), "Enter Details", Toast.LENGTH_SHORT).show();
                }
            }
        });

        q1btnNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Question1_login.class));
            }
        });
    }
}