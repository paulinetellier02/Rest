package org.libreapps.rest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class Calendrier extends AppCompatActivity {
    private Button buttonCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendrier);

        buttonCal = (Button) findViewById(R.id.button_ajouter_tdl);

        buttonCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Calendrier.this, AjoutCalendrier.class);
                    startActivity(intent);
                } finally {

                }
                ;
            };

        });

    }



}
