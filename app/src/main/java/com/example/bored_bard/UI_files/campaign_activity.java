/**
 * @author Caroline Barrineau
 */
package com.example.bored_bard.UI_files;

import android.content.Intent;
import android.os.Bundle;
import com.example.bored_bard.R;
import com.example.bored_bard.dice_roller.DieRoller;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
public class campaign_activity extends Activity {

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

        //UI references
        Button campaign1 = (Button) findViewById(R.id.campaign1);
        Button campaign2 = (Button) findViewById(R.id.campaign2);
        Button campaign3 = (Button) findViewById(R.id.campaign3);

        campaign1.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), combat_activity.class)));
        campaign2.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), combat_activity.class)));
        campaign3.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), combat_activity.class)));
    }
}
