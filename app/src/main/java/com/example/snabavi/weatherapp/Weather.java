package com.example.snabavi.weatherapp;

public class Weather
{
	String name;
	int temp_24H[] = new int[4];
	int state_24H[] = new int[4];
	int rain_24H[] = new int[4];
	
	int temp_hourly[] = new int[24];
	int state_hourly[] = new int[24];
	int rain_hourly[] = new int[24];
	
	int temp_14D[][] = new int[14][2];
	int state_14D[] = new int[14];
	int rain_14D[] = new int[14];
}
