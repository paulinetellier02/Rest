package org.libreapps.rest.obj;

import org.json.JSONObject;

public class User {
    private  int id ;
    private  String nom;
    private  String prenom,adresse_mail,mdp;



    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }




    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public User(JSONObject jObject) {
        this.id =jObject.optInt("id");
        this.nom = jObject.optString("Nom");
        this.prenom = jObject.optString("Prenom");
        this.adresse_mail = adresse_mail;

    }

    public int getId() {
        return id; }
    public String getNom() {
        return nom; }
    public String getPrenom() {
        return prenom; }

}


