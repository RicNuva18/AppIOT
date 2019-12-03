package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RutaTres extends AppCompatActivity {

    Button atras10;
    Button next10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruta_tres);

        //PARA VOLVER
        atras10 = (Button)findViewById(R.id.back10);

        atras10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent atras10 = new Intent(RutaTres.this, Reminder.class);
                startActivity(atras10);
            }
        });
    }
}
