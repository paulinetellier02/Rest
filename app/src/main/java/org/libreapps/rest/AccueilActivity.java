package org.libreapps.rest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;




public class AccueilActivity extends AppCompatActivity {

    private Button buttonConnexion, buttonInscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);

        buttonConnexion = (Button) findViewById(R.id.Connexion);
        buttonInscription = (Button) findViewById(R.id.Inscription);

        buttonConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    setContentView(R.layout.activity_login);
                } finally {

                }
                ;
            };

        });

        buttonInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    setContentView(R.layout.activity_registration);
                } finally {

                }
                ;
            };

        });


    }
}