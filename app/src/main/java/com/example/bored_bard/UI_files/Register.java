package com.example.bored_bard.UI_files;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
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
/**
 * @author Andrew MacMurray - FrozenDrew
 */
public class Register extends AppCompatActivity {
    TextInputEditText editTextEmailAddress, editTextPassword, editUsername;
    Button buttonRegister;
    ProgressBar progressBar;
    TextView textView;
    FirebaseAuth mAuth;
    FirebaseUser user;

    /**
     * If User is logged in will send the User to the Home Page(campaign_activity.class)
     * If User is not logged will keep them on the Register Page
     */
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
        //Sets the Views and Buttons
        editTextEmailAddress = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        editUsername = findViewById(R.id.username);
        buttonRegister = findViewById(R.id.btn_register);
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.LoginNow);

        //Calls the FirebaseAuth and DatabaseReferences
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        final FirebaseDatabase[] rootNode = new FirebaseDatabase[1];
        final DatabaseReference[] reference = new DatabaseReference[1];


        /**
         * Will take you back to the Login Screen
         */
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), google_signin_activity.class);
                startActivity(intent);
                finish();
            }
        });

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
        editUsername.setFilters(new InputFilter[] {filter});


        /**
         * Will Register a User using Email, Password, and Username
         * If Email is blank will prompt the user to Enter an Email
         * If Email is not properly formatted it will prompt the User to Enter a valid Email
         *
         * If Password is blank will prompt the user to Enter a Password
         * If Password is less that 6 characters long will prompt the User to Enter a longer password
         *
         * If Username is blank will prompt the user to Enter a Username
         *
         * If all data is formatted properly It will create an Account under FirebaseAuth
         * Then it Create a User entry in the FireBase RealTime Database to store the User's Data
         *
         * After doing that it will Log the User in Sending them to the Home page (campaign_activity.class)
         */
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String email, password, username;
                email = String.valueOf(editTextEmailAddress.getText());
                password = String.valueOf(editTextPassword.getText());
                username = String.valueOf(editUsername.getText());
                rootNode[0] = FirebaseDatabase.getInstance();
                reference[0] = rootNode[0].getReference();
                
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(Register.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Register.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    return;
                }
                if (password.length() < 6){
                    Toast.makeText(Register.this, "Password is too short", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    return;
                }

                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(Register.this, "Enter Username", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    return;
                }



                User Fuser = new User(editTextEmailAddress.getText().toString(),editTextPassword.getText().toString(),editUsername.getText().toString());





                // creates the user account with email and password in FirebaseAuth
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    progressBar.setVisibility(View.GONE);
                                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                                    //Sets the Username in FirebaseAuth
                                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                            .setDisplayName(Fuser.getUsername()).build();

                                    user.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                           if(task.isSuccessful()) {

                                               //Will Create the User's Node in the RealTime Database for User Data Storage
                                               reference[0].child(username).child("UserInfo").setValue(Fuser);
                                               Toast.makeText(Register.this, "Username updated.",
                                                       Toast.LENGTH_SHORT).show();
                                               Intent intent = new Intent(getApplicationContext(), google_signin_activity.class);
                                               startActivity(intent);
                                               finish();

                                           }
                                        }
                                    });

                                    Toast.makeText(Register.this, "Account Created.",
                                            Toast.LENGTH_SHORT).show();


                                } else {
                                    // If sign in fails, display a message to the user.
                                    progressBar.setVisibility(View.GONE);
                                    Toast.makeText(Register.this, "Please enter a valid Email.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });


                }

        });


    }
}