package org.libreapps.rest.obj;

import org.json.JSONObject;

public class User {
    private String adresse_mail;
    private String mdp;
    private String nom;
    private String prenom;
    private String date_naissance;

    public User(JSONObject jObject) {
        this.adresse_mail = jObject.optString("Adresse mail");
        this.mdp = jObject.optString("Mot de passe");
        this.nom = jObject.optString("Nom");
        this.prenom = jObject.optString("Prenom");
        this.date_naissance = jObject.optString("Date de naissance");
    }

    public String getAdresse_mail() {
        return adresse_mail;
    }

    public void setAdresse_mail(String adresse_mail) {
        this.adresse_mail = adresse_mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }
}
