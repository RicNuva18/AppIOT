package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QueDeseoHacer extends AppCompatActivity {

    Button volver;
    Button next;   //parquear
    Button salir1; //salir

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_que_deseo_hacer);


        //PARA PARQUEAR
        next = (Button)findViewById(R.id.parquear);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siguiente = new Intent(QueDeseoHacer.this, porteria.class);
                startActivity(siguiente);
            }
        });

        //PARA VOLVER
        volver = (Button)findViewById(R.id.atras);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver = new Intent(QueDeseoHacer.this, IniciarSesion.class);
                startActivity(volver);
            }
        });

        //PARA SALIR
        salir1 = (Button)findViewById(R.id.salir);

        salir1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent salir1 = new Intent(QueDeseoHacer.this, SeleccionarDestino.class);
                startActivity(salir1);
            }
        });


        /*//PARA PARQUEAR
        parquear1 = (Button)findViewById(R.id.lateral);

        parquear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parquear1.setBackground(getDrawable(R.drawable.rounded_yellow_button));
            }
        });*/


    }
}
