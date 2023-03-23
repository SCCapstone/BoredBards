package com.example.bored_bard;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.bored_bard.dice_roller.DieRoller;

import java.util.ArrayList;

@RunWith(AndroidJUnit4.class)
public class DieRollerInstrumentedTest extends AppCompatActivity {

    public static final int d4_size = 4;
    public static final int d6_size = 6;
    public static final int d8_size = 8;
    public static final int d10_size = 10;
    public static final int d12_size = 12;
    public static final int d20_size = 20;

    public static final ArrayList<String> D4 = new ArrayList<>(d4_size);
    public static final ArrayList<String> D6 = new ArrayList<>(d6_size);
    public static final ArrayList<String> D8 = new ArrayList<>(d8_size);
    public static final ArrayList<String> D10 = new ArrayList<>(d10_size);
    public static final ArrayList<String> D12 = new ArrayList<>(d12_size);
    public static final ArrayList<String> D20 = new ArrayList<>(d20_size);


    @Test
    public void d4ResultTests() {
        for (int i = 1; i <= d4_size; i++) {
            D4.add(Integer.toString(i));
        }

        TextView resWind = findViewById(R.id.result_window);
        EditText diceCount = findViewById(R.id.dice_count);

        startActivity(new Intent(getApplicationContext(), DieRoller.class));
        onView(withId(R.id.d4)).perform(click());
        diceCount.setText("1");
        onView(withId(R.id.count_button)).perform(click());
        onView(withId(R.id.roll_button)).perform(click());

        String d4Result = resWind.getText().toString();

        assertTrue(d4Result.equals(D4.get(0)) || d4Result.equals(D4.get(1))
                || d4Result.equals(D4.get(2)) || d4Result.equals(D4.get(3)));
    }

    @Test
    public void d6ResultTests() {
        for (int i = 1; i <= d6_size; i++) {
            D6.add(Integer.toString(i));
        }

        TextView resWind = findViewById(R.id.result_window);
        EditText diceCount = findViewById(R.id.dice_count);

        startActivity(new Intent(getApplicationContext(), DieRoller.class));
        onView(withId(R.id.d6)).perform(click());
        diceCount.setText("1");
        onView(withId(R.id.count_button)).perform(click());
        onView(withId(R.id.roll_button)).perform(click());

        String d6Result = resWind.getText().toString();

        assertTrue(d6Result.equals(D6.get(0)) || d6Result.equals(D6.get(1))
                || d6Result.equals(D6.get(2)) || d6Result.equals(D6.get(3)));
    }

    @Test
    public void d8ResultTests() {
        for (int i = 1; i <= d8_size; i++) {
            D8.add(Integer.toString(i));
        }

        TextView resWind = findViewById(R.id.result_window);
        EditText diceCount = findViewById(R.id.dice_count);

        startActivity(new Intent(getApplicationContext(), DieRoller.class));
        onView(withId(R.id.d8)).perform(click());
        diceCount.setText("1");
        onView(withId(R.id.count_button)).perform(click());
        onView(withId(R.id.roll_button)).perform(click());

        String d8Result = resWind.getText().toString();

        assertTrue(d8Result.equals(D8.get(0)) || d8Result.equals(D8.get(1))
                || d8Result.equals(D8.get(2)) || d8Result.equals(D8.get(3)));
    }

    @Test
    public void d10ResultTests() {
        for (int i = 1; i <= d10_size; i++) {
            D10.add(Integer.toString(i));
        }

        TextView resWind = findViewById(R.id.result_window);
        EditText diceCount = findViewById(R.id.dice_count);

        startActivity(new Intent(getApplicationContext(), DieRoller.class));
        onView(withId(R.id.d10)).perform(click());
        diceCount.setText("1");
        onView(withId(R.id.count_button)).perform(click());
        onView(withId(R.id.roll_button)).perform(click());

        String d10Result = resWind.getText().toString();

        assertTrue(d10Result.equals(D10.get(0)) || d10Result.equals(D10.get(1))
                || d10Result.equals(D10.get(2)) || d10Result.equals(D10.get(3)));
    }

    @Test
    public void d12ResultTests() {
        for (int i = 1; i <= d12_size; i++) {
            D12.add(Integer.toString(i));
        }

        TextView resWind = findViewById(R.id.result_window);
        EditText diceCount = findViewById(R.id.dice_count);

        startActivity(new Intent(getApplicationContext(), DieRoller.class));
        onView(withId(R.id.d12)).perform(click());
        diceCount.setText("1");
        onView(withId(R.id.count_button)).perform(click());
        onView(withId(R.id.roll_button)).perform(click());

        String d12Result = resWind.getText().toString();

        assertTrue(d12Result.equals(D12.get(0)) || d12Result.equals(D12.get(1))
                || d12Result.equals(D12.get(2)) || d12Result.equals(D12.get(3)));
    }

    @Test
    public void d20ResultTests() {
        for (int i = 1; i <= d20_size; i++) {
            D20.add(Integer.toString(i));
        }

        TextView resWind = findViewById(R.id.result_window);
        EditText diceCount = findViewById(R.id.dice_count);

        startActivity(new Intent(getApplicationContext(), DieRoller.class));
        onView(withId(R.id.d20)).perform(click());
        diceCount.setText("1");
        onView(withId(R.id.count_button)).perform(click());
        onView(withId(R.id.roll_button)).perform(click());

        String d20Result = resWind.getText().toString();

        assertTrue(d20Result.equals(D20.get(0)) || d20Result.equals(D20.get(1))
                || d20Result.equals(D20.get(2)) || d20Result.equals(D20.get(3)));
    }

}
