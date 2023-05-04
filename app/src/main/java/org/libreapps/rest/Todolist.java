package org.libreapps.rest;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.*;

public class Todolist extends AppCompatActivity {


    private ListView todoListView;
    //private ArrayAdapter<TodoTask> todoListAdapter;
    private Button button_Creer_tdl, button_Ajout_tdl;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolist);

        ArrayList<String> list_des_tdl;

        list_des_tdl = new ArrayList<String>();
        list_des_tdl.add("tdl 1");
        list_des_tdl.add("tdl 2");
        list_des_tdl.add("tdl 3");

        ListView todoListView;
        //faire un listview pour derouler la liste des tdl sur la page



        button_Creer_tdl = (Button) findViewById(R.id.button_creer_tdl);

        button_Creer_tdl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Todolist.this, AjoutTdl.class);
                startActivity(intent);

            }

            ;

        });


    }}