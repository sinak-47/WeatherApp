package com.example.snabavi.weatherapp;

import android.content.Context;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class Fraq_Hourly extends Fragment
{
	View view;
	private Context ROOT;
	private LinearLayout FRAQ_HOURLY;
	private ConstraintLayout.LayoutParams consLay_Params;
	private ConstraintLayout.LayoutParams Text_Params;
	private LinearLayout.LayoutParams Linear_Params;
	private ConstraintLayout.LayoutParams Weather_img_Params;
	private ConstraintLayout.LayoutParams Humidity_img_Params;
	private LinearLayout.LayoutParams Scroll_Params;
	private ConstraintSet constraintSet;
	private TextView textView_time;
	private LinearLayout.LayoutParams Bar_Params;
	
	
	public Fraq_Hourly() {}
	
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
							 Bundle savedInstanceState)
	{
		ROOT = getContext();
		consLay_Params = new ConstraintLayout.LayoutParams(
				ConstraintLayout.LayoutParams.MATCH_PARENT,
				(int) (MyTools.get_Screen_Width(ROOT) * 0.15));
		
		Text_Params = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT,
														ConstraintLayout.LayoutParams.MATCH_PARENT);
		
		Linear_Params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
													  ViewGroup.LayoutParams.WRAP_CONTENT);
		
		Scroll_Params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
													  ViewGroup.LayoutParams.MATCH_PARENT);
		
		Weather_img_Params = new ConstraintLayout.LayoutParams(
				(int) (MyTools.get_Screen_Width(ROOT) * 0.15),
				ConstraintLayout.LayoutParams.MATCH_PARENT);
		
		Humidity_img_Params = new ConstraintLayout.LayoutParams(
				(int) (MyTools.get_Screen_Width(ROOT) * 0.1),
				ConstraintLayout.LayoutParams.MATCH_PARENT);
		
		Bar_Params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,3);
		
		
		
		view = inflater.inflate(R.layout.fraq_hourly, container, false);
		return view;
	}
	
	@Override
	public void onResume()
	{
		FRAQ_HOURLY = getView().findViewById(R.id.fraq_hourly2);
		create_hourly_layout();
		super.onResume();
	}
	
	
	private void create_hourly_layout()
	{
		FRAQ_HOURLY.setOrientation(LinearLayout.HORIZONTAL);
		ScrollView scrollView = new ScrollView(ROOT);
		scrollView.setLayoutParams(Scroll_Params);
		LinearLayout linearLayout = new LinearLayout(ROOT);
		linearLayout.setLayoutParams(Linear_Params);
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		linearLayout.setGravity(View.TEXT_ALIGNMENT_CENTER);
		
		
		for (int i = 0; i < 23; i++)
		{
			View bar = new View(ROOT);
			bar.setBackgroundColor(Color.parseColor("#64000000"));
			bar.setVisibility(View.VISIBLE);
			bar.setLayoutParams(Bar_Params);
			linearLayout.addView(bar);
			
			
			ConstraintLayout constraintLayout = new ConstraintLayout(ROOT);
			constraintLayout.setLayoutParams(consLay_Params);
			constraintLayout.setId(View.generateViewId());
			constraintSet = new ConstraintSet();
			constraintLayout.setBackgroundColor(Color.parseColor("#64797979"));
			textView_time = new TextView(ROOT);
			textView_time.setId(View.generateViewId());
			TextView textView_temp = new TextView(ROOT);
			TextView textView_humidity = new TextView(ROOT);
			ImageView imageView_weather = new ImageView(ROOT);
			ImageView imageView_humidity = new ImageView(ROOT);

//			constraintLayout.addView(imageView_weather);
//			constraintLayout.addView(textView_temp);
//			constraintLayout.addView(imageView_humidity);
//			constraintLayout.addView(textView_humidity);
			
			
			textView_time.setText("this is test");
			textView_time.setLayoutParams(Text_Params);
			constraintLayout.addView(textView_time);
			textView_time.setGravity(Gravity.CENTER);
			textView_time.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
			constraintSet.clone(constraintLayout);
			constraintSet.connect(textView_time.getId(), ConstraintSet.BOTTOM,
								  constraintLayout.getId(), ConstraintSet.BOTTOM);
			constraintSet.connect(textView_time.getId(), ConstraintSet.TOP,
								  constraintLayout.getId(), ConstraintSet.TOP);
			constraintSet.connect(textView_time.getId(), ConstraintSet.START,
								  constraintLayout.getId(), ConstraintSet.START);
			constraintSet.setVerticalBias(textView_time.getId(), (float) 0.5);
			constraintSet.setHorizontalBias(textView_time.getId(), (float) 0.5);


//			imageView_weather.setLayoutParams(Weather_img_Params);
//
//			textView_temp.setLayoutParams(Text_Params);
//			textView_temp.setGravity(View.TEXT_ALIGNMENT_CENTER);
//
//			imageView_humidity.setLayoutParams(Humidity_img_Params);
//
//			textView_humidity.setLayoutParams(Text_Params);
//			textView_humidity.setGravity(View.TEXT_ALIGNMENT_CENTER);
			
			
			constraintSet.applyTo(constraintLayout);
			linearLayout.addView(constraintLayout);
		}
		
		View bar = new View(ROOT);
		bar.setBackgroundColor(Color.parseColor("#64000000"));
		bar.setVisibility(View.VISIBLE);
		bar.setLayoutParams(Bar_Params);
		linearLayout.addView(bar);
		
		scrollView.addView(linearLayout);
		FRAQ_HOURLY.addView(scrollView);
	}
}
