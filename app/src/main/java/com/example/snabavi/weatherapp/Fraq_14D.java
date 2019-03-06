package com.example.snabavi.weatherapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fraq_14D extends Fragment
{
	View view;
	
	public Fraq_14D() {}
	
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
							 Bundle savedInstanceState)
	{
		view = inflater.inflate(R.layout.fraq_14d, container, false);
		return view;
	}
}
