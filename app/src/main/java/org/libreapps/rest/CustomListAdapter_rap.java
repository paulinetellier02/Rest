package org.libreapps.rest;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.libreapps.rest.obj.User;

import java.util.ArrayList;

public class CustomListAdapter_rap extends BaseAdapter {

    private ArrayList<User> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter_rap(Context aContext, ArrayList<User> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.activity_custom_list_view, null);
            holder = new ViewHolder();
            holder.adresse_mail = (TextView) convertView.findViewById(R.id.textTitreNote);
            holder.mdp = (TextView) convertView.findViewById(R.id.textPrice);
            holder.nom = (TextView) convertView.findViewById(R.id.textNote);
            holder.prenom = (TextView) convertView.findViewById(R.id.textType);
            holder.date_naissance = (TextView) convertView.findViewById(R.id.textPrice);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
            Log.v("position",""+position);
        }

        if(position % 2 == 0){
            convertView.setBackgroundColor(Color.rgb(150,245,170));
        }

        User user = this.listData.get(position);
        holder.adresse_mail.setText(""+user.getAdresse_mail());
        holder.mdp.setText(user.getMdp());
        holder.nom.setText(user.getNom());
        holder.prenom.setText(""+user.getPrenom());
        holder.date_naissance.setText(""+user.getDate_naissance());
        Log.v("CUSTOM",""+user.getNom()+" "+user.getPrenom()+" "+user.getAdresse_mail()+" bien registré !");

        return convertView;
    }

    static class ViewHolder {
        TextView adresse_mail;
        TextView mdp;
        TextView nom;
        TextView prenom;
        TextView date_naissance;

    }

    public int getCount() {
        return (listData!=null)?listData.size():0;
    }
    public Object getItem(int position) {
        return listData.get(position);
    }
    public long getItemId(int position) {
        return position;
    }
}
