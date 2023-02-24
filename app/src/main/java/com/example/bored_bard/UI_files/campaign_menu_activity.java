package com.example.bored_bard.UI_files;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bored_bard.R;
import com.example.bored_bard.dice_roller.DieRoller;
import com.example.bored_bard.notes.NotesMainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class campaign_menu_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.campaign_menu_screen);

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
            } else {
                return false;
            }
        });

        Button notes = findViewById(R.id.Notes);
        Button NPCs = findViewById(R.id.NPC);
        Button EandM = findViewById(R.id.EandM);
        Button maps = findViewById(R.id.maps);
        Button plyrStats = findViewById(R.id.playerStats);
        Button bgnCmbt = findViewById(R.id.beginCombat);

//        notes.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), notes_activity.class)));
//        NPCs.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), MPC_activity.class)));
//        EandM.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), EandM_activity.class)));
//        maps.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), maps_activity.class)));
        plyrStats.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), edit_stats_activity.class)));
        bgnCmbt.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), combat_activity.class)));
    }
}
