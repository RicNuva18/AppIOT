package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RutaDos extends AppCompatActivity {

    Button atras8;
    Button next8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruta_dos);

        //PARA VOLVER
        atras8= (Button)findViewById(R.id.back8);

        atras8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent atras8 = new Intent(RutaDos.this, SeleccionarDestino.class);
                startActivity(atras8);
            }
        });

        //PARA SEGUIR
        next8 = (Button)findViewById(R.id.siguiente8);

        next8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next8 = new Intent(RutaDos.this, Reminder.class);
                startActivity(next8);
            }
        });
    }
}
