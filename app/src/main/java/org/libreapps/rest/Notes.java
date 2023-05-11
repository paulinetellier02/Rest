package org.libreapps.rest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.libreapps.rest.obj.Note;
import org.libreapps.rest.obj.Profil;

import java.util.*;
import java.util.concurrent.ExecutionException;

public class Notes extends AppCompatActivity {
    private Button buttonnote;

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
        ArrayList<Note> listData = getListData();
        final ListView listView = (ListView) findViewById(R.id.listViewNotes);
        listView.setAdapter(new CustomListAdapter_notes(this, listData));


    }


    public ArrayList<Note> getListData(){
        try{
            ConnectionRest connectionRest = new ConnectionRest();
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

    public ArrayList<Note> parse(final String json) {
        try {
            final ArrayList<Note> notes = new ArrayList<>();
            final JSONArray jNotesArray = new JSONArray(json);
            for (int i = 0; i < jNotesArray.length(); i++) {
                notes.add(new Note(jNotesArray.optJSONObject(i)));
            }
            return notes;
        } catch (JSONException e) {
            Log.v("TAG","[JSONException] e : " + e.getMessage());
        }
        return null;
    }
}