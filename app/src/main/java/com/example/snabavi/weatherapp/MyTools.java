package com.example.snabavi.weatherapp;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class MyTools
{
	
	
	private static short day[] = new short[14];//0= Saturday 6= Friday
	private static short date[] = new short[14];
	private final static short month = Short.valueOf(
			new SimpleDateFormat("MM").format(Calendar.getInstance().getTime()));
	
	private static void update_date()
	{
		short tmp = month;
		date[0] = Short.valueOf(
				new SimpleDateFormat("dd").format(Calendar.getInstance().getTime()));
		for (int i = 1; i < 14; i++)
		{
			date[i] = (short) (date[i - 1] + 1);
			if (tmp < 7)
			{
				if (date[i] > 31)
				{
					date[i] = 1;
					tmp++;
				}
			}
			else if (tmp < 12)
			{
				if (date[i] > 30)
				{
					date[i] = 1;
					tmp++;
				}
			}
			else
			{
				if (date[i] > 29)
				{
					date[i] = 1;
					tmp = 1;
				}
			}
		}
	}
	
	private static void update_day()
	{
		String Day = new SimpleDateFormat("EEEE").format(Calendar.getInstance().getTime());
		switch (Day)
		{
			case "Saturday":
				day[0] = 0;
				break;
			case "Sunday":
				day[0] = 1;
				break;
			case "Monday":
				day[0] = 2;
				break;
			case "Tuesday":
				day[0] = 3;
				break;
			case "Wednesday":
				day[0] = 4;
				break;
			case "Thursday":
				day[0] = 5;
				break;
			case "Friday":
				day[0] = 6;
				break;
		}
		
		for (int i = 1; i < 14; i++)
		{
			day[i] = (short) (day[i - 1] + 1);
			if (day[i] == 7)
			{
				day[i] = 0;
			}
		}
	}
	
	private static String Convert_Day(short day)
	{
		switch (day)
		{
			case 0:
				return "Saturday ";
			case 1:
				return "Sunday ";
			case 2:
				return "Monday ";
			case 3:
				return "Tuesday ";
			case 4:
				return "Wednesday ";
			case 5:
				return "Thursday ";
			case 6:
				return "  Friday ";
			default:
				return null;
		}
	}
	
	
	public static String get_Date(short index)
	{
		if (date[0] != Short.valueOf(
				new SimpleDateFormat("dd").format(Calendar.getInstance().getTime())))
		{
			update_date();
		}
		
		if (index > 0 && date[index] < date[index - 1])
		{
			return String.valueOf(month + 1) + "/" + String.valueOf(date[index]);
		}
		else
		{
			return String.valueOf(month) + "/" + String.valueOf(date[index]);
		}
	}
	
	public static String get_Day(short index)
	{
		if (Convert_Day(day[0]) != new SimpleDateFormat("EEEE").format(
				Calendar.getInstance().getTime()))
		{
			update_day();
		}
		return Convert_Day(day[index]);
	}
	
	public static int get_Screen_Width(Context context)
	{
		DisplayMetrics displayMetrics = new DisplayMetrics();
		((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		return displayMetrics.widthPixels;
	}
	
	public static int get_Screen_Height(Context context)
	{
		DisplayMetrics displayMetrics = new DisplayMetrics();
		((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		return displayMetrics.heightPixels;
	}
	
	public static String Convert_Hour(short hour)
	{
		if (hour < 12)
		{
			return String.valueOf(hour) + " AM  ";
		}
		else if (hour == 12)
		{
			return "12 PM  ";
		}
		else if (hour == 24)
		{
			return "12 AM  ";
		}
		else
		{
			return String.valueOf(hour - 12) + " PM  ";
		}
	}
	
	public static int Convert_State(short state)
	{
		switch (state)
		{
			case 0:
				return R.mipmap.ic_sunny;
			case 1:
				return R.mipmap.ic_rainy;
			case 2:
				return R.mipmap.ic_snowy;
			case 3:
				return R.mipmap.ic_cloudy;
			default:
				return R.mipmap.ic_sunny;
		}
	}
	
	public static String Convert_Humidity(short humidity)
	{
		return String.valueOf(humidity) + " %";
	}
	
	public static String Convert_Time(short time)
	{
		switch (time)
		{
			case 0:
				return "Morning";
			case 1:
				return "Afternoon";
			case 2:
				return "Evening";
			case 3:
				return "Night";
			default:
				return null;
		}
	}
}
