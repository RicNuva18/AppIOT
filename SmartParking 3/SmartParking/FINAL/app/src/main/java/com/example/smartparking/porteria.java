package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class porteria extends AppCompatActivity {

    Button volver2;
    Button next2;
    private  Button lateral1;
    private  Button principal1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porteria);



        //PARA VOLVER
        volver2 = (Button)findViewById(R.id.back2);

        volver2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver2 = new Intent(porteria.this, QueDeseoHacer.class);
                startActivity(volver2);
            }
        });


        //PARA SEGUIR

        next2 = (Button)findViewById(R.id.siguiente2);

        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next2 = new Intent(porteria.this, SeleccionarZonaParqueo.class);
                startActivity(next2);
            }
        });

        //PARA LATERAL
        lateral1 = (Button)findViewById(R.id.lateral);

        lateral1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lateral1.setBackground(getDrawable(R.drawable.rounded_yellow_button));

                principal1.setBackground(getDrawable(R.drawable.rounded_white_button));
            }
        });

        //PARA PRINCIPAL
        principal1 = (Button)findViewById(R.id.principal);

        principal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                principal1.setBackground(getDrawable(R.drawable.rounded_yellow_button));
                lateral1.setBackground(getDrawable(R.drawable.rounded_white_button));

            }
        });

            }




    }

