package com.example.android.soundtrack;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Window;



public class MainActivity extends FragmentActivity {

    private int[] tabIcons = {
            R.drawable.note,
            R.drawable.favorite
    };

    TabLayout tabLayout;
    ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Set color for StatusBar

        Window window = this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.toolbar));


        // Find the view pager that will allow the user to swipe between fragments
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        //PagerAdapter adapter = new PagerAdapter(MainActivity.this, getSupportFragmentManager());
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager(),
                MainActivity.this));



        // Find the tab layout that shows the tabs
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);

        /** Connect the tab layout with the view pager. This will
         * 1. Update the tab layout when the view pager is swiped
         * 2. Update the view pager when a tab is selected
         * 3. Set the tab layout's tab names with the view pager's adapter's titles
              by calling onPageTitle()**/

        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#BDBDBD"), PorterDuff.Mode.SRC_IN);
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);


        // Set colors for the icons

        tabLayout.getTabAt(0).getIcon().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(1).getIcon().setColorFilter(Color.parseColor("#BDBDBD"), PorterDuff.Mode.SRC_IN);
    }

}