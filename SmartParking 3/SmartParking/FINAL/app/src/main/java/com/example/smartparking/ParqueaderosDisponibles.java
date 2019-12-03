package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ParqueaderosDisponibles extends AppCompatActivity {

    Button atras4;
    Button next4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parqueaderos_disponibles);

        //PARA VOLVER
        atras4 = (Button)findViewById(R.id.back4);

        atras4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent atras4 = new Intent(ParqueaderosDisponibles.this, SeleccionarZonaParqueo.class);
                startActivity(atras4);
            }
        });

        //PARA SEGUIR
        next4 = (Button)findViewById(R.id.siguiente4);

        next4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next4 = new Intent(ParqueaderosDisponibles.this, RutaUno.class);
                startActivity(next4);
            }
        });
    }
}
