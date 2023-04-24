package com.example.bored_bard.notes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bored_bard.R;
import com.example.bored_bard.UI_files.campaign_activity;
import com.example.bored_bard.UI_files.settings_activity;
import com.example.bored_bard.dice_roller.DieRoller;
import com.example.bored_bard.encyclopedia.Encyclopedia;
import com.example.bored_bard.encyclopedia.Monsters;
import com.example.bored_bard.encyclopedia.MyAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;

public class enemiesAndMonstersList extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Monsters> entryList;
    monsterAdapter myAdapter;
    FirebaseFirestore db;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monster_list); //Tie java file to xml file

        recyclerView = findViewById(R.id.enemiesAndMonstersRecyclerView); //Initialize RecyclerView
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance(); //Get Instance of Firestore
        entryList = new ArrayList<Monsters>();
        myAdapter = new monsterAdapter(enemiesAndMonstersList.this,entryList); //Initialize Adapter
        recyclerView.setAdapter(myAdapter);
        Gson gson = new Gson();

        db.collection("Encyclopedia").document("Default").collection("Monsters")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String json = gson.toJson(document.getData());
                                //Log.d("Monster: ", json);
                                entryList.add(gson.fromJson(json,Monsters.class));
                                myAdapter.notifyDataSetChanged();
                            }
                            for (Monsters i : entryList) {
                                Log.d("entry: ", i.getName());
                            }
                        }
                    }
                });


        BottomNavigationView bottomNavView = findViewById(R.id.bottom_nav);
        bottomNavView.setSelectedItemId(R.id.encyclopedia);
        // bottom navigation bar to move between activities
        bottomNavView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.campaigns_page) {
                startActivity(new Intent(getApplicationContext(), campaign_activity.class));
                overridePendingTransition(0, 0);
                return true;
            } else if (item.getItemId() == R.id.dice_page) {
                startActivity(new Intent(getApplicationContext(), DieRoller.class));
                overridePendingTransition(0, 0);
                return true;
            } else if (item.getItemId() == R.id.notes_page) {
                startActivity(new Intent(getApplicationContext(), NotesMainActivity.class));
                overridePendingTransition(0, 0);
                return true;
            } else if (item.getItemId() == R.id.settings_page) {
                startActivity(new Intent(getApplicationContext(), settings_activity.class));
                overridePendingTransition(0, 0);
                return true;
            } else if (item.getItemId() == R.id.encyclopedia) {
                startActivity(new Intent(getApplicationContext(), Encyclopedia.class));
                overridePendingTransition(0, 0);
                return true;
            } else {
                return false;
            }
        });
    }
}
