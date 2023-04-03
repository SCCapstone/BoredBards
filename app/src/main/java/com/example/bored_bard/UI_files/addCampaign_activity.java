/**
 * @author Charles Simons and Caroline Barrineau
 */
package com.example.bored_bard.UI_files;

import android.content.Intent;
import android.os.Bundle;

import com.example.bored_bard.R;
import com.example.bored_bard.dice_roller.DieRoller;
import com.example.bored_bard.notes.NotesMainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class addCampaign_activity extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcampaign_screen);

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

        // @TODO buttons and textinputs
    }
}