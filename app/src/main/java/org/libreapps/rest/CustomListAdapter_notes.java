package org.libreapps.rest;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.libreapps.rest.obj.FctNote;
import org.libreapps.rest.LoginActivity;

import java.util.ArrayList;

public class CustomListAdapter_notes extends BaseAdapter {

    private ArrayList<FctNote> listData;
    private LayoutInflater layoutInflater;
    private Context context;
    private int id;

    public CustomListAdapter_notes(Context aContext, ArrayList<FctNote> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        id =Param.getInstance().getIdUser();//TODO

        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.activity_custom_list_view_note, null);
            holder = new ViewHolder();
            holder.titre = (TextView) convertView.findViewById(R.id.textTitreNote);
            holder.note = (TextView) convertView.findViewById(R.id.textNote);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
            Log.v("position",""+position);
        }

        if(position % 2 == 0){
            convertView.setBackgroundColor(Color.rgb(5,0,0));
            //150,245,170
        }

        FctNote note = this.listData.get(position);
        holder.titre.setText(note.getTitre());
        holder.note.setText(note.getNote());


        Log.v("NOTE",""+note.getTitre()+" "+note.getNote()+" "+"coucou");
        return convertView;
    }

    static class ViewHolder {
        TextView titre;
        TextView note;


    }

    public int getCount() {
        return (listData !=null)? listData.size():0;
    }
    public Object getItem(int position) {
        return listData.get(position);
    }
    public long getItemId(int position) {
        return position;
    }
}
