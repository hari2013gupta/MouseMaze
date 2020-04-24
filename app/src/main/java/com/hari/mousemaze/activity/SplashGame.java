package com.hari.mousemaze.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.hari.mousemaze.R;

// Activity class that manages the main menu
public class SplashGame extends Activity {
	
	private String level = "diff1";

	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	    	super.onCreate(savedInstanceState);
	    	setContentView(R.layout.splash_game);
			Bundle extras = getIntent().getExtras();
			if (extras != null){	
				level = extras.getString("level");
			}
	    	Thread countdownSplash = new Thread() {
	    		@Override 
	    		public void run() {
	    			try {
//	    				Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
	    			
//	    				v.vibrate(500);
		    			System.gc();
	    				sleep(500);
					} catch (InterruptedException e) {
						// do nothing
					}
	    			Intent intent = new Intent(SplashGame.this, MazeActivity.class);
	                intent.putExtra("level", level);
	    	        startActivity(intent);finish();
	    		};
	    	};
	    	countdownSplash.start();
	    }
}