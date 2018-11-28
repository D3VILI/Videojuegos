package com.example.eag.videogamesinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class info_TomRaider extends AppCompatActivity {
    TextView Tomb,Tomb_info,Tomb_p,Tomb_g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info__tom_raider);
        Tomb = (TextView) findViewById(R.id.Tomb);
        Tomb_info = (TextView) findViewById(R.id.Tomb_info);
        Tomb_p = (TextView) findViewById(R.id.Tomb_p);
        Tomb_g = (TextView) findViewById(R.id.Tomb_g);

        String tomb = getIntent().getStringExtra("name");
        String tomb_p = getIntent().getStringExtra("champ");
        String tomb_g = getIntent().getStringExtra("gene");

        Tomb.setText(tomb);
        Tomb_p.setText(tomb_p);
        Tomb_g.setText(tomb_g);
        Tomb_info.setText("");

    }
    public void cerrar(View view){

        Toast.makeText(this, "Volviendo a la pagina principal", Toast.LENGTH_SHORT).show();
        finish();
    }
}
