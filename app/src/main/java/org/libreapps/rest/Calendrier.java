package org.libreapps.rest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;


public class Calendrier extends AppCompatActivity {
    private Button button_Ajouter_event;
    private CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendrier);

        button_Ajouter_event = (Button) findViewById(R.id.button_ajouter_event);
        calendarView = (CalendarView) findViewById(R.id.calendarView);

        // Récupérer la date d'aujourd'hui
        Calendar today = Calendar.getInstance();
        long currentDate = today.getTimeInMillis();

        // Définir la date d'aujourd'hui dans le calendrier
        calendarView.setDate(currentDate);

        button_Ajouter_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Calendrier.this, AjoutCalendrier.class);
                    startActivity(intent);
                } finally {

                }
            }
        });
    }
}



/*public class Calendrier extends AppCompatActivity {
    private Button button_Ajouter_event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendrier);

        button_Ajouter_event = (Button) findViewById(R.id.button_ajouter_event);



        button_Ajouter_event.setOnClickListener(new View.OnClickListener() {
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



}*/
