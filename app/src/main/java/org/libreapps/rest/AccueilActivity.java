package org.libreapps.rest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class AccueilActivity extends AppCompatActivity {

    private Button buttonConnexion, buttonInscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);

        buttonConnexion = (Button) findViewById(R.id.button_connexion);
        buttonInscription = (Button) findViewById(R.id.Inscription);

        buttonConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    setContentView(R.layout.activity_login);

            };

        });

        buttonInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    setContentView(R.layout.activity_registration);

            };

        });


    }
}