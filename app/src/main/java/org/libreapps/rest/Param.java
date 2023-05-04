package org.libreapps.rest;

public class Param {
    private String token;
    private int idUser;
    private static Param param;

    private Param() {
    }

    public static Param getInstance() {
        if (param == null) {
            param = new Param();
        }
        return param;
    }

    public void setToken(String token) { this.token = token; }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getToken() { return token; }
    public int getIdUser() {return idUser;}
}
