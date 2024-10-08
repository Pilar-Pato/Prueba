package com.factoriaf5.model;

public class UserModel {
    private String nameUser;
    private int password;

    public UserModel(String nameUser, int password) {
        this.nameUser = nameUser;
        this.password = password;
    }

    public String getNameUser() {
        return nameUser;
}

    public void setNameUser(String nameUser){
        this.nameUser = nameUser;
}

    public int password(int password) {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public boolean login(int password) {
        return this.password == password;
    }
}
