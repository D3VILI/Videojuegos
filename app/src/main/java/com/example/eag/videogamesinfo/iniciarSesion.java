package com.example.eag.videogamesinfo;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class iniciarSesion extends AppCompatActivity {
    EditText nick,contra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
        nick = (EditText) findViewById(R.id.nick);
        contra = (EditText) findViewById(R.id.contra);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"videojuegos",null,1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

        String[] nombres = {"Kingdom Hearts","Assassins Creed","Tomb Raider","Super Mario 64"};
        String[] personajes ={"Sora, Riku, Aqua, Kairi, Roxas, Cloud","Ezio Auditore, Edward Kenway, Desmond Miles, Haytham kenway","Lara Croft, Jonah, Dominguez, Unuratu, Etzli","Mario, Bowser, Peach, Toad"};
        String[] generos ={"Rol/Accion","Accion/Aventura/Sigilo","Accion/Aventura","Plataforma"};
        String[] informaciones ={"Es un videojuego de tipo ARPG actualmente en desarrollo por Square Enix y que será publicado por la misma empresa para las consolas PlayStation 4 y Xbox One.",
                "Es un videojuego de acción y aventura desarrollado por Eidos Montréal y distribuido por Square Enix, para las plataformas PlayStation 4, Xbox One y Microsoft Windows.",
                "Rogue es un videojuego de acción-aventura y sigilo de ficción histórica, desarrollado por Ubisoft Sofia y publicado por Ubisoft.",
                "Es un videojuego de plataformas para la videoconsola Nintendo 64, desarrollado por Nintendo Entertaiment Analysis and Development y publicado por la propia Nintendo."};
        ContentValues datos;
         for(int i = 0; i< nombres.length;i++){
            datos = new ContentValues();
            datos.put("nombre",nombres[i]);
            datos.put("personaje",personajes[i]);
            datos.put("genero",generos[i]);
            datos.put("informacion",informaciones[i]);
             baseDeDatos.insert("juegos",null,datos);
         }
        baseDeDatos.close();
    }
    public void iniciar(View view){
        String nom = nick.getText().toString();
        String cont = contra.getText().toString();
        SharedPreferences iniciar = getSharedPreferences("inicio", Context.MODE_PRIVATE);
        String contrase = iniciar.getString("contrasena", cont);
        String nicker = iniciar.getString("nick",nom);
        if(contrase.length() == 0 && nicker.length() == 0){
            Toast.makeText(this,"El dato no existe",Toast.LENGTH_SHORT).show();
        }else{
            Intent i = new Intent(this,MainActivity.class);
            Toast.makeText(this, "Logueado", Toast.LENGTH_SHORT).show();
            startActivity(i);
        }
    }
    public void crear(View view){
        Intent i = new Intent(this,crearCuenta.class);
        Toast.makeText(this, "Creacion de cuenta", Toast.LENGTH_SHORT).show();
        startActivity(i);
    }
}
