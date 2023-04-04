package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class java extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        Button button1 = findViewById(R.id.b2);
        button1.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.b2:
                Toast.makeText(this,"JAVA", Toast.LENGTH_LONG).show();
                Intent b = new Intent(java.this, Sum.class);
                startActivity(b);
                break;}




        }
    }
