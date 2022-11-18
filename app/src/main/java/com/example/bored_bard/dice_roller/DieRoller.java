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

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bored_bard.R;

// allows a user to roll a d20 for initiative
// plan to add other dice values later
public class DieRoller extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.die_roller);

        Button rollerButton = findViewById(R.id.button);

        rollerButton.setOnClickListener(v -> rollDie());

        rollDie();
    }

    private void rollDie() {
        Die die = new Die(20);
        int dieRoll = die.roll();

        TextView dieResult = findViewById(R.id.textView);
        String result;
        switch (dieRoll) {
            case 2:
                result = "2";
                break;
            case 3:
                result = "3";
                break;
            case 4:
                result = "4";
                break;
            case 5:
                result = "5";
                break;
            case 6:
                result = "6";
                break;
            case 7:
                result = "7";
                break;
            case 8:
                result = "8";
                break;
            case 9:
                result = "9";
                break;
            case 10:
                result = "10";
                break;
            case 11:
                result = "11";
                break;
            case 12:
                result = "12";
                break;
            case 13:
                result = "13";
                break;
            case 14:
                result = "14";
                break;
            case 15:
                result = "15";
                break;
            case 16:
                result = "16";
                break;
            case 17:
                result = "17";
                break;
            case 18:
                result = "18";
                break;
            case 19:
                result = "19";
                break;
            case 20:
                result = "20";
                break;
            default:
                result = "1";
                break;
        }

        // update TextView with result
        dieResult.setText(result);

        // update description
        dieResult.setContentDescription(String.valueOf(dieRoll));
    }
}
