package com.example.bored_bard.Combat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bored_bard.R;
import com.example.bored_bard.player.Player;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;
import java.util.jar.Attributes;


public class CombatAdapter extends RecyclerView.Adapter<CombatAdapter.CombatHolder>{
    Context context;
   ArrayList<Player> playerlist;

    public CombatAdapter(Context context, ArrayList<Player> playerlist) {
        this.context = context;
        this.playerlist = playerlist;
    }

    @NonNull
    @Override
    public CombatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.combat_card, parent, false);
        return new CombatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CombatHolder holder, int position) {FirebaseUser user;


                holder.Name.setText(playerlist.get(position).getName());
            holder.HP.setText(playerlist.get(position).getHp());
            holder.AC.setText(playerlist.get(position).getAc());



    }

    @Override
    public int getItemCount() {
        return playerlist.size();
    }

    public void onBindViewHolder(String s) {
    }


    public static class CombatHolder extends RecyclerView.ViewHolder{
        TextView Name, AC;
        EditText HP, IntRoll;

        CardView CombatCard;
        public CombatHolder(@NonNull View itemView){
            super(itemView);

            Name = itemView.findViewById(R.id.CombatName);
            AC = itemView.findViewById(R.id.CombatAC);

            HP = itemView.findViewById(R.id.CombatHP);
            IntRoll = itemView.findViewById(R.id.IntRoll);

            CombatCard = itemView.findViewById(R.id.combatCard);




        }
    }
}

