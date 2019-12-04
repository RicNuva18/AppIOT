package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FeedbackDos extends AppCompatActivity {

    Button next12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_dos);

        next12 = (Button)findViewById(R.id.siguiente12);

        next12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next12 = new Intent(FeedbackDos.this, QueDeseoHacer.class);
                startActivity(next12);
            }
        });
    }
}
