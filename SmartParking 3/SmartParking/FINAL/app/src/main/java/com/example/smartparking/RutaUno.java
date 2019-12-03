package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RutaUno extends AppCompatActivity {

    Button atras5;
    Button next5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruta_uno);

        //PARA VOLVER
        atras5=(Button)findViewById(R.id.back5);

        atras5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent atras5 = new Intent(RutaUno.this, ParqueaderosDisponibles.class);
                startActivity(atras5);
            }
        });

        //PARA SEGUIR
        next5 = (Button)findViewById(R.id.siguiente5);

        next5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next5 = new Intent(RutaUno.this, FeedbackUno.class);
                startActivity(next5);
            }
        });
    }
}
