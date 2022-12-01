// This controls the login_screen's buttons
package com.example.bored_bard.UI_files;
/**
 * @author Caroline Barrineau
 */
import com.example.bored_bard.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.view.View;


public class login_activity extends Activity {
    // UI references
    private Button loginBt, toRegBt;
    private EditText emailET, passwordET;

    // values for login attempt
    private String Aemail;
    private String Apassword;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        loginBt = (Button) findViewById(R.id.loginButton);
        toRegBt = (Button) findViewById(R.id.toRegButton);
        emailET = (EditText) findViewById(R.id.EmailAddress);
        passwordET = (EditText) findViewById(R.id.Password);

        loginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // verify inputted information
                verify();
            }
        });
        toRegBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // go to register screen
            }
        });


    }

    boolean isNull(EditText input) {
        // check if the text boxes are filled in
        return false;
    }

    boolean isValidEmail(EditText input) {
        // check if info is valid
        return false;
    }

    void verify() {
        if (!isNull(emailET) && isValidEmail(emailET)) {
            // valid
        } else {
            emailET.setError("Email Address is incorrect");
        }
        if (!isNull(passwordET)) {
            // valid
        } else {
            passwordET.setError("Password is incorrect");
        }
    }


}
