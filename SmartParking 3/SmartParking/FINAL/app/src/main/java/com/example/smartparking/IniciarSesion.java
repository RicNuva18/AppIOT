package com.example.smartparking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class IniciarSesion extends AppCompatActivity {

    Button atras;
    Button siguiente;

    private EditText mEditTextEmail;
    private EditText mEditTextPassword;
    private Button mButtonLogin;


    private String email = "";
    private String password = "";

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        mAuth = FirebaseAuth.getInstance();


        mEditTextEmail = (EditText)findViewById(R.id.editText3);
        mEditTextPassword = (EditText)findViewById(R.id.editText2);
        mButtonLogin = (Button)findViewById(R.id.siguiente);

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = mEditTextEmail.getText().toString();
                password = mEditTextPassword.getText().toString();

                if (!email.isEmpty() && !password.isEmpty()){
                    loginUser();

                }else
                {
                    Toast.makeText(IniciarSesion.this, "complete los campos", Toast.LENGTH_SHORT).show();

                }
            }
        });

        /*
        //para seguir
        siguiente = (Button)findViewById(R.id.siguiente);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inicioSesion = new Intent(IniciarSesion.this, QueDeseoHacer.class);
                startActivity(inicioSesion);
            }
        });

        */
        //PARA VOLVER
        atras = (Button)findViewById(R.id.back);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent volver = new Intent(IniciarSesion.this, MainActivity.class);
                startActivity(volver);
            }
        });

    }

    private void loginUser(){
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    startActivity(new Intent(IniciarSesion.this, QueDeseoHacer.class));
                    finish();
                }else{
                    Toast.makeText(IniciarSesion.this, "no se pudo iniciar sesión, comprueba los datos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
