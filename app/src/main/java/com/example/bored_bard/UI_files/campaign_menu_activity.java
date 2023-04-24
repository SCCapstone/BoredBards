package com.example.bored_bard.UI_files;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bored_bard.Combat.combat_activity;
import com.example.bored_bard.R;
import com.example.bored_bard.campaign.Campaign;
import com.example.bored_bard.dice_roller.DieRoller;
import com.example.bored_bard.dice_roller.encyclopedia.Encyclopedia;
import com.example.bored_bard.notes.NotesMainActivity;
import com.example.bored_bard.player.playerList;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class campaign_menu_activity extends AppCompatActivity {


    public TextView TitleC;
    Campaign campaign;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth mAuth;
    FirebaseUser user;
    DatabaseReference databaseReference;
    TextView backBtn;
    Button playerStats, beginCombatBtn, monstersBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.campaign_menu_screen);

        playerStats = findViewById(R.id.playerStats);
        TitleC = findViewById(R.id.header_title);
        backBtn = findViewById(R.id.backBtn);
        beginCombatBtn = findViewById(R.id.beginCombat);
        monstersBtn = findViewById(R.id.EandM);


        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        String username = user.getDisplayName(), Title;

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            TitleC.setText(bundle.getString("Title"));

        }

        databaseReference = FirebaseDatabase.getInstance().getReference(username).child("Campaigns").child(TitleC.getText().toString());
         Title = String.valueOf(TitleC.getText());



         monstersBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
//                 Intent intent = Intent(getApplicationContext(), name.here);
//                 startActivity(intent);
//                 finish();
             }
         });

        playerStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), playerList.class);
                intent.putExtra("PlayerTitle", TitleC.getText().toString());
                startActivity(intent);
                finish();
            }
        });

        beginCombatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), combat_activity.class);
                intent.putExtra("CombatTitle", Title);
            }
        });





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
            } else if (item.getItemId() == R.id.encyclopedia) {
                startActivity(new Intent(getApplicationContext(), Encyclopedia.class));
                overridePendingTransition(0, 0);
                return true;

            } else {
                return false;
            }
        });
    }
}
