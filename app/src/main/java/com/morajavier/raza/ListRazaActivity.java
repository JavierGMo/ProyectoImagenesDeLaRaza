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
//nota: Agregar un fragment para el VisorImageActivity para que se adapte al girar la pantalla
public class ListRazaActivity extends AppCompatActivity implements ListFragment.DataListener{
    private String[] descripcionesImagens = {
            "Si toda la historia de la Tierra se representara en un año, los ultimos 15 minutos, es decir, de las 23:45 a la media noche del dia 31 de diciembre, significaría los últimos 130 mil años.",
            "Fósiles humanos de hace 160 mil años muestran que los primeros Homo sapiens eran completamente semejantes a nosotros.\n Hace 130 mil años habían bosques en el Ártico, mientras que en África existían ya seres humanos.",
            "Hace 85 mil años comenzó la salida de los primeros humanos modernos de África rumbo a Asia; los cuales se cree estuvieron en peligro de extinción a causa de la erupción de un gran volcán en Sumatra que abrió un cráter de 100 km de ancho, hoy ocupado por el lago Toba.",
            "Hace 55 mil años siguieron las migraciones de los humanos cazadores y recolectores hacia el sur y este de Asia, Australia y Europa.",
            "Hace 32 mil años comenzaron a extinguirse los neandertales. Por otro lado las, primeras señales de la creatividad humana aparecen plasmadas en piedras. Las pinturas rupestres son esencialmente una expresión espiritual primitiva y están relacionadas con prácticas de magia y religión para propiciar la caza.",
            "Los seres humanos no son originarios de América. Se cree que llegaron a este continente procedentes de Siberia hace cerca de 20 mil años. Durante la última glaciación se creó un punto terrestre, conocido como el Estrecho de Bering, por donde cruzaron.",
            "Durante miles de años los humanos se alimentaron y sobrevivieron solo cazando animales y recolectando plantas. Mucho de los animales que se conocian entonces ya no existen.",
            "Hace 10 mil años se inicia la historia humana escrita. En un inicio la escritura era pictográfica, es decir, se usaban dibujos simples que representaban objetos, pero con ellos no podian comunicarse ideas abstractas.",
            "Hace 5 mil 500 años surgen numerosas comunidades agricolas en el valle de Mesopotamia, entre los rios Tigris y Eufrates. Estas comunidades evolucionaron y surgieron las primeras civilizaciones, como los sumerios. Posteriormente aparecieron las culturas acadias, asirias y babilonicas, las cuales aprovecharon las técnicas y conocimientos que se iban desarrollando en la región para formar nuevas grandes ciudades.",
            "Hace 4 mil 500 años se construyeron las piramides de Egipto. La primera de grandes proporciones, albergaba los restos del rey, pero las mas famosas son las de Keops, Kefren y Micerino que se encuentran en el valle de Guiza.",
            "Hasta el final del Neolítico, es decir la Edad de Piedra, la humanidad construía herramientas sólo de este material. Más tarde, aprendió a hacer objetos de metal que resultaron ser cada vez más útiles y resistentes. Primero se usó el cobre y, al mezclarlo con estaño, se obtuvo el bronce."
    };

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
    public void sendInfo(String txtcnt, int idimgr, int position) {
        //nota:configuracion, con el boton de regresar que el fragment de listview se vuelva poner
        //recibimos el texto y el id de la imagen
        //y cargamos el fragment del visualizador
        //remplazamos el otro fragment
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        VisorImageFragment visorImageFragment = new VisorImageFragment(txtcnt, idimgr, descripcionesImagens[position]);
        //visorImageFragment.visorChido(txtcnt, idimgr);
        ft.replace(R.id.fragmet_vizor, visorImageFragment);
        ft.addToBackStack(null);
        ft.commitAllowingStateLoss();
    }
}
