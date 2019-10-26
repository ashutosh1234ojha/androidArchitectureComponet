package com.androidarchitecturecomponents;





import android.support.test.rule.ActivityTestRule;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;

import com.androidarchitecturecomponents.espresso.HelloActivity;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class HelloTest {


    @Rule
    public ActivityTestRule<HelloActivity> mActivityRule =
            new ActivityTestRule<>(HelloActivity.class);

    @Test
    public void loginSuccess(){
                Espresso.onView((withId(R.id.etEmail))).perform(ViewActions.typeText("Hello Ashutosh"));
//                onView((withId(R.id.etEmail))).check(matches(isDisplayed()));


    }
}
