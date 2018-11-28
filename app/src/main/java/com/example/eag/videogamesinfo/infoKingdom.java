package com.example.eag.videogamesinfo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class infoKingdom extends AppCompatActivity {
    TextView King,King_info,King_p,King_g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_kingdom);
        King = (TextView) findViewById(R.id.King);
        King_info = (TextView) findViewById(R.id.King_info);
        King_p = (TextView) findViewById(R.id.King_p);
        King_g = (TextView) findViewById(R.id.King_g);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"videojuegos",null,1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();


        String king = getIntent().getStringExtra("name");
        String king_p = getIntent().getStringExtra("champ");
        String king_g = getIntent().getStringExtra("gene");
        if(!king.isEmpty()){
            Cursor fila = baseDeDatos.rawQuery("select nombre,personaje,genero,informacion from juegos where nombre="+king,null);

            if(fila.moveToFirst()){
                King.setText(fila.getString(0));
                King_p.setText(fila.getString(1));
                King_g.setText(fila.getString(2));
                King_info.setText(fila.getString(3));
            }
        }
    }
    public void cerrar(View view){
        Toast.makeText(this, "Volviendo a la pagina principal", Toast.LENGTH_SHORT).show();
        finish();
    }
}
