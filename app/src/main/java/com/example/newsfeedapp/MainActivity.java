package com.example.newsfeedapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TabItem home,sports,health,entertainment,science,technology;
    PagerAdapter pagerAdapter;
    Toolbar toolbar;

    ImageView app_icon_image;

    LinearLayout linearLayout;
    String apiKey="3dcbb1ef2d8c4d5b945fedf5d7997ae6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.purple));

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        home=findViewById(R.id.home);
        sports=findViewById(R.id.sports);
        health=findViewById(R.id.health);
        science=findViewById(R.id.science);
        technology=findViewById(R.id.technology);
        entertainment=findViewById(R.id.entertainment);
        app_icon_image=findViewById(R.id.app_icon_image);
        linearLayout=findViewById(R.id.linear_layout);



        linearLayout.animate().alpha(0f).setDuration(1);

        TranslateAnimation animation=new TranslateAnimation(0,0,0,0);
        animation.setDuration(2000);
        animation.setFillAfter(false);
        animation.setAnimationListener(new MyAnimationListener());

        app_icon_image.setAnimation(animation);




        ViewPager viewPager=findViewById(R.id.fragmentContainer);
        tabLayout=findViewById(R.id.tabLayout);

        pagerAdapter=new PagerAdapter(getSupportFragmentManager(),6);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0 || tab.getPosition()==1 || tab.getPosition()==2 || tab.getPosition()==3 ||
                tab.getPosition()==4 ||tab.getPosition()==5 ){
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

    private class MyAnimationListener implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            app_icon_image.clearAnimation();
            app_icon_image.setVisibility(View.INVISIBLE);
            linearLayout.animate().alpha(1f).setDuration(1000);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}