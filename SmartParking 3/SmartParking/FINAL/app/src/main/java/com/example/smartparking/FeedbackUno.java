package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FeedbackUno extends AppCompatActivity {

    Button next6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_uno);

        next6 = (Button)findViewById(R.id.siguiente6);

        next6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next6 = new Intent(FeedbackUno.this, MainActivity.class);
                startActivity(next6);
            }
        });
    }
}
