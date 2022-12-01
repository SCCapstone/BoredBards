/**
 * @author Charles Simons - csimons637
 */
/*

package com.example.bored_bard.campaign;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bored_bard.R;
import com.example.bored_bard.dice_roller.DieRoller;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CampaignsActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.combat_screen.xml);

        BottomNavigationView bottomNavView = findViewById(R.id.bottom_nav);
        bottomNavView.setSelectedItemId(R.id.campaigns_page);
        // bottom navigation bar to move between activities
        bottomNavView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.campaigns_page:
                    startActivity(new Intent(getApplicationContext(), CampaignsActivity.class));
                    bottomNavView.setSelectedItemId(R.id.campaigns_page);
                    return true;
                case R.id.dice_page:
                    startActivity(new Intent(getApplicationContext(), DieRoller.class));
                    bottomNavView.setSelectedItemId(R.id.dice_page);
                    return true;
                case R.id.notes_page:
                    // start the notes activity here
                    bottomNavView.setSelectedItemId(R.id.notes_page);
                    return true;
                case R.id.settings_page:
                    // start the settings activity here
                    bottomNavView.setSelectedItemId(R.id.settings_page);
                    return true;
            }
            return false;
        });

        Button editStats = findViewById(R.id.editStats);
        Button combat = findViewById(R.id.combat);

        combat.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), CombatActivity.class)));
        editStats.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), EditStats.class)));
    }
}
*/
