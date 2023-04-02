/**
 * @author Caroline Barrineau
 */
package com.example.bored_bard.UI_files;

import android.content.Intent;
import android.os.Bundle;
import com.example.bored_bard.R;
import com.example.bored_bard.dice_roller.DieRoller;
import com.example.bored_bard.notes.NotesMainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class campaign_activity extends AppCompatActivity {

    // ArrayList<Campaigns> camp;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_campaigns_screen);

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
        // @todo make it so the username comes from the database

        // @todo make it so the campaign names are taken from the firebase list of campaigns

        // RecyclerView rvCampaigns = (RecyclerView) findViewById(R.id.campaigns);


        //UI references
        Button campaign1 = (Button) findViewById(R.id.campaign1);

        FloatingActionButton FABaddCampaign = (FloatingActionButton) findViewById(R.id.FABaddCampaign);

        campaign1.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), campaign_menu_activity.class)));
//        campaign2.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), .class)));
//        campaign3.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), .class)));

        FABaddCampaign.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), addCampaign_activity.class)));
    }
}
