package org.libreapps.rest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;


import org.libreapps.rest.obj.FctNote;

import android.view.Menu;
import android.view.MenuItem;


import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Notes extends AppCompatActivity {
    private Button buttonnote;
    private int id;

    private String indice_note, titre;
    private Spinner spinner;
    private ArrayAdapter<String> spinnerAdapter;
    private ArrayList<FctNote> listData;
    private ArrayList<String> notes;
    private ListView listView;
    private ArrayAdapter<FctNote> listAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);


        ArrayList<FctNote> listData = getListData();
        final ListView listView = (ListView) findViewById(R.id.listnote);
        System.out.println("listData");
        System.out.println(listData.get(0));
        listView.setAdapter(new CustomListAdapter_notes(this, listData));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                FctNote upload = (FctNote) o;
                Intent intent = new Intent(Notes.this, Notes.class);
                intent.putExtra("id", upload.getId());
                intent.putExtra("titre", upload.getTitre());
                intent.putExtra("note", upload.getNote());
                startActivity(intent);
            }
        });
        buttonnote = findViewById(R.id.button_creer_note);

        id =Param.getInstance().getIdUser();


        buttonnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Notes.this, AjoutNote.class);
                startActivity(intent);
                //return null;
            }
        });

        /*listData = getListData();//creation du spinner avec tous les titres
        ArrayList<String> noteTitles = new ArrayList<>();
        for (FctNote note : listData) {
            noteTitles.add(note.getTitre());
        }*/
// Créer l'adaptateur pour le Spinner avec les titres des notes
        /*spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, noteTitles);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAdapter.add("Nouvel élément 1");
        spinnerAdapter.add("Nouvel élément 2");

// Rafraîchissez l'affichage du Spinner
        spinnerAdapter.notifyDataSetChanged();
        spinner.setAdapter(spinnerAdapter);

        //spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //@Override
            //public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            // Récupérer l'élément sélectionné
                //String selectedTitle = parent.getItemAtPosition(position).toString();

            //}});

*/

// When the user clicks on the ListItem

/*FloatingActionButton fab = findViewById(R.id.fabnotes);

if ("ADMIN ".equals( id)){
fab.setVisibility(View.VISIBLE);

}
else {
fab.setVisibility(View.GONE);
}
fab.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
Intent intent = new Intent(Notes.this, AjoutNote.class);
startActivity(intent);
}
});*/
    }

/*private void setAdapter() {
RecyclerAdapterNote adapter = new RecyclerAdapterNote(listData);
RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
recyclerView.setLayoutManager(layoutManager);
recyclerView.setItemAnimator(new DefaultItemAnimator());
recyclerView.setAdapter(adapter);
}

private void setFctNoteInfo() throws JSONException {
JSONObject list_note = new JSONObject();
list_note.put("titre", "hello");


}*/

    public ArrayList<FctNote> getListData(){
        try{
            ConnectionRestNote connectionRestNote = new ConnectionRestNote();
            connectionRestNote.setAction("notes");
            connectionRestNote.execute("GET");
            String listJsonObjs = connectionRestNote.get();
            //System.out.print("Note 222");
            //System.out.println(listJsonObjs);

            //String[] arrayStrings = new String[listJsonObjs.length()];
            //System.out.print("Note 3333");
            //System.out.println(arrayStrings);
            //for (int i = 0; i < listJsonObjs.size(); i++) {
                //FctNote jsonObject = listJsonObjs.get(i);
                //arrayStrings[i] = jsonObject.toString();
           // }
            if(listJsonObjs != null) {





                //System.out.println(listJsonObjs);

                /*for (int i = 0; i < listJsonObjs.length(); i++) {// BOuclé sur la list d'objet str
                    System.out.println("Notes");
                    System.out.println(listJsonObjs);
//System.out.println(listJsonObjs.length());
                }*/

/*
List<FctNote> listeJsonObjects = new FctNote(getListData());

// Convertir la liste de JsonObject en un tableau de chaînes de caractères
String[] arrayStrings = new String[listJsonObjs.length()];
for (int i = 0; i < listeJsonObjects.size(); i++) {
FctNote jsonObject = listeJsonObjects.get(i);
arrayStrings[i] = jsonObject.toString();
}

// Utilisez le tableau de chaînes de caractères selon vos besoins
for (String jsonString : arrayStrings) {
System.out.println(jsonString);
}*/
                return connectionRestNote.parse(listJsonObjs);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } //catch (JSONException e) {
//throw new RuntimeException(e);
//}
        return null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// Handle action bar item clicks here. The action bar will
// automatically handle clicks on the Home/Up button, so long
// as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

//noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    public String toString() {
        return titre;
    }


}