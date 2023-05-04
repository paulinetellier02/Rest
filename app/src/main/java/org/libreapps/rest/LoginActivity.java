
package org.libreapps.rest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Base64;
import java.util.concurrent.ExecutionException;

public class LoginActivity extends AppCompatActivity {
    private EditText userEmail;
    private EditText userPassword;
    private Button buttonLogin,buttonTest;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userEmail = (EditText)findViewById(R.id.user_email);
        userPassword = (EditText)findViewById(R.id.user_password);
        buttonLogin = (Button)findViewById(R.id.button_connexion);


        userEmail.setText("pauline.tellier@esme.fr");
        userPassword.setText("Ponchet02!");

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    JSONObject jAuth = new JSONObject();
                    jAuth.put("email", userEmail.getText().toString());
                    jAuth.put("password", userPassword.getText().toString());
                    jAuth.put("app", "MNA");

                    Log.v("LoginActivity", userEmail.getText().toString()+" "+userPassword.getText().toString());
                    ConnectionRest connectionRest = new ConnectionRest();
                    connectionRest.setObj(jAuth);
                    connectionRest.setAction("auth");
                    connectionRest.execute("POST");
                    String token = connectionRest.get();
                    Param.getInstance().setToken(token);

                    if(token.charAt(0)=='{') {
                        Log.v("LoginActivity", token);
                    }else{
                        Log.v("LoginActivity", token);//TODO
                        String tabTok[] = token.split("\\.");
                        String jsonPayload =  "";
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            jsonPayload = new String(Base64.getDecoder().decode(tabTok[1]));
                        }
                        Log.v("Payload", jsonPayload);//TODO
                        JSONObject jsonObj = new JSONObject(jsonPayload);

                        Param.getInstance().setIdUser(jsonObj.optInt("usr"));
                        Param.getInstance().setToken(token);

                        Log.v("IdUser", ""+Param.getInstance().getIdUser());//TODO

                        Intent intent = new Intent(LoginActivity.this, EditActivity.class);
                        startActivity(intent);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (InterruptedException  e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}