package com.example.eag.videogamesinfo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.TextKeyListener;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nombre, personaje, genero;
    RadioGroup grupo;
    RadioButton opcion1, opcion2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = (EditText) findViewById(R.id.nombre);
        personaje = (EditText) findViewById(R.id.personaje);
        genero = (EditText) findViewById(R.id.genero);
        grupo = (RadioGroup) findViewById(R.id.grupo);
        opcion1 = (RadioButton) findViewById(R.id.opcion1);
        opcion2 = (RadioButton) findViewById(R.id.opcion2);

    }

    public void ir(View view) {
        Intent i = new Intent();
        String data = nombre.getText().toString();
        String dat = data.substring(0,1).toUpperCase()+data.substring(1);
        switch (dat) {
            case "Kingdom Hearts":
                i = new Intent(this, infoKingdom.class);
                i.putExtra("name", nombre.getText().toString());
                i.putExtra("champ", personaje.getText().toString());
                i.putExtra("gene", genero.getText().toString());
                startActivity(i);
                break;
            case "Assassins Creed":
                i = new Intent(this, info_asasincreed.class);
                i.putExtra("name", nombre.getText().toString());
                i.putExtra("champ", personaje.getText().toString());
                i.putExtra("gene", genero.getText().toString());
                startActivity(i);
                break;

            case "Tomb Raider":
                i = new Intent(this, info_TomRaider.class);
                i.putExtra("name", nombre.getText().toString());
                i.putExtra("champ", personaje.getText().toString());
                i.putExtra("gene", genero.getText().toString());
                startActivity(i);
                break;

            case "Super Mario 64":
                i = new Intent(this, info_supermario.class);
                i.putExtra("name", nombre.getText().toString());
                i.putExtra("champ", personaje.getText().toString());
                i.putExtra("gene", genero.getText().toString());
                startActivity(i);
                break;

            default:
                Toast.makeText(this, "Kingdom Hearts o Assassins Creed o Tomb Raider o Super Mario 64", Toast.LENGTH_LONG).show();
        }

    }

    public void otro(View view) {
        Toast.makeText(this, "Videos de juegos nuevos", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, otros_juegos.class);
        startActivity(i);
    }

    public void seleccionar(View view) {
        if (opcion1.isChecked()) {
            Toast.makeText(this, "Recibir información", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this,"No recibir información",Toast.LENGTH_SHORT).show();
        }
    }
    public void cerrar(View view){
        Toast.makeText(this, "Volviendo al inicio de sesion", Toast.LENGTH_SHORT).show();
        finish();
    }
}
