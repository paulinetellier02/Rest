package org.libreapps.rest;
/*
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.libreapps.rest.obj.FctNote;

import java.util.ArrayList;

public class CustomListAdapter_notes extends BaseAdapter {

    private ArrayList<FctNote> listData;
    private LayoutInflater layoutInflater;
    private Context context;
    private int id;
    private  String titre,note;

    public CustomListAdapter_notes(Context aContext, ArrayList<FctNote> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        id =Param.getInstance().getIdUser();//TODO


        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.activity_custom_list_view_note,null);
            holder = new ViewHolder();
            holder.titre = (TextView) convertView.findViewById(R.id.textViewtitre);
            holder.note = (TextView) convertView.findViewById(R.id.textViewnote);
            //System.out.println("affichage");
            //System.out.println(holder.titre);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
            Log.v(" position",""+position);
            //System.out.println("affichage position");
        }

        if(position % 2 == 0){
            convertView.setBackgroundColor(Color.rgb(255,25,255));
            //150,245,170
        }

        FctNote note = this.listData.get(position);

        holder.titre.setText(note.getTitre());
        holder.note.setText(note.getNote());

        //holder.titre.setText("toto titre");
        //holder.note.setText("toto note");


        /*System.out.println("affichage titre:");
        System.out.println(note.getTitre());
        System.out.println("affichage note");
        System.out.println(note.getNote());*/

        //System.out.println(titre);

        /*System.out.println("jmlistdata");
        System.out.println(listData);
        System.out.println("jmposition");
        System.out.println(position);



        if ("usr".equals(id)){
            Log.v("NOTE"," "+note.getTitre()+" "+note.getNote()+" "+"coucou");
        }

        Log.v("NOTE"," "+note.getTitre()+" "+note.getNote()+" "+"coucou");
        return convertView;
    }

    static class ViewHolder {
        TextView titre;
        TextView note;


    }
    public Integer random (){
        int random = (int )(Math.random() * 5);
        return random;
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
*/

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.libreapps.rest.obj.FctNote;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class CustomListAdapter_notes extends BaseAdapter {

    private ArrayList<FctNote> listDataNotes;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter_notes(Context aContext, ArrayList<FctNote> listDataNotes ) {
        this.context = aContext;

        this.listDataNotes = listDataNotes;

        //this.listDataNotes = {"titre:coucou", "note : c'est la premiere note", "ID : 136"};
        layoutInflater = LayoutInflater.from(aContext);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        /*ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.activity_custom_list_view_note, null);
            holder = new ViewHolder();
            holder.titre = (TextView) convertView.findViewById(R.id.textViewtitre);
            holder.note = (TextView) convertView.findViewById(R.id.textViewnote);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
            Log.v("position",""+position);
        }

        if(position % 2 == 0){
            convertView.setBackgroundColor(Color.rgb(150,245,170));
        }

        FctNote view_notes = this.listDataNotes.get(position);
        System.out.println(view_notes);
        holder.titre.setText(view_notes.getTitre());
        holder.note.setText(view_notes.getNote());*/
        /*ConnectionRestNote connectionRest = new ConnectionRestNote();
        connectionRest.setAction("notes");
        connectionRest.execute("GET");*/


        try {
            ConnectionRestNote connectionRest = new ConnectionRestNote();
            connectionRest.setAction("notes");
            connectionRest.execute("GET");
            String listJsonObjs = connectionRest.get();
            JSONObject list_note = new JSONObject();
            ArrayList<FctNote> listData = getListData();

             // Récupère le premier objet FctNote de la liste (index 0)
            //String noteValue = String.valueOf(listData.get(1)); // Récupère la valeur de la note
            //System.out.println("test popo");

            //System.out.println(noteValue);


            //list_note.getItem(2);

            //System.out.println("listData");
            System.out.println(listData.size()); //6 correspond au nombre de note

            System.out.println(listData.get(0));
            //ArrayList<FctNote> listData = getListData();
            //List<String> listeTitre = Arrays.asList(listJsonObjs.toString());
            //listeTitre.get(Integer.parseInt("titre:"));


            //Log.d("JSON", listJsonObjs.toString());

            //holder.Id.setText(view_notes.getId());



            try {
                final ArrayList<FctNote> list_note2 = new ArrayList<>();
                final JSONArray jProductArray = new JSONArray(listJsonObjs);
                //JSONArray jsonArray = new JSONArray(listJsonObjs);
                System.out.println("test popo");

                //System.out.println(jsonArray.length());

                for (int i = 0; i < jProductArray.length(); i++) {
                    list_note2.clear();
                    list_note2.add(new FctNote(jProductArray.optJSONObject(i)));
                    System.out.println("test popo");
                    System.out.println(list_note2);
                    list_note2.get(0);



                }

            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

            //Log.v("Note :",""+view_notes.getNote()+" "+view_notes.getTitre()+"");

            convertView = layoutInflater.inflate(R.layout.activity_custom_list_view_note, null);
            TextView titre = (TextView) convertView.findViewById(R.id.textViewtitre);
            TextView note = (TextView) convertView.findViewById(R.id.textViewnote);
            //String valeur = listJsonObjs.getString();
            //titre.setText(listJsonObjs); //affichage
            titre.setText(listJsonObjs);
            //note.setText(noteValue);
            //note.setText((CharSequence) listData.get(0));


            return convertView;
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       return null;
    }

    public ArrayList<FctNote> getListData(){
        try{
            ConnectionRestNote connectionRestNote = new ConnectionRestNote();
            connectionRestNote.setAction("notes");

            connectionRestNote.execute("GET");
            String listJsonObjs = connectionRestNote.get();
            if(listJsonObjs != null) {


               /* for (int i = 0; i < listJsonObjs.length(); i++) {// BOuclé sur la list d'objet str
                    System.out.println("Notes");
                    System.out.println(listJsonObjs);
//System.out.println(listJsonObjs.length());
                }*/

/*
List<FctNote> listeJsonObjects = new FctNote(getListData());

// Convertir la liste de JsonObject en un tableau de chaînes de caractères
String[] arrayStrings = new String[listJsonObjs.length()];
for (int i = 0; i < listeJsonObjects.size(); i++) {
FctNote jsonObject = listeJsonObjects.get(i);
arrayStrings[i] = jsonObject.toString();
}

// Utilisez le tableau de chaînes de caractères selon vos besoins
for (String jsonString : arrayStrings) {
System.out.println(jsonString);
}*/
                return connectionRestNote.parse(listJsonObjs);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } //catch (JSONException e) {
//throw new RuntimeException(e);
//}
        return null;
    }

    static class ViewHolder {
        TextView titre;
        TextView note;
        TextView Id;
    }

    public int getCount() {
        return (listDataNotes !=null)? listDataNotes.size():0;
    }
    public Object getItem(int position) {
        return listDataNotes.get(position);
    }
    public long getItemId(int position) {
        return position;
    }
}

