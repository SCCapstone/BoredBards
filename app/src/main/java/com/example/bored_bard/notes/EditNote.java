package com.example.bored_bard.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.bored_bard.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class EditNote extends AppCompatActivity {

    EditText  EDescription;
    TextView NTitle, ETitle, finishEdit, cancelEdit,CTitle;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth mAuth;
    FirebaseUser user;
    DatabaseReference reference;
    String id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        mAuth = FirebaseAuth.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        String username = user.getDisplayName();



        ETitle = findViewById(R.id.ETitle);
        EDescription = findViewById(R.id.EDescription);
        CTitle = findViewById(R.id.CNoteTitle);
        NTitle = findViewById(R.id.NNoteTitle);
        finishEdit = findViewById(R.id.finishEdit);
        cancelEdit = findViewById(R.id.cancelEdit);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            CTitle.setText(bundle.getString("Title"));
            NTitle.setText(bundle.getString("NTitle"));
            ETitle.setText(bundle.getString("NoteTitle"));
            EDescription.setText(bundle.getString("Description"));
            id = bundle.getString("id");
        }


        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = FirebaseDatabase.getInstance().getReference(username).child("Campaigns").child(CTitle.getText().toString()).child("Notes").child(id);




        //Saves the instances of the Original Note to send back if user decides not to change text.
        String ETitleOG = ETitle.getText().toString();
        String EDescriptionOG = EDescription.getText().toString();

        //Button cancels the editing of the note
        cancelEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(EditNote.this);
                builder.setTitle("Cancel");
                builder.setMessage("Are you sure you want to Cancel this Edit? You will lose all your changes.");
                builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(), NoteExtendedView.class);
                        intent.putExtra("Title", CTitle.getText().toString());
                        intent.putExtra("NTitle", NTitle.getText().toString());
                        intent.putExtra("Description", EDescriptionOG);
                        intent.putExtra("NoteTitle", ETitleOG);
                        intent.putExtra("id", id);
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

        finishEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(EditNote.this);
                builder.setTitle("Save");
                builder.setMessage("Are you sure you want to Save this note?");
                builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String NewTitle, NewDescription;
                        NewTitle = ETitle.getText().toString();
                        NewDescription = EDescription.getText().toString();

                        if (TextUtils.isEmpty(NewTitle)) {
                            Toast.makeText(EditNote.this, "Please add a Title", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (TextUtils.isEmpty(NewDescription)) {
                            Toast.makeText(EditNote.this, "Come on man you can't leave this empty", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        Notes note = new Notes(NewTitle,NewDescription, id);

                        reference.setValue(note).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(EditNote.this, "Note Saved", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), NoteExtendedView.class);
                                intent.putExtra("Title", CTitle.getText().toString());
                                intent.putExtra("NTitle", ETitle.getText().toString());
                                intent.putExtra("Description", EDescription.getText().toString());
                                intent.putExtra("NoteTitle", ETitle.getText().toString());
                                intent.putExtra("id", id);
                                startActivity(intent);
                                finish();
                            }
                        });

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