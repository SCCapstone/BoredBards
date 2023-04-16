package com.example.bored_bard.UI_files;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bored_bard.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.checkerframework.checker.nullness.qual.NonNull;

public class Register extends AppCompatActivity {
    TextInputEditText editTextEmailAddress, editTextPassword, editUsername;
    Button buttonRegister;
    ProgressBar progressBar;
    TextView textView;
    FirebaseAuth mAuth;
    FirebaseUser user;

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), campaign_activity.class);
            startActivity(intent);
            finish();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editTextEmailAddress = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        editUsername = findViewById(R.id.username);
        buttonRegister = findViewById(R.id.btn_register);
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.LoginNow);
        mAuth = FirebaseAuth.getInstance();
        DAOUser dao = new DAOUser();
        user = mAuth.getCurrentUser();
        final FirebaseDatabase[] rootNode = new FirebaseDatabase[1];
        final DatabaseReference[] reference = new DatabaseReference[1];


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), google_signin_activity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String email, password, username;
                email = String.valueOf(editTextEmailAddress.getText());
                password = String.valueOf(editTextPassword.getText());
                username = String.valueOf(editUsername.getText());
                rootNode[0] = FirebaseDatabase.getInstance();
                reference[0] = rootNode[0].getReference("User");
                
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(Register.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Register.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(Register.this, "Enter Username", Toast.LENGTH_SHORT).show();
                    return;
                }

                User Fuser = new User(editTextEmailAddress.getText().toString(),editTextPassword.getText().toString(),editUsername.getText().toString());

                reference[0].child(username).setValue(Fuser);



                // creates the user account with email and password
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    progressBar.setVisibility(View.GONE);
                                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                            .setDisplayName(Fuser.getUsername()).build();
                                    user.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                           if(task.isSuccessful()) {
                                               Toast.makeText(Register.this, "Username updated.",
                                                       Toast.LENGTH_SHORT).show();
                                           }
                                        }
                                    });

                                    Toast.makeText(Register.this, "Account Created.",
                                            Toast.LENGTH_SHORT).show();


                                } else {
                                    // If sign in fails, display a message to the user.
                                    progressBar.setVisibility(View.GONE);
                                    Toast.makeText(Register.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });


               //Sends user back to login in page after the user creates account
                Intent intent = new Intent(getApplicationContext(), google_signin_activity.class);
                startActivity(intent);
                finish();
                }

        });


    }
}