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
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bored_bard.R;

import java.text.BreakIterator;
import java.text.DateFormat;
import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHodler> {

    Context context;
    ArrayList<Notes> list;
    public MyAdapter(Context context, ArrayList<Notes> list) {
        this.context = context;
        this.list = list;
    }



    @NonNull
    @Override
    public MyViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(context).inflate(R.layout.activity_note_list,parent, false);
        return new MyViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHodler holder, int position) {
        Notes note = list.get(position);
        holder.titleOutput.setText(note.getTitle());
        holder.descriptionOutput.setText(note.getDescription());



        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                PopupMenu menu = new PopupMenu(context, view);
                menu.getMenu().add("DELETE");
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getTitle().equals("DELETE")){

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
        return list.size();
    }

    public static class MyViewHodler extends RecyclerView.ViewHolder{

        TextView titleOutput;
        TextView descriptionOutput;
        public TextView CampaignTitle;
        public CardView CampaignCard;

            public MyViewHodler(@NonNull View itemView){
                super(itemView);
                titleOutput = itemView.findViewById(R.id.notesTitle);
                descriptionOutput = itemView.findViewById(R.id.descriptioninput);
                CampaignTitle = itemView.findViewById(R.id.recCampaignTitle);
                CampaignCard = itemView.findViewById(R.id.CampaignCard);

//


            }
    }
}
