/**
 * @author Charles Simons and Caroline Barrineau
 */
package com.example.bored_bard.UI_files;

import android.content.Intent;
import android.os.Bundle;

import com.example.bored_bard.R;
import com.example.bored_bard.campaign.Campaign;
import com.example.bored_bard.dice_roller.DieRoller;
import com.example.bored_bard.encyclopedia.Encyclopedia;
import com.example.bored_bard.notes.NotesMainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
/**
 * @author Andrew MacMurray - FrozenDrew
 */
public class addCampaign_activity extends AppCompatActivity{


Button createCampaign;
EditText CampaignTitle, CampaignInfo;
FirebaseUser user;
DatabaseReference databaseReference;
FirebaseAuth mAuth;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcampaign_screen);

        createCampaign = findViewById(R.id.campaign1);
        CampaignInfo = findViewById(R.id.Bio);
        CampaignTitle = findViewById(R.id.NewTitle);
        //Firebase
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();

       String campaignTitle = CampaignTitle.getText().toString();
       String campaignDescription = CampaignInfo.getText().toString();


        /**
         * Will Insert a Campaign into the User's Database under the "Campaigns" branch
         * If the Title is blank it will prompt the user to enter an Title
         * If the Description is blank it will prompt the user to enter a Description
          */
       createCampaign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = user.getDisplayName(), Title;

                Title = String.valueOf(CampaignTitle.getText());

                String campaignDescription = String.valueOf(CampaignInfo.getText());


                if (TextUtils.isEmpty(Title)) {
                    Toast.makeText(addCampaign_activity.this, "Enter Title", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(campaignDescription)) {
                    Toast.makeText(addCampaign_activity.this, "Enter Description", Toast.LENGTH_SHORT).show();
                    return;
                }


                //Is the reference calls from the Database
                Campaign Ccampign = new Campaign(CampaignTitle.getText().toString(), CampaignInfo.getText().toString());
                databaseReference.child(username).child("Campaigns").child(Title).setValue(Ccampign).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Intent intent = new Intent(getApplicationContext(), campaign_activity.class);
                        startActivity(intent);
                        finish();
                    }
                });
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
