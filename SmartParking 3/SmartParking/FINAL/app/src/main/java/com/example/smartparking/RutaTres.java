package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class RutaTres extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerDragListener {

    Button atras10;
    Button next10;
    private static final String TAG="MapsActivity";
    private static final int REQUEST_CODE = 11 ;
    private GoogleMap mMap;
    private LocationManager manager;
    private Marker me;
    private Button btn_edificioL;


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

        //PARA SEGUIR

        next10 = (Button)findViewById(R.id.siguiente10);

        next10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next10 = new Intent(RutaTres.this, FeedbackTres.class);
                startActivity(next10);
            }
        });
        //PARA GOOGLE MAPS
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapRutaTres);
        mapFragment.getMapAsync(this);
        manager = (LocationManager) getSystemService(LOCATION_SERVICE);
    }

    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {

    }

    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
        }, REQUEST_CODE);



        //Universidad Icesi- Edificio L
        LatLng ediL2= new LatLng(3.343214,-76.529642);
        mMap.addMarker(new MarkerOptions().position(ediL2).title("Salida Lateral").snippet("Salida cercana").icon(BitmapDescriptorFactory.fromResource(R.drawable.exit)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ediL2));



        //mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);

        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 10, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                if(me!=null){
                    me.remove();
                }
                me = mMap.addMarker(new MarkerOptions()
                        .position(new LatLng( location.getLatitude() ,  location.getLongitude()))
                        .title("Me")
                );
                mMap.moveCamera(CameraUpdateFactory
                        .newLatLng(new LatLng(location.getLatitude() ,  location.getLongitude())));

                LatLng userPosition = new LatLng(me.getPosition().latitude, me.getPosition().longitude);
                LatLng ediL2= new LatLng(3.343037,-76.529689);
                mMap.addPolyline(new PolylineOptions().add(userPosition,ediL2).width(8f).color(Color.BLACK));

                //Log.e(">>>", "LAT: " + me.getPosition().latitude + " , LONG: " + me.getPosition().longitude);
                // Edificio L zona de preguntas
                if (userPosition.latitude >= 3.3403028 && userPosition.longitude >= -76.529606 && userPosition.latitude <= 3.343217 && userPosition.longitude <= -76.529643 ) {
                    btn_edificioL = findViewById(R.id.siguiente10);
                    btn_edificioL.setVisibility(View.VISIBLE);
                    btn_edificioL.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(RutaTres.this, FeedbackTres.class);
                            startActivity(i);
                        }
                    });

                } else {
                    btn_edificioL = findViewById(R.id.siguiente10);
                    btn_edificioL.setVisibility(View.INVISIBLE);
                    btn_edificioL.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(RutaTres.this, FeedbackTres.class);
                            startActivity(i);
                        }
                    });

                }



            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        });

    }
}
