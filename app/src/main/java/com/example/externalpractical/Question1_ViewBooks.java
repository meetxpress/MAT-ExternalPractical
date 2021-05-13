package com.example.externalpractical;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Question1_ViewBooks extends AppCompatActivity {
    ArrayList<Student> students;
    DatabaseReference databaseStudent;
    ListView lvDisplay;
    private static final String sId = "com.example.externalpractical.sId";
    private static final String sName = "com.example.externalpractical.sName";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1__view_books);
        lvDisplay = findViewById(R.id.lvDisyplay);
    }
    @Override
    protected void onStart() {
        super.onStart();
        databaseStudent.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                students.clear();
                for (DataSnapshot postSnapshots : snapshot.getChildren()) {
                    Student st = postSnapshots.getValue(Student.class);
                    students.add(st);
                    StudentList stli = new StudentList(Question1_ViewBooks.this, students);
                    lvDisplay.setAdapter(stli);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}