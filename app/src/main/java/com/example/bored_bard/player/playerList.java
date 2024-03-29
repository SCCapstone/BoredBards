package com.example.bored_bard.player;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bored_bard.R;
import com.example.bored_bard.UI_files.campaign_activity;
import com.example.bored_bard.UI_files.campaign_menu_activity;
import com.example.bored_bard.UI_files.settings_activity;
import com.example.bored_bard.dice_roller.DieRoller;
import com.example.bored_bard.encyclopedia.Encyclopedia;
import com.example.bored_bard.notes.MyAdapter;
import com.example.bored_bard.notes.Notes;
import com.example.bored_bard.notes.NotesMainActivity;
import com.example.bored_bard.notes.noteList;
import com.google.android.material.bottomnavigation.BottomNavigationView;
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
public class playerList extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth mAuth;
    FirebaseUser user;
    public DatabaseReference PlayerDatabaseReference;
    public TextView PlayerCampaignTitle;
    TextView backBtn;
    ValueEventListener eventListener;
    Button addPlayerBtn;

    ArrayList<Player> playerlist;
    FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list);



        //User info
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        String username = user.getDisplayName();

       //declare title change
       PlayerCampaignTitle = findViewById(R.id.workdamnit);

        //declare buttons
        addPlayerBtn = findViewById(R.id.addPlayerBtn);
        backBtn = findViewById(R.id.backBtn);
        database = FirebaseDatabase.getInstance();

        //Gets pointer information
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            PlayerCampaignTitle.setText(bundle.getString("PlayerTitle"));

        }
        playerlist = new ArrayList<>();

       String Title = String.valueOf(PlayerCampaignTitle.getText());

        RecyclerView recyclerView = findViewById(R.id.recyclerviewPlayers);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(playerList.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        PlayerAdapter playerAdapter = new PlayerAdapter(playerList.this, playerlist);

        recyclerView.setAdapter(playerAdapter);





     PlayerDatabaseReference = database.getReference(username).child("Campaigns").child(Title).child("Players");

        /**
         * Pulls the Player informaiton from the Firebase RealTimeDatabase
         * Then adds it to the Player ArrayList for the PlayerAdapter to set the information to the Card.
          */
     eventListener = PlayerDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                playerlist.clear();
                for(DataSnapshot dataSnapshot: snapshot.getChildren())
                {
                    Player player = dataSnapshot.getValue(Player.class);
                    playerlist.add(player);
                }
                playerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        /**
         * Will take you to the AddPlayers Class sends the Title Pointer
          */
     addPlayerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), addPlayer.class);
                intent.putExtra("Title", PlayerCampaignTitle.getText().toString());
                startActivity(intent);
                finish();
            }
        });


        /**
         * Will take you back to the Campaign menu and will send the Title Pointer
          */
     backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), campaign_menu_activity.class);
                intent.putExtra("Title", PlayerCampaignTitle.getText().toString());
                startActivity(intent);
                finish();
            }
        });


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