package com.example.bored_bard.UI_files;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bored_bard.R;
import com.example.bored_bard.dice_roller.DieRoller;
import com.example.bored_bard.notes.NotesMainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class list_of_characters_activity extends AppCompatActivity {
    private RecyclerView RV;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_players_screen);

        BottomNavigationView bottomNavView = findViewById(R.id.bottom_nav);
        bottomNavView.setSelectedItemId(R.id.campaigns_page);
        // bottom navigation bar to move between activities
        bottomNavView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.campaigns_page:
                    startActivity(new Intent(getApplicationContext(), campaign_activity.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.dice_page:
                    startActivity(new Intent(getApplicationContext(), DieRoller.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.notes_page:
                    startActivity(new Intent(getApplicationContext(), NotesMainActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.settings_page:
                    // start the settings activity here
                    return true;
            }
            return false;
        });
        // @todo read and write to firebase for the collection of campaigns
        // recycler content viewing
        RV = (RecyclerView) findViewById(R.id.RVPlayers);
        RV.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        RV.setLayoutManager(layoutManager);
        // @todo make it so the characters names and attributes are taken from the firebase list of campaigns
        // adapter = new MyAdapter(my data set)
        RV.setAdapter(adapter);
        Button newCharacter = findViewById(R.id.UpdateCharacter);

        newCharacter.setOnClickListener(v-> startActivity(new Intent(getApplicationContext(), edit_stats_activity.class)));
    }

}
