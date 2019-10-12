package com.example.introscreen;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.introscreen.utils.ISharedStorage;
import com.example.introscreen.utils.SharedStorage;

public class App extends Application {

    public static ISharedStorage sharedStorage;
    public static  AppPreferences appPreferences;
    public static final String CHANEL_1 = "chanel1";

    @Override
    public void onCreate() {
        super.onCreate();

        sharedStorage = new SharedStorage(this, "prefs");
        appPreferences = new AppPreferences(sharedStorage);
        createNotoficationChanels();

    }


    public void createNotoficationChanels(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel1 = new NotificationChannel(
                    CHANEL_1,
                    "Chanel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );

            channel1.setDescription("This is Chanel 1");
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
        }

    }
}
