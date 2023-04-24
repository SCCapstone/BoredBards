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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bored_bard.R;
import com.example.bored_bard.UI_files.campaign_activity;
import com.example.bored_bard.UI_files.settings_activity;
import com.example.bored_bard.encyclopedia.Encyclopedia;
import com.example.bored_bard.notes.NotesMainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import kotlin.Triple;

// allows a user to roll different dice
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
    int numDice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.die_roller);
        BottomNavigationView bottomNavView = findViewById(R.id.bottom_nav);
        bottomNavView.setSelectedItemId(R.id.dice_page);
        // bottom navigation bar to move between activities
        bottomNavView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.campaigns_page) {
                startActivity(new Intent(getApplicationContext(), campaign_activity.class));
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
                startActivity(new Intent(getApplicationContext(), settings_activity.class));
                overridePendingTransition(0, 0);
                return true;
            } else if (item.getItemId() == R.id.encyclopedia) {
                startActivity(new Intent(getApplicationContext(), Encyclopedia.class));
                overridePendingTransition(0, 0);
                return true;
            } else {
                return false;
            }
        });

        Button rollerButton = findViewById(R.id.roll_button);
        Button numDiceButton = findViewById(R.id.count_button);
        Button adv = findViewById(R.id.advantage_button);
        Button disadv = findViewById(R.id.disadvantage_button);
        // buttons to change the type of die (i.e. numSides)
        ImageButton d4 = findViewById(R.id.d4);
        ImageButton d6 = findViewById(R.id.d6);
        ImageButton d8 = findViewById(R.id.d8);
        ImageButton d10 = findViewById(R.id.d10);
        ImageButton d12 = findViewById(R.id.d12);
        ImageButton d20 = findViewById(R.id.d20);

        d4.setOnClickListener(v -> setNumSides(D4));
        d6.setOnClickListener(v -> setNumSides(D6));
        d8.setOnClickListener(v -> setNumSides(D8));
        d10.setOnClickListener(v -> setNumSides(D10));
        d12.setOnClickListener(v -> setNumSides(D12));
        d20.setOnClickListener(v -> setNumSides(D20));

        adv.setOnClickListener(v -> advantagedRoll());
        disadv.setOnClickListener(v -> disadvantagedRoll());

        numDiceButton.setOnClickListener(v -> setNumDice());
        rollerButton.setOnClickListener(v -> rollDie(numSides));

        rollDie(numSides);
    }

    /**
     * Checks that the number of dice to be rolled
     * isn't too large
     * @return - if number of dice exceeds 25, returns true
     */
    private boolean excessDice() {
        return numDice > 25;
    }

    /**
     * Sets the number of dice to be rolled
     */
    private void setNumDice() {
        EditText input = findViewById(R.id.dice_count);

        if (input.getText() == null) {
            numDice = 1;
        } else if (Integer.parseInt(input.getText().toString()) == 1) {
            numDice = Integer.parseInt(input.getText().toString());
        } else if (Integer.parseInt(input.getText().toString()) > 1) {
            numDice = Integer.parseInt(input.getText().toString());
        }

        String tst_msg = numDice + " dice seems a bit high. Consider a smaller number";
        if (excessDice()) {
            Toast.makeText(getApplicationContext(), tst_msg, Toast.LENGTH_SHORT).show();
        }
        setNumSides(numDice);
    }

    /**
     * Sets the number of sides to use shen rolling
     * @param num - the number of sides
     */
    private void setNumSides(int num) {
        // displays a message about the type of die being rolled
        TextView dieType = findViewById(R.id.type_window);
        numSides = D20;
        String dieMsg = "Rolling " + numDice + "d" + numSides;
        dieType.setText(dieMsg);
        dieType.setContentDescription(String.valueOf(numSides));
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
        dieMsg = "Rolling " + numDice + "d" + numSides;
        dieType.setText(dieMsg);
        dieType.setContentDescription(String.valueOf(numSides));
    }

    /**
     * called by rollDice any number of times specified by the user
      */
    private void rollDie(int numSides) {
        setNumDice();
        Die die = new Die(numSides);
        int result;

        if (numDice == 1) {
            result = die.roll();
            String msg = "Breakdown of results:\n\n" + result;
            TextView dieResult = findViewById(R.id.result_window);
            TextView res_breakdown = findViewById(R.id.roll_breakdown);
            res_breakdown.setText(msg);
            res_breakdown.setContentDescription(msg);
            dieResult.setText(String.valueOf(result));
            dieResult.setContentDescription(String.valueOf(result));
        }
        else {
            rollMultiple(die, numDice);
        }
    }

    /**
     * rolls multiple dice, based on user input
     * on the related EditText object
     * (checks that the Die object is not null)
     * @param die - the die to be rolled
     * @param numDice - the number of times to roll
     */
    private void rollMultiple(@NonNull Die die, int numDice) {
        int res;
        int out = 0;
        ArrayList<Integer> multiResult = new ArrayList<>();

        for (int i = 0; i < numDice; i++) {
            res = die.roll();
            multiResult.add(res);
            out += res;
        }

        // displays a breakdown of the rolls
        String temp = multiResult.toString().substring(1, multiResult.toString().length() - 1);
        String breakdown = ("Breakdown of results:\n\n" + temp);

        TextView res_window = findViewById(R.id.result_window);
        res_window.setText(String.valueOf(out));
        TextView res_breakdown = findViewById(R.id.roll_breakdown);
        res_breakdown.setText(breakdown);
        res_breakdown.setContentDescription(breakdown);
    }

    /**
     * Allows a user to roll a d20 with "advantage";
     * (i.e. roll 2d20 and use the highest number)
     */
    public Triple<String, Integer, Integer> advantagedRoll() {
        Die die = new Die(D20);
        ArrayList<Integer> multiResult = new ArrayList<>();

        int roll1 = die.roll();
        int roll2 = die.roll();

        multiResult.add(roll1);
        multiResult.add(roll2);
        String temp = multiResult.toString().substring(1, multiResult.toString().length() - 1);
        String breakdown = ("Breakdown of results:\n\n" + temp);
        TextView dieResult = findViewById(R.id.result_window);
        TextView res_breakdown = findViewById(R.id.roll_breakdown);
        res_breakdown.setText(breakdown);
        res_breakdown.setContentDescription(breakdown);

        TextView dieType = findViewById(R.id.type_window);
        String dieMsg = "Rolling with advantage";
        dieType.setText(dieMsg);
        dieType.setContentDescription(String.valueOf(numSides));

        String max = String.valueOf(Math.max(roll1, roll2));
        dieResult.setText(max);
        dieResult.setContentDescription(max);

        return new Triple<>(max, roll1, roll2);
    }

    /**
     * Allows a user to roll a d20 with "disadvantage";
     * (i.e. roll 2d20 and use the lowest number)
     */
    public Triple<String, Integer, Integer> disadvantagedRoll() {
        Die die = new Die(D20);
        ArrayList<Integer> multiResult = new ArrayList<>();

        int roll1 = die.roll();
        int roll2 = die.roll();

        multiResult.add(roll1);
        multiResult.add(roll2);
        String temp = multiResult.toString().substring(1, multiResult.toString().length() - 1);
        String breakdown = ("Breakdown of results:\n\n" + temp);
        TextView dieResult = findViewById(R.id.result_window);
        TextView res_breakdown = findViewById(R.id.roll_breakdown);
        res_breakdown.setText(breakdown);
        res_breakdown.setContentDescription(breakdown);

        TextView dieType = findViewById(R.id.type_window);
        String dieMsg = "Rolling with disadvantage";
        dieType.setText(dieMsg);
        dieType.setContentDescription(String.valueOf(numSides));

        String min = String.valueOf(Math.min(roll1, roll2));
        dieResult.setText(min);
        dieResult.setContentDescription(min);

        return new Triple<>(min, roll1, roll2);
    }
}
