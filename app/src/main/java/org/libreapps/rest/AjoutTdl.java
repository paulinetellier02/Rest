package org.libreapps.rest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.*;
public class AjoutTdl extends AppCompatActivity {

    private EditText nomTLD, legendeTLD;
    private CheckBox tache1, tache2, tache3;
    private String titre, legende;
    private ArrayList<String> taches = new ArrayList<>();
    private Button button_Ajouter_tdl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_tdl);
    /*on recupère les id des éléments rentrés par l'utilisateur*/
        nomTLD = findViewById(R.id.nomTLD);
        legendeTLD = findViewById(R.id.legendeTLD);
        tache1 = findViewById(R.id.tache1);
        tache2 = findViewById(R.id.tache2);
        tache3 = findViewById(R.id.tache3);

        Button buttonAjouterTdl = findViewById(R.id.button_ajouter_rappel);
        buttonAjouterTdl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Récupération des données entrées par l'utilisateur en mode text*/
                titre = nomTLD.getText().toString();
                legende = legendeTLD.getText().toString();
                if (tache1.isChecked()) {
                    taches.add(tache1.getText().toString());
                }
                if (tache2.isChecked()) {
                    taches.add(tache2.getText().toString());
                }
                if (tache3.isChecked()) {
                    taches.add(tache3.getText().toString());
                }
                // Affichage des données pour vérification
                Log.d("Titre", titre);
                Log.d("Légende", legende);
                Log.d("Tâches", taches.toString());
            }
        });

            ArrayList<String> list_Taches;
            list_Taches = new ArrayList<String>();
            list_Taches.add("tâche 1");
            list_Taches.add("tâche  2");
            list_Taches.add("tâche 3");


            //retour vers la page to do list après avoir créer une nouvelle to do list
            button_Ajouter_tdl = (Button) findViewById(R.id.button_ajouter_rappel);

            button_Ajouter_tdl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(AjoutTdl.this, Todolist.class);
                    startActivity(intent);
                    //dès qu'on ajoute une tache on la rajoute à la liste




                }

                ;

            });
    }
}

