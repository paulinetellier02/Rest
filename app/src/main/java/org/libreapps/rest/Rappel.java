package org.libreapps.rest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Rappel extends AppCompatActivity {
    private Button buttonrappel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rappel);
        buttonrappel = (Button) findViewById(R.id.button_creer_rappel);

        buttonrappel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    setContentView(R.layout.activity_ajout_rappel);
                } finally {

                }
                ;
            };

        });
    }
}