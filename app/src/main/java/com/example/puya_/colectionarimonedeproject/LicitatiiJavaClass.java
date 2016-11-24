package com.example.puya_.colectionarimonedeproject;

/**
 * Created by rusuvalentin on 24/11/2016.
 */

public class LicitatiiJavaClass {

    private String nume;
    private String descriere;
    private String pretPornire;

    public LicitatiiJavaClass(String nume, String descriere, String pretPornire) {
        this.nume = nume;
        this.descriere = descriere;
        this.pretPornire = pretPornire;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public String getPretPornire() {
        return pretPornire;
    }

    public void setPretPornire(String pretPornire) {
        this.pretPornire = pretPornire;
    }
}
