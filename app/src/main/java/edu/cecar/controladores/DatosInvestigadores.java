package edu.cecar.controladores;

class DatosInvestigadores {
    String urlinv;
    String nominv;
    boolean catinv;
    String sexinv;
    int numlininv;

    public DatosInvestigadores(String urlinv, String nominv, String sexinv, boolean catinv, int numlininv) {
        this.urlinv = urlinv;
        this.nominv = nominv;
        this.sexinv = sexinv;
        this.catinv = catinv;
        this.numlininv = numlininv;
    }
}