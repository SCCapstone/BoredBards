/**
 * @author Charles Simons - csimons637
 */
/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * This project is based on code that is licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.bored_bard.dice_roller;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bored_bard.R;
import com.example.bored_bard.campaign.CampaignsActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

// allows a user to roll a d20 for initiative
// plan to add other dice values later
public class DieRoller extends AppCompatActivity {

    // number of sides for each die type
    public static final int D4 = 4;
    public static final int D6 = 6;
    public static final int D8 = 8;
    public static final int D10 = 10;
    public static final int D12 = 12;
    public static final int D20 = 20;

    // sets number of side for the Die
    int numSides = D20;
    // number of dice to roll
    int numDice = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.die_roller);

        // gets user's number of dice
        EditText text = findViewById(R.id.dice_count);
        numSides = Integer.parseInt(text.getText().toString());

        BottomNavigationView bottomNavView = findViewById(R.id.bottom_nav);
        bottomNavView.setSelectedItemId(R.id.dice_page);
        // bottom navigation bar to move between activities
        bottomNavView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.campaigns_page:
                    startActivity(new Intent(getApplicationContext(), CampaignsActivity.class));
                    bottomNavView.setSelectedItemId(R.id.campaigns_page);
                    return true;
                case R.id.dice_page:
                    startActivity(new Intent(getApplicationContext(), DieRoller.class));
                    bottomNavView.setSelectedItemId(R.id.dice_page);
                    return true;
                case R.id.notes_page:
                    // start the notes activity here
                    bottomNavView.setSelectedItemId(R.id.notes_page);
                    return true;
                case R.id.settings_page:
                    // start the settings activity here
                    bottomNavView.setSelectedItemId(R.id.settings_page);
                    return true;
            }
            return false;
        });

        Button rollerButton = findViewById(R.id.button);
        // buttons to change the type of die (i.e. numSides)
        ImageButton d4 = findViewById(R.id.d4);
        ImageButton d6 = findViewById(R.id.d6);
        ImageButton d8 = findViewById(R.id.d8);
        ImageButton d10 = findViewById(R.id.d10);
        ImageButton d12 = findViewById(R.id.d12);
        ImageButton d20 = findViewById(R.id.d20);

        // need to add edit text element here
        // takes input for the number of dice to roll

        d4.setOnClickListener(v -> setNumSides(D4));
        d6.setOnClickListener(v -> setNumSides(D6));
        d8.setOnClickListener(v -> setNumSides(D8));
        d10.setOnClickListener(v -> setNumSides(D10));
        d12.setOnClickListener(v -> setNumSides(D12));
        d20.setOnClickListener(v -> setNumSides(D20));

        rollerButton.setOnClickListener(v -> rollDie(numSides));

        rollDie(numSides);
//        rollDice(numSides, numDice);
    }

    // sets the number of sides to use shen rolling
    private void setNumSides(int num) {
        // displays a message about the type of die being rolled
        TextView dieType = findViewById(R.id.type_window);
        switch (num) {
            case D4:
                numSides = D4;
                break;
            case D6:
                numSides = D6;
                break;
            case D8:
                numSides = D8;
                break;
            case D10:
                numSides = D10;
                break;
            case D12:
                numSides = D12;
                break;
            default:
                numSides = D20;
                break;
        }
        String dieMsg = "Rolling " + numDice + "x D" + numSides;
        dieType.setText(dieMsg);
        dieType.setContentDescription(String.valueOf(numSides));
    }

    // called by rollDice any number of times specified by the user
    private void rollDie(int numSides) {
        Die die = new Die(numSides);
//        return die.roll();
    }

//    // rolls any number of dice specified by the user
//    private void rollDice(int numSides, int numDice) {
//        TextView dieResult = findViewById(R.id.result_window);
//
//        int count = numDice;
//        int total = 0;
//        while (count != 0) {
//            total += rollDie(numSides);
//            count--;
//        }
//        // update TextView with result
//        dieResult.setText(String.valueOf(total));
//
//        // update description
//        dieResult.setContentDescription(String.valueOf(total));
//    }
}
