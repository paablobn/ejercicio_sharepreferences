package com.example.ejercicio1ex.ejercicio_sharepreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    private EditText txtUsuario, txtContraseña;

    private Button btnGuardar;

    private final String Usuario = "u";
    private final String Password = "p";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(Constantes.USER, MODE_PRIVATE);

        txtUsuario = findViewById(R.id.txtUsusario);
        txtContraseña = findViewById(R.id.txtContrasenya);
        btnGuardar = findViewById(R.id.btnGuardar);

        inicializarValores();

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!txtUsuario.getText().toString().isEmpty() && !txtContraseña.getText().toString().isEmpty()) {
                    // Escribir -> editor de sharedpreferences
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    // Inserto elementos
                    editor.putString(Constantes.USER, txtUsuario.getText().toString());
                    editor.putString(Constantes.PASSWORD, txtContraseña.getText().toString());
                    editor.apply();
                    startActivity(new Intent(MainActivity.this, login2.class));
                    Toast.makeText(MainActivity.this, "GUARDADO", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "RELLENA DATOS", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void inicializarValores() {
        String usuario = sharedPreferences.getString(Constantes.USER, null);
        String contrasenya = sharedPreferences.getString(Constantes.PASSWORD, null);

        if (usuario != null && contrasenya != null) {
            if (usuario.equals(Usuario) && contrasenya.equals(Password)){
                startActivity(new Intent(MainActivity.this,login2.class));
            }
        }
    }
}