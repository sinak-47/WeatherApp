package com.example.snabavi.weatherapp;

import java.util.ArrayList;

public class Weathers
{
	private static Weathers ourInstance = new Weathers();
	
	public static ArrayList<Weather> get_weathers_list()
	{
		return list;
	}
	
	public static void add_weather(Weather weather)
	{
		list.add(weather);
	}
	
	public static boolean remove_weather(Weather weather)
	{
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) == weather)
			{
				list.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public static boolean remove_weather(String weather)
	{
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i).getCity().equals(weather))
			{
				list.remove(i);
				return true;
			}
		}
		return false;
	}
	
	
	private Weathers() {}
	
	private static ArrayList<Weather> list = new ArrayList();
}
