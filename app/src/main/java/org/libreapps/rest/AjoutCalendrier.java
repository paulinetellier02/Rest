package org.libreapps.rest;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.libreapps.rest.LoginActivity;
import org.libreapps.rest.RegistrationActivity;
import org.libreapps.rest.obj.Event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

//chaque ligne utilisateur une colonne pour toutes les notes recuperer id user
public class AjoutCalendrier extends AppCompatActivity {

    private int id;
    private ArrayList listecal;
    private Button buttonOk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_calendier);
        String nom = getIntent().getStringExtra("nom");
        String heure = getIntent().getStringExtra("heure ");
        String date = getIntent().getStringExtra("date ");


        final EditText nomEditTxt = (EditText) findViewById(R.id.editText_nom_evenement);
        final EditText heureEditTxt = (EditText) findViewById(R.id.editTextTime2);
        final EditText dateEditTxt = (EditText) findViewById(R.id.editTextDate2);
        Button buttonOk = (Button) findViewById(R.id.button_creer_evenement);

        if(nomEditTxt.getText().toString()==" ") {
            nomEditTxt.setText("Tapez le titre...");
            //nomEditTxt.setText("Tapez votre texte...");
            buttonOk.setText("Modifier");
        }
        id =Param.getInstance().getIdUser();//TODO

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ConnectionRest_cal connectionRest = new ConnectionRest_cal();
                    JSONObject listecal = new JSONObject();

                    if(nomEditTxt.getText().toString()==" "){

                        listecal.put("calendrier",nom);
                    }
                    listecal.put("nom_event:", nomEditTxt.getText().toString());
                    listecal.put("date:", dateEditTxt.getText().toString());
                    listecal.put("heure:", heureEditTxt.getText().toString());
                    listecal.put("ID:",id);

                    System.out.println(nomEditTxt.getText().toString());
                    //System.out.println(legendeEditTxt.getText().toString());
                    //List<String> listeRap = Arrays.asList(legendeEditTxt.getText().toString());
                    //System.out.println(listeRap);
                    //System.out.println(listerappel);




                    connectionRest.setObj(listecal);

                    if(nomEditTxt.getText().toString()==" ") { // Modification
                        connectionRest.execute("PUT");
                    }else{ // Creation
                        connectionRest.execute("POST");
                    }
                    Intent intent = new Intent(AjoutCalendrier.this, Calendrier.class);
                    startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //return null;
            }
        });
    }
}