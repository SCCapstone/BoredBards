package com.example.bored_bard.UI_files;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.bored_bard.R;
import com.example.bored_bard.campaign.Campaign;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CampaginList extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;
    FirebaseUser user;
    List<Campaign> campaignList;
    ValueEventListener eventListener;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campagin_list);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewCampaigns);

//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(CampaginList.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        campaignList = new ArrayList<>();

        CampaignAdapter adapter = new CampaignAdapter(CampaginList.this, campaignList);
        recyclerView.setAdapter(adapter);
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        String username = user.getDisplayName();

        databaseReference = FirebaseDatabase.getInstance().getReference("User").child(username).child("Campaigns");

        eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                campaignList.clear();
                for(DataSnapshot itemSnapshot: snapshot.getChildren()){

                    Campaign campaign = itemSnapshot.getValue(Campaign.class);

                    campaignList.add(campaign);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });







    }


}