package com.example.bored_bard.campaign;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bored_bard.R;

public class CampaignsActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.campaign_layout);

        Button switch_to_roller = findViewById(R.id.bottom_nav);
    }
}
