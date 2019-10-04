package com.example.introscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    private ViewPager screenPager;
    IntroPagerAdapter adapter;
    TabLayout tabIndicator;
    Button next, getStart;
    int position = 0;
    TextView skip;

    public static void start(Context context) {
        Intent intent = new Intent(context, IntroActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_intro);
        getSupportActionBar().hide();
        redirect();

    }

    public void redirect(){

        screenPager = findViewById(R.id.screen_viewPager);
        tabIndicator = findViewById(R.id.tabLayout);
        next = findViewById(R.id.btn_next);
        getStart = findViewById(R.id.btn_get_started);
        skip = findViewById(R.id.tv_skip);

        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("IronMan","Iron Man is a fictional superhero appearing in American comic books published by Marvel Comics. ",
                R.drawable.ironman));
        mList.add(new ScreenItem("Thanos","Thanos is a fictional supervillain appearing in American comic books published by Marvel Comics. " +
                "The character, created by writer/artist Jim Starlin",R.drawable.thanos));
        mList.add(new ScreenItem("Deadpool","Deadpool is a 2016 American superhero film based on the Marvel Comics character of the same name. " +
                "Distributed by 20th Century Fox",R.drawable.deadpool));


        adapter = new IntroPagerAdapter(this, mList);
        screenPager.setAdapter(adapter);
        tabIndicator.setupWithViewPager(screenPager);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                position = screenPager.getCurrentItem();
                if (position < mList.size()){
                    position ++;
                    screenPager.setCurrentItem(position);
                }

                if (position == mList.size()-1){
                    loadLastScreen();
                }

            }
        });

        getStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void loadLastScreen(){
      next.setVisibility(View.INVISIBLE);
      getStart.setVisibility(View.VISIBLE);
      tabIndicator.setVisibility(View.INVISIBLE);
    }
}
