package UITestingforCampaignMenu;
import com.example.bored_bard.UI_files.*;
import com.example.bored_bard.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith (AndroidJUnit4.class)
@LargeTest
public class UIforCampaignAcitivityTesting {
    @Rule
    public ActivityScenarioRule<campaign_menu_activity> activityRule =
            new ActivityScenarioRule<campaign_menu_activity>(campaign_menu_activity.class);

    @Test
    public void selectButtons() {
        //checks for a button (or anything that matches that ID) that says Begin Combat and clicks it

        onView(withId(R.id.NPC)).perform(click());
        onView(withId(R.id.beginCombat)).perform(click());

    }
}