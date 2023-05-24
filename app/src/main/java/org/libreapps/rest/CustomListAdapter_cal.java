package org.libreapps.rest;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONObject;
import org.libreapps.rest.obj.Event;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class CustomListAdapter_cal extends BaseAdapter {

    private ArrayList<Event> listDataCal;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter_cal(Context aContext, ArrayList<Event> listDataCal) {
        this.context = aContext;
        this.listDataCal = listDataCal;
        layoutInflater = LayoutInflater.from(aContext);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ConnectionRest_cal connectionRest = new ConnectionRest_cal();
        connectionRest.setAction("event");
        connectionRest.execute("GET");
        try {

            String listJsonObjsevent = connectionRest.get();
            JSONObject list_note = new JSONObject();

            Log.d("JSON", listJsonObjsevent.toString());

            //holder.Id.setText(view_notes.getId());


            //Log.v("Note :",""+view_notes.getNote()+" "+view_notes.getTitre()+"");

            convertView = layoutInflater.inflate(R.layout.activity_custom_list_view_cal, null);
            TextView Event = (TextView) convertView.findViewById(R.id.textViewEvent);
            TextView date = (TextView) convertView.findViewById(R.id.textViewDate);
            TextView heure = (TextView) convertView.findViewById(R.id.textViewHeure);
            //String valeur = listJsonObjs.getString();
            //Event.setText(listJsonObjsevent); //affichage
            //titre.setText("bonjour");
            //Event.setText(listJsonObjsevent);
            date.setText(listJsonObjsevent);
            //heure.setText("heure");
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
        return (listDataCal !=null)? listDataCal.size():0;
    }
    public Object getItem(int position) {
        return listDataCal.get(position);
    }
    public long getItemId(int position) {
        return position;
    }
}

