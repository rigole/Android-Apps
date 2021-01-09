package com.example.weather_app.data;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class ForecastViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment>fragments;
    public ForecastViewPagerAdapter(@NonNull FragmentManager fm, int behavior, List<Fragment>fragments) {
        super(fm, behavior);
        this.fragments=fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }
}
