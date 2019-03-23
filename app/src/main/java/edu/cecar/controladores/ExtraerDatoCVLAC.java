package edu.cecar.controladores;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ExtraerDatoCVLAC {

    private ExtraerDatoCVLAC() {
    }

    public synchronized static Investigador getDatosH3(String url) {
        Investigador investigador = null;
        int posTabla = -1;
        String[] localLineas;

        try {
            //Se obtiene el documento HTML
            Document documentoHTML = Jsoup.connect(url).get();

            Elements h3 = documentoHTML.select("h3"); //Se obtiene la segunda tabla

            for (int i = 0; i < h3.size(); i++) {
                if (h3.get(i).text().trim().equals("Líneas de investigación")) {
                    posTabla = i;
                }
            }

            Element tablasGeneral = documentoHTML.select("table").get(1); //Se obtiene la segunda tabla
            Elements filasTablaGeneral = tablasGeneral.select("tr"); // Se obtienen las filas de la tabla

            int filaNombre = 0;
            int filaNacionalidad = 2;
            int filaSexo = 3;
            int filacategoria = -1;
            boolean categorizado = false;

            if (filasTablaGeneral.size() > 4) {
                filacategoria = 1;
                filaNombre = 2;
                filaNacionalidad = 4;
                filaSexo = 5;
                categorizado = true;
            }

            //Se obtienen las columnas para cada atributo del invstigador
            String nombre = filasTablaGeneral.get(filaNombre).select("td").get(1).text();
            String nacionalidad = filasTablaGeneral.get(filaNacionalidad).select("td").get(1).text();
            String sexo = filasTablaGeneral.get(filaSexo).select("td").get(1).text();
            String categoria;

            if (filacategoria > 0) {
                categoria = filasTablaGeneral.get(filacategoria).select("td").get(1).text();
            } else {
                categoria = "No esta categorizado.";
            }

            if (posTabla != -1) {
                Element tablasLineaInves = documentoHTML.select("table").get(posTabla + 1); //Se obtiene la segunda tabla
                Elements filasLineaInves = tablasLineaInves.select("tr");
                int j = 0;

                localLineas = new String[filasLineaInves.size() - 1];

                for (int i = 1; i < filasLineaInves.size(); i++) {
                    localLineas[j] = filasLineaInves.get(i).text();
                    j++;
                }
            }else{
                localLineas = new String[0];
            }

            //Se crea el objeto investigador
            investigador = new Investigador(nombre, nacionalidad, sexo, categorizado, categoria, localLineas);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return investigador;
    }
}