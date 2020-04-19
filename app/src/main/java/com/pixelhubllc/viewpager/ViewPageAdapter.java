package com.pixelhubllc.viewpager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPageAdapter extends FragmentPagerAdapter {


    public ViewPageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> fragmentListTitle = new ArrayList<String>();

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentListTitle.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return (CharSequence) fragmentListTitle.get(position);
    }

    public void addFragment(Fragment fragment, String title){
        mFragmentList.add(fragment);
        fragmentListTitle.add(title);
    }
}
