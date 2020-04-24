package com.hari.mousemaze.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.hari.mousemaze.R;

//import android.os.Vibrator;

public class MenuActivity extends Activity implements OnClickListener {
	
	private String level = "diff1";
	Button _btn_diff1,_btn_diff2,_btn_diff3,_btn_diff4,_btn_diff5,_btn_diff6,_btn_diff7,_btn_diff8,_btn_diff9,_btn_diff10;
	Button _btn_diff11,_btn_diff12,_btn_diff13,_btn_diff14,_btn_diff15,_btn_diff16,_btn_diff17,_btn_diff18,_btn_diff19,_btn_diff20;
	// Include a 'filename' for our shared preferences
	private static final String PREFS_NAME = "GAME_USERDATA";
	/* These keys will tell the shared preferences editor which
	data we're trying to access */
	private static final String UNLOCKED_LEVEL_KEY = "unlockedLevels";
	private static final String SOUND_KEY = "soundKey";
	/* Create our shared preferences object & editor which will
	be used to save and load data */
	private SharedPreferences mSettings;
	private SharedPreferences.Editor mEditor;
	// keep track of our max unlocked level
	private int mUnlockedLevels;
	// keep track of whether or not sound is enabled
	private boolean mSoundEnabled;
	MediaPlayer mp;
		
