package com.example.bored_bard.notes;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bored_bard.R;

import java.text.DateFormat;

import io.realm.Realm;
import io.realm.RealmResults;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHodler> {

    Context context;
    RealmResults<Notes> notesList;
    public MyAdapter(Context context, RealmResults<Notes> notesList) {
        this.context = context;
        this.notesList = notesList;
    }



    @NonNull
    @Override
    public MyViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHodler(LayoutInflater.from(context).inflate(R.layout.note_item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHodler holder, int position) {
        Notes note = notesList.get(position);
        holder.titleOutput.setText(note.getTitle());
        holder.descriptionOutput.setText(note.getDescription());

        String formatedTime = DateFormat.getDateTimeInstance().format(note.createdTime);
        holder.timeOutput.setText(formatedTime);

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                PopupMenu menu = new PopupMenu(context, view);
                menu.getMenu().add("DELETE");
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getTitle().equals("DELETE")){

                            Realm realm = Realm.getDefaultInstance();
                            realm.beginTransaction();
                            note.deleteFromRealm();
                            realm.commitTransaction();
                            Toast.makeText(context, "Deleted",Toast.LENGTH_SHORT).show();
                        }
                            return true;
                    }
                });
                menu.show();

                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public class MyViewHodler extends RecyclerView.ViewHolder{
            TextView titleOutput;
            TextView descriptionOutput;
            TextView timeOutput;

            public MyViewHodler(@NonNull View itemView){
                super(itemView);
                titleOutput = itemView.findViewById(R.id.titleoutput);
                descriptionOutput = itemView.findViewById(R.id.descriptionoutput);
                timeOutput = itemView.findViewById(R.id.timeoutput);
            }
    }
}
