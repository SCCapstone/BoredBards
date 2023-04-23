package com.example.bored_bard.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.bored_bard.R;
import com.google.android.material.button.MaterialButton;

import io.realm.Realm;

public class AddNotes extends AppCompatActivity {
    TextView CNTitle;
    FirebaseAuth mAuth;
    FirebaseUser user;
    DatabaseReference database;

    EditText titleInput, descriptionInput;
    MaterialButton saveBtn, exitBtn;
    TextView backBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);

        EditText titleInput = findViewById(R.id.titleinput);
        EditText descriptionInput = findViewById(R.id.descriptioninput);
        MaterialButton saveBtn = findViewById(R.id.savebutton);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        titleInput = findViewById(R.id.titleinput);
        descriptionInput = findViewById(R.id.descriptioninput);
        saveBtn = findViewById(R.id.savebutton);
        exitBtn = findViewById(R.id.exitButton);
        database = FirebaseDatabase.getInstance().getReference();
        CNTitle = findViewById(R.id.NCampaignTitle);
        CNTitle = findViewById(R.id.NCampaignTitle);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            CNTitle.setText(bundle.getString("Title"));

        }

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = titleInput.getText().toString();
                String description = descriptionInput.getText().toString();
                long createdTime = System.currentTimeMillis();

                realm.beginTransaction();
                Notes note = realm.createObject(Notes.class);
                note.setTitle(title);
                note.setDescription(description);
                note.setCreatedTime(createdTime);
                realm.commitTransaction();
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
        TextView backBtn;

        backBtn = findViewById(R.id.backBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NotesMainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
    private void InsertNote(){
        String Title = String.valueOf(CNTitle.getText());

        String title, description, id;
        String username = user.getDisplayName();

        title = String.valueOf(titleInput.getText());
        id = String.valueOf(titleInput.getText());

        description = String.valueOf(descriptionInput.getText());

        Notes Cnote = new Notes(titleInput.getText().toString(), descriptionInput.getText().toString(), id);
        database.child(username).child("Campaigns").child(Title).child("Notes").child(id).setValue(Cnote);
    }


}
