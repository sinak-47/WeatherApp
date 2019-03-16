package com.example.snabavi.weatherapp;

import android.content.Context;
import android.provider.DocumentsContract;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity
{
	
	private TabLayout tabLayout;
	private ViewPager viewPager;
	private AppBarLayout appBarLayout;
	public Context ROOT = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Weathers.add_weather(new Weather("Tehran"));
		
		viewPager = (ViewPager) findViewById(R.id.view_pager);
		tabLayout = (TabLayout) findViewById(R.id.tab_changer);
		appBarLayout = (AppBarLayout) findViewById(R.id.top_bar);
		ConstraintLayout constraintLayout = findViewById(R.id.main_layout);
		TextView textView = findViewById(R.id.textView);
		textView.bringToFront();
		
		ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
		adapter.AddFragment(new Fraq_24H(), "24 HOURS");
		adapter.AddFragment(new Fraq_Hourly(), "HOURLY");
		adapter.AddFragment(new Fraq_14D(), "14 DAYS");
		
		viewPager.setAdapter(adapter);
		tabLayout.setupWithViewPager(viewPager);
		
		switch (Weathers.get_weathers_list().get(0).getTime()[0])
		{
			case 0:
				constraintLayout.setBackgroundResource(R.drawable.sun);
				break;
			case 1:
				constraintLayout.setBackgroundResource(R.drawable.snow);
				break;
			case 2:
				constraintLayout.setBackgroundResource(R.drawable.rain);
				break;
			case 3:
				constraintLayout.setBackgroundResource(R.drawable.cloud);
				break;
		}
		
		
	}
}
