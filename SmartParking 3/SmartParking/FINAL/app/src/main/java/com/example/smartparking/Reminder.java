package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Reminder extends AppCompatActivity {

    Button atras9;
    Button next9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        //PARA VOLVER
        atras9 = (Button)findViewById(R.id.back9);

        atras9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent atras9 = new Intent(Reminder.this, RutaDos.class);
                startActivity(atras9);
            }
        });


        //PARA SEGUIR
        next9 = (Button)findViewById(R.id.siguiente9);

        next9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next9 = new Intent(Reminder.this, RutaTres.class);
                startActivity(next9);
            }
        });
    }
}
