package com.example.snabavi.weatherapp;

import android.content.Intent;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Weather
{
	
	public Weather(String City_Name)
	{
		City = City_Name;
		
		for (int i = 0; i < 24; i++)
		{
			temp_hourly[i] = (short) (i * 2);
			humidity_hourly[i] = (short) (i * 4);
			state_hourly[i] = (short) (i % 4);
		}
		
		update_hour();
		update_time();
	}
	
	private final String City;
	
	private short temp_24H[] = new short[4];
	private short state_24H[] = new short[4];//1= Sunny 2= Rainy 3= Snowy 4= Cloudy
	private short humidity_24H[] = new short[4];
	
	private short temp_hourly[] = new short[24];
	private short state_hourly[] = new short[24];
	private short humidity_hourly[] = new short[24];
	
	private short temp_14D[][] = new short[14][2];
	private short state_14D[][] = new short[14][2];
	private short humidity_14D[] = new short[14];
	
	private static short time[] = new short[4];//0= Morning 1= Afternoon 2= Evening 3= Night
	private static short hour[] = new short[24];
	
	private void update_hour()
	{
		hour[0] = Short.valueOf(
				new SimpleDateFormat("HH").format(Calendar.getInstance().getTime()));
		for (int i = 1; i < 24; i++)
		{
			hour[i] = (short) (hour[i - 1] + 1);
			if (hour[i] > 24)
			{
				hour[i] -= 24;
			}
		}
	}
	
	private void update_time()
	{
		time[0] = (Short.valueOf(
				new SimpleDateFormat("HH").format(Calendar.getInstance().getTime())));
		if (time[0] < 6)
		{
			time[0] = 0;
		}
		else if (time[0] < 12)
		{
			time[0] = 1;
		}
		else if (time[0] < 18)
		{
			time[0] = 2;
		}
		else
		{
			time[0] = 3;
		}
		
		
		for (int i = 1; i < 3; i++)
		{
			time[i] = (short) (time[i - 1] + 1);
			if (time[i] == 4)
			{
				time[i] = 0;
			}
		}
	}
	
	public short[] getHour()
	{
		if (hour[0] != Short.valueOf(
				new SimpleDateFormat("HH").format(Calendar.getInstance().getTime())))
		{
			update_hour();
		}
		
		return hour;
	}
	
	public short[] getTime()
	{
		if (time[0] != (short) (Short.valueOf(
				new SimpleDateFormat("HH").format(Calendar.getInstance().getTime())) % 4))
		{
			update_time();
		}
		return time;
	}
	
	public String getCity()
	{
		return City;
	}
	
	public short[] getTemp_24H()
	{
		return temp_24H;
	}
	
	public short[] getState_24H()
	{
		return state_24H;
	}
	
	public short[] getHumidity_24H()
	{
		return humidity_24H;
	}
	
	public short[] getTemp_hourly()
	{
		return temp_hourly;
	}
	
	public short[] getState_hourly()
	{
		return state_hourly;
	}
	
	public short[] getHumidity_hourly()
	{
		return humidity_hourly;
	}
	
	public short[][] getTemp_14D()
	{
		return temp_14D;
	}
	
	public short[][] getState_14D()
	{
		return state_14D;
	}
	
	public short[] getHumidity_14D()
	{
		return humidity_14D;
	}
	
}
