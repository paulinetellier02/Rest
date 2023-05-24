package org.libreapps.rest.obj;

import android.widget.ListView;

import org.json.JSONObject;
import org.libreapps.rest.R;

import java.util.ArrayList;

public class Tdl {
    private  int id ;
    private  String legende;
    private  String nom;


    public void setId(int id) {
        this.id = id;
    }

    public Tdl(JSONObject jObject) {
        this.id = jObject.optInt("id");
        this.legende = jObject.optString("legende");
        this.nom= jObject.optString("nom");

    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLegende() {
        return legende;
    }

    public void setLegende(String legende) {
        this.legende = legende;
    }

    public int getId() {
        return id; }
    public String getLegend() {
        return legende; }
    public String getNom() {
        return nom; }

}
