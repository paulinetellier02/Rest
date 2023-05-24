package org.libreapps.rest;

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
import org.libreapps.rest.Notes;
import org.libreapps.rest.RegistrationActivity;
import org.libreapps.rest.obj.FctNote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

//chaque ligne utilisateur une colonne pour toutes les notes recuperer id user
public class AjoutNote extends AppCompatActivity {

    private int id;
    private ListView listViewNotes;
    private ArrayList listeTitre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_note);

        //code chat
        setContentView(R.layout.activity_ajout_note);
        listViewNotes = findViewById(R.id.listview_notes);

        //nom et type
        String titre = getIntent().getStringExtra("titre ");
        String note = getIntent().getStringExtra("note ");

        final EditText titreEditTxt = (EditText) findViewById(R.id.textview_titre);
        final EditText noteEditTxt = (EditText) findViewById(R.id.textview_note);


        Button buttonCancel = (Button) findViewById(R.id.button_cancel_n);
        Button buttonOk = (Button) findViewById(R.id.button_ok_n);

        if(noteEditTxt.getText().toString()==" ") {
            titreEditTxt.setText("Tapez le titre...");
            noteEditTxt.setText("Tapez votre texte...");
            buttonCancel.setText("Supprimer");
            buttonOk.setText("Modifier");
        }
        id =Param.getInstance().getIdUser();//TODO


        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(noteEditTxt.getText().toString()==" "){

                    try {
                        ConnectionRestNote connectionRest = new ConnectionRestNote();
                        JSONObject list_note = new JSONObject();
                        list_note.put("note:", note);
                        list_note.put("titre:",titre);
                        list_note.get("note:");
                        System.out.print(list_note.get("Notes"));
                        System.out.print(list_note.get("titre:"));

                        connectionRest.setObj(list_note);
                        connectionRest.setAction("notes");
                        connectionRest.execute("DELETE");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Intent intent = new Intent(AjoutNote.this, Notes.class);
                    startActivity(intent);
                }
                Intent intent = new Intent(AjoutNote.this, Notes.class);
                startActivity(intent);
                //return null;
            }

        });



        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ConnectionRestNote connectionRest = new ConnectionRestNote();
                    JSONObject list_note = new JSONObject();

                    if(noteEditTxt.getText().toString()==" "){

                        list_note.put("note bla",note);
                    }
                    list_note.put("titre:", titreEditTxt.getText().toString());
                    list_note.put("note:", noteEditTxt.getText().toString());
                    list_note.put("ID",id);
                    System.out.println(list_note.opt("titre:"));
                    System.out.println(list_note.opt("note:"));

                    //System.out.println(noteEditTxt.getText().toString());
                    System.out.println(titreEditTxt.getText().toString());
                    List<String> listeTitre = Arrays.asList(titreEditTxt.getText().toString());
                    System.out.println("AjoutNote");
                    System.out.println(listeTitre);
                    System.out.println(list_note);


                    connectionRest.setObj(list_note);

                    if(noteEditTxt.getText().toString()==" ") { // Modification
                        connectionRest.execute("PUT");
                    }else{ // Creation
                        connectionRest.execute("POST");
                    }
                    Intent intent = new Intent(AjoutNote.this, Notes.class);
                    startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //return null;
            }
        });
    }
}







