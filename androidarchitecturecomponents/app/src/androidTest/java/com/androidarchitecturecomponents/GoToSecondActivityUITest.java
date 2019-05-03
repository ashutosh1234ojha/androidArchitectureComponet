package com.androidarchitecturecomponents;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.androidarchitecturecomponents.uiTesting.FirstActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Ashutosh Ojha on 4/22/19.
 */
@RunWith(AndroidJUnit4.class)
public class GoToSecondActivityUITest {


    @Rule
    public ActivityTestRule<FirstActivity> mainActivityTestRule =
            new ActivityTestRule<>(FirstActivity.class);

    @Test
    public void buttonClick_goToSecondActivity() {
        onView((withId(R.id.btnProgressBar))).perform(click());
        onView((withId(R.id.constraintParent))).check(matches(isDisplayed()));

    }
}