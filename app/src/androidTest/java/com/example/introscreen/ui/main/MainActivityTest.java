package com.example.introscreen.ui.main;

import android.content.Intent;

import androidx.test.espresso.intent.Intents;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import com.example.introscreen.R;
import com.example.introscreen.ui.intro.IntroActivity;

import junit.extensions.ActiveTestSuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


@LargeTest

public class MainActivityTest {

 @Rule
    public ActivityTestRule<IntroActivity> mActivityTestRule =
         new ActivityTestRule<>(IntroActivity.class, true, false);

 @Before
    public void setUp(){
     Intent intent = new Intent();
     mActivityTestRule.launchActivity(intent);
 }

 @Test
 public void testIntroActivity() throws InterruptedException{
     onView(withId(R.id.btn_next)).perform(click());
     Thread.sleep(200L);

     onView(withId(R.id.btn_next)).perform(click());
     Thread.sleep(200L);

     onView(withId(R.id.btn_get_started)).perform(click());
     Thread.sleep(200L);


       onView(withId(R.id.show)).perform(click());
       Thread.sleep(300L);

 }

 @After

    public void finishActivity(){mActivityTestRule.finishActivity();}
}