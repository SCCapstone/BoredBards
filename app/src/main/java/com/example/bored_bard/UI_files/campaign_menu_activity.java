package com.example.bored_bard.UI_files;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bored_bard.R;

public class campaign_menu_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.campaign_menu_screen);

        Button notes = findViewById(R.id.Notes);
        Button NPCs = findViewById(R.id.NPC);
        Button EandM = findViewById(R.id.EandM);
        Button maps = findViewById(R.id.maps);
        Button plyrStats = findViewById(R.id.playerStats);
        Button bgnCmbt = findViewById(R.id.beginCombat);
    }
}
