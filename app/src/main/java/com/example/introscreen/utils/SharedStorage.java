package com.example.introscreen.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedStorage implements ISharedStorage {

    SharedPreferences preferences;

    public SharedStorage(Context context, String prefsName) {
        preferences = context.getSharedPreferences(prefsName, Context.MODE_PRIVATE);
    }

    @Override
    public void setBoolean(String key, boolean value) {
        preferences.edit().putBoolean(key, value).apply();
    }

    @Override
    public boolean getBoolean(String key, boolean defValue) {
        return preferences.getBoolean(key, defValue);
    }
}
