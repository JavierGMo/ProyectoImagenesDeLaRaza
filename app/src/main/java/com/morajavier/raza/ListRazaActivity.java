package com.morajavier.raza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListRazaActivity extends AppCompatActivity{
    ListView listImageRaza;
    private ArrayList<Descripciones> descripcionesCont;

    //private ArrayList<String> listDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_raza);
        descripcionesCont = new ArrayList<Descripciones>();
        listImageRaza = findViewById(R.id.list_image_raza);

        descripcionesCont.add(new Descripciones(R.drawable.buho, "El paso de tiempo"));
        descripcionesCont.add(new Descripciones(R.drawable.buho, "lorem"));
        descripcionesCont.add(new Descripciones(R.drawable.buho, "lorem"));
        descripcionesCont.add(new Descripciones(R.drawable.buho, "lorem"));
        descripcionesCont.add(new Descripciones(R.drawable.buho, "lorem"));
        descripcionesCont.add(new Descripciones(R.drawable.buho, "lorem"));
        descripcionesCont.add(new Descripciones(R.drawable.buho, "lorem"));
        descripcionesCont.add(new Descripciones(R.drawable.buho, "lorem"));
        descripcionesCont.add(new Descripciones(R.drawable.buho, "lorem"));
        descripcionesCont.add(new Descripciones(R.drawable.buho, "lorem"));
        descripcionesCont.add(new Descripciones(R.drawable.buho, "lorem"));

        AdaptadorRaza adapterRaza = new AdaptadorRaza(this, R.layout.list_item, descripcionesCont);
        listImageRaza.setAdapter(adapterRaza);

        listImageRaza.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                FragmentManager  manager   =   getSupportFragmentManager ( ) ;
                FragmentTransaction  ft   =   manager . beginTransaction ( ) ;
                VisorImageFragment visImg = new VisorImageFragment(descripcionesCont.get(position).getImage(), descripcionesCont.get(position).getDescripcion());
                ft.replace(R.id.fragment_visor, visImg);
                //Toast.makeText(ListRazaActivity.this, "Posicion: "+ position + " id: " + id, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
