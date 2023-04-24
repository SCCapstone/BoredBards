package com.example.bored_bard.UI_files;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bored_bard.R;
import com.example.bored_bard.dice_roller.DieRoller;
import com.example.bored_bard.encyclopedia.Encyclopedia;
import com.example.bored_bard.notes.NotesMainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class settings_activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_screen);

        BottomNavigationView bottomNavView = findViewById(R.id.bottom_nav);
        bottomNavView.setSelectedItemId(R.id.settings_page);
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

        TextView report = findViewById(R.id.reportIssue);
        TextView about = findViewById(R.id.aboutUs);
        TextView logout = findViewById(R.id.logout);

        report.setOnClickListener(v -> reportNavigator());
        about.setOnClickListener(v -> aboutNavigator());
        logout.setOnClickListener(v -> logout());
    }

    /**
     * when called, logs the user out
     */
    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getApplicationContext(), google_signin_activity.class);
        startActivity(intent);
        finish();
    }

    /**
     * when called, takes user to the repository page
     */
    private void aboutNavigator() {
        try {
            Intent about_link = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sccapstone.github.io/BoredBards/about.html"));
            about_link.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(about_link);
        } catch (Exception e) {
            Log.e("Exception caught", e.toString());
        }
    }

    /**
     * when called, take user to repository page to leave a comment
     */
    private void reportNavigator() {
        try {
            Intent report_link = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/SCCapstone/BoredBards"));
            report_link.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(report_link);
        } catch (Exception e) {
            Log.e("Exception caught", e.toString());
        }
    }
}
