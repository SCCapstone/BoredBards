/**
 * @author Caroline Barrineau
 */
package com.example.bored_bard.UI_files;

import android.content.Intent;
import android.os.Bundle;
import com.example.bored_bard.R;
import com.example.bored_bard.campaign.Campaign;
import com.example.bored_bard.dice_roller.DieRoller;
import com.example.bored_bard.encyclopedia.Encyclopedia;
import com.example.bored_bard.notes.NotesMainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Andrew MacMurray - FrozenDrew
 */
public class campaign_activity extends AppCompatActivity {

    DatabaseReference databaseReference;
    List<Campaign> campaignList;
    ValueEventListener eventListener;
    FirebaseAuth auth;
    FirebaseUser user;
    TextView textView;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_campaigns_screen);


        //Firebase User Auth Calls
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        textView = findViewById(R.id.username);

        //RecyclerView Calls
        RecyclerView RV = findViewById(R.id.recyclerview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(campaign_activity.this, 1);
        RV.setLayoutManager(gridLayoutManager);

        //Creates an Arraylist of Campaigns
        campaignList = new ArrayList<>();
        CampaignAdapter adapter = new CampaignAdapter(campaign_activity.this, campaignList);
        RV.setAdapter(adapter);

        //More User Auth Calls
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        assert user != null;
        String username = user.getDisplayName();

        assert username != null;

        /**
         * Adds the Database's stored Campaigns to an ArrayList
         * That ArrayList will be used to set the Values of the CardView
         */

        databaseReference = FirebaseDatabase.getInstance().getReference(username).child("Campaigns");
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





        //UI references
        Button campaign1 = (Button) findViewById(R.id.campaign1);
        FloatingActionButton FABaddCampaign = (FloatingActionButton) findViewById(R.id.FABaddCampaign);
        FABaddCampaign.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), addCampaign_activity.class)));


        if (user == null){
            Intent intent = new Intent(getApplicationContext(), google_signin_activity.class);
            startActivity(intent);
            finish();
        }
        else{
            textView.setText(user.getDisplayName());
        }

        BottomNavigationView bottomNavView = findViewById(R.id.bottom_nav);
        bottomNavView.setSelectedItemId(R.id.campaigns_page);
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