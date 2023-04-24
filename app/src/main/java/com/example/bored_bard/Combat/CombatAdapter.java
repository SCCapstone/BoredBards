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


import java.util.ArrayList;


public class CombatAdapter extends RecyclerView.Adapter<CombatAdapter.CombatHolder>{
    Context context;
    ArrayList<> list;

    @NonNull
    @Override
    public CombatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.combat_card, parent, false);
        return new CombatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CombatHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
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

