package com.example.eag.videogamesinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class info_asasincreed extends AppCompatActivity {
    TextView Asasin,Asasin_info,Asasin_p,Asasin_g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_asasincreed);
        Asasin = (TextView) findViewById(R.id.Asasin);
        Asasin_info = (TextView) findViewById(R.id.Asasin_info);
        Asasin_p = (TextView) findViewById(R.id.Asasin_p);
        Asasin_g = (TextView) findViewById(R.id.Asasin_g);

        String nombre = getIntent().getStringExtra("name");
        String personaje = getIntent().getStringExtra("champ");
        String genero = getIntent().getStringExtra("gene");

        Asasin.setText(nombre);
        Asasin_p.setText(personaje);
        Asasin_g.setText(genero);
        Asasin_info.setText("");
    }
    public void cerrar(View view){
        Toast.makeText(this, "Volviendo a la pagina principal", Toast.LENGTH_SHORT).show();
        finish();
    }
}
