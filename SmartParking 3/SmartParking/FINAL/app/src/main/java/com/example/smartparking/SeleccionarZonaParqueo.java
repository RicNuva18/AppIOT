package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SeleccionarZonaParqueo extends AppCompatActivity {

    Button volver3;
    ImageButton zona5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_zona_parqueo);


        //PARA VOLVER
        volver3 = (Button)findViewById(R.id.back3);

        volver3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver3 = new Intent(SeleccionarZonaParqueo.this, porteria.class);
                startActivity(volver3);
            }
        });

        //PARA SELECCIONAR ZONA
        zona5 = (ImageButton) findViewById(R.id.zonacinco);

        zona5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent zona5 = new Intent(SeleccionarZonaParqueo.this, ParqueaderosDisponibles.class);
                startActivity(zona5);
            }
        });
    }
}
