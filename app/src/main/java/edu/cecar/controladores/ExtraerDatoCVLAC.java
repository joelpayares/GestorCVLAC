package edu.cecar.controladores;

import android.util.Log;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class ExtraerDatoCVLAC {

    private ExtraerDatoCVLAC() {

    }

    /*public static Investigador  getDatos(String url) {

        Investigador investigador = null;

        try {

            //Se obtiene el documento HTML
            Document documentoHTML = Jsoup.connect(url).get();

            Element tablasGeneral = documentoHTML.select("table").get(1); //Se obtiene la segunda tabla
            Elements filasTablaGeneral = tablasGeneral.select("tr"); // Se obtienen las filas de la tabla

            int filaNombre = 0;
            int filaNacionalidad = 2;
            int filaSexo = 3;

            if (filasTablaGeneral.size() > 4){
                filaNombre = 2;
                filaNacionalidad = 4;
                filaSexo = 5;
            }

            //Se obtienen las columnas para cada atributo del invstigador
            String nombre = filasTablaGeneral.get(filaNombre).select("td").get(1).text();
            String nacionalidad = filasTablaGeneral.get(filaNacionalidad).select("td").get(1).text();
            String sexo = filasTablaGeneral.get(filaSexo).select("td").get(1).text();

            //Se crea el objeto investigador
            investigador = new Investigador(nombre, nacionalidad,sexo,true, null);

        } catch (IOException e) {

            e.printStackTrace();

        }

        return investigador;

    }*/

    public static Investigador  getDatosH3(String url) {

        Investigador investigador = null;
        int posTabla = -1;
        String[] localLineas = new String[50];

        try {
            //Se obtiene el documento HTML
            Document documentoHTML = Jsoup.connect(url).get();

            Elements h3 = documentoHTML.select("h3"); //Se obtiene la segunda tabla

            for (int i = 0; i < h3.size(); i++){
                //Log.i("H3 [" + i + "]: " , tablasGeneral.get(i).text());

                if (h3.get(i).text().trim().equals("Líneas de investigación")){
                    posTabla = i;
                }
            }

            if (posTabla != -1) {
                Element tablasGeneral = documentoHTML.select("table").get(1); //Se obtiene la segunda tabla
                Elements filasTablaGeneral = tablasGeneral.select("tr"); // Se obtienen las filas de la tabla

                int filaNombre = 0;
                int filaNacionalidad = 2;
                int filaSexo = 3;

                if (filasTablaGeneral.size() > 4) {
                    filaNombre = 2;
                    filaNacionalidad = 4;
                    filaSexo = 5;
                }

                //Se obtienen las columnas para cada atributo del invstigador
                String nombre = filasTablaGeneral.get(filaNombre).select("td").get(1).text();
                String nacionalidad = filasTablaGeneral.get(filaNacionalidad).select("td").get(1).text();
                String sexo = filasTablaGeneral.get(filaSexo).select("td").get(1).text();

                Element tablasLineaInves = documentoHTML.select("table").get(posTabla+1); //Se obtiene la segunda tabla
                Elements filasLineaInves = tablasLineaInves.select("tr"); // Se obtienen las filas de la tabla

                for (int i = 0; i < filasLineaInves.size(); i++){
                    localLineas[i] = filasLineaInves.get(i).text();
                }

                //Se crea el objeto investigador
                investigador = new Investigador(nombre, nacionalidad, sexo, true, localLineas);
            }else{
                    Element tablasGeneral = documentoHTML.select("table").get(1); //Se obtiene la segunda tabla
                    Elements filasTablaGeneral = tablasGeneral.select("tr"); // Se obtienen las filas de la tabla

                    int filaNombre = 0;
                    int filaNacionalidad = 2;
                    int filaSexo = 3;

                    if (filasTablaGeneral.size() > 4){
                        filaNombre = 2;
                        filaNacionalidad = 4;
                        filaSexo = 5;
                    }

                    //Se obtienen las columnas para cada atributo del invstigador
                    String nombre = filasTablaGeneral.get(filaNombre).select("td").get(1).text();
                    String nacionalidad = filasTablaGeneral.get(filaNacionalidad).select("td").get(1).text();
                    String sexo = filasTablaGeneral.get(filaSexo).select("td").get(1).text();

                    //Se crea el objeto investigador
                    investigador = new Investigador(nombre, nacionalidad,sexo,true, null);
            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        return investigador;

    }

    public static Investigador getH3(String url) {

        Investigador investigador = null;

        try {

            //Se obtiene el documento HTML
            Document documentoHTML = Jsoup.connect(url).get();

            Elements tablasGeneral = documentoHTML.select("h3"); //Se obtiene la segunda tabla

            for (int i = 0; i < tablasGeneral.size(); i++){
                Log.i("H3 [" + i + "]: " , tablasGeneral.get(i).text());
            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        return investigador;

    }
}
