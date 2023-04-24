/**
 * @author Charles Simons and Caroline Barrineau
 */
package com.example.bored_bard.UI_files;

import android.content.Intent;
import android.os.Bundle;

import com.example.bored_bard.R;
import com.example.bored_bard.campaign.Campaign;
import com.example.bored_bard.dice_roller.DieRoller;
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
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();

       String campaignTitle = CampaignTitle.getText().toString();
       String campaignDescription = CampaignInfo.getText().toString();



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
        bottomNavView.setOnNavigationItemSelectedListener(item -> {
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
                    // start the settings activity here
                    return true;
            }
            return false;
        });

        // @TODO buttons and textinputs
    }
}
