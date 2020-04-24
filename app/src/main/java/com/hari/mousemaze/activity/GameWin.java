package com.hari.mousemaze.activity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//import android.os.Vibrator;
import com.hari.mousemaze.R;

public class GameWin extends Activity {
	MediaPlayer Audio;
	private String level = "diff1";

	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	    	super.onCreate(savedInstanceState);
	    	setContentView(R.layout.game_win);
	    	Bundle extras = getIntent().getExtras();
	    	
	    	Audio = MediaPlayer.create(this, R.raw.mp_game_over);
	        	Audio.start();
	    	if (extras != null){	
	    		level = extras.getString("level");
	    	}
	    	final Button PlayAgain = (Button) findViewById(R.id.btn_playagain);
	    	final Button MainMenu = (Button) findViewById(R.id.btn_mainmenu);
////////////////////	    	
	    	PlayAgain.setOnClickListener(new View.OnClickListener() { 
	        	public void onClick(View v) {
	                Intent intent = new Intent (GameWin.this, MazeActivity.class);
	                intent.putExtra("level", level);
	                startActivity(intent);finish();
	            }
	         });
	         
	         MainMenu.setOnClickListener(new View.OnClickListener() {
	        	 public void onClick(View v) {
		                Intent intent = new Intent (GameWin.this, MainActivity.class);
		                startActivity(intent);finish();
		         }
	         });
	 }//endoncre
		@Override
		protected void onDestroy() {
			super.onDestroy();
			Audio.release();
//			doUnbindService();
		}
	 @Override
	public void onBackPressed() {
         Intent intent = new Intent (GameWin.this, MenuActivity.class);
         startActivity(intent);finish();
		super.onBackPressed();
	}
}