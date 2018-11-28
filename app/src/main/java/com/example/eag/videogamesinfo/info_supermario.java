package com.example.eag.videogamesinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class info_supermario extends AppCompatActivity {
    TextView Mario,Mario_info,Mario_p,Mario_g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_supermario);
        Mario = (TextView) findViewById(R.id.Mario);
        Mario_info = (TextView) findViewById(R.id.Mario_info);
        Mario_p = (TextView) findViewById(R.id.Mario_p);
        Mario_g = (TextView) findViewById(R.id.Mario_g);

        String mario = getIntent().getStringExtra("name");
        String mario_p = getIntent().getStringExtra("champ");
        String mario_g= getIntent().getStringExtra("gene");

        Mario.setText(mario);
        Mario_p.setText(mario_p);
        Mario_g.setText(mario_g);
        Mario_info.setText("");
    }
    public void cerrar(View view){
        Toast.makeText(this, "Volviendo a la pagina principal", Toast.LENGTH_SHORT).show();
        finish();
    }
}
