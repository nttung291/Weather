package com.example.nttungpc.weather.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.nttungpc.weather.fragments.Day1Fragment;

/**
 * Created by Nttung PC on 10/19/2017.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Day1Fragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 1;
    }
}
