/**
 * Clase: Investigador.java
 * <p>
 * Version: 0.1
 * <p>
 * Fecha Creaci�n: 12/02/2019
 * <p>
 * Ultima Fecha de Modificaci�n:
 * <p>
 * Copyright: Jhon Jaime Mendez
 */

package edu.cecar.controladores;

/**
 Esta clase modela los datos de un Investigador
 */

public class Investigador {

    private String nombres;
    private String nacionalidad;
    private String sexo;
    private boolean categorizado;
    private String categoria;
    private String[] lineas;

    private int conhom = 0;
    private int conmuj = 0;
    private int concat = 0;
    private int consincat = 0;
    private int conlininv = 0;
    private int consininv = 0;

    public Investigador() {
    }

    public Investigador(String nombres, String nacionalidad, String sexo, boolean categorizado, String categoria, String[] lineas) {

        this.nombres = nombres;
        this.nacionalidad = nacionalidad;
        this.sexo = sexo;
        this.categorizado = categorizado;
        this.categoria = categoria;
        this.lineas = lineas;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean isCategorizado() {
        return categorizado;
    }

    public String[] getLineas() {
        return lineas;
    }

    public void setLineas(String[] lineas) {
        this.lineas = lineas;
    }

    public int getConhom() {
        return conhom;
    }

    public void setConhom(int conhom) {
        this.conhom = conhom;
    }

    public int getConmuj() {
        return conmuj;
    }

    public void setConmuj(int conmuj) {
        this.conmuj = conmuj;
    }

    public int getConcat() {
        return concat;
    }

    public void setConcat(int concat) {
        this.concat = concat;
    }

    public int getConsincat() {
        return consincat;
    }

    public void setConsincat(int consincat) {
        this.consincat = consincat;
    }

    public int getConlininv() {
        return conlininv;
    }

    public void setConlininv(int conlininv) {
        this.conlininv = conlininv;
    }

    public int getConsininv() {
        return consininv;
    }

    public void setConsininv(int consininv) {
        this.consininv = consininv;
    }
}
