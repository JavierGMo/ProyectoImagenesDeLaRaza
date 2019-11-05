package com.morajavier.raza;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorRaza extends BaseAdapter {

    private Context context;
    private ArrayList<Descripciones> descripciones;
    private int layout;
    //TextView descripcioncorta;
    //ImageView imagenRaza;

    public  AdaptadorRaza(Context context, int layout, ArrayList<Descripciones> descripciones){
        this.context = context;
        this.layout = layout;
        this.descripciones = descripciones;
    }


    @Override
    public int getCount() {
        return this.descripciones.size();
    }

    @Override
    public Object getItem(int i) {
        return this.descripciones.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        //se copia la vista
        View viewPersonal = convertView;

        //inflamos la vista que se obtiene del layout personalizado
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        viewPersonal = layoutInflater.inflate(R.layout.list_item, null);
        //inflamos el textview y el iamgeview
        String texto = descripciones.get(position).getDescripcion();
        int imageID = descripciones.get(position).getImage();
        TextView textosDesc = viewPersonal.findViewById(R.id.xdescripcion);
        ImageView imgenRaza = viewPersonal.findViewById(R.id.imageViewRaza);
        textosDesc.setText(texto);
        imgenRaza.setImageResource(imageID);
        return viewPersonal;
    }
}
