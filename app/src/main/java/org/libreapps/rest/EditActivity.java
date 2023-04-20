package org.libreapps.rest;

import android.content.Intent;
        import android.os.Bundle;

        import androidx.appcompat.app.AppCompatActivity;

        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

        import org.json.JSONException;
        import org.json.JSONObject;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        final int id = getIntent().getIntExtra("id", 0);
        String name = getIntent().getStringExtra("name");
        String type = getIntent().getStringExtra("type");
        double price = getIntent().getDoubleExtra("price", 1.0);
        final EditText nameEditTxt = (EditText) findViewById(R.id.nameEditTxt);
        final EditText typeEditTxt = (EditText) findViewById(R.id.typeEditTxt);
        final EditText priceEditTxt = (EditText) findViewById(R.id.priceEditTxt);
        TextView idTxt = (TextView) findViewById(R.id.textview_id);
        Button buttonCancel = (Button) findViewById(R.id.button_cancel);
        Button buttonOk = (Button) findViewById(R.id.button_ok);

        if(id!=0){
            idTxt.setText(""+id);
            nameEditTxt.setText(name);
            typeEditTxt.setText(type);
            priceEditTxt.setText(""+price);
            buttonCancel.setText("Supprimer");
            buttonOk.setText("Modifier");
        }

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(id!=0){ // Suppression
                    try {
                        ConnectionRest connectionRest = new ConnectionRest();
                        JSONObject product = new JSONObject();
                        product.put("id", id);
                        connectionRest.setObj(product); //parfois JsonObj
                        connectionRest.execute("DELETE");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                Intent intent = new Intent(EditActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ConnectionRest connectionRest = new ConnectionRest();
                    JSONObject user = new JSONObject();
                    if(id!=0) {
                        user.put("id", id);
                    }
                    user.put("nom", nameEditTxt.getText().toString());
                    user.put("type", typeEditTxt.getText().toString());
                    user.put("prenom", Double.parseDouble(priceEditTxt.getText().toString()));
                    connectionRest.setObj(user); //parfois JsonObj

                    if(id!=0) { // Modification
                        connectionRest.execute("PUT");
                    }else{ // Creation
                        connectionRest.execute("POST");
                    }
                    Intent intent = new Intent(EditActivity.this, MainActivity.class);
                    startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}