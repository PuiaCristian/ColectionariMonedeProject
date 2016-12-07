package com.example.puya_.colectionarimonedeproject;

/**
 * Created by rusuvalentin on 07/12/2016.
 */

public class UtilizatorJavaClass {
    private String id;
    private String nume;
    private String prenume;
    private String user;
    private String password;
    private String data;
    private String email;



    public UtilizatorJavaClass(String id, String nume, String prenume, String user, String password, String data, String email) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.user = user;
        this.password = password;
        this.data = data;
        this.email = email;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
