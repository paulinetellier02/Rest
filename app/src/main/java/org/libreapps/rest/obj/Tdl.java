package org.libreapps.rest.obj;

import org.json.JSONObject;

public class Tdl {
    private final int id ;
    private final String legende;
    private final String nom;



    public Tdl(JSONObject jObject) {
        this.id = jObject.optInt("id");
        this.legende = jObject.optString("legende");
        this.nom= jObject.optString("nom");

    }


    public int getId() {
        return id; }
    public String getLegend() {
        return legende; }
    public String getNom() {
        return nom; }

}
