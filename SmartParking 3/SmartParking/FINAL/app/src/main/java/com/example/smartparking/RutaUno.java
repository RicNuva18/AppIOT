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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.Locale;

public class RutaUno extends FragmentActivity  implements OnMapReadyCallback, GoogleMap.OnMarkerDragListener{

    Button atras5;
    Button next5;
       private static final String TAG="MapsActivity";
    private static final int REQUEST_CODE = 11 ;
    private GoogleMap mMap;
    private LocationManager manager;
    private Marker me;
    private Button btn_edificioL;

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

        //next5.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View view) {
              //  Intent next5 = new Intent(RutaUno.this, FeedbackUno.class);
                //startActivity(next5);
            //}
        //});


        //PARA GOOGLE MAPS
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapRutaUno);
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
        LatLng ediL = new LatLng(3.341601, -76.529623);
        mMap.addMarker(new MarkerOptions().position(ediL).title("Edificio L").snippet("Zona cercana a parqueaderos").icon(BitmapDescriptorFactory.fromResource(R.drawable.edificio)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ediL));
        LatLng ediL2= new LatLng(3.341606,-76.529515);
        LatLng ediL3= new LatLng(3.341478,-76.529515);
        LatLng ediL4= new LatLng(3.341462,-76.529274);
        LatLng ediL5= new LatLng(3.340905,-76.529301);
        LatLng ediL6= new LatLng(3.340905,-76.529489);
        LatLng ediL7= new LatLng(3.340953,-76.529489);
        LatLng ediL8= new LatLng(3.340951,-76.529540);
        LatLng ediL9= new LatLng(3.341229,-76.529513);
        LatLng ediL10= new LatLng(3.341234,-76.529470);
        LatLng ediL11= new LatLng(3.341335,-76.529465);
        LatLng ediL12= new LatLng(3.341346,-76.529631);
        LatLng ediL13= new LatLng(3.341602,-76.529620);
       // LatLng userPositionIncio1 = new LatLng(me.getPosition().latitude, me.getPosition().longitude);
       // LatLng destino=new LatLng(ediL.latitude,ediL.longitude);


        mMap.addPolyline(new PolylineOptions().add(ediL,ediL2,ediL3,ediL4,ediL5,ediL6,ediL7,ediL8,ediL9,ediL10,ediL11,ediL12,ediL13).width(8f).color(Color.RED));


        //LatLng userPositionIncio1 = new LatLng(me.getPosition().latitude, me.getPosition().longitude);
        //Log.e(">>>", "LAT: " + me.getPosition().latitude + " , LONG: " + me.getPosition().longitude);


        //LatLng destino=new LatLng(ediL.latitude,ediL.longitude);
        //mMap.addPolyline(new PolylineOptions().add(userPositionIncio1,destino).width(8f).color(Color.BLACK));

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
                LatLng ediL = new LatLng(3.341601, -76.529623);
                mMap.addPolyline(new PolylineOptions().add(userPosition,ediL).width(8f).color(Color.BLACK));

                //Log.e(">>>", "LAT: " + me.getPosition().latitude + " , LONG: " + me.getPosition().longitude);
                // Edificio L zona de preguntas
                if (userPosition.latitude >= 3.340905 && userPosition.longitude >= -76.529631 && userPosition.latitude <= 3.341606 && userPosition.longitude <= -76.529274 ) {
                    btn_edificioL = findViewById(R.id.siguiente5);
                    btn_edificioL.setVisibility(View.VISIBLE);
                    btn_edificioL.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(RutaUno.this, FeedbackUno.class);
                            startActivity(i);
                        }
                    });

                } else {
                    btn_edificioL = findViewById(R.id.siguiente5);
                    btn_edificioL.setVisibility(View.INVISIBLE);


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
