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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class Fraq_24H extends Fragment
{
	View view;
	private Context ROOT;
	private LinearLayout FRAQ_24H;
	private ConstraintLayout.LayoutParams consLay_Params;
	private ConstraintLayout.LayoutParams Text_Params[] = new ConstraintLayout.LayoutParams[3];
	private LinearLayout.LayoutParams Linear_Params;
	private ConstraintLayout.LayoutParams Weather_img_Params;
	private ConstraintLayout.LayoutParams Humidity_img_Params;
	private LinearLayout.LayoutParams Scroll_Params;
	private ConstraintSet constraintSet;
	private LinearLayout.LayoutParams Bar_Params;
	
	public Fraq_24H(){}
	
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
							 Bundle savedInstanceState)
	{
		view = inflater.inflate(R.layout.fraq_24h,container,false);
		
		ROOT = getContext();
		consLay_Params = new ConstraintLayout.LayoutParams(
				ConstraintLayout.LayoutParams.MATCH_PARENT,
				(int) (MyTools.get_Screen_Height(ROOT) * 0.185));
		
		Text_Params[0] = new ConstraintLayout.LayoutParams(
				(int) (MyTools.get_Screen_Width(ROOT)*0.15),
				ConstraintLayout.LayoutParams.MATCH_PARENT);
		
		Text_Params[1] = new ConstraintLayout.LayoutParams(
				(int) (MyTools.get_Screen_Width(ROOT)*0.05),
				ConstraintLayout.LayoutParams.MATCH_PARENT);
		
		Text_Params[2] = new ConstraintLayout.LayoutParams(
				(int) (MyTools.get_Screen_Width(ROOT)*0.08),
				ConstraintLayout.LayoutParams.MATCH_PARENT);
		
		Linear_Params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
													  ViewGroup.LayoutParams.WRAP_CONTENT);
		
		Scroll_Params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
													  ViewGroup.LayoutParams.MATCH_PARENT);
		
		Weather_img_Params = new ConstraintLayout.LayoutParams(
				(int) (MyTools.get_Screen_Width(ROOT) * 0.15),
				ConstraintLayout.LayoutParams.MATCH_PARENT);
		
		Humidity_img_Params = new ConstraintLayout.LayoutParams(
				(int) (MyTools.get_Screen_Width(ROOT) * 0.07),
				ConstraintLayout.LayoutParams.MATCH_PARENT);
		
		Bar_Params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 3);
		
		return view;
	}
	
	
	@Override
	public void onResume()
	{
		FRAQ_24H = getView().findViewById(R.id.fraq_24H2);
		create_hourly_layout(Weathers.get_weathers_list().get(0));
		super.onResume();
	}
	
	
	
	private void create_hourly_layout(Weather weather)
	{
		FRAQ_24H.setOrientation(LinearLayout.HORIZONTAL);
		ScrollView scrollView = new ScrollView(ROOT);
		scrollView.setLayoutParams(Scroll_Params);
		LinearLayout linearLayout = new LinearLayout(ROOT);
		linearLayout.setLayoutParams(Linear_Params);
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		linearLayout.setGravity(View.TEXT_ALIGNMENT_CENTER);
		
		
		for (int i = 0; i < 4; i++)
		{
			View bar = new View(ROOT);
			bar.setBackgroundColor(Color.parseColor("#96000000"));
			bar.setVisibility(View.VISIBLE);
			bar.setLayoutParams(Bar_Params);
			linearLayout.addView(bar);
			
			ConstraintLayout constraintLayout = new ConstraintLayout(ROOT);
			constraintLayout.setLayoutParams(consLay_Params);
			constraintLayout.setId(View.generateViewId());
			constraintSet = new ConstraintSet();
			constraintLayout.setBackgroundColor(Color.parseColor("#96797979"));
			
			
			TextView textView_time = new TextView(ROOT);
			textView_time.setId(View.generateViewId());
			textView_time.setText(MyTools.Convert_Time(weather.getTime()[i]));
			constraintLayout.addView(textView_time);
			textView_time.setLayoutParams(Text_Params[0]);
			textView_time.setGravity(Gravity.CENTER);
			textView_time.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
			
			ImageView imageView_weather = new ImageView(ROOT);
			imageView_weather.setId(View.generateViewId());
			imageView_weather.setImageResource(MyTools.Convert_State(weather.getState_24H()[i]));
			constraintLayout.addView(imageView_weather);
			imageView_weather.setLayoutParams(Weather_img_Params);
			
			TextView textView_temp = new TextView(ROOT);
			textView_temp.setId(View.generateViewId());
			textView_temp.setText(String.valueOf(weather.getTemp_24H()[i]));
			constraintLayout.addView(textView_temp);
			textView_temp.setLayoutParams(Text_Params[1]);
			textView_temp.setGravity(Gravity.CENTER);
			textView_temp.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
			
			ImageView imageView_humidity = new ImageView(ROOT);
			imageView_humidity.setId(View.generateViewId());
			imageView_humidity.setImageResource(R.mipmap.ic_humidity);
			constraintLayout.addView(imageView_humidity);
			imageView_humidity.setLayoutParams(Humidity_img_Params);
			
			TextView textView_humidity = new TextView(ROOT);
			textView_humidity.setId(View.generateViewId());
			textView_humidity.setText(MyTools.Convert_Humidity(weather.getHumidity_24H()[i]));
			constraintLayout.addView(textView_humidity);
			textView_humidity.setLayoutParams(Text_Params[2]);
			textView_humidity.setGravity(Gravity.CENTER);
			textView_humidity.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
			
			
			constraintSet.clone(constraintLayout);
			
			constraintSet.connect(textView_time.getId(), ConstraintSet.BOTTOM,
								  constraintLayout.getId(), ConstraintSet.BOTTOM);
			constraintSet.connect(textView_time.getId(), ConstraintSet.TOP,
								  constraintLayout.getId(), ConstraintSet.TOP);
			constraintSet.connect(textView_time.getId(), ConstraintSet.START,
								  constraintLayout.getId(), ConstraintSet.START,
								  (int) (MyTools.get_Screen_Width(ROOT)*0.03));
			
			constraintSet.connect(imageView_weather.getId(), ConstraintSet.START,
								  constraintLayout.getId(), ConstraintSet.START);
			constraintSet.connect(imageView_weather.getId(), ConstraintSet.END,
								  constraintLayout.getId(), ConstraintSet.END ,
								  (int) (MyTools.get_Screen_Width(ROOT)*0.08));
			constraintSet.connect(imageView_weather.getId(), ConstraintSet.TOP,
								  constraintLayout.getId(), ConstraintSet.TOP);
			constraintSet.connect(imageView_weather.getId(), ConstraintSet.BOTTOM,
								  constraintLayout.getId(), ConstraintSet.BOTTOM);
			
			constraintSet.connect(textView_temp.getId(), ConstraintSet.TOP,
								  constraintLayout.getId(), ConstraintSet.TOP);
			constraintSet.connect(textView_temp.getId(), ConstraintSet.BOTTOM,
								  constraintLayout.getId(), ConstraintSet.BOTTOM);
			constraintSet.connect(textView_temp.getId(), ConstraintSet.START,
								  imageView_weather.getId(), ConstraintSet.END,
								  (int) (MyTools.get_Screen_Width(ROOT) * 0.02));
			
			constraintSet.connect(textView_humidity.getId(), ConstraintSet.BOTTOM,
								  constraintLayout.getId(), ConstraintSet.BOTTOM);
			constraintSet.connect(textView_humidity.getId(), ConstraintSet.TOP,
								  constraintLayout.getId(), ConstraintSet.TOP);
			constraintSet.connect(textView_humidity.getId(), ConstraintSet.END,
								  constraintLayout.getId(), ConstraintSet.END,
								  (int) (MyTools.get_Screen_Width(ROOT)*0.03));
			
			constraintSet.connect(imageView_humidity.getId(), ConstraintSet.BOTTOM,
								  constraintLayout.getId(), ConstraintSet.BOTTOM);
			constraintSet.connect(imageView_humidity.getId(), ConstraintSet.TOP,
								  constraintLayout.getId(), ConstraintSet.TOP);
			constraintSet.connect(imageView_humidity.getId(), ConstraintSet.END,
								  textView_humidity.getId(), ConstraintSet.START,
								  (int) (MyTools.get_Screen_Width(ROOT)*0.02));
			
			
			constraintSet.applyTo(constraintLayout);
			linearLayout.addView(constraintLayout);
		}
		
		View bar = new View(ROOT);
		bar.setBackgroundColor(Color.parseColor("#64000000"));
		bar.setVisibility(View.VISIBLE);
		bar.setLayoutParams(Bar_Params);
		linearLayout.addView(bar);
		
		scrollView.addView(linearLayout);
		FRAQ_24H.addView(scrollView);
	}
}
