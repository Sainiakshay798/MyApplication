package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Helloworld extends AppCompatActivity implements View.OnClickListener {
    TextView tview2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_helloworld);
        tview2 = findViewById(R.id.texthello);
        List<String> data2 = new ArrayList<>();
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
  firestore.collection("JAVA").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
      @Override
      public void onComplete(@NonNull Task<QuerySnapshot> task) {
          if (task.isSuccessful()) {
              for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                  data2.add(documentSnapshot.get("CODE2").toString());
              }
              tview2.setText(data2.get(0));
          } else {
              Toast.makeText(Helloworld.this, "error", Toast.LENGTH_SHORT).show();


          }





      }
  });

    }











    @Override
    public void onClick(View v) {

    }
}