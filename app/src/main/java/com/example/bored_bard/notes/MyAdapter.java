package com.example.bored_bard.notes;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bored_bard.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Notes> list;

    String CNote;
    noteList noteList = new noteList();


    public MyAdapter(Context context, ArrayList<Notes> list) {
        this.context = context;
        this.list = list;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(context).inflate(R.layout.note_item,parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

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

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView NoteTitle, NoteDescription, CTitle;
        public TextView CampaignTitle;
        public CardView CampaignCard;

        public CardView CharacterCard;

        public TextView Name;
        public TextView Race;
        public TextView CClass;
        public TextView HP;
        public TextView AC;
        CardView NoteCard;

            public MyViewHolder(@NonNull View itemView){
                super(itemView);

                NoteTitle = itemView.findViewById(R.id.NoteTitle);
                NoteDescription = itemView.findViewById(R.id.NoteDescription);
                NoteCard = itemView.findViewById(R.id.NoteCard);
                CTitle = itemView.findViewById(R.id.CTitle);

                Name = itemView.findViewById(R.id.NameC);
                Race = itemView.findViewById(R.id.RaceC);
                CClass = itemView.findViewById(R.id.ClassC);
                HP = itemView.findViewById(R.id.HPC);
                AC = itemView.findViewById(R.id.ACC);
                CharacterCard = itemView.findViewById(R.id.CharacterCard);



                CampaignTitle = itemView.findViewById(R.id.recCampaignTitle);
                CampaignCard = itemView.findViewById(R.id.CampaignCard);







            }
    }
}
