package edu.cecar.controladores;

public class Investigadores {
    DatosInvestigadores matdatinv[];

    public Investigadores(int modo) //modo=0 producción, modo=1 testeo
    {
        matdatinv = new DatosInvestigadores[5];
        if (modo == 0) {
            this.cargar_datos_investigadores_produccion();
        } else {
            this.cargar_datos_investigadores_testeo();
        }
    }

    public void cargar_datos_investigadores_produccion() {

        matdatinv[0] = new DatosInvestigadores("http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0001376707", "Guillermo Carlos Hernández Hernández");
        matdatinv[1] = new DatosInvestigadores("http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0000402478", "Luty Del Carmen Gomezcaceres Peréz");
        matdatinv[2] = new DatosInvestigadores("http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0000733180", "Jhon Jaime Mendez Alandete");
        matdatinv[3] = new DatosInvestigadores("http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0000787132", "Namuel Francisco Solórzano Peralta");
        matdatinv[4] = new DatosInvestigadores("http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0001414537", "Adriana Patricia Arboleda Lopez");
    }

    public void cargar_datos_investigadores_testeo() {

        matdatinv[0] = new DatosInvestigadores("http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0001376707", "Guillermo Carlos Hernández Hernández", "Masculino", false, 0);
        matdatinv[1] = new DatosInvestigadores("http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0000402478", "Luty Del Carmen Gomezcaceres Peréz", "Femenino", true, 3);
        matdatinv[2] = new DatosInvestigadores("http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0000733180", "Jhon Jaime Mendez Alandete", "Masculino", false, 1);
        matdatinv[3] = new DatosInvestigadores("http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0000787132", "Namuel Francisco Solórzano Peralta", "Masculino", false, 0);
        matdatinv[4] = new DatosInvestigadores("http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0001414537", "Adriana Patricia Arboleda Lopez", "Femenino", true, 5);
    }
}