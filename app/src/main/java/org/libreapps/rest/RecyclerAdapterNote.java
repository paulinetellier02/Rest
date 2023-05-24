package org.libreapps.rest;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.libreapps.rest.obj.FctNote;

import java.util.ArrayList;
public class RecyclerAdapterNote extends RecyclerView.Adapter<RecyclerAdapterNote.myViewHolder> {
private ArrayList<FctNote> notelist;
public RecyclerAdapterNote(ArrayList<FctNote> notelist){
    this.notelist=notelist;
}
    public class myViewHolder extends RecyclerView.ViewHolder{
        private TextView noteText;
        public myViewHolder(final View view){
            super(view);
            noteText = view.findViewById(R.id.textViewnote);
        }
    }
    @NonNull
    @Override
    public RecyclerAdapterNote.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_custom_list_view_note,parent,false);
        return new myViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterNote.myViewHolder holder, int position) {
        String note = notelist.get(position).getNote();
        holder.noteText.setText(note);

    }

    @Override
    public int getItemCount() {
        return notelist.size();
    }
}
