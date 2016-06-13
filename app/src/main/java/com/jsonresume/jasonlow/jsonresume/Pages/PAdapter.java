package com.jsonresume.jasonlow.jsonresume.Pages;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Jason Low on 6/12/2016.
 */
public class PAdapter extends FragmentStatePagerAdapter {
    private static final int PAGES = 7;
    public PAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return new Profile();
        else if (position == 1)
            return new About();
        else if (position == 2)
            return new TechnicalSkill();
        else if (position == 3)
            return new Personality();
        else if (position == 4)
            return new Experience();
        else if(position == 5)
            return new EducationBackground();
        else
            return new Contact();
    }

    @Override
    public int getCount() {
        return PAGES;
    }
}
