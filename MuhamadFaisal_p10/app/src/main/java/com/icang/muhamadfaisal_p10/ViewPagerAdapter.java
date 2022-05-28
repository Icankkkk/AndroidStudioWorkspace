package com.icang.muhamadfaisal_p10;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
       switch (position) {
           case 0:
               return new ProgramFragment();
           case 1:
               return new BiodataFragment();
       }
       return null;
    }

    @Override
    public int getCount() { return 2; }

    @Override
    public CharSequence getPageTitle(int position)
    {
        switch (position) {
            case 0:
                return "Program";
            case 1:
                return "Biodata";
        }
        return super.getPageTitle(position);
    }
}
