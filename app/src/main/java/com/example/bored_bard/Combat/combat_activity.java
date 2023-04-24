package com.example.bored_bard.Combat;
import com.example.bored_bard.R;
import com.example.bored_bard.UI_files.campaign_activity;
import com.example.bored_bard.UI_files.campaign_menu_activity;
import com.example.bored_bard.UI_files.settings_activity;
import com.example.bored_bard.dice_roller.DieRoller;
import com.example.bored_bard.notes.NotesMainActivity;
import com.example.bored_bard.player.Player;
import com.example.bored_bard.player.PlayerAdapter;
import com.example.bored_bard.player.playerList;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * @author Caroline Barrineau
 */
public class combat_activity extends Activity {
    FirebaseAuth mAuth;
    FirebaseUser user;
    ArrayList<Player> playerlist;
    DatabaseReference databaseReference;
    FirebaseDatabase database;
    ValueEventListener eventListener;
    String CombatPath ="";
    TextView backBtn, CombatName, CombatAC, combatTitle;
    EditText IntRoll, CombatHP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_combat_screen);


        combatTitle = findViewById(R.id.combatTitle);
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        String username = user.getDisplayName();
        database = FirebaseDatabase.getInstance();






        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
        combatTitle.setText(bundle.getString("CombatTitle"));
        //CombatPath = bundle.getString("CombatTitle");
        }
        String Title = String.valueOf(combatTitle.getText());

        //Firebase calls



        playerlist = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.combatRecycler);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(combat_activity.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        CombatAdapter playerAdapter = new CombatAdapter(combat_activity.this, playerlist);

        recyclerView.setAdapter(playerAdapter);

        databaseReference = database.getReference(username).child("Campaigns").child(Title).child("Players");

        eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
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

        playerAdapter.onBindViewHolder(Title = String.valueOf(combatTitle));



        //button calls
        backBtn = findViewById(R.id.CombatbackBtn);



        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), campaign_menu_activity.class);
                intent.putExtra("Title", combatTitle.getText().toString());
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
//            } else if (item.getItemId() == R.id.encyclopedia) {
//                startActivity(new Intent(getApplicationContext(), encyclopedia.class));
//                overridePendingTransition(0, 0);
//                return true;
            } else {
                return false;
            }
        });

    }
}
