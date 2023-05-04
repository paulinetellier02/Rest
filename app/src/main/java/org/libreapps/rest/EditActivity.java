package org.libreapps.rest;

import android.content.Intent;
        import android.os.Bundle;

        import androidx.appcompat.app.AppCompatActivity;

        import android.view.View;
        import android.widget.Button;

public class EditActivity extends AppCompatActivity {
    private Button button_Tdl,button_Agenda,button_Notes,button_Calendrier,button_Rappel,button_creerTdl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        button_Tdl = (Button) findViewById(R.id.button_tdl);

        button_Tdl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditActivity.this, Todolist.class);
                startActivity(intent);


            }

            ;
        });


        button_Rappel = (Button) findViewById(R.id.button_rappel);
        button_Rappel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditActivity.this, Rappel.class);
                startActivity(intent);


            }

            ;
        });

        button_Calendrier = (Button) findViewById(R.id.button_calendrier);
        button_Calendrier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditActivity.this, Calendrier.class);
                startActivity(intent);


            }

            ;
        });

        button_Notes = (Button) findViewById(R.id.button_note);
        button_Notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditActivity.this, Notes.class);
                startActivity(intent);


            }

            ;
        });

    }};