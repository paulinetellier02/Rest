package org.libreapps.rest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.libreapps.rest.obj.FctNote;
import org.libreapps.rest.LoginActivity;


import java.util.*;
import java.util.concurrent.ExecutionException;

public class Notes extends AppCompatActivity {
    private Button buttonnote;
    private int id;
    private String indice_note,titre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        buttonnote= (Button) findViewById(R.id.button_creer_note);

        buttonnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Notes.this, AjoutNote.class);
                startActivity(intent);
                ;
            };

        });
        titre = "aa";//TODO
        ArrayList<FctNote> listData = getListData();
        for (int i=0; i<listData.size();i++){
            //FctNote indice_note = listData.get(i);
            FctNote auction = listData.get(i);
            if (titre.equals(auction.getTitre())){
                System.out.println("oui");

            }


        }
        final ListView listView = (ListView) findViewById(R.id.listViewNotes);
        listView.setAdapter(new CustomListAdapter_notes(this, listData)); //remplie list view




    }


    public ArrayList<FctNote> getListData(){
        try{
            ConnectionRestNote connectionRest = new ConnectionRestNote();
            connectionRest.setAction("notes");
            connectionRest.execute("GET");
            String listJsonObjs = connectionRest.get();
            if(listJsonObjs != null) {
                return parse(listJsonObjs);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<FctNote> parse(final String json) {
        try {
            final ArrayList<FctNote> notes = new ArrayList<>();
            final JSONArray jNotesArray = new JSONArray(json);
            for (int i = 0; i < jNotesArray.length(); i++) {
                notes.add(new FctNote(jNotesArray.optJSONObject(i)));
            }
            return notes;
        } catch (JSONException e) {
            Log.v("TAG","[JSONException] e : " + e.getMessage());
        }
        return null;
    }


}