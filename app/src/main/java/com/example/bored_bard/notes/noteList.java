package com.example.bored_bard.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.bored_bard.R;
import com.example.bored_bard.UI_files.campaign_activity;
import com.example.bored_bard.UI_files.settings_activity;
import com.example.bored_bard.dice_roller.DieRoller;
import com.example.bored_bard.encyclopedia.Encyclopedia;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class noteList extends AppCompatActivity {

    TextView CNTitle, backBtn;
    RecyclerView recyclerView;
    ArrayList<Notes> noteslist;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    MyAdapter adapter;
    FirebaseAuth mAuth;
    FirebaseUser user;
    ValueEventListener eventListener;
    MaterialButton addNoteBtn;
    String CTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        CNTitle = findViewById(R.id.CNoteTitle);


        String username = user.getDisplayName();



        addNoteBtn = findViewById(R.id.addNoteButton);
        backBtn = findViewById(R.id.backBtn);


        addNoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(noteList.this, AddNotes.class);
                intent.putExtra("Title", CNTitle.getText().toString());
                startActivity(intent);
                finish();
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NotesMainActivity.class);
                intent.putExtra("Title", CNTitle.getText().toString());
                startActivity(intent);
                finish();
            }
        });


        noteslist = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerview);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(noteList.this, 1);
        MyAdapter adapter = new MyAdapter(noteList.this, noteslist);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);



        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            CNTitle.setText(bundle.getString("Title"));
        }

        CTitle = String.valueOf(CNTitle.getText());

        adapter.CNote = CTitle;

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference(username).child("Campaigns").child(CTitle).child("Notes");


         eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                noteslist.clear();
                for(DataSnapshot dataSnapshot: snapshot.getChildren())
                {

                    Notes notes = dataSnapshot.getValue(Notes.class);
                    notes.setKey(dataSnapshot.getKey());
                    noteslist.add(notes);
                }
             adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        BottomNavigationView bottomNavView = findViewById(R.id.bottom_nav);
        bottomNavView.setSelectedItemId(R.id.encyclopedia);
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