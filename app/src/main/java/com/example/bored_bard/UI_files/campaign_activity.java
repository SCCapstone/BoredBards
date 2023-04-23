/**
 * @author Caroline Barrineau
 */
package com.example.bored_bard.UI_files;

import android.content.Intent;
import android.os.Bundle;
import com.example.bored_bard.R;
import com.example.bored_bard.dice_roller.DieRoller;
import com.example.bored_bard.encyclopedia.Encyclopedia;
import com.example.bored_bard.notes.NotesMainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class campaign_activity extends AppCompatActivity {
    private RecyclerView RV;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;



    FirebaseAuth auth;
    FirebaseUser user;
    TextView textView;
    EditText editText;
    Button button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_campaigns_screen);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        textView =findViewById(R.id.username);






        if (user == null){
            Intent intent = new Intent(getApplicationContext(), google_signin_activity.class);
            startActivity(intent);
            finish();
        }
        else{
            textView.setText(user.getDisplayName());
        }



        BottomNavigationView bottomNavView = findViewById(R.id.bottom_nav);
        bottomNavView.setSelectedItemId(R.id.campaigns_page);
        // bottom navigation bar to move between activities
        bottomNavView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.campaigns_page) {
                startActivity(new Intent(getApplicationContext(), CampaginList.class));
                overridePendingTransition(0, 0);
                return true;
            } else if (item.getItemId() == R.id.dice_page) {
                startActivity(new Intent(getApplicationContext(), DieRoller.class));
                overridePendingTransition(0, 0);
                return true;
            } else if (item.getItemId() == R.id.notes_page) {
                startActivity(new Intent(getApplicationContext(), NotesMainActivity.class));
                overridePendingTransition(0, 0);
                return true;
            } else if (item.getItemId() == R.id.settings_page) {
                startActivity(new Intent(getApplicationContext(), Encyclopedia.class));
                overridePendingTransition(0, 0);
                return true;
            } else {
                return false;
            }
        });

        //UI references
        Button campaign1 = findViewById(R.id.campaign1);
        Button campaign2 = findViewById(R.id.campaign2);
        Button campaign3 = findViewById(R.id.campaign3);

        campaign1.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), campaign_menu_activity.class)));
//        campaign2.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), .class)));
//        campaign3.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), .class)));
    }
}
