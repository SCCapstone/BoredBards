package com.example.bored_bard.Combat;
import com.example.bored_bard.R;
import com.example.bored_bard.UI_files.campaign_activity;
import com.example.bored_bard.UI_files.settings_activity;
import com.example.bored_bard.dice_roller.DieRoller;
import com.example.bored_bard.notes.NotesMainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author Caroline Barrineau
 */
public class combat_activity extends Activity {
    String CombatPath;
    FirebaseAuth mAuth;
    FirebaseUser user;

    TextView backBtn, CombatName, CombatAC;
    EditText IntRoll, CombatHP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_combat_screen);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
          CombatPath = bundle.getString("CombatTitle");
        }
        //Firebase calls
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        String username = user.getDisplayName();

        //button calls
        backBtn = findViewById(R.id.CombatbackBtn);



        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), campaign_activity.class);
                startActivity(intent);
                finish();
            }
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

    }
}
