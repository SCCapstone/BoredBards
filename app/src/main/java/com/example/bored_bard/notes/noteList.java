package com.example.bored_bard.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.TextView;

import com.example.bored_bard.R;
import com.example.bored_bard.UI_files.CampaginList;
import com.example.bored_bard.campaign.Campaign;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.EventListener;

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

//        addNoteBtn.setOnClickListener(view -> startActivity(new Intent(noteList.this, AddNotes.class)));

        addNoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddNotes.class);
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



    }


}