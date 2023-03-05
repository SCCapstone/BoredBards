/**
 * @author Caroline Barrineau
 */
package com.example.bored_bard.UI_files;

import android.content.Intent;
import android.os.Bundle;
import com.example.bored_bard.R;
import com.example.bored_bard.dice_roller.DieRoller;
import com.example.bored_bard.notes.NotesMainActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class campaign_activity extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseUser user;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_campaigns_screen);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        textView = findViewById(R.id.username);
        button = findViewById(R.id.btn_logout);

        if (user == null){
            Intent intent = new Intent(getApplicationContext(), google_signin_activity.class);
            startActivity(intent);
            finish();
        }
        else{
            textView.setText(user.getEmail());
        }

        button.setOnClickListener(view -> {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(getApplicationContext(), google_signin_activity.class);
            startActivity(intent);
            finish();
        });



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
//            } else if (item.getItemId() == R.id.encyclopedia) {
//                startActivity(new Intent(getApplicationContext(), encyclopedia.class));
//                overridePendingTransition(0, 0);
//                return true;
            } else {
                return false;
            }
        });
        // @todo make it so the username comes from the database

        // @todo make it so the campaign names are taken from the firebase list of campaigns


        //UI references
        Button campaign1 = (Button) findViewById(R.id.campaign1);
        Button campaign2 = (Button) findViewById(R.id.campaign2);
        Button campaign3 = (Button) findViewById(R.id.campaign3);
        FloatingActionButton FABaddCampaign = (FloatingActionButton) findViewById(R.id.FABaddCampaign);

        campaign1.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), campaign_menu_activity.class)));
//        campaign2.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), .class)));
//        campaign3.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), .class)));

        FABaddCampaign.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), addCampaign_activity.class)));
    }
}
