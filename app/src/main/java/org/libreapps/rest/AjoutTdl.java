package org.libreapps.rest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.*;

public class AjoutTdl extends AppCompatActivity {
    private Button button_Ajouter_tdl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_tdl);



        ArrayList<String> list_Taches;
        list_Taches = new ArrayList<String>();
        list_Taches.add("tâche 1");
        list_Taches.add("tâche  2");
        list_Taches.add("tâche 3");

        button_Ajouter_tdl = (Button) findViewById(R.id.button_ajouter_tdl);

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