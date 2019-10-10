package com.example.introscreen;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.introscreen.ui.intro.IntroActivity;
import com.example.introscreen.ui.main.MainActivity;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        redirect();
    }

    private void redirect(){
        if (App.appPreferences.isFirstLaunch()) {
            App.appPreferences.setLaunched();
            IntroActivity.start(this);
        } else {
            MainActivity.start(this);
        }
        finish();
    }
}
