package com.example.bored_bard;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anyOf;
import static org.junit.Assert.assertTrue;

import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.bored_bard.dice_roller.DieRoller;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;

@RunWith(AndroidJUnit4.class)
public class DieRollerInstrumentedTest {
    @Rule
    public ActivityScenarioRule<DieRoller> actRule = new ActivityScenarioRule<>(DieRoller.class);

    public static final int d4_size = 4;
    public static final int d6_size = 6;
    public static final int d8_size = 8;
    public static final int d10_size = 10;
    public static final int d12_size = 12;
    public static final int d20_size = 20;
    public static final ArrayList<String> D4 = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
    public static final ArrayList<String> D6 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6"));
    public static final ArrayList<String> D8 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8"));
    public static final ArrayList<String> D10 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
    public static final ArrayList<String> D12 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"));
    public static final ArrayList<String> D20 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"));


    @Test
    public void d4ResultTests() {
        onView(withId(R.id.d4)).perform(click());
        onView(withId(R.id.count_button)).perform(click());
        onView(withId(R.id.roll_button)).perform(click());

        onView(withId(R.id.result_window))
                .check(matches(anyOf(withText("1"), withText("2"), withText("3"), withText("4"))));
    }

    @Test
    public void d6ResultTests() {
        onView(withId(R.id.d6)).perform(click());
        onView(withId(R.id.count_button)).perform(click());
        onView(withId(R.id.roll_button)).perform(click());

        onView(withId(R.id.result_window))
                .check(matches(anyOf(withText("1"), withText("2"), withText("3"), withText("4"),
                        withText("5"), withText("6"))));
    }

    @Test
    public void d8ResultTests() {
        onView(withId(R.id.d8)).perform(click());
        onView(withId(R.id.count_button)).perform(click());
        onView(withId(R.id.roll_button)).perform(click());

        onView(withId(R.id.result_window))
                .check(matches(anyOf(withText("1"), withText("2"), withText("3"), withText("4"),
                        withText("5"), withText("6"), withText("7"), withText("8"))));
    }

    @Test
    public void d10ResultTests() {
        onView(withId(R.id.d10)).perform(click());
        onView(withId(R.id.count_button)).perform(click());
        onView(withId(R.id.roll_button)).perform(click());

        onView(withId(R.id.result_window))
                .check(matches(anyOf(withText("1"), withText("2"), withText("3"), withText("4"),
                        withText("5"), withText("6"), withText("7"), withText("8"), withText("9"), withText("10"))));
    }

    @Test
    public void d12ResultTests() {
        onView(withId(R.id.d12)).perform(click());
        onView(withId(R.id.count_button)).perform(click());
        onView(withId(R.id.roll_button)).perform(click());

        onView(withId(R.id.result_window))
                .check(matches(anyOf(withText("1"), withText("2"), withText("3"), withText("4"),
                        withText("5"), withText("6"), withText("7"), withText("8"), withText("9"),
                        withText("10"), withText("11"), withText("12"))));
    }

    @Test
    public void d20ResultTests() {
        onView(withId(R.id.d20)).perform(click());
        onView(withId(R.id.count_button)).perform(click());
        onView(withId(R.id.roll_button)).perform(click());

        onView(withId(R.id.result_window))
                .check(matches(anyOf(withText("1"), withText("2"), withText("3"), withText("4"),
                        withText("5"), withText("6"), withText("7"), withText("8"), withText("9"),
                        withText("10"), withText("11"), withText("12"), withText("13"), withText("15"),
                        withText("16"), withText("17"), withText("18"), withText("19"), withText("20"))));
    }

}
