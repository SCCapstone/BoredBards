package com.example.bored_bard.encyclopedia;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bored_bard.R;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter {
    private static final int ABILITYSCORE = 0;
    private static final int ALIGNMENT = 1;
    private static final int BACKGROUNDS = 2;
    private static final int CLASSES = 3;
    private static final int CONDITIONS = 4;
    private static final int DAMAGETYPES = 5;
    private static final int EQUIPMENT = 6;
    private static final int EQUIPMENTCATEGORIES = 7;
    private static final int FEATS = 8;
    private static final int FEATURES = 9;
    private static final int LANGUAGES = 10;
    private static final int LEVELS = 11;
    private static final int MAGICITEMS = 12;
    private static final int MAGICSCHOOLS = 13;
    private static final int MONSTERS = 14;
    private static final int PROFICIENCIES = 15;
    private static final int RACES = 16;
    private static final int RULES = 17;
    private static final int RULESSECTIONS = 18;
    private static final int SKILLS = 19;
    private static final int SPELLS = 20;
    private static final int SUBCLASSES = 21;
    private static final int SUBRACES = 22;
    private static final int TRAITS = 23;
    private static final int WEAPONPROPERTIES = 24;

    Context context;
    ArrayList<JSONObject> entryList;
    Gson gson;

    public MyAdapter(Context context, ArrayList<JSONObject> entries) {
        this.context = context;
        this.entryList = entries;
        this.gson = new Gson();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        switch (viewType) {
            case  ABILITYSCORE:
                v = LayoutInflater.from(context).inflate(R.layout.ability_score_row,parent,false);
                return new abilityScoreViewHolder(v);
            case  ALIGNMENT:
                v = LayoutInflater.from(context).inflate(R.layout.alignment_row,parent,false);
                return new alignmentViewHolder(v);
            case  BACKGROUNDS:

            case  CLASSES:

            case  CONDITIONS:

            case  DAMAGETYPES:

            case  EQUIPMENT:

            case  EQUIPMENTCATEGORIES:

            case  FEATS:

            case  FEATURES:

            case  LANGUAGES:

            case  LEVELS:

            case  MAGICITEMS:

            case  MAGICSCHOOLS:

            case  MONSTERS:

            case  PROFICIENCIES:

            case  RACES:

            case  RULES:

            case  RULESSECTIONS:

            case  SKILLS:

            case  SPELLS:

            case  SUBCLASSES:

            case  SUBRACES:

            case  TRAITS:

            case  WEAPONPROPERTIES:


            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.d("MyAdapter", entryList.get(position).toString());
        try {
            switch (entryList.get(position).getString("type")) {
                case "AbilityScores":
                    abilityScores ability = gson.fromJson(entryList.get(position).toString(),abilityScores.class);
                    ((abilityScoreViewHolder) holder).setView(ability);
                    break;
                case "Alignments":
                    alignment align = gson.fromJson(entryList.get(position).toString(),alignment.class);
                    ((alignmentViewHolder) holder).setView(align);
                    break;
                case "Backgrounds":
                    break;
                case "Classes":
                    break;
                case "Conditions":
                    break;
                case "DamageTypes":
                    break;
                case "Equipment":
                    break;
                case "EquipmentCategories":
                    break;
                case "Feats":
                    break;
                case "Features":
                    break;
                case "Languages":
                    break;
                case "Levels":
                    break;
                case "MagicItems":
                    break;
                case "MagicSchools":
                    break;
                case "Monsters":
                    break;
                case "Proficiencies":
                    break;
                case "Races":
                    break;
                case "Rules":
                    break;
                case "RuleSections":
                    break;
                case "Skills":
                    break;
                case "Spells":
                    break;
                case "Subclasses":
                    break;
                case "Subraces":
                    break;
                case "Traits":
                    break;
                case "WeaponProperties":
                    break;
    
                default:
                    break;
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getItemCount() {
        return entryList.size();
    }

    @Override
    public int getItemViewType(int position) {
        try {
            switch (entryList.get(position).getString("type")) {
                case "AbilityScores":
                    return ABILITYSCORE;
                case "Alignments":
                    return ALIGNMENT;
                case "Backgrounds":
                    return BACKGROUNDS;
                case "Classes":
                    return CLASSES;
                case "Conditions":
                    return CONDITIONS;
                case "DamageTypes":
                    return DAMAGETYPES;
                case "Equipment":
                    return EQUIPMENT;
                case "EquipmentCategories":
                    return EQUIPMENTCATEGORIES;
                case "Feats":
                    return FEATS;
                case "Features":
                    return FEATURES;
                case "Languages":
                    return LANGUAGES;
                case "Levels":
                    return LEVELS;
                case "MagicItems":
                    return MAGICITEMS;
                case "MagicSchools":
                    return MAGICSCHOOLS;
                case "Monsters":
                    return MONSTERS;
                case "Proficiencies":
                    return PROFICIENCIES;
                case "Races":
                    return RACES;
                case "Rules":
                    return RULES;
                case "RuleSections":
                    return RULESSECTIONS;
                case "Skills":
                    return SKILLS;
                case "Spells":
                    return SPELLS;
                case "Subclasses":
                    return SUBCLASSES;
                case "Subraces":
                    return SUBRACES;
                case "Traits":
                    return TRAITS;
                case "WeaponProperties":
                    return WEAPONPROPERTIES;

                default:
                    return -1;
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }

    public static class abilityScoreViewHolder extends RecyclerView.ViewHolder{

        TextView desc, full_name, index, name, skills, url;

        public abilityScoreViewHolder(@NonNull View itemView) {
            super(itemView);
            full_name = itemView.findViewById(R.id.viewFullName);
            desc = itemView.findViewById(R.id.viewDescription);
            skills = itemView.findViewById(R.id.skillsRelevant);
        }
        private void setView(abilityScores c) {
            full_name.setText(c.getFull_name());
            desc.setText(c.getDesc());
            skills.setText(c.skillsToString());
        }
    }

    public static class alignmentViewHolder extends RecyclerView.ViewHolder {

        TextView abbreviation, desc, index, name, url;
        public alignmentViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.viewFullName);
            desc = itemView.findViewById(R.id.viewDescription);
        }
        private void setView(alignment c) {
            name.setText(c.getName());
            desc.setText(c.getDesc());
        }
    }

}
