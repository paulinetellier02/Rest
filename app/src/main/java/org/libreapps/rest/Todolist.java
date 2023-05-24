package org.libreapps.rest;
/*
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.libreapps.rest.AjoutTdl;
import org.libreapps.rest.R;

import java.util.ArrayList;

public class Todolist extends AppCompatActivity {

    private ListView todoListView;
    private Button button_Creer_tdl;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolist);

        ArrayList<String> listDesTdl = new ArrayList<>();
        listDesTdl.add("tdl 1");
        listDesTdl.add("tdl 2");
        listDesTdl.add("tdl 3");

        //ListView todoListView = findViewById(R.id.todoListView);
        // Utilisez un adaptateur personnalisé pour afficher la liste des ToDoListes

        button_Creer_tdl = findViewById(R.id.button_creer_rappel);
        button_Creer_tdl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Todolist.this, AjoutTdl.class);
                startActivity(intent);
            }
        });
    }
}*/


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import android.view.Menu;
import android.view.MenuItem;


import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.libreapps.rest.obj.FctNote;
import org.libreapps.rest.obj.Tdl;

public class Todolist extends AppCompatActivity {
    private Button buttontdl;
    private int id;
    private String legende,nom;

    private ArrayList<Tdl> listDatatdl;
    private ArrayList<String> todolist;
    private ListView listView;
    private ArrayAdapter<Tdl> listAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolist);



        ArrayList<Tdl> listDatatdl = getListData();
        final ListView listView = (ListView) findViewById(R.id.listview_tdl);
        listView.setAdapter(new CustomListAdapter_tdl(this, listDatatdl));
        buttontdl = findViewById(R.id.button_creer_rap);

//listView = findViewById(R.id.listViewNotes);
        id =Param.getInstance().getIdUser();
//System.out.println(id);

        buttontdl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Todolist.this, AjoutTdl.class);
                startActivity(intent);
                //return null;
            }
        });

        /*listData = getListData();//creation du spinner avec tous les titres
        ArrayList<String> noteTitles = new ArrayList<>();
        for (FctNote note : listData) {
            noteTitles.add(note.getTitre());
        }*/






// When the user clicks on the ListItem
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                Tdl upload = (Tdl) o;
                Intent intent = new Intent(Todolist.this, Todolist.class);
                intent.putExtra("id", upload.getId());
                intent.putExtra("nom", upload.getNom());
                intent.putExtra("legende", upload.getLegende());
                //listView.setVisibility(View.VISIBLE);
                startActivity(intent);
            }
        });}


    public ArrayList<Tdl> getListData(){
        try{
            ConnectionRest_tdl connectionRestTdl = new ConnectionRest_tdl();
            connectionRestTdl.execute("GET");
            String listJsonObjs = connectionRestTdl.get();
            if(listJsonObjs != null) {
                System.out.println(listJsonObjs);

                for (int i = 0; i < listJsonObjs.length(); i++) {// BOuclé sur la list d'objet str
                    System.out.println(listJsonObjs);
                }

                return connectionRestTdl.parse(listJsonObjs);

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


    /*titre = "aa"; // TODO
    listData = getListData();
    notes = new ArrayList<>();
    for (int i = 0; i < listData.size(); i++) {
    FctNote note = listData.get(i);
    notes.add(note.getTitre());
    }

    /*ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
    this,
    android.R.layout.simple_spinner_item,
    notes);

    spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(spinnerAdapter);

    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    String selectedNote = (String) parent.getItemAtPosition(position);
    // Faire quelque chose avec la note sélectionnée
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    // Aucune note sélectionnée
    }
    });

    listAdapter = new ArrayAdapter<>(
    this,
    android.R.layout.simple_list_item_1,
    listData);

    listView.setAdapter(listAdapter);
    }


    }


    */
    public String toString() {
        return legende;
    }


}
