package com.morajavier.raza;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



public class VisorImageFragment extends Fragment {
    private int idImg;
    private String contDescript;
    private String desc;
    TextView txtDescripcion, textViewDescChida;
    ImageView imgRaza;

    public VisorImageFragment(String contDescript, int idImg, String desc) {
        // Required empty public constructor
        this.contDescript = contDescript;
        this.idImg = idImg;
        this.desc = desc;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //Recuerden poner los find en su lugar
        //en mi caso lo puse despues del setImageResource y me mando un error
        View v = inflater.inflate(R.layout.fragment_visor_image, container, false);
        txtDescripcion = v.findViewById(R.id.txtfragmentdescripcioncont);
        imgRaza = v.findViewById(R.id.imageViewConte);
        textViewDescChida = v.findViewById(R.id.txtfragdescchida);
        txtDescripcion.setText(this.contDescript);
        imgRaza.setImageResource(this.idImg);
        textViewDescChida.setText(this.desc);



        return v;
    }
    /*
    public void visorChido(String cnt, int idIMG){
        txtDescripcion.setText(cnt);
        imgRaza.setImageResource(idIMG);
    }*/
}
