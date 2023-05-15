package org.libreapps.rest.obj;

import org.json.JSONObject;

public class Rappel {
    private final int id ;
    private final String legende;
    private final String heure;
    private final String periode;


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
    public String getPeriode() {
        return periode; }
}
