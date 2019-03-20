package edu.cecar.controladores;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExtraerDatoCVLACUnitTest {

    @Rule
    public GestionTestExtraerDatoCVLAC gestionTestExtraerDatoCVLAC = new GestionTestExtraerDatoCVLAC();

    @Test
    public void testDatosCVLAC() {
        DatosInvestigadores matdatinv[]= new DatosInvestigadores[5];
        matdatinv[0] = new DatosInvestigadores("http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0001376707","Guillermo Carlos Hernández Hernández","Masculino",false,0);
        matdatinv[1] = new DatosInvestigadores("http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0000402478","Luty Del Carmen Gomezcaceres Peréz","Femenino",true,3);
        matdatinv[2] = new DatosInvestigadores("http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0000733180","Jhon Jaime Mendez Alandete","Masculino",false,1);
        matdatinv[3] = new DatosInvestigadores("http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0000787132","Namuel Francisco Solórzano Peralta","Masculino",false,0);
        matdatinv[4] = new DatosInvestigadores("http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0001414537","Adriana Patricia Arboleda Lopez","Femenino",true,5);

        Investigador investigador1 = ExtraerDatoCVLAC.getDatosH3(matdatinv[0].urlinv);

        // Se comprueba o testea el valor esperado con el obtenido
        System.out.println("Comparacion 1: " + matdatinv[0].numlininv + " - " + investigador1.getLineas().length);

        assertEquals(false, matdatinv[0].numlininv > 0 && investigador1.getLineas().length > 0); //si tiene lineas de investigacion
        assertEquals(matdatinv[0].catinv,investigador1.isCategorizado());  // si esta categorizado
        assertEquals(matdatinv[0].nominv, investigador1.getNombres()); // Se comparan nombres
        assertEquals(matdatinv[0].sexinv, investigador1.getSexo()); // Se comparan sexos
        //assertEquals(matdatinv[0].numlininv, investigador1.getLineas().length);

        Investigador investigador2 = ExtraerDatoCVLAC.getDatosH3(matdatinv[1].urlinv);

        System.out.println("Comparacion 2: " + matdatinv[1].numlininv + " - " + investigador2.getLineas().length);

        assertEquals(true, matdatinv[1].numlininv > 0 && investigador2.getLineas().length > 0); //si tiene lineas de investigacion
        assertEquals(matdatinv[1].catinv,investigador2.isCategorizado());  // si esta categorizado
        assertEquals(matdatinv[1].nominv, investigador2.getNombres()); // Se comparan nombres
        assertEquals(matdatinv[1].sexinv, investigador2.getSexo()); // Se comparan sexos
        assertEquals(matdatinv[1].numlininv,investigador2.getLineas().length ); //si son iguales el numero lineas de investigacion

        Investigador investigador3 = ExtraerDatoCVLAC.getDatosH3(matdatinv[2].urlinv);

        System.out.println("Comparacion 3: " + matdatinv[2].numlininv + " - " + investigador3.getLineas().length);

        assertEquals(true, matdatinv[2].numlininv > 0 && investigador3.getLineas().length > 0); //si tiene lineas de investigacion
        assertEquals(matdatinv[2].catinv,investigador3.isCategorizado());  // si esta categorizado
        assertEquals(matdatinv[2].nominv, investigador3.getNombres()); // Se comparan nombres
        assertEquals(matdatinv[2].sexinv, investigador3.getSexo()); // Se comparan sexos
        assertEquals(matdatinv[2].numlininv, investigador3.getLineas().length);

        Investigador investigador4 = ExtraerDatoCVLAC.getDatosH3(matdatinv[3].urlinv);

        System.out.println("Comparacion 4: " + matdatinv[3].numlininv + " - " + investigador4.getLineas().length);

        assertEquals(false, matdatinv[3].numlininv > 0 && investigador4.getLineas().length > 0); //si tiene lineas de investigacion
        assertEquals(matdatinv[3].catinv,investigador4.isCategorizado());  // si esta categorizado
        assertEquals(matdatinv[3].nominv, investigador4.getNombres()); // Se comparan nombres
        assertEquals(matdatinv[3].sexinv, investigador4.getSexo()); // Se comparan sexos
        assertEquals(matdatinv[3].numlininv,investigador4.getLineas().length ); //si son iguales el numero lineas de investigacion


        Investigador investigador5 = ExtraerDatoCVLAC.getDatosH3(matdatinv[4].urlinv);

        System.out.println("Comparacion 5: " + matdatinv[4].numlininv + " - " + investigador5.getLineas().length);

        assertEquals(true, matdatinv[4].numlininv > 0 && investigador5.getLineas().length > 0); //si tiene lineas de investigacion
        assertEquals(matdatinv[4].catinv,investigador5.isCategorizado());  // si esta categorizado
        assertEquals(matdatinv[4].nominv, investigador5.getNombres()); // Se comparan nombres
        assertEquals(matdatinv[4].sexinv, investigador5.getSexo()); // Se comparan sexos
        assertEquals(matdatinv[4].numlininv, investigador5.getLineas().length);
    }
}