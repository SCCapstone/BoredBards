package com.example.bored_bard.player;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bored_bard.R;
import com.example.bored_bard.notes.MyAdapter;
import com.example.bored_bard.notes.Notes;
import com.example.bored_bard.notes.noteList;

import java.util.ArrayList;
import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHodler> {

   private Context context;

    private List<Player> Plist;




    public PlayerAdapter(Context context, List<Player> Plist) {
        this.context = context;
        this.Plist = Plist;
    }




    @NonNull
    @Override
    public MyAdapter.MyViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_characters, parent, false);
        return new MyAdapter.MyViewHodler(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHodler holder, int position) {
            holder.Name.setText(Plist.get(position).getName());
            holder.Race.setText(Plist.get(position).getRace());
            holder.CClass.setText(Plist.get(position).getCClass());
            holder.HP.setText(Plist.get(position).getHp());
            holder.AC.setText(Plist.get(position).getAC());


            holder.CharacterCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Werid", Toast.LENGTH_SHORT).show();
                }
            });
    }

    @Override
    public int getItemCount() {
        return Plist.size();
    }

}