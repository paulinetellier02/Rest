
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

import org.libreapps.rest.obj.Rappel;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import androidx.recyclerview.widget.RecyclerView;


public class Rappels extends AppCompatActivity {
    private Button buttonrap;
    private int id;
    private String legende,heure,periode;

    private ArrayList<Rappel> listDatarap;
    private ArrayList<String> rappel;
    private ListView listView;
    private ArrayAdapter<Rappel> listAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rappel);



        ArrayList<Rappel> listDatarap = getListData();
        final ListView listView = (ListView) findViewById(R.id.listviewrap);

        listView.setAdapter(new CustomListAdapter_rap(this, listDatarap));

        buttonrap = findViewById(R.id.button_creer_rap); //peut etre tdl le bouton si bug

//listView = findViewById(R.id.listViewNotes);
        id =Param.getInstance().getIdUser();
//System.out.println(id);

        buttonrap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Rappels.this, AjoutRappel.class);
                startActivity(intent);
                //return null;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                Rappel upload = (Rappel) o;
                Intent intent = new Intent(Rappels.this, AjoutRappel.class);
                intent.putExtra("id", upload.getId());
                intent.putExtra("legende", upload.getLegend());
                intent.putExtra("heure", upload.getHeure());
                intent.putExtra("periode", upload.getPeriode());
                //listView.setVisibility(View.VISIBLE);
                startActivity(intent);
            }
        });
    }

    public ArrayList<Rappel> getListData(){
        try{
            ConnectionRest_rap connectionRestrap = new ConnectionRest_rap();
            connectionRestrap.setAction("rappel");
            connectionRestrap.execute("GET");
            String listJsonObjs = connectionRestrap.get();
            if(listJsonObjs != null) {
                System.out.println(listJsonObjs);

                for (int i = 0; i < listJsonObjs.length(); i++) {// BOuclé sur la list d'objet str
                    System.out.println(listJsonObjs);

                }
           return connectionRestrap.parse(listJsonObjs);

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
        return legende;
    }


}

