package com.pixelhubllc.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPref = new SharedPref(this);
        if (sharedPref.loadNightModeState()==true){
            setTheme(R.style.DarkTheme);
        } else {
            setTheme(R.style.AppTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        ViewPageAdapter adapter= new ViewPageAdapter(getSupportFragmentManager());


        adapter.addFragment(new fragmentone(), "one");
        adapter.addFragment(new fragmenttwo(), "two");
        adapter.addFragment(new fragmentthree(), "three");
        adapter.addFragment(new fragmentfour(), "four");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_android_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_android_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_android_black_24dp);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_android_black_24dp);

    }
}
