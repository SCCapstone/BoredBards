package com.example.bored_bard.UI_files;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bored_bard.R;
import com.example.bored_bard.dice_roller.DieRoller;
import com.example.bored_bard.notes.NotesMainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class settings_activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_screen);

        BottomNavigationView bottomNavView = findViewById(R.id.bottom_nav);
        bottomNavView.setSelectedItemId(R.id.settings_page);
        // bottom navigation bar to move between activities
        bottomNavView.setOnItemSelectedListener(item -> {
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
                    startActivity(new Intent(getApplicationContext(), settings_activity.class));
                    overridePendingTransition(0, 0);
                    return true;
            }
            return false;
        });

//        Button report = findViewById(R.id.report_button);
//        Button offline_data = findViewById(R.id.offline_data);
//        Button logout = findViewById(R.id.logout_button);
//        Button about = findViewById(R.id.about_button);
//
//        report.setOnClickListener(v -> reportNavigator());
//        offline_data.setOnClickListener(v -> offlineDataManagement());
//        logout.setOnClickListener(v -> logout());
//        about.setOnClickListener(v -> aboutNavigator());
    }

    /**
     * when called, takes user to the repository page
     */
    private void aboutNavigator() {

    }

    /**
     * when called, take user to repository page to leave a comment
     */
    private void reportNavigator() {

    }

    /**
     * when called, logs the user out
     */
    private void logout() {

    }

    /**
     * when called, allows the user to change data management policies
     */
    private void offlineDataManagement() {

    }
}
