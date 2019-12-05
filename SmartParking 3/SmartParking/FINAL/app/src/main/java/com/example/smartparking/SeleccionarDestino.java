package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SeleccionarDestino extends AppCompatActivity {

    Button atras;
    ImageButton next7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_destino);

        //PARA VOLVER
        atras = (Button)findViewById(R.id.atras2);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent atras = new Intent(SeleccionarDestino.this, QueDeseoHacer.class);
                startActivity(atras);
            }
        });

        //PARA SEGUIR
        next7= (ImageButton) findViewById(R.id.zonaCincoDosDos);

        next7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next7 = new Intent(SeleccionarDestino.this, RutaDos.class);
                startActivity(next7);
            }
        });
    }
}
