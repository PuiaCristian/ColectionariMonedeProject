package com.example.puya_.colectionarimonedeproject;

/**
 * Created by puya_ on 11/24/2016.
 */

public class EvenimenteJavaClass {

    private String nume;
    private String locatie;
    private String descriere;
    private String data;

    public EvenimenteJavaClass(){

    }

    public EvenimenteJavaClass(String nume, String locatie, String descriere, String data) {
        this.nume = nume;
        this.locatie = locatie;
        this.descriere = descriere;
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
