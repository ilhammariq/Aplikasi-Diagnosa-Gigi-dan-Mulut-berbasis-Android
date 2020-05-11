package com.kelompok.sistempakar.models;

public class Kelas_Login {
    String username,password;
    // constructors
    public Kelas_Login() {

    }

    public Kelas_Login(String username, String password) {
        this.username = username;
        this.password = password;
    }



    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
}
