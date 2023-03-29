package com.example.bored_bard.UI_files;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bored_bard.R;
import com.example.bored_bard.dice_roller.DieRoller;
import com.example.bored_bard.notes.NotesMainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class settings_activity extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseUser user;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_screen);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        textView = findViewById(R.id.toLogout);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), google_signin_activity.class);
                startActivity(intent);
                finish();
            }
        });






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
            } else {
                return false;
            }
        });

        TextView report = findViewById(R.id.reportIssue);
        TextView offline_data = findViewById(R.id.offlineData);

        TextView about = findViewById(R.id.aboutUs);

        report.setOnClickListener(v -> reportNavigator());
        offline_data.setOnClickListener(v -> offlineDataManagement());

        about.setOnClickListener(v -> aboutNavigator());
    }

    /**
     * when called, takes user to the repository page
     */
    private void aboutNavigator() {
        try {
            Intent about_link = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/SCCapstone/BoredBards"));
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

    /**
     * when called, logs the user out
     */


    /**
     * when called, allows the user to change data management policies
     */
    private void offlineDataManagement() {
//        startActivity(new Intent(getApplicationContext(), logout.class));
//        overridePendingTransition(0, 0);

    }
}
