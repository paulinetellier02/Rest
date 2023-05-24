package org.libreapps.rest;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;
import android.widget.RadioButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.libreapps.rest.LoginActivity;
import org.libreapps.rest.RegistrationActivity;
import org.libreapps.rest.obj.Rappel;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

//chaque ligne utilisateur une colonne pour toutes les notes recuperer id user
public class AjoutRappel extends AppCompatActivity {

    private int id;
    private ArrayList listeRappel;
    private Button buttonOk;

    private RadioGroup radioGroupPeriode;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private String test2;
    RadioGroup test;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_rappel);
        String legende = getIntent().getStringExtra("legende");
        String heure = getIntent().getStringExtra("heure ");
        String time = getIntent().getStringExtra("time");

        final EditText legendeEditTxt = (EditText) findViewById(R.id.editTextLegende);
        final EditText timeEditTxt = (EditText) findViewById(R.id.editTextTime);

        Button buttonOk = (Button) findViewById(R.id.button_creer_evenement);
        CheckedTextView checkedTextView = findViewById(R.id.checkedTextView);
        CheckedTextView checkedTextView2 = findViewById(R.id.checkedTextView2);

        if(legendeEditTxt.getText().toString()==" ") {
            legendeEditTxt.setText("Tapez le titre...");
            timeEditTxt.setText("Tapez votre texte...");
            buttonOk.setText("Modifier");
        }
        id =Param.getInstance().getIdUser();//TODO

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkedTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        CheckedTextView checkedView = (CheckedTextView) v;
                        boolean checked = checkedView.isChecked();
                        checkedView.setChecked(!checked);

                try {
                    ConnectionRest_rap connectionRest = new ConnectionRest_rap();
                    JSONObject listerappel = new JSONObject();

                    if(legendeEditTxt.getText().toString()==" "){

                        listerappel.put("tdl",legende);
                    }

                    listerappel.put("legende:", legendeEditTxt.getText().toString());
                    listerappel.put("heure:", timeEditTxt.getText().toString());
                    listerappel.put("periode:", "une fois");
                    //listerappel.put("periode:", "plusieurs fois");
                    listerappel.put("ID",id);

                    connectionRest.setObj(listerappel);

                    if(legendeEditTxt.getText().toString()==" ") { // Modification
                        connectionRest.execute("PUT");
                    }else{ // Creation
                        connectionRest.execute("POST");
                    }
                    Intent intent = new Intent(AjoutRappel.this, Rappels.class);
                    startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                    }
                });

                checkedTextView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        CheckedTextView checkedView2 = (CheckedTextView) v;
                        boolean checked = checkedView2.isChecked();
                        checkedView2.setChecked(!checked);

                        try {
                            ConnectionRest_rap connectionRest = new ConnectionRest_rap();
                            JSONObject listerappel = new JSONObject();

                            if(legendeEditTxt.getText().toString()==" "){

                                listerappel.put("tdl",legende);
                            }

                            listerappel.put("legende:", legendeEditTxt.getText().toString());
                            listerappel.put("heure:", timeEditTxt.getText().toString());
                            listerappel.put("periode:", "plusieurs fois");
                            listerappel.put("ID",id);

                            connectionRest.setObj(listerappel);

                            if(legendeEditTxt.getText().toString()==" ") { // Modification
                                connectionRest.execute("PUT");
                            }else{ // Creation
                                connectionRest.execute("POST");
                            }
                            Intent intent = new Intent(AjoutRappel.this, Rappels.class);
                            startActivity(intent);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });


            }
        });
    }

    }
