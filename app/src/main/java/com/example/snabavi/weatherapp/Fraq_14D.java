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

public class Fraq_14D extends Fragment
{
	View view;
	private Context ROOT;
	private LinearLayout FRAQ_14D;
	private ConstraintLayout.LayoutParams consLay_Params;
	private ConstraintLayout.LayoutParams Text_Params[] = new ConstraintLayout.LayoutParams[5];
	private LinearLayout.LayoutParams Linear_Params;
	private ConstraintLayout.LayoutParams Weather_img_Params[] = new ConstraintLayout.LayoutParams[2];
	private ConstraintLayout.LayoutParams Humidity_img_Params;
	private LinearLayout.LayoutParams Scroll_Params;
	private ConstraintSet constraintSet;
	private LinearLayout.LayoutParams Bar_Params;
	
	public Fraq_14D() {}
	
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
							 Bundle savedInstanceState)
	{
		view = inflater.inflate(R.layout.fraq_14d, container, false);
		
		
		ROOT = getContext();
		consLay_Params = new ConstraintLayout.LayoutParams(
				ConstraintLayout.LayoutParams.MATCH_PARENT,
				(int) (MyTools.get_Screen_Height(ROOT) * 0.15));
		
		Text_Params[0] = new ConstraintLayout.LayoutParams(
				(int) (MyTools.get_Screen_Width(ROOT)*0.15),
				ConstraintLayout.LayoutParams.WRAP_CONTENT);
		Text_Params[4] = new ConstraintLayout.LayoutParams(
				(int) (MyTools.get_Screen_Width(ROOT)*0.15),
				ConstraintLayout.LayoutParams.WRAP_CONTENT);
		Text_Params[3] = new ConstraintLayout.LayoutParams(
				(int) (MyTools.get_Screen_Width(ROOT)*0.05),
				ConstraintLayout.LayoutParams.WRAP_CONTENT);
		Text_Params[2] = new ConstraintLayout.LayoutParams(
				(int) (MyTools.get_Screen_Width(ROOT)*0.08),
				ConstraintLayout.LayoutParams.WRAP_CONTENT);
		Text_Params[1] = new ConstraintLayout.LayoutParams(
				(int) (MyTools.get_Screen_Width(ROOT)*0.05),
				ConstraintLayout.LayoutParams.WRAP_CONTENT);
		
		Linear_Params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
													  ViewGroup.LayoutParams.WRAP_CONTENT);
		
		Scroll_Params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
													  ViewGroup.LayoutParams.MATCH_PARENT);
		
		Weather_img_Params[0] = new ConstraintLayout.LayoutParams(
				(int) (MyTools.get_Screen_Width(ROOT) * 0.13),
				ConstraintLayout.LayoutParams.MATCH_PARENT);
		
		Weather_img_Params[1] = new ConstraintLayout.LayoutParams(
				(int) (MyTools.get_Screen_Width(ROOT) * 0.13),
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
		FRAQ_14D = getView().findViewById(R.id.fraq_14D2);
		create_hourly_layout(Weathers.get_weathers_list().get(0));
		super.onResume();
	}
	
	
	private void create_hourly_layout(Weather weather)
	{
		FRAQ_14D.setOrientation(LinearLayout.HORIZONTAL);
		ScrollView scrollView = new ScrollView(ROOT);
		scrollView.setLayoutParams(Scroll_Params);
		LinearLayout linearLayout = new LinearLayout(ROOT);
		linearLayout.setLayoutParams(Linear_Params);
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		linearLayout.setGravity(View.TEXT_ALIGNMENT_CENTER);
		
		
		for (int i = 0; i < 14; i++)
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
			
			
			TextView textView_day = new TextView(ROOT);
			textView_day.setId(View.generateViewId());
			textView_day.setText(MyTools.get_Day((short) i));
			constraintLayout.addView(textView_day);
			textView_day.setLayoutParams(Text_Params[0]);
			textView_day.setGravity(Gravity.LEFT);
			
			ImageView imageView_weather[] = new ImageView[2];
			imageView_weather[0] = new ImageView(ROOT);
			imageView_weather[0].setId(View.generateViewId());
			imageView_weather[0].setImageResource(MyTools.Convert_State(weather.getState_14D()[i][0]));
			constraintLayout.addView(imageView_weather[0]);
			imageView_weather[0].setLayoutParams(Weather_img_Params[0]);
			
			imageView_weather[1] = new ImageView(ROOT);
			imageView_weather[1].setId(View.generateViewId());
			imageView_weather[1].setImageResource(MyTools.Convert_State(weather.getState_14D()[i][1]));
			constraintLayout.addView(imageView_weather[1]);
			imageView_weather[1].setLayoutParams(Weather_img_Params[1]);
			
			TextView textView_temp[] = new TextView[2];
			textView_temp[0] = new TextView(ROOT);
			textView_temp[0].setId(View.generateViewId());
			textView_temp[0].setText(String.valueOf(weather.getTemp_14D()[i][0]));
			constraintLayout.addView(textView_temp[0]);
			textView_temp[0].setLayoutParams(Text_Params[1]);
			textView_temp[0].setGravity(Gravity.CENTER);
			textView_temp[0].setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
			
			textView_temp[1] = new TextView(ROOT);
			textView_temp[1].setId(View.generateViewId());
			textView_temp[1].setText(String.valueOf(weather.getTemp_14D()[i][1]));
			constraintLayout.addView(textView_temp[1]);
			textView_temp[1].setLayoutParams(Text_Params[3]);
			textView_temp[1].setGravity(Gravity.CENTER);
			textView_temp[1].setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
			
			ImageView imageView_humidity = new ImageView(ROOT);
			imageView_humidity.setId(View.generateViewId());
			imageView_humidity.setImageResource(R.mipmap.ic_humidity);
			constraintLayout.addView(imageView_humidity);
			imageView_humidity.setLayoutParams(Humidity_img_Params);
			
			TextView textView_humidity = new TextView(ROOT);
			textView_humidity.setId(View.generateViewId());
			textView_humidity.setText(MyTools.Convert_Humidity(weather.getHumidity_14D()[i]));
			constraintLayout.addView(textView_humidity);
			textView_humidity.setLayoutParams(Text_Params[2]);
			textView_humidity.setGravity(Gravity.CENTER);
			textView_humidity.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
			
			TextView textView_date = new TextView(ROOT);
			textView_date.setId(View.generateViewId());
			textView_date.setText(MyTools.get_Date((short) i));
			constraintLayout.addView(textView_date);
			textView_date.setLayoutParams(Text_Params[4]);
			textView_date.setGravity(Gravity.CENTER);
			textView_date.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
			
			
			constraintSet.clone(constraintLayout);
			
			constraintSet.connect(textView_day.getId(), ConstraintSet.BOTTOM,
								  constraintLayout.getId(), ConstraintSet.BOTTOM);
			constraintSet.connect(textView_day.getId(), ConstraintSet.TOP,
								  constraintLayout.getId(), ConstraintSet.TOP);
			constraintSet.connect(textView_day.getId(), ConstraintSet.START,
								  constraintLayout.getId(), ConstraintSet.START,
								  (int) (MyTools.get_Screen_Width(ROOT)*0.03));
			constraintSet.setVerticalBias(textView_day.getId(),(float) 0.3);
			
			constraintSet.connect(textView_date.getId(), ConstraintSet.BOTTOM,
								  constraintLayout.getId(), ConstraintSet.BOTTOM);
			constraintSet.connect(textView_date.getId(), ConstraintSet.TOP,
								  constraintLayout.getId(), ConstraintSet.TOP);
			constraintSet.connect(textView_date.getId(), ConstraintSet.END,
								  textView_day.getId(), ConstraintSet.END,
								  (int) (MyTools.get_Screen_Width(ROOT)*0.01));
			constraintSet.setVerticalBias(textView_date.getId(),(float) 0.6);
			
			constraintSet.connect(imageView_weather[0].getId(), ConstraintSet.START,
								  constraintLayout.getId(), ConstraintSet.START);
			constraintSet.connect(imageView_weather[0].getId(), ConstraintSet.END,
								  constraintLayout.getId(), ConstraintSet.END ,
								  (int) (MyTools.get_Screen_Width(ROOT)*0.08));
			constraintSet.connect(imageView_weather[0].getId(), ConstraintSet.TOP,
								  constraintLayout.getId(), ConstraintSet.TOP);
			constraintSet.connect(imageView_weather[0].getId(), ConstraintSet.BOTTOM,
								  constraintLayout.getId(), ConstraintSet.BOTTOM);
			constraintSet.setHorizontalBias(imageView_weather[0].getId(), (float) 0.35);
			
			constraintSet.connect(textView_temp[0].getId(), ConstraintSet.TOP,
								  constraintLayout.getId(), ConstraintSet.TOP);
			constraintSet.connect(textView_temp[0].getId(), ConstraintSet.BOTTOM,
								  constraintLayout.getId(), ConstraintSet.BOTTOM);
			constraintSet.connect(textView_temp[0].getId(), ConstraintSet.START,
								  imageView_weather[0].getId(), ConstraintSet.END,
								  (int) (MyTools.get_Screen_Width(ROOT) * 0.02));
			
			constraintSet.connect(imageView_weather[1].getId(), ConstraintSet.START,
								  constraintLayout.getId(), ConstraintSet.START);
			constraintSet.connect(imageView_weather[1].getId(), ConstraintSet.END,
								  constraintLayout.getId(), ConstraintSet.END ,
								  (int) (MyTools.get_Screen_Width(ROOT)*0.08));
			constraintSet.connect(imageView_weather[1].getId(), ConstraintSet.TOP,
								  constraintLayout.getId(), ConstraintSet.TOP);
			constraintSet.connect(imageView_weather[1].getId(), ConstraintSet.BOTTOM,
								  constraintLayout.getId(), ConstraintSet.BOTTOM);
			constraintSet.setHorizontalBias(imageView_weather[1].getId(), (float) 0.65);
			
			constraintSet.connect(textView_temp[1].getId(), ConstraintSet.TOP,
								  constraintLayout.getId(), ConstraintSet.TOP);
			constraintSet.connect(textView_temp[1].getId(), ConstraintSet.BOTTOM,
								  constraintLayout.getId(), ConstraintSet.BOTTOM);
			constraintSet.connect(textView_temp[1].getId(), ConstraintSet.START,
								  imageView_weather[1].getId(), ConstraintSet.END,
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
		FRAQ_14D.addView(scrollView);
	}
}
