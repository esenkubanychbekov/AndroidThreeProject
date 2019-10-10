package com.example.introscreen.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.introscreen.R;
import com.example.introscreen.ui.fragments.FragmentsChangeAdapter;

public class MainActivity extends AppCompatActivity {

    FragmentPagerAdapter adapter;
    ViewPager viewPager;

    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadViewPager();
    }


    public void loadViewPager(){
        viewPager = findViewById(R.id.viewPager);
        adapter = new FragmentsChangeAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }


}
