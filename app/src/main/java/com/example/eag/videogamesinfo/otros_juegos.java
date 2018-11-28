package com.example.eag.videogamesinfo;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.VideoView;

public class otros_juegos extends AppCompatActivity {
    VideoView videoView,videoView2;
    Spinner spinner;
    ListView spinner2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otros_juegos);
        videoView = (VideoView) findViewById(R.id.videoView);
        videoView2 = (VideoView) findViewById(R.id.videoView2);
         spinner = (Spinner) findViewById(R.id.spinner);
         spinner2 = (ListView) findViewById(R.id.spinner2);


         String[] opciones = {"MonsterHunterWorld","The Legend of Zelda: Breathof the Wild"};
         String[] option = {"Call of Duty: Black ops 4","Anthem"};

        Uri uri = Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
        videoView2.setMediaController(new MediaController(this));
        videoView2.setVideoURI(uri);
        videoView2.start();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opciones);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,option);

        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter1);




        spinner2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String aux = spinner2.getItemAtPosition(position).toString();
                seleccionado2(aux);
            }
        });






        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                  String aux = spinner.getSelectedItem().toString();
                  seleccionado(aux);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }

    public void seleccionado(String selecccion){

        Uri uri = Uri.parse("");
        switch (selecccion){
            case "MonsterHunterWorld":
                uri = Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
                videoView.setMediaController(new MediaController(this));
                videoView.setVideoURI(uri);
                videoView.start();
                break;

            case "The Legend of Zelda: Breathof the Wild":
                uri = Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
                videoView.setMediaController(new MediaController(this));
                videoView.setVideoURI(uri);
                videoView.start();
                break;
             default:

        }

    }
    public void seleccionado2(String seleccion){
        Uri uri = Uri.parse("");
        switch (seleccion){
            case "Call of Duty: Black ops 4":
                uri = Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
                videoView2.setMediaController(new MediaController(this));
                videoView2.setVideoURI(uri);
                videoView2.start();
                break;
            case "Anthem":
                uri = Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
                videoView2.setMediaController(new MediaController(this));
                videoView2.setVideoURI(uri);
                videoView2.start();
                break;
                default:
        }
    }

    public void cerrar(View view){
        Toast.makeText(this, "Volviendo a la pagina principal", Toast.LENGTH_SHORT).show();
        finish();
    }
}
