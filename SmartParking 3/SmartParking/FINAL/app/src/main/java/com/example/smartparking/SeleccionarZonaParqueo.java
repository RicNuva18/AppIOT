package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class SeleccionarZonaParqueo extends AppCompatActivity   {

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
        zona5 = (ImageButton) findViewById(R.id.zonaCincoDos);

        zona5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent zona5 = new Intent(SeleccionarZonaParqueo.this, ParqueaderosDisponibles.class);
                startActivity(zona5);
            }
        });

    }


}


