package com.example.bored_bard.notes;


import android.content.Context;
import android.content.Intent;
import android.icu.text.CaseMap;
import android.provider.ContactsContract;
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
import com.example.bored_bard.UI_files.CampaginList;
import com.example.bored_bard.UI_files.CampaignAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.BreakIterator;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHodler> {

    Context context;
    List<Notes> list;

    String CNote;
    noteList noteList = new noteList();


    public MyAdapter(Context context, ArrayList<Notes> list) {
        this.context = context;
        this.list = list;
    }



    @NonNull
    @Override
    public MyViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(context).inflate(R.layout.note_item,parent, false);
        return new MyViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHodler holder, int position) {

        holder.NoteTitle.setText(list.get(position).getTitle());

        holder.NoteDescription.setText(list.get(position).getDescription());

        holder.CTitle.setText(CNote);

        holder.NoteCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, NoteExtendedView.class);
                intent.putExtra("NTitle", list.get(holder.getAdapterPosition()).getTitle());
                intent.putExtra("Title", CNote);
                intent.putExtra("Description", list.get(holder.getAdapterPosition()).getDescription());
                intent.putExtra("NoteTitle", list.get(holder.getAdapterPosition()).getTitle());
                intent.putExtra("id",   list.get(holder.getAdapterPosition()).getId());

                intent.putExtra("Key", list.get(holder.getAdapterPosition()).getKey());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHodler extends RecyclerView.ViewHolder{

        public TextView NoteTitle, NoteDescription, CTitle;
        public TextView CampaignTitle;
        public CardView CampaignCard;
        CardView NoteCard;

            public MyViewHodler(@NonNull View itemView){
                super(itemView);

                NoteTitle = itemView.findViewById(R.id.NoteTitle);
                NoteDescription = itemView.findViewById(R.id.NoteDescription);
                NoteCard = itemView.findViewById(R.id.NoteCard);
                CTitle = itemView.findViewById(R.id.CTitle);


                CampaignTitle = itemView.findViewById(R.id.recCampaignTitle);
                CampaignCard = itemView.findViewById(R.id.CampaignCard);


//


            }
    }
}
