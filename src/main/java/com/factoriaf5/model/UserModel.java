package com.factoriaf5.model;

public class UserModel {
    private int id_user;
    private String nombre_user;
    private int password;

    public UserModel(int id_user, String nombre_user, int password) {
        this.nombre_user = nombre_user;
        this.password = password;
        this.id_user = id_user;
    }

    public int getId(){
        return id_user;
    }

    public void setId_user(int id_user){
        this.id_user = id_user;
    }
    
    public String getNombre_user() {
        return nombre_user;
}

    public void setNombre_user(String nombre_user){
        this.nombre_user = nombre_user;
}

    public int getPassword(int password) {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public boolean login(String nombreUser, int password) {
        return this.nombre_user.equals(nombreUser) && this.password == password;
    }
}
