package com.example.bored_bard.notes;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bored_bard.R;
import com.example.bored_bard.encyclopedia.Monsters;
import com.example.bored_bard.encyclopedia.MyAdapter;
import com.example.bored_bard.encyclopedia.abilityScores;
import com.example.bored_bard.encyclopedia.conditions;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;

public class monsterAdapter extends RecyclerView.Adapter {
    Context context;
    ArrayList<Monsters> entryList;
    Gson gson;

    public monsterAdapter(Context context, ArrayList<Monsters> entryList) {
        this.context = context;
        this.entryList = entryList;
        this.gson = new Gson();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.monsters_row,parent,false);
        return new monsterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.d("monsterAdapter: ", entryList.get(position).getName());
        Monsters monster = entryList.get(position);
        ((monsterViewHolder) holder).setView(entryList.get(position));
    }

    @Override
    public int getItemCount() {
        return entryList.size();
    }



    public static class monsterViewHolder extends RecyclerView.ViewHolder {

        TextView name, armor_class, hit_points, charisma, constitution, dexterity, intelligence, strength, wisdom;
        public monsterViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.viewName);
            armor_class = itemView.findViewById(R.id.viewArmorClass);
            hit_points = itemView.findViewById(R.id.viewHitPoints);
            charisma = itemView.findViewById(R.id.viewCharisma);
            constitution = itemView.findViewById(R.id.viewConstitution);
            dexterity = itemView.findViewById(R.id.viewDexterity);
            intelligence = itemView.findViewById(R.id.viewIntelligence);
            strength = itemView.findViewById(R.id.viewStrength);
            wisdom = itemView.findViewById(R.id.viewWisdom);
        }
        private void setView(Monsters c) {
            name.setText(c.getName());
            armor_class.setText(c.getArmor_classAsString());
            hit_points.setText(c.getHit_points());
            charisma.setText(c.getCharisma());
            constitution.setText(c.getConstitution());
            dexterity.setText(c.getDexterity());
            intelligence.setText(c.getIntelligence());
            strength.setText(c.getStrength());
            wisdom.setText(c.getWisdom());
        }
    }
}
