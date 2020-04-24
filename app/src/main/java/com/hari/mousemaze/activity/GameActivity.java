package com.hari.mousemaze.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

//import android.os.Vibrator;
import com.hari.mousemaze.R;

public class GameActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.splash);
    	Thread countdownSplash = new Thread() {
    		@Override 
    		public void run() {
    			try {
//    				Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    			
//    				v.vibrate(500);
    				sleep(4500);
    				
				} catch (InterruptedException e) {
					// do nothing
				}
    			Intent intent = new Intent(GameActivity.this, MainActivity.class);
    	        startActivity(intent);finish();
    		};
    	};
    	countdownSplash.start();
    }
}