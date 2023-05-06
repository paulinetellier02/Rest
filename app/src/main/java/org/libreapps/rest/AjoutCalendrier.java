package org.libreapps.rest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class AjoutCalendrier extends AppCompatActivity {
    private EditText editTextNomEvenement;
    private DatePicker datePickerEvenement;
    private Button buttonCouleurEvenement;
    private Button buttonCreerEvenement;
    private Spinner spinnerCouleurEvenement;
    private ArrayAdapter<CharSequence> couleurAdapter;
    private TimePicker timePickerEvenement;


    private int selectedColor = Color.RED; // Couleur par défaut (rouge)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_calendier);

        // Récupérer les références des vues
        editTextNomEvenement = findViewById(R.id.editText_nom_evenement);
        datePickerEvenement = findViewById(R.id.datePicker_evenement);
        buttonCreerEvenement = findViewById(R.id.button_creer_evenement);
        timePickerEvenement = findViewById(R.id.timePicker_evenement);

        // Définir le listener pour le bouton de choix de couleur


        // Définir le listener pour le bouton de création d'événement
        buttonCreerEvenement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupérer les valeurs saisies par l'utilisateur
                String nomEvenement = editTextNomEvenement.getText().toString();
                int jour = datePickerEvenement.getDayOfMonth();
                int mois = datePickerEvenement.getMonth();
                int annee = datePickerEvenement.getYear();
                int heure = timePickerEvenement.getHour();
                int minute = timePickerEvenement.getMinute();
                // Ici, vous pouvez utiliser les valeurs récupérées pour créer l'événement
                // par exemple, en utilisant une bibliothèque de calendrier ou en enregistrant les informations dans une base de données

                // Dans cet exemple, nous affichons simplement les valeurs récupérées
                String dateEvenement = jour + "/" + (mois + 1) + "/" + annee;
                String message = "Nom de l'événement : " + nomEvenement + "\n"
                        + "Date de l'événement : " + dateEvenement + "\n"
                        + "Couleur de l'événement : " + String.format("#%06X", (0xFFFFFF & selectedColor));

                // Afficher un message pour vérifier les valeurs
                Toast.makeText(AjoutCalendrier.this, message, Toast.LENGTH_SHORT).show();
            }
        });



    }
}

