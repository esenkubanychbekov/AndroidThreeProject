package com.example.introscreen.ui.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.introscreen.ui.fragments.MapFragment;
import com.example.introscreen.ui.fragments.WeatherFragment;

public class FragmentsChangeAdapter extends FragmentPagerAdapter {

    public FragmentsChangeAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new WeatherFragment();
            case 1:
                return new MapFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }



    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }

}
