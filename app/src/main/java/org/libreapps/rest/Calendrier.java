package org.libreapps.rest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import androidx.appcompat.app.AppCompatActivity;

import org.libreapps.rest.obj.Profil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.ExecutionException;


public class Calendrier extends AppCompatActivity {
    private Button button_Ajouter_event;
    private CalendarView calendarView;

    String data=null;
    ArrayList<Profil> listprofil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendrier);

        button_Ajouter_event = (Button) findViewById(R.id.button_ajouter_event);
        calendarView = (CalendarView) findViewById(R.id.calendarView);

        try {
            ConnectionRest connectionRest = new ConnectionRest();
            connectionRest.setAction("Profil");
            connectionRest.execute("GET");
            data = connectionRest.get();
            listprofil = connectionRest.parse(data);

            }
        catch (ExecutionException e)
        { throw new RuntimeException(e);}
        catch (InterruptedException e) {
            throw new RuntimeException(e); }
        //recup id profil connecté



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
