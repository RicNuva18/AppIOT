package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FeedbackTres extends AppCompatActivity {

    Button next13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_tres);

        //PARA SEGUIR
        next13 = (Button)findViewById(R.id.siguiente13);

        next13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next13 = new Intent(FeedbackTres.this, MainActivity.class);
                startActivity(next13);
            }
        });
    }
}
