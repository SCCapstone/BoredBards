package com.example.bored_bard.player;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bored_bard.R;
import com.example.bored_bard.UI_files.campaign_activity;
import com.example.bored_bard.UI_files.settings_activity;
import com.example.bored_bard.dice_roller.DieRoller;
import com.example.bored_bard.encyclopedia.Encyclopedia;
import com.example.bored_bard.notes.NotesMainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
/**
 * @author Andrew MacMurray - FrozenDrew
 */
public class addPlayer extends AppCompatActivity {

   TextInputEditText Name, Race, CClass, HP, AC;
   Button createChar, cancel;
   FirebaseAuth mAuth;
   FirebaseUser user;
   DatabaseReference reference;
   TextView CTitle;
   String Title = "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        Name = findViewById(R.id.Name);
        Race = findViewById(R.id.Race);
        CClass = findViewById(R.id.CClass);
        HP = findViewById(R.id.HpInput);
        AC = findViewById(R.id.ACInput);
        createChar = findViewById(R.id.createChar);
        CTitle = findViewById(R.id.CTitle);

        //FireBase Auth Calls
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        //Gets Pointer infromation from PlayerList
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            Title = bundle.getString("Title");
        }


        reference = FirebaseDatabase.getInstance().getReference();

        /**
         * Inserts the Players information into the Users database if All Text boxes were filled out properly
         * Will prompt the user with a message if they left any boxes blank
         */
        createChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = String.valueOf(Name.getText());
                String race = String.valueOf(Race.getText());
                String cclass = String.valueOf(CClass.getText());
                String hp = String.valueOf(HP.getText());
                String ac = String.valueOf(AC.getText());

                //Checks if name is entered if not will prompt the user
                if ( name.length() == 0){
                    Toast.makeText(addPlayer.this, "Please enter a name", Toast.LENGTH_SHORT).show();
                return;
                }
                //Checks if race is entered if not will prompt the user
                if ( race.length() == 0){
                    Toast.makeText(addPlayer.this, "Please enter race", Toast.LENGTH_SHORT).show();
                    return;
                }
                //Checks if class is entered if not will prompt the user
                if ( cclass.length() == 0){
                    Toast.makeText(addPlayer.this, "Please enter a Class", Toast.LENGTH_SHORT).show();
                    return;
                }
                //Checks if hp is entered if not will prompt the user
                if ( hp.length() == 0){
                    Toast.makeText(addPlayer.this, "Please enter Health Points", Toast.LENGTH_SHORT).show();
                    return;
                }
                //Checks if Armor Class is entered if not will prompt the user
                if ( ac.length() == 0){
                    Toast.makeText(addPlayer.this, "Please enter Armor Class", Toast.LENGTH_SHORT).show();
                    return;
                }
                InsertPlayer();
                //Send the Database point to the next playerList page
                Toast.makeText(addPlayer.this, "Player Created", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), playerList.class);
                intent.putExtra("PlayerTitle", Title);
                startActivity(intent);
                finish();
            }
        });


        /**
         * Will cancel the Creation of a Player and send them back to the playerList page
         */
        cancel = findViewById(R.id.cancel_button);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), playerList.class);
                intent.putExtra("PlayerTitle", Title);
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

    /**
     * This will use the Firebase RealTime Database references to insert the Players information under the User's selected Campaign.
     */
    private void InsertPlayer(){


        String username = user.getDisplayName();
        String name = String.valueOf(Name.getText());
        String race = String.valueOf(Race.getText());
        String cclass = String.valueOf(CClass.getText());
        String hp = String.valueOf(HP.getText());
        String ac = String.valueOf(AC.getText());
        String initiative = "";


        Player player = new Player(name, race, cclass, hp, ac);

        reference.child(username).child("Campaigns").child(Title).child("Players").child(name).setValue(player);


    }


}