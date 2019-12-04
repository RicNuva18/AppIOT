package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class IniciarSesion extends AppCompatActivity {

    Button atras;
    Button siguiente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);


        siguiente = (Button)findViewById(R.id.siguiente);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inicioSesion = new Intent(IniciarSesion.this, QueDeseoHacer.class);
                startActivity(inicioSesion);
            }
        });

        atras = (Button)findViewById(R.id.back);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent volver = new Intent(IniciarSesion.this, MainActivity.class);
                startActivity(volver);
            }
        });
    }
}
