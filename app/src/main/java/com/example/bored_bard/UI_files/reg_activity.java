// This controls the login_screen's buttons
package com.example.bored_bard.UI_files;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bored_bard.R;

/**
 * @author Caroline Barrineau
 */
public class reg_activity extends AppCompatActivity {
   // UI references
    private Button regBt;
    private Button toLoginBt;
    private EditText emailET;
    private EditText passwordET;
    private EditText repasswordET;

    // values for login attempt
    private String Aemail;
    private String Apassword;
    private String Arepassword;

 protected void onCreate(Bundle savedInstanceState){
  super.onCreate(savedInstanceState);
  setContentView(R.layout.register_screen);
  regBt = (Button)findViewById(R.id.RegButton);
  toLoginBt = (Button)findViewById(R.id.toLoginButton);
  emailET = (EditText)findViewById(R.id.EmailAddress);
  passwordET = (EditText)findViewById(R.id.Password);
  repasswordET = (EditText)findViewById(R.id.RePassword);

  regBt.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {
    // verify registry info and then log in
    verify();
   }
  });

  toLoginBt.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {
    // go to log in page
   }
  });


 }
 boolean isNull(EditText input) {
  // check if the text boxes are filled in
  return false;
 }
 boolean isValidEmail(EditText em){
  // check if info is valid
  return false;
 }

 boolean passMatch(EditText pass, EditText repass){
  return false;
 }

 void verify() {
  if (isNull(emailET) || !isValidEmail(emailET)) {
   emailET.setError("Enter a valid Email Address");
  } else {
   //valid
  }

  if (isNull(passwordET) || isNull(repasswordET)) {
   passwordET.setError("Enter a password");
  } else if (passMatch(passwordET, repasswordET)) {
   //valid
  } else {
   passwordET.setError("Passwords do not match");
  }

 }

}
