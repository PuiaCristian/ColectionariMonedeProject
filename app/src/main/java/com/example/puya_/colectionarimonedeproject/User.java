package com.example.puya_.colectionarimonedeproject;

/**
 * Created by rusuvalentin on 24/11/2016.
 */

public class User {
    public int id;
    public String user;
    public String nume;
    public String prenume;
    public String data;
    public String sex;
    public String email;
    public String parola;

    public User(){

    }

    public User(String user, String nume, String prenume, String data, String sex, String email, String parola){
        this.user=user;
        this.nume=nume;
        this.prenume=prenume;
        this.data=data;
        this.sex=sex;
        this.email=email;
        this.parola=parola;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
