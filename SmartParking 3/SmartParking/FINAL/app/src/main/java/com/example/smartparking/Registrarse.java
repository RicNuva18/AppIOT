package com.example.smartparking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Registrarse extends AppCompatActivity {

    Button volver11;
    Button next11;
    private Button btnRegistrar;
    private EditText TextEmail;
    private EditText TextPassword;
    //private ProgressDialog progressDialog;


    //VARIABLES DE LOS DATOS QUE VAMOS A REGISTRAR
    private String email = "";
    private String passoword = "";

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    //Declaramos un objeto firebaseAuth
    //private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();


        //inicializamos el objeto firebaseauth
        //firebaseAuth = FirebaseAuth.getInstance();

        //referenciamos los views
        TextEmail = (EditText)findViewById(R.id.editText);
        TextPassword = (EditText)findViewById(R.id.editText4);

        btnRegistrar = (Button) findViewById(R.id.siguiente11);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email = TextEmail.getText().toString();
                passoword = TextPassword.getText().toString();

                //VERIFICACION ACERCA SI EL USUARIO INGRESÓ ALGO
                if (!email.isEmpty()&& !passoword.isEmpty()){

                    //contraseña
                    if (passoword.length()>=6){

                    }else {
                        Toast.makeText(Registrarse.this,"El password debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
                    }

                    registrarUsuario();
                }else{
                    Toast.makeText(Registrarse.this, "Debe completar los campos", Toast.LENGTH_LONG).show();
                }
            }
        });


        //btnRegistrar = (Button)findViewById(R.id.siguiente11);

        //progressDialog = new ProgressDialog(this);


        //PARA VOLVER
        volver11 = (Button)findViewById(R.id.back11);

        volver11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver11 = new Intent(Registrarse.this, MainActivity.class);
                startActivity(volver11);
            }
        });
/*
        //PARA SEGUIR
        next11 = (Button)findViewById(R.id.siguiente11);

        next11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next11 = new Intent(Registrarse.this, FeedbackDos.class);
                startActivity(next11);
            }
        });
*/
    }

    private void registrarUsuario(){

        mAuth.createUserWithEmailAndPassword(email, passoword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){

                    Map<String, Object> map = new HashMap<>();
                    map.put("email", email);
                    map.put("contraseña", passoword);

                    String id = mAuth.getCurrentUser().getUid();

                    mDatabase.child("Users").child(id).setValue(map);
                    startActivity(new Intent(Registrarse.this, FeedbackDos.class));
                    finish();

                }else {
                    Toast.makeText(Registrarse.this, "No se pudo registrar el usuario", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //obtenemos el email y la contraseña desde las cajas de texto
        //String email = TextEmail.getText().toString().trim();
        //String password = TextPassword.getText().toString().trim();

        //verificamos que las cajas de texto no esten vacias
        /*
        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "Se debe ingresar un email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Falta ingresar la contraseña", Toast.LENGTH_LONG).show();
            return;
        }
        */

        //progressDialog.setMessage("Realizando registro en linea...");
        //progressDialog.show();

        /*//creating a new user
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //cheking if success
                        if (task.isSuccessful()){
                            Toast.makeText(Registrarse.this, "Se ha registrado el email", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(Registrarse.this, "No se pudo registrar el usuario", Toast.LENGTH_LONG).show();
                        }

                        progressDialog.dismiss();
                    }
                });
        */

    }

    public void onClick(View view){
        //Invocamos al método:
        registrarUsuario();
    }
}
