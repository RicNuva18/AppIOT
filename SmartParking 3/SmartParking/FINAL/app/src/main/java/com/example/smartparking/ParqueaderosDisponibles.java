package com.example.smartparking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ParqueaderosDisponibles extends AppCompatActivity {

    Button atras4;
    Button next4;

    private DatabaseReference mDatabase;
    private TextView disponibles;
    private TextView cantidadMax;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parqueaderos_disponibles);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        disponibles = (TextView)findViewById(R.id.textView3);
        cantidadMax=(TextView) findViewById(R.id.textView4);


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

        mDatabase.child("ZonaA").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for (final DataSnapshot snapshot : dataSnapshot.getChildren()){
                    mDatabase.child("ZonaA").child("Disponibles").addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot1) {
                            Log.e("mensajee", dataSnapshot1.getChildren().toString());
                            if (dataSnapshot1.exists()) {

                                String carrosIngresados = dataSnapshot1.getChildrenCount()+"";//para obtener el nombre
                                Integer disponible=20-Integer.parseInt(carrosIngresados);

                                disponibles.setText(disponible+"");
                                cantidadMax.setText("20");
                            }


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
            }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
