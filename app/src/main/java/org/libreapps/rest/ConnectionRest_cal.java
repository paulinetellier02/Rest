/*package org.libreapps.rest;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import org.libreapps.rest.obj.Rappel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ConnectionRest_rap extends AsyncTask<String, Void, String> {

    private JSONObject obj;
    private String action;



    public void setObj(JSONObject obj) {
        this.obj = obj;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    protected String doInBackground(String... params) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL("https://api.munier.me/jwt/" + action); // Remplacez "your-api-url.com" par l'URL de votre API
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(params[0]);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            if (obj != null) {
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(obj.toString().getBytes("UTF-8"));
                outputStream.close();
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                StringBuilder response = new StringBuilder();
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                return response.toString();
            } else {
                Log.e("HTTP", "Error code: " + responseCode);
            }
        } catch (IOException e) {
            Log.e("HTTP", "Error: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    Log.e("HTTP", "Error closing BufferedReader: " + e.getMessage());
                }
            }

            if (connection != null) {
                connection.disconnect();
            }
        }

        return null;
    }

    @Override
    protected void onPostExecute(String response) {
        if (response != null) {
            // Gérer la réponse de l'API
            try {
                JSONObject jsonResponse = new JSONObject(response);
                // Faire quelque chose avec la réponse JSON
            } catch (JSONException e) {
                Log.e("HTTP", "Error parsing JSON response: " + e.getMessage());
            }
        } else {
            // Gérer l'échec de la requête
        }
    }
}*/
package org.libreapps.rest;


import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.libreapps.rest.obj.Event;
import org.libreapps.rest.obj.Rappel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class ConnectionRest_cal extends AsyncTask<String, Void, String> {
    private final static String URL = "https://api.munier.me/jwt/";
    private JSONObject jsonObj = null;
    private String action = "event";

    @Override
    protected String doInBackground(String... strings) {
        try {
            return get(strings[0]);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String get(String methode) throws IOException, JSONException {
        String url = URL + action + "/";
        String token = Param.getInstance().getToken();
        InputStream is = null;
        String parameters = "";
        if(!methode.equals("POST")&&(jsonObj!=null)&&!methode.equals("CREATE_CALENDRIER")){
            url += jsonObj.getInt("id");
        }
        if(jsonObj != null){
            if(methode.equals("PUT")){
                jsonObj.remove("id");
            }
            parameters  = "data="+URLEncoder.encode(jsonObj.toString(), "utf-8");
            //Log.v("URL", url+" "+parameters);
        }
        if (methode.equals("CREATE_CALENDRIER")) {
            methode = "POST";
            url = URL + "register.php";
        }
        try {
            final HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod(methode);
            if (token != null) {
                conn.setRequestProperty("Authorization", "Bearer " + URLEncoder.encode(token, "utf-8"));
            }

            // Pour les methode POST et PUT on envoie les parametre avec l'OutputStreamWriter
            if(methode.equals("POST")||methode.equals("PUT")){
                conn.setDoInput(true);
                conn.setDoOutput(true);
                OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
                out.write(parameters);// here i sent the parameter
                out.close();
            }else{
                conn.setDoInput(true);
                conn.connect();
            }

            is = conn.getInputStream();
            // Lit le InputStream et l'enregistre dans une string
            return readIt(is);
        } finally {
            // Pour etre sur que le InputStream soit ferme apres avoir quitter l'application
            if (is != null) {
                is.close();
            }
        }
    }

    private String readIt(InputStream is) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(is));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = r.readLine()) != null) {
            response.append(line).append('\n');
        }
        return response.toString();
    }

    public ArrayList<Event> parse(final String json) {
        try {
            final ArrayList<Event> list_event = new ArrayList<>();
            final JSONArray jProductArray = new JSONArray(json);
            for (int i = 0; i < jProductArray.length(); i++) {
                list_event.add(new Event(jProductArray.optJSONObject(i)));
            }
            return list_event;
        } catch (JSONException e) {
            Log.v("TAG","[JSONException] e : " + e.getMessage());
        }
        return null;
    }

    public void setObj(JSONObject jsonObj){
        this.jsonObj = jsonObj;
    }
    public void setAction(String monAction){ this.action = monAction;}


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}