	@Override
	    public void onCreate(Bundle savedInstanceState) {
	    	super.onCreate(savedInstanceState);
	    	setContentView(R.layout.menu);
//			Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
			// Vibrate 3 short bursts
			long[] pattern = {300,200,200,200,200,200,200};
//			v.vibrate(pattern,-1);
			getButtonId();setButtonClickListener();
			init(getApplicationContext());getMaxUnlockedLevel();
			setButtonsUnlockedImages();
	    	mp = MediaPlayer.create(this, R.raw.mp_picking_coin);
//	    	mp.setLooping(true);
//	        	mp.start();
	 }//endoncre
	 private void getButtonId() {
	    	_btn_diff1 = (Button) findViewById(R.id.btn_diff1);_btn_diff2 = (Button) findViewById(R.id.btn_diff2);_btn_diff3 = (Button) findViewById(R.id.btn_diff3);_btn_diff4 = (Button) findViewById(R.id.btn_diff4);_btn_diff5 = (Button) findViewById(R.id.btn_diff5);
	    	_btn_diff6 = (Button) findViewById(R.id.btn_diff6);_btn_diff7 = (Button) findViewById(R.id.btn_diff7);_btn_diff8 = (Button) findViewById(R.id.btn_diff8);_btn_diff9 = (Button) findViewById(R.id.btn_diff9);_btn_diff10 = (Button) findViewById(R.id.btn_diff10);
	    	_btn_diff11 = (Button) findViewById(R.id.btn_diff11);_btn_diff12 = (Button) findViewById(R.id.btn_diff12);_btn_diff13 = (Button) findViewById(R.id.btn_diff13);_btn_diff14 = (Button) findViewById(R.id.btn_diff14);_btn_diff15 = (Button) findViewById(R.id.btn_diff15);
	    	_btn_diff16 = (Button) findViewById(R.id.btn_diff16);_btn_diff17 = (Button) findViewById(R.id.btn_diff17);_btn_diff18 = (Button) findViewById(R.id.btn_diff18);_btn_diff19 = (Button) findViewById(R.id.btn_diff19);_btn_diff20 = (Button) findViewById(R.id.btn_diff20);
	}
	 private void setButtonClickListener(){
		 _btn_diff1.setOnClickListener(this);_btn_diff2.setOnClickListener(this);_btn_diff3.setOnClickListener(this);_btn_diff4.setOnClickListener(this);_btn_diff5.setOnClickListener(this);
		 _btn_diff6.setOnClickListener(this);_btn_diff7.setOnClickListener(this);_btn_diff8.setOnClickListener(this);_btn_diff9.setOnClickListener(this);_btn_diff10.setOnClickListener(this);
		 _btn_diff11.setOnClickListener(this);_btn_diff12.setOnClickListener(this);_btn_diff13.setOnClickListener(this);_btn_diff14.setOnClickListener(this);_btn_diff15.setOnClickListener(this);
		 _btn_diff16.setOnClickListener(this);_btn_diff17.setOnClickListener(this);_btn_diff18.setOnClickListener(this);_btn_diff19.setOnClickListener(this);_btn_diff20.setOnClickListener(this);
	 }
	 private void setButtonsUnlockedImages(){
		 if(1<=mUnlockedLevels)_btn_diff1.setBackgroundResource(R.drawable.btn_level1);else _btn_diff1.setBackgroundResource(R.drawable.btn_level1);
		 if(2<=mUnlockedLevels)_btn_diff2.setBackgroundResource(R.drawable.btn_level2);else _btn_diff2.setBackgroundResource(R.drawable.btn_level2);
		 if(3<=mUnlockedLevels)_btn_diff3.setBackgroundResource(R.drawable.btn_level3);else _btn_diff3.setBackgroundResource(R.drawable.btn_level3);
		 if(4<=mUnlockedLevels)_btn_diff4.setBackgroundResource(R.drawable.btn_level4);else _btn_diff4.setBackgroundResource(R.drawable.btn_level4);
		 if(5<=mUnlockedLevels)_btn_diff5.setBackgroundResource(R.drawable.btn_level5);else _btn_diff5.setBackgroundResource(R.drawable.btn_level5);
		 if(6<=mUnlockedLevels)_btn_diff6.setBackgroundResource(R.drawable.btn_level6);else _btn_diff6.setBackgroundResource(R.drawable.btn_level6);
		 if(7<=mUnlockedLevels)_btn_diff7.setBackgroundResource(R.drawable.btn_level7);else _btn_diff7.setBackgroundResource(R.drawable.btn_level7);
		 if(8<=mUnlockedLevels)_btn_diff8.setBackgroundResource(R.drawable.btn_level8);else _btn_diff8.setBackgroundResource(R.drawable.btn_level8);
		 if(9<=mUnlockedLevels)_btn_diff9.setBackgroundResource(R.drawable.btn_level9);else _btn_diff9.setBackgroundResource(R.drawable.btn_level9);
		 if(10<=mUnlockedLevels)_btn_diff10.setBackgroundResource(R.drawable.btn_level10);else _btn_diff10.setBackgroundResource(R.drawable.btn_level10);
		 if(11<=mUnlockedLevels)_btn_diff11.setBackgroundResource(R.drawable.btn_level11);else _btn_diff11.setBackgroundResource(R.drawable.btn_level11);
		 if(12<=mUnlockedLevels)_btn_diff12.setBackgroundResource(R.drawable.btn_level12);else _btn_diff12.setBackgroundResource(R.drawable.btn_level12);
		 if(13<=mUnlockedLevels)_btn_diff13.setBackgroundResource(R.drawable.btn_level13);else _btn_diff13.setBackgroundResource(R.drawable.btn_level13);
		 if(14<=mUnlockedLevels)_btn_diff14.setBackgroundResource(R.drawable.btn_level14);else _btn_diff14.setBackgroundResource(R.drawable.btn_level14);
		 if(15<=mUnlockedLevels)_btn_diff15.setBackgroundResource(R.drawable.btn_level15);else _btn_diff15.setBackgroundResource(R.drawable.btn_level15);
		 if(16<=mUnlockedLevels)_btn_diff16.setBackgroundResource(R.drawable.btn_level16);else _btn_diff16.setBackgroundResource(R.drawable.btn_level16);
		 if(17<=mUnlockedLevels)_btn_diff17.setBackgroundResource(R.drawable.btn_level17);else _btn_diff17.setBackgroundResource(R.drawable.btn_level17);
		 if(18<=mUnlockedLevels)_btn_diff18.setBackgroundResource(R.drawable.btn_level18);else _btn_diff18.setBackgroundResource(R.drawable.btn_level18);
		 if(19<=mUnlockedLevels)_btn_diff19.setBackgroundResource(R.drawable.btn_level19);else _btn_diff19.setBackgroundResource(R.drawable.btn_level19);
		 if(20<=mUnlockedLevels)_btn_diff20.setBackgroundResource(R.drawable.btn_level20);else _btn_diff20.setBackgroundResource(R.drawable.btn_level20);
		 }
 	
