package com.example.snabavi.weatherapp;

import java.util.ArrayList;
import java.util.List;

public class FakeData
{

	public static List<Weather> getData(){

		List<Weather> strings = new ArrayList<>();
		Weather weather = new Weather("Tehran");

		strings.add(weather);

		return strings;

	}

}
