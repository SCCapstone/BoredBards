package com.example.bored_bard.UI_files;
import com.example.bored_bard.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.view.View;
/**
 * @author Caroline Barrineau
 */
public class initiative_activity extends Activity{
    //UI references
    private Button beginCombat, editStats;
    // private EditText P1Roll, P2Roll, Monster1;

    //values for user inputs
    private String aInitRoll;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roll_initative);
        beginCombat = (Button)findViewById(R.id.beginCombat);
        editStats = (Button)findViewById(R.id.editStats);
        // P1Roll = (EditText)findViewById(R.id.P1Roll);
        // P2Roll = (EditText)findViewById(R.id.P2Roll);
        // Monster1 = (EditText)findViewById(R.id.P3Roll);

        beginCombat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // verify that all information needed is inputted
                // save inputted info
                // proceed to combat screen
            }
        });
        editStats.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // send message that changes will not be saved
                // proceed to edit Player Stats page
            }
        });
    }




}
