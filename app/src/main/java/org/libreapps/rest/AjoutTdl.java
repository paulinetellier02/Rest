/*package org.libreapps.rest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;
import org.libreapps.rest.ConnectionRest_tdl;
import org.libreapps.rest.Param;
import org.libreapps.rest.R;
import org.libreapps.rest.Todolist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AjoutTdl extends AppCompatActivity {

    private EditText nomTLD, legendeTLD;
    private int id;
    private String titre, legende;
    private Button button_ajt_tdl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_tdl);

        final EditText nomEditTxt = findViewById(R.id.nomTLD);
        final EditText legendeEditTxt = findViewById(R.id.legendeTLD);

        Button buttonOk = findViewById(R.id.button_ajt_tdl);

        String nom = getIntent().getStringExtra("nom");
        String legende = getIntent().getStringExtra("legende");
        id = Param.getInstance().getIdUser();

        if (nom != null) {
            nomEditTxt.setText(nom);
            legendeEditTxt.setText(legende);
            buttonOk.setText("Modifier");
        }

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = nomEditTxt.getText().toString();
                String legende = legendeEditTxt.getText().toString();

                try {
                    JSONObject tdlData = new JSONObject();
                    tdlData.put("nom", nom);
                    tdlData.put("legende", legende);
                    tdlData.put("id", id);

                    ConnectionRest_tdl connectionRestTdl = new ConnectionRest_tdl();
                    connectionRestTdl.setObj(tdlData);

                    if (nom.isEmpty()) {
                        connectionRestTdl.execute("POST"); // Création
                    } else {
                        connectionRestTdl.execute("PUT"); // Modification
                    }

                    Intent intent = new Intent(AjoutTdl.this, Todolist.class);
                    startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
*/


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
        import org.libreapps.rest.RegistrationActivity;
        import org.libreapps.rest.obj.Tdl;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;
        import java.util.concurrent.ExecutionException;

//chaque ligne utilisateur une colonne pour toutes les notes recuperer id user
public class AjoutTdl extends AppCompatActivity {

    private int id;
    private ListView listViewTdl;
    private ArrayList listeTdl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_tdl);

        //code chat

        //listViewTdl = findViewById(R.id.listview_tdl);

        //nom et type
        String legende = getIntent().getStringExtra("legende");
        String nom = getIntent().getStringExtra("nom ");

        final EditText legendeEditTxt = (EditText) findViewById(R.id.legendeTLD);
        final EditText nomEditTxt = (EditText) findViewById(R.id.nomTLD);



        Button buttonOk = (Button) findViewById(R.id.button_ajt_tdl);

        if(legendeEditTxt.getText().toString()==" ") {
            legendeEditTxt.setText("Tapez le titre...");
            nomEditTxt.setText("Tapez votre texte...");
            buttonOk.setText("Modifier");
        }
        id =Param.getInstance().getIdUser();//TODO





        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ConnectionRest_tdl connectionRest = new ConnectionRest_tdl();
                    JSONObject listeTdl = new JSONObject();

                    if(legendeEditTxt.getText().toString()==" "){

                        listeTdl.put("tdl",legende);
                    }
                    listeTdl.put("nom:", nomEditTxt.getText().toString());
                    listeTdl.put("Legende:", legendeEditTxt.getText().toString());
                    listeTdl.put("ID",id);

                    System.out.println(nomEditTxt.getText().toString());
                    System.out.println(legendeEditTxt.getText().toString());
                    List<String> listeTdl2 = Arrays.asList(legendeEditTxt.getText().toString());
                    System.out.println(listeTdl2);
                    System.out.println(listeTdl);




                    connectionRest.setObj(listeTdl);

                    if(legendeEditTxt.getText().toString()==" ") { // Modification
                        connectionRest.execute("PUT");
                    }else{ // Creation
                        connectionRest.execute("POST");
                    }
                    Intent intent = new Intent(AjoutTdl.this, Todolist.class);
                    startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //return null;
            }
        });
    }
}