package com.hari.mousemaze.activity;

import android.app.Activity;
import android.os.Bundle;

//import android.os.Vibrator;
import com.hari.mousemaze.R;

// Activity class that manages the main menu
public class Splash extends Activity {
	
	private String level = "diff1";

	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	    	super.onCreate(savedInstanceState);
	    	setContentView(R.layout.splash);
	    	
//			Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
	 }
}