package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class  MainActivity extends AppCompatActivity {

    Button iniciodesesion;
    Button registro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //PARA INICIAR SESIÓN

        iniciodesesion=(Button)findViewById(R.id.button1);

        iniciodesesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, IniciarSesion.class);
                startActivity(intent);

            }
        });

        //PARA REGISTRARSE

        registro = (Button)findViewById(R.id.button);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registro = new Intent(MainActivity.this, Registrarse.class);
                startActivity(registro);
            }
        });
    }
}
