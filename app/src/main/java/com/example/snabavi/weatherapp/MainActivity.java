package com.example.snabavi.weatherapp;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{
	
	private TabLayout tabLayout;
	private ViewPager viewPager;
	private AppBarLayout appBarLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		viewPager = (ViewPager) findViewById(R.id.view_pager);
		tabLayout = (TabLayout) findViewById(R.id.tab_changer);
		appBarLayout =(AppBarLayout) findViewById(R.id.top_bar);
		
		ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
		adapter.AddFragment(new Fraq_14D(),"14 DAYS");
		adapter.AddFragment(new Fraq_Hourly(),"HOURLY");
		adapter.AddFragment(new Fraq_24H(), "24 HOURS");
		
		viewPager.setAdapter(adapter);
		tabLayout.setupWithViewPager(viewPager);
	}
}
