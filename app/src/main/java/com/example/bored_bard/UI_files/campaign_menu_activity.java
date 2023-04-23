package com.example.bored_bard.UI_files;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bored_bard.R;
import com.example.bored_bard.campaign.Campaign;
import com.example.bored_bard.dice_roller.DieRoller;
import com.example.bored_bard.encyclopedia.Encyclopedia;
import com.example.bored_bard.notes.NotesMainActivity;
import com.example.bored_bard.player.playerList;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class campaign_menu_activity extends AppCompatActivity {


    public TextView TitleC;
    Campaign campaign;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth mAuth;
    FirebaseUser user;
    DatabaseReference databaseReference;
    TextView backBtn;

    Button playerStats;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.campaign_menu_screen);

        playerStats = findViewById(R.id.playerStats);
        TitleC = findViewById(R.id.header_title);



        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        String username = user.getDisplayName(), Title;



        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            TitleC.setText(bundle.getString("Title"));
        }
        databaseReference = FirebaseDatabase.getInstance().getReference("User").child(username).child("Campaigns").child(TitleC.getText().toString());
        playerStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), playerList.class);
                intent.putExtra("Title", TitleC.getText().toString());
                startActivity(intent);
                finish();
            }
        });

        backBtn = findViewById(R.id.backBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), campaign_activity.class);
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

        // Button notes = findViewById(R.id.notes_page);
        Button NPCs = findViewById(R.id.NPC);
        Button EandM = findViewById(R.id.EandM);
        Button maps = findViewById(R.id.maps);
//        Button players = findViewById(R.id.playerStats);
        Button bgnCmbt = findViewById(R.id.beginCombat);

//        notes.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), notes_activity.class)));
//        NPCs.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), MPC_activity.class)));
//        EandM.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), EandM_activity.class)));
//        maps.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), maps_activity.class)));
//        players.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), list_of_characters_activity.class)));
        bgnCmbt.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), combat_activity.class)));
    }
}
