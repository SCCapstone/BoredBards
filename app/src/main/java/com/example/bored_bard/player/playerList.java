package com.example.bored_bard.player;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bored_bard.R;
import com.example.bored_bard.UI_files.campaign_menu_activity;
import com.example.bored_bard.notes.MyAdapter;
import com.example.bored_bard.notes.Notes;
import com.example.bored_bard.notes.NotesMainActivity;
import com.example.bored_bard.notes.noteList;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class playerList extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth mAuth;
    FirebaseUser user;
    DatabaseReference databaseReference;
    TextView TitleC, backBtn;
    ValueEventListener eventListener;
    Button addPlayerBtn;

    ArrayList<Player> playerlist;
    FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list);



        //User info
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        String username = user.getDisplayName();

       //declare title change
        TitleC = findViewById(R.id.workdamnit);

        //declare buttons
        addPlayerBtn = findViewById(R.id.addPlayerBtn);
        backBtn = findViewById(R.id.backBtn);


        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            TitleC.setText(bundle.getString("PlayerTitle"));

        }

        RecyclerView recyclerView = findViewById(R.id.recyclerviewPlayers);


        database = FirebaseDatabase.getInstance();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(playerList.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        playerlist = new ArrayList<>();

        PlayerAdapter playerAdapter = new PlayerAdapter(playerList.this, playerlist);

        recyclerView.setAdapter(playerAdapter);


        databaseReference = database.getReference(username).child("Campaigns").child(TitleC.getText().toString()).child("Players");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                playerlist.clear();
                for(DataSnapshot dataSnapshot: snapshot.getChildren())
                {
                    Player player = dataSnapshot.getValue(Player.class);
                    playerlist.add(player);
                }
                playerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        addPlayerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), addPlayer.class);
                intent.putExtra("Title", TitleC.getText().toString());
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