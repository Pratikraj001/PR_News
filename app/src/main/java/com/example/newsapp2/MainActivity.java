package com.example.newsapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mhome, mscience, mhealth, mtech, menterinment, msports;
    PagerAdapter pagerAdapter;
    Toolbar mtoolbar;

    String api = "1085ce43b96a424fb1881fca538b8440";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);

        mhome = findViewById(R.id.home);
        msports = findViewById(R.id.sports);
        mscience = findViewById(R.id.science);
        mhealth = findViewById(R.id.health);
        menterinment = findViewById(R.id.entertainment);
        mtech = findViewById(R.id.technology);

        ViewPager viewPager = findViewById(R.id.fragmentcontainer);
        tabLayout = findViewById(R.id.included);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 6);
        viewPager.setAdapter(pagerAdapter);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2 ||
                        tab.getPosition() == 3 || tab.getPosition() == 4 || tab.getPosition() == 5){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));



    }
}