package org.libreapps.rest;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



import org.json.JSONObject;
import org.libreapps.rest.obj.Rappel;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class CustomListAdapter_rap extends BaseAdapter {

    private ArrayList<Rappel> listDataRap;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter_rap(Context aContext, ArrayList<Rappel> listDataRap) {
        this.context = aContext;
        this.listDataRap = listDataRap;
        layoutInflater = LayoutInflater.from(aContext);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ConnectionRest_cal connectionRest = new ConnectionRest_cal();
        connectionRest.setAction("rappel");
        connectionRest.execute("GET");
        try {

            String listJsonObjsrap = connectionRest.get();
            JSONObject list_rap = new JSONObject();

            Log.d("JSON RAPPEL", listJsonObjsrap.toString());

            //holder.Id.setText(view_notes.getId());


            //Log.v("Note :",""+view_notes.getNote()+" "+view_notes.getTitre()+"");

            convertView = layoutInflater.inflate(R.layout.activity_custom_list_view_rappel, null);
            TextView legende = (TextView) convertView.findViewById(R.id.textViewLegende2);
            TextView periode = (TextView) convertView.findViewById(R.id.textViewDate2);
            TextView heure = (TextView) convertView.findViewById(R.id.textViewHeure2);
            //String valeur = listJsonObjs.getString();
            //Event.setText(listJsonObjsevent); //affichage
            //titre.setText("bonjour");
            //legende.setText(listJsonObjsrap);
            //periode.setText(listJsonObjsrap);
           // heure.setText("heure");
            legende.setText("test");
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
        return (listDataRap !=null)? listDataRap.size():0;
    }
    public Object getItem(int position) {
        return listDataRap.get(position);
    }
    public long getItemId(int position) {
        return position;
    }
}

