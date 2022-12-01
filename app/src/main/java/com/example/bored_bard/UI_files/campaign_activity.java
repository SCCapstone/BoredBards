/**
 * @author Caroline Barrineau
 */
package com.example.bored_bard.UI_files;

import android.os.Bundle;
import com.example.bored_bard.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
public class campaign_activity extends Activity {
    //UI references
    private Button campaign1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_campaigns_screen);
        campaign1 = (Button) findViewById(R.id.campagin1);

        campaign1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // proceed to this campaign
            }
        });
    }
}
