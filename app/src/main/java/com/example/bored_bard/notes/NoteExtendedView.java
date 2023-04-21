package com.example.bored_bard.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bored_bard.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NoteExtendedView extends AppCompatActivity {

    LinearLayout NoteExpanded;
    TextView closeNote, titleNote, descriptionNote, editNote, deleteNote,CTitle, NTitle;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth mAuth;
    FirebaseUser user;
    DatabaseReference reference;
    String key = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_extended_view);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        String username = user.getDisplayName();
        firebaseDatabase = FirebaseDatabase.getInstance();


        closeNote = findViewById(R.id.closeNote);
        titleNote= findViewById(R.id.titleNote);
        descriptionNote = findViewById(R.id.descriptionNote);
        editNote = findViewById(R.id.editNote);
        deleteNote = findViewById(R.id.deleteNote);
        CTitle = findViewById(R.id.CTitle);
        NTitle = findViewById(R.id.NTitle);
        String ENTitle = String.valueOf(NTitle.getText());
        String ECTitle = String.valueOf(CTitle.getText());

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            CTitle.setText(bundle.getString("Title"));
            NTitle.setText(bundle.getString("NTitle"));
            titleNote.setText(bundle.getString("NoteTitle"));
            descriptionNote.setText(bundle.getString("Description"));
            key = bundle.getString("Key");
        }
        reference = FirebaseDatabase.getInstance().getReference(username).child("Campaigns").child(CTitle.getText().toString()).child("Notes").child(NTitle.getText().toString());

        closeNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NoteExtendedView.this, noteList.class);
                intent.putExtra("Title", CTitle.getText().toString());
                startActivity(intent);


            }
        });

        editNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NoteExtendedView.this, EditNote.class);
                intent.putExtra("Title", CTitle.getText().toString());
                intent.putExtra("NTitle", NTitle.getText().toString());
                intent.putExtra("Description", descriptionNote.getText().toString());
                intent.putExtra("NoteTitle", titleNote.getText().toString());

                startActivity(intent);
                finish();
            }
        });

        deleteNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(NoteExtendedView.this);
                builder.setTitle("Deletion");
                builder.setMessage("Are you sure you want to Delete this note");
                builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        reference.removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(NoteExtendedView.this, "Deleted Note", Toast.LENGTH_SHORT).show();
                            }
                        });
                        Intent intent = new Intent(getApplicationContext(), noteList.class);
                        intent.putExtra("Title", CTitle.getText().toString());
                        startActivity(intent);
                        finish();
                    }
                });
                builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {




                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }
}