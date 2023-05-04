package org.libreapps.rest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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
    }
}