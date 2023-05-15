package org.libreapps.rest.obj;

import org.json.JSONObject;

public class Event{
    private final int id ;
    private final String Nom_event;
    private final String date;
    private final String heure;


    public Event(JSONObject jObject) {
        this.id =jObject.optInt("id");
        this.Nom_event= jObject.optString("Nom_event");
        this.date = jObject.optString("date");
        this.heure = jObject.optString("heure");
    }

    public int getId() {
        return id; }
    public String getNom_event() {
        return Nom_event; }
    public String getDate() {
        return date; }
    public String getHeure() {
        return heure; }

}


