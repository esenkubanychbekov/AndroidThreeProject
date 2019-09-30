package com.example.introscreen;

import android.app.Application;

import com.example.introscreen.utils.ISharedStorage;
import com.example.introscreen.utils.SharedStorage;

public class App extends Application {

    public static ISharedStorage sharedStorage;
    public static  AppPreferences appPreferences;

    @Override
    public void onCreate() {
        super.onCreate();

        sharedStorage = new SharedStorage(this, "prefs");
        appPreferences = new AppPreferences(sharedStorage);
    }
}
