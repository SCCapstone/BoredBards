package com.example.bored_bard.UI_files;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bored_bard.Combat.combat_activity;
import com.example.bored_bard.R;
import com.example.bored_bard.campaign.Campaign;
import com.example.bored_bard.dice_roller.DieRoller;
import com.example.bored_bard.encyclopedia.Encyclopedia;
import com.example.bored_bard.notes.NoteExtendedView;
import com.example.bored_bard.notes.NotesMainActivity;
import com.example.bored_bard.notes.enemiesAndMonstersList;
import com.example.bored_bard.notes.noteList;
import com.example.bored_bard.player.playerList;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Time;
/**
 * @author Andrew MacMurray - FrozenDrew
 */
public class campaign_menu_activity extends AppCompatActivity {


    public TextView TitleC;
    Campaign campaign;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth mAuth;
    FirebaseUser user;
    DatabaseReference databaseReference;
    TextView backBtn;
    Button playerStats, beginCombatBtn, monstersBtn, deleteCampaign;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.campaign_menu_screen);

        playerStats = findViewById(R.id.playerStats);
        TitleC = findViewById(R.id.header_title);

        //button calls
        backBtn = findViewById(R.id.backBtn);
        beginCombatBtn = findViewById(R.id.beginCombat);
        monstersBtn = findViewById(R.id.EandM);
        deleteCampaign = findViewById(R.id.deleteCampaign);

        //Firebase Auth Calls
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        String username = user.getDisplayName();

        //Grabs the Campaign Title Pointer
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            TitleC.setText(bundle.getString("Title"));

        }

        databaseReference = FirebaseDatabase.getInstance().getReference(username).child("Campaigns").child(TitleC.getText().toString());

         String Title = TitleC.getText().toString();


        /**
         * Will take the User to the Enemies and Monsters page
         */
        monstersBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(getApplicationContext(), enemiesAndMonstersList.class);
                 startActivity(intent);
                 finish();
             }
         });

        /**
         * Will take the User to the PlayersList page and send the Reference Pointer
         */
        playerStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), playerList.class);
                intent.putExtra("PlayerTitle", TitleC.getText().toString());
                startActivity(intent);
                finish();
            }
        });

        /**
         * Will take the User to the Combat page and send the Reference Pointer
         */
        beginCombatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), combat_activity.class);
                intent.putExtra("CombatTitle", TitleC.getText().toString());
                startActivity(intent);
                finish();
            }
        });





        /**
         * Will take the User back to the home page
         */
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), campaign_activity.class);
                startActivity(intent);
                finish();
            }
        });

        /**
         * Will Prompt the User asking if they want to delete the Campaign
         * If Yes that Campaign and all information saved under it will be deleted
         * If No the it will close the prompt
         */
        deleteCampaign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creates the Prompt
                AlertDialog.Builder builder = new AlertDialog.Builder(campaign_menu_activity.this);
                builder.setTitle("Deleting Campaign");
                builder.setMessage("Are you sure you want to Delete this Campaign? Once Deleted all data with it will be deleted as well.");
                //Will Delete the selected Campaign's information
                builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        databaseReference.removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(campaign_menu_activity.this, "Campaign Deleted", Toast.LENGTH_SHORT).show();
                            }
                        });
                        Intent intent = new Intent(getApplicationContext(), campaign_activity.class);
                        startActivity(intent);
                        finish();
                    }
                });
                //Will close the Prompt
                builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {




                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
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
