package com.example.bored_bard.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.bored_bard.R;
import com.example.bored_bard.UI_files.CampaignAdapterNotes;
import com.example.bored_bard.UI_files.addCampaign_activity;
import com.example.bored_bard.UI_files.campaign_activity;
import com.example.bored_bard.UI_files.settings_activity;
import com.example.bored_bard.campaign.Campaign;
import com.example.bored_bard.dice_roller.DieRoller;
import com.example.bored_bard.encyclopedia.Encyclopedia;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Andrew MacMurray - FrozenDrew
 */
public class NotesMainActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    FirebaseAuth mAuth;
    FirebaseUser user;
    List<Campaign> campaignList;
    ValueEventListener eventListener;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_main);


        MaterialButton addCampaignBtn = findViewById(R.id.AddCampaign);


        addCampaignBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), addCampaign_activity.class);
                startActivity(intent);
                finish();
            }
        });


        campaignList = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(NotesMainActivity.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);


        //Creates a new instance of the CampaignAdapterNotes class and sets it as the object for the recyclerview to display
        CampaignAdapterNotes myAdapter = new CampaignAdapterNotes(NotesMainActivity.this, campaignList);
        recyclerView.setAdapter(myAdapter);

        //FirebaseAuth Calls
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        String username = user.getDisplayName();

        //FireBase Realtime Database Reference call
        databaseReference = FirebaseDatabase.getInstance().getReference(username).child("Campaigns");



        //Adds the Campaigns from the Campaign List to be displayed by the recyclerView
        eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                campaignList.clear();
                for(DataSnapshot itemSnapshot: snapshot.getChildren()){

                    Campaign campaign = itemSnapshot.getValue(Campaign.class);

                    campaignList.add(campaign);
                }
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






        BottomNavigationView bottomNavView = findViewById(R.id.bottom_nav);
        bottomNavView.setSelectedItemId(R.id.notes_page);
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