package com.morajavier.raza;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class ListFragment extends Fragment {


    private DataListener callback;
    ListView listImageRaza;
    private ArrayList<Descripciones> descripcionesCont;

    public ListFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        listImageRaza = v.findViewById(R.id.list_image_raza);
        descripcionesCont = new ArrayList<Descripciones>();

        System.out.println("*************************** " + getContext() + "************************************");
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
        //uso mi propio adaptador
        //le paso el contexto, busco mis item de la lista(como es algo global se busca directamente en R)
        //le paso mi arraylist
        AdaptadorRaza adaptadorRaza = new AdaptadorRaza(getContext(), R.layout.list_item, descripcionesCont);
        //AdaptadorRaza adapterRaza = new AdaptadorRaza(ListFragment.this, R.id.list_item, descripcionesCont);
        listImageRaza.setAdapter(adaptadorRaza);

        listImageRaza.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getContext(), "Posicion: " + position, Toast.LENGTH_SHORT).show();
                //Aqui envio la informacion al otro callback para visualizar la imagen
                callback.sendInfo(descripcionesCont.get(position).getDescripcion(),descripcionesCont.get(position).getImage());
            }
        });
        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            callback = (DataListener) context;
        }catch (Exception e){
            throw new RuntimeException("" + e);
        }
    }

    @Override
    public void onDetach() {
        callback = null;
        super.onDetach();
    }

    //comunicacion entre fragments
    public interface DataListener {
        void sendInfo(String txtcnt, int idimgr);
    }

    public void logicaListView(){

    }
}
