package com.example.eag.videogamesinfo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class crearCuenta extends AppCompatActivity {
    EditText nombreCompleto,nick,contra,correoelec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);
        nombreCompleto = (EditText) findViewById(R.id.nombreUsuario);
        nick = (EditText) findViewById(R.id.nombre_nick);
        contra = (EditText)  findViewById(R.id.crearContra);
        correoelec =  (EditText)  findViewById(R.id.correo);
    }
    public void guardar(View view){
        String nom = nombreCompleto.getText().toString();
        String nicker = nick.getText().toString();
        String contrase = contra.getText().toString();
        String correoelectronico = correoelec.getText().toString();
        SharedPreferences guardar = getSharedPreferences("inicio", Context.MODE_PRIVATE);
        if(!guardar.contains(nicker)){
            SharedPreferences.Editor editar = guardar.edit();
            editar.putString("nick",nicker);
            editar.putString("contrasena",contrase);
            editar.putString("nombreCompleto",nom);
            editar.putString("correo",correoelectronico);
            editar.commit();
            nick.setText("");
            contra.setText("");
            nombreCompleto.setText("");
            correoelec.setText("");
            Toast.makeText(this,"Datos guardados correctamnente",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this,iniciarSesion.class);
            startActivity(i);
        }else{
            Toast.makeText(this,"El nick ya existe, cambialo",Toast.LENGTH_SHORT).show();
        }
    }

    public void cerrar(View view){
        Toast.makeText(this, "Volviendo a la pagina principal", Toast.LENGTH_SHORT).show();
        finish();
    }
}
