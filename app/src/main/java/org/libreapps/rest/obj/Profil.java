package org.libreapps.rest.obj;

import org.json.JSONObject;

    public class Profil {
        private final int id ;
        private final String nom;
        private final String prenom;
        private final String calendrier;


        public Profil(JSONObject jObject) {
            this.id =jObject.optInt("id");
            this.nom = jObject.optString("Nom");
            this.prenom = jObject.optString("Prenom");
            this.calendrier = jObject.optString("calendrier");
             }

        public int getId() {
            return id; }
        public String getNom() {
            return nom; }
        public String getPrenom() {
            return prenom; }

}
