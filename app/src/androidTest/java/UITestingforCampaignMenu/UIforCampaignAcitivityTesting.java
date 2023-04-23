package UITestingforCampaignMenu;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.bored_bard.R;
import com.example.bored_bard.UI_files.campaign_menu_activity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith (AndroidJUnit4.class)
@LargeTest
public class UIforCampaignAcitivityTesting {
    @Rule
    public ActivityScenarioRule<campaign_menu_activity> activityRule =
            new ActivityScenarioRule<>(campaign_menu_activity.class);

    @Test
    public void selectBeginCombatButton() {
        // checks if begins combat button exists and can be clicked

        onView(withId(R.id.beginCombat)).perform(click());
    }
    @Test
    public void selectNPCButton(){
        // checks if NPC button exists and can be clicked
        onView(withId(R.id.NPC)).perform(click());
    }
    @Test
    public void selectEandMButton(){
        // checks if EandM button exists and can be clicked
        onView(withId(R.id.EandM)).perform(click());
    }

    @Test
    public void selectMapsButton(){
        // checks if Maps button exists and can be clicked
        onView(withId(R.id.maps)).perform(click());
    }

    @Test
    public void selectNotesButton(){
        // checks if Notes button exists and can be clicked
        onView(withId(R.id.Notes)).perform(click());
    }

    @Test
    public void selectPlayerStatsButton(){
        // checks if PlayerStats button exists and can be clicked
        onView(withId(R.id.playerStats)).perform(click());
    }
}