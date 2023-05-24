package org.libreapps.rest;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.libreapps.rest.obj.Tdl;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class CustomListAdapter_tdl extends BaseAdapter {

    private ArrayList<Tdl> listDataTdl;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter_tdl(Context aContext, ArrayList<Tdl> listDataTdl) {
        this.context = aContext;
        this.listDataTdl = listDataTdl;
        layoutInflater = LayoutInflater.from(aContext);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ConnectionRest_tdl connectionRest = new ConnectionRest_tdl();
        connectionRest.setAction("tdl");


        connectionRest.execute("GET");
        try {

            String listJsonObjstdl = connectionRest.get();
            JSONObject list_tdl = new JSONObject();

            try {
                list_tdl.put("name:", "chicago");
                //list_tdl.opt("nom:");
                System.out.println(list_tdl.opt("name:"));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

            //list_tdl.get("nom:");
            connectionRest.setObj(list_tdl);
            Log.d("JSON", listJsonObjstdl.toString());

            System.out.println(list_tdl);

            //holder.Id.setText(view_notes.getId());


            //Log.v("Note :",""+view_notes.getNote()+" "+view_notes.getTitre()+"");

            convertView = layoutInflater.inflate(R.layout.activity_custom_list_view, null);
            TextView nom = (TextView) convertView.findViewById(R.id.textViewnom);
            TextView legende = (TextView) convertView.findViewById(R.id.textViewTdl);
            //String valeur = listJsonObjs.getString();
            //Event.setText(listJsonObjsevent); //affichage
            //titre.setText("bonjour");
            nom.setText(listJsonObjstdl);
            //legende.setText(listJsonObjstdl);
            return convertView;
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    static class ViewHolder {
        TextView titre;
        TextView note;
        TextView Id;
    }

    public int getCount() {
        return (listDataTdl !=null)? listDataTdl.size():0;
    }
    public Object getItem(int position) {
        return listDataTdl.get(position);
    }
    public long getItemId(int position) {
        return position;
    }
}

