package com.example.introscreen;

import com.example.introscreen.utils.ISharedStorage;

public class AppPreferences {

    private static final String IS_FIRST_LAUNCH = "is_first_launch";
    private ISharedStorage sharedStorage;

    public AppPreferences(ISharedStorage sharedStorage){
        this.sharedStorage = sharedStorage;
    }

   boolean isFirstLaunch(){
        return sharedStorage.getBoolean(IS_FIRST_LAUNCH, true);
    }

    void setLaunched(){
        sharedStorage.setBoolean(IS_FIRST_LAUNCH, false);
    }
}
