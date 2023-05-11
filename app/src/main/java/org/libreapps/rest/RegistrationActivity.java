package org.libreapps.rest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class RegistrationActivity extends AppCompatActivity {

    private EditText userName, userPassword, userEmail;
    private Button btn_Register_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        userName = (EditText) findViewById(R.id.reg_user_name);
        userEmail = (EditText) findViewById(R.id.reg_user_email);
        userPassword = (EditText) findViewById(R.id.reg_user_password);
        btn_Register_2 = (Button) findViewById(R.id.btn_register_2);

        btn_Register_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ConnectionRest connectionRest = new ConnectionRest();
                    JSONObject jsonAuthentification = new JSONObject();
                    jsonAuthentification.put("name", userName.getText());
                    jsonAuthentification.put("email", userEmail.getText());
                    jsonAuthentification.put("password", userPassword.getText());
                    jsonAuthentification.put("licence", "MNA-1A-5U-29");//licence Adèle
                    connectionRest.setObj(jsonAuthentification);
                    connectionRest.execute("CREATE_USER");
                    String token = connectionRest.get();

                    /*ConnectionRest connectionRest = new ConnectionRest();
                    JSONObject Profil = new JSONObject();
                    final int id = getIntent().getIntExtra("id",2);
                    try{
                        if(id!=0) {
                            Profil.put("id", id);//getuser pour le bon id
                        }
                        System.out.println(userNom.getText());
                        Profil.put("nom", userNom.getText().toString());
                        Profil.put("prenom", userprenom.getText().toString());
                        Profil.put("ielts", userielts.getText().toString());
                        Profil.put("moyenne", usermoy.getText().toString());
                        connectionRest.setObj(Profil);
                        connectionRest.setAction("Profil");

                    // Creation
                        connectionRest.execute("POST");
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }*/

                    if(token.charAt(0)=='{') {
                        Log.v("LoginActivity", token);
                    }else {
                        Intent intent = new Intent(RegistrationActivity.this, EditActivity.class);
                        intent.putExtra("token", token);
                        startActivity(intent);
                    }
                } catch (JSONException e1) {
                    Log.v("TAG", "[JSONException] e : " + e1.getMessage());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
