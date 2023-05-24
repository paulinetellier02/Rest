package org.libreapps.rest.obj;

import org.json.JSONObject;

public class Rappel {
    private  int id ;
    private  String legende;
    private  String heure;
    private  String periode;


    public Rappel(JSONObject jObject) {

        this.id = jObject.optInt("id");
        this.legende = jObject.optString("legende");
        this.heure = jObject.optString("heure");
        this.periode = jObject.optString("periode");
    }


    public int getId() {
        return id; }
    public String getLegend() {
        return legende; }
    public String getHeure() {
        return heure; }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public String getPeriode() {
        return periode; }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setLegende(String legende) {
        this.legende = legende;
    }

}
