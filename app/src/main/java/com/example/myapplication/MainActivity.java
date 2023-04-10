package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    TextView tview ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseApp.initializeApp(this);

        setContentView(R.layout.activity_main);
        Button button1 = findViewById(R.id.java);
        Button button2 = findViewById(R.id.python);
        Button button3 = findViewById(R.id.c);
        Button button4 = findViewById(R.id.pattern);
        tview = findViewById(R.id.t);

        List<String> data = new ArrayList<>();

        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        firestore.collection("JAVA").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    for (QueryDocumentSnapshot documentSnapshot : task.getResult()){
                        data.add(documentSnapshot.get("CODE").toString());
                    }
                    tview.setText(data.get(0));
                }else{
                    Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
            }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.java:
                Toast.makeText(this,"JAVA", Toast.LENGTH_LONG).show();
                Intent b = new Intent(MainActivity.this, java.class);
                startActivity(b);
                break;

                case R.id.c:
                Toast.makeText(this,"C",Toast.LENGTH_LONG).show();
                Intent a = new Intent(MainActivity.this, c.class);
                startActivity(a);
                break;

                case R.id.pattern:
                Toast.makeText(this, "PATTERN",Toast.LENGTH_LONG).show();
                Intent c = new Intent(MainActivity.this, pattern.class);
                startActivity(c);
                break;

                case R.id.python:
                Toast.makeText(this,"PYTHON",Toast.LENGTH_LONG).show();
                Intent d = new Intent(MainActivity.this, python.class);
                startActivity(d);
                break;

    }
    }}