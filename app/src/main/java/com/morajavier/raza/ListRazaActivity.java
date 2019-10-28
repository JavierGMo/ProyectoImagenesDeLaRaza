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

public class ListRazaActivity extends AppCompatActivity implements ListFragment.DataListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_raza);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        //String containterDesc = descripcionesCont.get(position).getDescripcion();
        //int idIMG = descripcionesCont.get(position).getImage();
        //Metemos el fragment de listview en el activity
        ListFragment listFragment = new ListFragment();
        ft.replace(R.id.fragmet_vizor, listFragment);
        ft.commitAllowingStateLoss();
    }

    //comunicacion entre fragments
    @Override
    public void sendInfo(String txtcnt, int idimgr) {
        //nota:configuracion, con el boton de regresar que el fragment de listview se vuelva poner
        //recibimos el texto y el id de la imagen
        //y cargamos el fragment del visualizador
        //remplazamos el otro fragment
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        VisorImageFragment visorImageFragment = new VisorImageFragment(txtcnt, idimgr);
        //visorImageFragment.visorChido(txtcnt, idimgr);
        ft.replace(R.id.fragmet_vizor, visorImageFragment);
        ft.commitAllowingStateLoss();
    }
}