 	@Override
 	public void onClick(View v) {
 		if(v==_btn_diff1){
				mp.start();
 			if(1 <= mUnlockedLevels){
	         level = "diff1"; _btn_diff1.setSelected(true);
             Intent intent = new Intent (MenuActivity.this, SplashGame.class);
             intent.putExtra("level", level);
             startActivity(intent);finish();
 			}else _btn_diff1.setEnabled(false);
 		}
 		else if(v==_btn_diff2){
 			System.out.println("_______________//"+mUnlockedLevels);
				mp.start();
 			if(2 <= mUnlockedLevels){
	         level = "diff2";
             _btn_diff2.setSelected(true);
             Intent intent = new Intent (MenuActivity.this, SplashGame.class);
             intent.putExtra("level", level);
             startActivity(intent);finish();
 			}else _btn_diff2.setEnabled(false);
 		}
 		else if(v==_btn_diff3){
				mp.start();
			if(3 <= mUnlockedLevels){
			_btn_diff3.setEnabled(true);
			level = "diff3";
             Intent intent = new Intent (MenuActivity.this, SplashGame.class);
             intent.putExtra("level", level);
             startActivity(intent);finish();
 			}else _btn_diff3.setEnabled(false);
 		}
 		else if(v==_btn_diff4){
				mp.start();
			if(4 <= mUnlockedLevels){
	         level = "diff4";
             Intent intent = new Intent (MenuActivity.this, SplashGame.class);
             intent.putExtra("level", level);
             startActivity(intent);finish();
 			}else _btn_diff4.setEnabled(false);
 		}
 		else if(v==_btn_diff5){
				mp.start();
//			if(5 <= mUnlockedLevels){
	         level = "diff5";
             Intent intent = new Intent (MenuActivity.this, SplashGame.class);
             intent.putExtra("level", level);
             startActivity(intent);finish();
// 			}else _btn_diff5.setEnabled(false);
 		}
 		else if(v==_btn_diff6){
				mp.start();
	         level = "diff6";
             Intent intent = new Intent (MenuActivity.this, SplashGame.class);
             intent.putExtra("level", level);
             startActivity(intent);finish();
 		}
 		else if(v==_btn_diff7){
				mp.start();
	         level = "diff7";
             Intent intent = new Intent (MenuActivity.this, SplashGame.class);
             intent.putExtra("level", level);
             startActivity(intent);finish();
 		}
 		else if(v==_btn_diff8){
				mp.start();
	         level = "diff8";
             Intent intent = new Intent (MenuActivity.this, SplashGame.class);
             intent.putExtra("level", level);
             startActivity(intent);finish();
 		}
 		else if(v==_btn_diff9){
				mp.start();
	         level = "diff9";
             Intent intent = new Intent (MenuActivity.this, SplashGame.class);
             intent.putExtra("level", level);
             startActivity(intent);finish();
 		}
 		else if(v==_btn_diff10){
				mp.start();
	         level = "diff10";
             Intent intent = new Intent (MenuActivity.this, SplashGame.class);
             intent.putExtra("level", level);
             startActivity(intent);finish();
 		}
 		else if(v==_btn_diff11){
				mp.start();
	         level = "diff11";
             Intent intent = new Intent (MenuActivity.this, SplashGame.class);
             intent.putExtra("level", level);
             startActivity(intent);finish();
 		}
 		else if(v==_btn_diff12){
				mp.start();
	         level = "diff12";
             Intent intent = new Intent (MenuActivity.this, SplashGame.class);
             intent.putExtra("level", level);
             startActivity(intent);finish();
 		}
 		else if(v==_btn_diff13){
				mp.start();
	         level = "diff13";
             Intent intent = new Intent (MenuActivity.this, SplashGame.class);
             intent.putExtra("level", level);
             startActivity(intent);finish();
 		}
 		else if(v==_btn_diff14){
				mp.start();
	         level = "diff14";
             Intent intent = new Intent (MenuActivity.this, SplashGame.class);
             intent.putExtra("level", level);
             startActivity(intent);finish();
 		}
 		else if(v==_btn_diff15){
				mp.start();
	         level = "diff15";
             Intent intent = new Intent (MenuActivity.this, SplashGame.class);
             intent.putExtra("level", level);
             startActivity(intent);finish();
 		}
 		else if(v==_btn_diff16){
				mp.start();
	         level = "diff16";
             Intent intent = new Intent (MenuActivity.this, SplashGame.class);
             intent.putExtra("level", level);
             startActivity(intent);finish();
 		}
 		else if(v==_btn_diff17){
				mp.start();
	         level = "diff17";
             Intent intent = new Intent (MenuActivity.this, SplashGame.class);
             intent.putExtra("level", level);
             startActivity(intent);finish();
 		}
 		else if(v==_btn_diff18){
				mp.start();
	         level = "diff18";
             Intent intent = new Intent (MenuActivity.this, SplashGame.class);
             intent.putExtra("level", level);
             startActivity(intent);finish();
 		}
 		else if(v==_btn_diff19){
				mp.start();
	         level = "diff19";
             Intent intent = new Intent (MenuActivity.this, SplashGame.class);
             intent.putExtra("level", level);
             startActivity(intent);finish();
 		}
 		else if(v==_btn_diff20){
				mp.start();
	         level = "diff20";
             Intent intent = new Intent (MenuActivity.this, SplashGame.class);
             intent.putExtra("level", level);
             startActivity(intent);finish();
 		}
 	}
 	//-------------------------------------------------------------------------
 	//-------------------------------------------------------------------------
 	// 	ALL METHODS STARTS FROM HERE*******************************
 	//-------------------------------------------------------------------------
 	//-------------------------------------------------------------------------
 	public synchronized void init(Context pContext) {
 		if (mSettings == null) {
 		/* Retrieve our shared preference file, or if it's not yet
 		* created (first application execution) then create it now
 		*/
 		mSettings = pContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
 		/* Define the editor, used to store data to our preference
 		file
 		*/
 		mEditor = mSettings.edit();
 		/* Retrieve our current unlocked levels. if the UNLOCKED_
 		LEVEL_KEY
 		* does not currently exist in our shared preferences, we'll
 		create
 		* the data to unlock level 1 by default
 		*/
 		mUnlockedLevels = mSettings.getInt(UNLOCKED_LEVEL_KEY, 1);
 		/* Same idea as above, except we'll set the sound boolean to
 		true
 		* if the setting does not currently exist
 		*/
 		mSoundEnabled = mSettings.getBoolean(SOUND_KEY, true);
 			}
 		}
 	
 	/* retrieve the max unlocked level value */
 	public synchronized int getMaxUnlockedLevel() {
 	return mUnlockedLevels;
 	}
 	public synchronized void unlockNextLevel() {
 	// Increase the max level by 1
 	 	mUnlockedLevels++;
// 	 	mUnlockedLevels--;
 	/* Edit our shared preferences unlockedLevels key, setting its
 	* value our new mUnlockedLevels value
 	*/
 	mEditor.putInt(UNLOCKED_LEVEL_KEY, mUnlockedLevels);
 	/* commit() must be called by the editor in order to save
 	* changes made to the shared preference data
 	*/
 	mEditor.commit();
 	}
 	
@Override
public void onBackPressed() {
	Intent intent = new Intent(MenuActivity.this, MainActivity.class);
    startActivity(intent);finish();
	super.onBackPressed();mp.stop();
}
}