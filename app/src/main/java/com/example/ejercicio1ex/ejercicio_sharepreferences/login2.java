package com.example.ejercicio1ex.ejercicio_sharepreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login2 extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    private Button btnEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        sharedPreferences = getSharedPreferences(Constantes.USER,MODE_PRIVATE);

        btnEliminar = findViewById(R.id.btnEliminar);

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(Constantes.USER);
                editor.remove(Constantes.PASSWORD);
                editor.apply();
            }
        });
    }
}