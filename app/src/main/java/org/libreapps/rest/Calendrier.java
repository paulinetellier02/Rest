
package org.libreapps.rest;

//import static org.libreapps.rest.R.id.listView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.libreapps.rest.obj.Event;
import org.libreapps.rest.obj.FctNote;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import androidx.recyclerview.widget.RecyclerView;


public class Calendrier extends AppCompatActivity {
    private Button buttoncal;
    private int id;
    private String nom,heure,date;

    private ArrayList<Event> listDatacal;
    private ArrayList<String> rappel;
    private ListView listView;
    private ArrayAdapter<Event> listAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendrier);



        ArrayList<Event> listDatacal = getListData();
        final ListView listView = (ListView) findViewById(R.id.listview_cal);

        listView.setAdapter(new CustomListAdapter_cal(this, listDatacal));


        buttoncal = findViewById(R.id.button_ajouter_event); //peut etre tdl le bouton si bug

//listView = findViewById(R.id.listViewNotes);
        id =Param.getInstance().getIdUser();
//System.out.println(id);

        buttoncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Calendrier.this, AjoutCalendrier.class);
                startActivity(intent);
                //return null;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                Event upload = (Event) o;
                Intent intent = new Intent(Calendrier.this, Calendrier.class);
                intent.putExtra("id", upload.getId());
                intent.putExtra("nom event", upload.getNom_event());
                intent.putExtra("heure", upload.getHeure());
                intent.putExtra("date", upload.getDate());
                //listView.setVisibility(View.VISIBLE);
                startActivity(intent);
            }
        });
    }

    public ArrayList<Event> getListData(){
        try{
            ConnectionRest_cal connectionRestcal = new ConnectionRest_cal();
            connectionRestcal.setAction("event");
            connectionRestcal.execute("GET");
            String listJsonObjs = connectionRestcal.get();
            if(listJsonObjs != null) {
                System.out.println(listJsonObjs);

                for (int i = 0; i < listJsonObjs.length(); i++) {// BOuclé sur la list d'objet str
                    System.out.println(listJsonObjs);

                }
                return connectionRestcal.parse(listJsonObjs);

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
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public String toString() {
        return nom;
    }


}

