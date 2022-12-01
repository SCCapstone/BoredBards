package com.example.bored_bard.UI_files;
import com.example.bored_bard.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
/**
 * @author Caroline Barrineau
 */
public class initiative_activity extends Activity{
    // private EditText P1Roll, P2Roll, Monster1;

    //values for user inputs
    private String aInitRoll;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_combat_screen);
        //UI references
        Button beginCombat = (Button) findViewById(R.id.beginCombat);
        Button editStats = (Button) findViewById(R.id.editStats);
        // P1Roll = (EditText)findViewById(R.id.P1Roll);
        // P2Roll = (EditText)findViewById(R.id.P2Roll);
        // Monster1 = (EditText)findViewById(R.id.P3Roll);

        beginCombat.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), combat_activity.class)));
//            public void onClick(View view) {
//                // verify that all information needed is inputted
//                // save inputted info
//                // proceed to combat screen
//            }
//        });
        editStats.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), edit_stats_activity.class)));
//            public void onClick(View view) {
//                // send message that changes will not be saved
//                // proceed to edit Player Stats page
//            }
//        });
    }




}
