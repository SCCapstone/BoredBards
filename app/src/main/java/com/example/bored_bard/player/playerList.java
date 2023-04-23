package com.example.bored_bard.player;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bored_bard.R;
import com.example.bored_bard.UI_files.campaign_menu_activity;
import com.example.bored_bard.notes.NotesMainActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class playerList extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth mAuth;
    FirebaseUser user;
    DatabaseReference databaseReference;
    TextView TitleC, backBtn;

    Button addPlayerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        String username = user.getDisplayName();
        TitleC = findViewById(R.id.CTitle);


        addPlayerBtn = findViewById(R.id.addPlayerBtn);
        backBtn = findViewById(R.id.backBtn);






        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            TitleC.setText(bundle.getString("Title"));

        }
        String CTitle = String.valueOf(TitleC.getText());

        databaseReference = FirebaseDatabase.getInstance().getReference("User").child(username).child("Campaigns").child(TitleC.getText().toString()).child("Players");



        addPlayerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), addPlayer.class);
                intent.putExtra("Title", CTitle);
                startActivity(intent);
                finish();
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), campaign_menu_activity.class);
                intent.putExtra("Title", TitleC.getText().toString());
                startActivity(intent);
                finish();
            }
        });












    }
}