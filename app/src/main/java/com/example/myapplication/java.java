package com.example.myapplication;


import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;


public class java extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_java);
        Button button1 = findViewById(R.id.b2);
        Button button2 = findViewById(R.id.b3);
        Button button3 = findViewById(R.id.b4);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.b2:
                Toast.makeText(this,"SUM", Toast.LENGTH_LONG).show();
                Intent b = new Intent(java.this, Sum.class);
                startActivity(b);
                break;

        case R.id.b3:
        Toast.makeText(this,"PRIME", Toast.LENGTH_LONG).show();
        Intent c = new Intent(java.this, Prime.class);
        startActivity(c);
        break;

            case R.id.b4:
                Toast.makeText(this,"Hello world", Toast.LENGTH_LONG).show();
                Intent d = new Intent(java.this, Helloworld.class);
                startActivity(d);
                break;






        }


        }
    }
