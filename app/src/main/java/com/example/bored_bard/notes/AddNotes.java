package com.example.bored_bard.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
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
/**
 * @author Andrew MacMurray - FrozenDrew
 */
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

        //Firebase Auth Calls for username
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();


        titleInput = findViewById(R.id.titleinput);
        descriptionInput = findViewById(R.id.descriptioninput);
        saveBtn = findViewById(R.id.savebutton);
        exitBtn = findViewById(R.id.exitButton);
        database = FirebaseDatabase.getInstance().getReference();
        CNTitle = findViewById(R.id.NCampaignTitle);
        CNTitle = findViewById(R.id.NCampaignTitle);

        //Sets the Title of the page.
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            CNTitle.setText(bundle.getString("Title"));

        }
        InputFilter filter = new InputFilter() {
            public CharSequence filter(CharSequence source, int start, int end,
                                       Spanned dest, int dstart, int dend) {
                for (int i = start; i < end; i++) {
                    char c = source.charAt(i);
                    if (c == '.' || c == '#' || c == '$' || c == '[' || c == ']') {
                        return ""; // return an empty string to prevent the character from being entered
                    }
                }
                return null; // let the character be entered
            }
        };
        titleInput.setFilters(new InputFilter[] {filter});


        //Creates a New Note and returns the user to the NotesList page
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String title = String.valueOf(titleInput.getText());
                String description = String.valueOf(descriptionInput.getText());


                //Checks to see if the Title was left blank. If so it will prompt the user to add a Title
                if (TextUtils.isEmpty(title)) {
                    Toast.makeText(AddNotes.this, "Can't leave blank please enter a Title", Toast.LENGTH_SHORT).show();
                    return;
                }

                //Checks to see if the Description was left blank. If so it will prompt the user to add a Description
                if (TextUtils.isEmpty(description)) {
                    Toast.makeText(AddNotes.this, "Can't leave blank please enter a Description", Toast.LENGTH_SHORT).show();
                    return;
                }

                    InsertNote();


                //Takes the user to the Notes list page.
                Toast.makeText(getApplicationContext(),"Note created",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), noteList.class);
                intent.putExtra("Title", CNTitle.getText().toString());
                startActivity(intent);
                finish();

            }
        });

        //Cancels the Creation of a Note and Returns you to the Notes list page.
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), noteList.class);
                intent.putExtra("Title", CNTitle.getText().toString());
                startActivity(intent);
                finish();
            }
        });




    }

    //Uses the Reference point to insert the New Note under the selected Campaign
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