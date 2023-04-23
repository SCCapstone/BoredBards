package com.example.bored_bard.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.bored_bard.R;
import com.example.bored_bard.UI_files.Register;
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
    TextView CNTitle;
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
        CNTitle = findViewById(R.id.NCampaignTitle);
        CNTitle = findViewById(R.id.NCampaignTitle);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            CNTitle.setText(bundle.getString("Title"));

        }





        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String title = String.valueOf(titleInput.getText());
                String description = String.valueOf(descriptionInput.getText());


                if (TextUtils.isEmpty(title)) {
                    Toast.makeText(AddNotes.this, "Can't leave blank please enter a Title", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(description)) {
                    Toast.makeText(AddNotes.this, "Can't leave blank please enter a Description", Toast.LENGTH_SHORT).show();
                    return;
                }

                    InsertNote();

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