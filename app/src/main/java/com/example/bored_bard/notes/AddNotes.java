package com.example.bored_bard.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.bored_bard.R;
import com.example.bored_bard.UI_files.google_signin_activity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import io.realm.Realm;

public class AddNotes extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseUser user;
    DatabaseReference database;

    EditText titleInput, descriptionInput;
    MaterialButton saveBtn, exitBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);


        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        titleInput = findViewById(R.id.titleinput);
        descriptionInput = findViewById(R.id.descriptioninput);
        saveBtn = findViewById(R.id.savebutton);
        exitBtn = findViewById(R.id.exitButton);
        database = FirebaseDatabase.getInstance().getReference();








//        Realm.init(getApplicationContext());
//        Realm realm = Realm.getDefaultInstance();

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    InsertNote();

//                String title = titleInput.getText().toString();
//                String description = descriptionInput.getText().toString();
//                long createdTime = System.currentTimeMillis();
//
//                realm.beginTransaction();
//                Notes note = realm.createObject(Notes.class);
//                note.setTitle(title);
//                note.setDescription(description);
//                note.setCreatedTime(createdTime);
//                realm.commitTransaction();
//
//                Notes Cnote = new Notes(title.toString(),description.toString(), createdTime);




                Toast.makeText(getApplicationContext(),"Note created",Toast.LENGTH_SHORT).show();
                finish();



            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NotesMainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
    private void InsertNote(){
//        String noteTitle = titleInput.getText().toString();
//        String noteDescritpion = descriptionInput.getText().toString();
//        long createdTime = System.currentTimeMillis();
//
//        Notes Cnote = new Notes(noteTitle, noteDescritpion);
//        String username = user.getDisplayName();
//        database.child("User").child(username).child("Campaigns").child("Notes").setValue(Cnote)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if(task.isSuccessful()){
//                    Toast.makeText(AddNotes.this, "Note has been created", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
        String title, description;
        String username = user.getDisplayName();
        title = String.valueOf(titleInput.getText());
        description = String.valueOf(descriptionInput.getText());

        Notes Cnote = new Notes(titleInput.getText().toString(), descriptionInput.getText().toString());
        database.child("user").child(username).child("Campaigns").child("Notes").setValue(Cnote);


    }

}