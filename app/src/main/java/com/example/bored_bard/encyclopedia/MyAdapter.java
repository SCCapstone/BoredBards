package com.example.bored_bard.encyclopedia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bored_bard.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<com.example.bored_bard.encyclopedia.MyAdapter.MyViewHolder> {


    Context context;
    ArrayList<abilityScores> abilityList;

    public MyAdapter(Context context, ArrayList<abilityScores> abilityScores) {
        this.context = context;
        this.abilityList = abilityScores;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.ability_score_row,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

        abilityScores ability = abilityList.get(position);

        holder.full_name.setText(ability.getFull_name());
        holder.desc.setText(ability.getDesc());
        holder.skills.setText(ability.skillsToString());
    }

    @Override
    public int getItemCount() {
        return abilityList.size();
    }

    @Override
    public int getItemViewType(int position) {

        return super.getItemViewType(position);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView desc, full_name, index, name, skills, url;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            full_name = itemView.findViewById(R.id.viewFullName);
            desc = itemView.findViewById(R.id.viewDescription);
            skills = itemView.findViewById(R.id.skillsRelevant);
        }
    }

}
