package com.example.snabavi.weatherapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

public final class MyTools
{
	public static int get_Screen_Width(Context context)
	{
		DisplayMetrics displayMetrics = new DisplayMetrics();
		((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		return displayMetrics.widthPixels;
	}
	
	public static int get_Screen_Height(Context context)
	{
		DisplayMetrics displayMetrics = new DisplayMetrics();
		((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		return displayMetrics.heightPixels;
	}
}
