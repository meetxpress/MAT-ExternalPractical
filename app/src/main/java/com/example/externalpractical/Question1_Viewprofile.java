package com.example.externalpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Question1_Viewprofile extends AppCompatActivity {
    EditText up_q1name, up_q1email, up_q1pass;
    Button up_q1btnUpdate, up_q1btnDelete;

    DatabaseReference databaseStudent;
    private static final String sId = "com.example.externalpractical.sId";
    private static final String sName = "com.example.externalpractical.sName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1__viewprofile);

        up_q1name = findViewById(R.id.up_q1name);
        up_q1email = findViewById(R.id.up_q1email);
        up_q1pass = findViewById(R.id.up_q1pass);
        up_q1btnDelete = findViewById(R.id.up_q1btnDelete);
        up_q1btnUpdate = findViewById(R.id.up_q1btnUpdate);
        databaseStudent = FirebaseDatabase.getInstance().getReference("students");

        up_q1btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                up_q1name.setText("");
                up_q1email.setText("");
                up_q1pass.setText("");
                Toast.makeText(getApplicationContext(), "Record Updated", Toast.LENGTH_SHORT).show();
            }
        });

        up_q1btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference rf = FirebaseDatabase.getInstance().getReference("students").child(sId);
                rf.removeValue();
                Toast.makeText(getApplicationContext(), "Record Deleted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}