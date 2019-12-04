package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Registrarse extends AppCompatActivity {

    Button volver11;
    Button next11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);


        //PARA VOLVER
        volver11 = (Button)findViewById(R.id.back11);

        volver11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver11 = new Intent(Registrarse.this, MainActivity.class);
                startActivity(volver11);
            }
        });

        //PARA SEGUIR
        next11 = (Button)findViewById(R.id.siguiente11);

        next11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next11 = new Intent(Registrarse.this, FeedbackDos.class);
                startActivity(next11);
            }
        });
    }
}
