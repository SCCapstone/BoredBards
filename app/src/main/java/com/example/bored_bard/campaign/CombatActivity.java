/**
 * @author Charles Simons - csimons637
 */
package com.example.bored_bard.campaign;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bored_bard.R;

public class CombatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roll_initative);
    }

    Button initiative = findViewById(R.id.beginCombat);
}