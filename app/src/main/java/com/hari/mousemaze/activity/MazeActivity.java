package com.hari.mousemaze.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hari.mousemaze.CountDownTimer;
import com.hari.mousemaze.R;
import com.hari.mousemaze.view.MVEn5;
import com.hari.mousemaze.view.MVEn6;
import com.hari.mousemaze.view.MView;
import com.hari.mousemaze.view.MazeView;
import com.hari.mousemaze.view.MyView;

public class MazeActivity extends Activity implements OnTouchListener, SensorEventListener, OnClickListener {

	public MazeView mazeview;//MenuActivity menuactivity;
	public MView mview;public MyView myview;
//	public MVEn3 mvEn3;//public MVEn4 mvEn4;
	public MVEn5 mvEn5;public MVEn6 mvEn6;//public MVEn7 mvEn7;
	//public MVEn8 mvEn8;public MVEn9 mvEn9;public MVEn10 mvEn10;
	private SensorManager mSensorManager;private Sensor mAccelerometer;
    private WakeLock mWakeLock;
	public CountDownTimer cdt, cdt1;long millis_cdt=0,millis_cdt1=0;
	private long TotalTime = 300000, sec = 1000;
	boolean timeCheck=false;
	public Button b1, b2, b3;public ImageView b4;
	public  TextView txtTitle;
	public String diff;
	protected Activity context;
	public static String sensor_value="center";
	boolean bool_timer=false,bool_pwr=false; int ctr_timer=0,ctr_pwr;
	MediaPlayer Audio;//,mp_failed;
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
//	private boolean mIsBound = false;
//	private MusicService mServ;
//	private ServiceConnection Scon =new ServiceConnection(){
//
//		public void onServiceConnected(ComponentName name, IBinder
//	     binder) {
//		mServ = ((MusicService.ServiceBinder)binder).getService();
//		}
//
//		public void onServiceDisconnected(ComponentName name) {
//			mServ = null;
//		}
//		};
//		void doBindService(){
//	 		bindService(new Intent(this,MusicService.class),
//					Scon,Context.BIND_AUTO_CREATE);
//			mIsBound = true;
//		}
//
//		void doUnbindService()
//		{
//			if(mIsBound)
//			{
//				unbindService(Scon);
//	      		mIsBound = false;
//			}
//		}
		
	@Override
    public void onCreate(Bundle savedInstanceState) {
		this.getWindow().requestFeature(Window.FEATURE_PROGRESS);
		getWindow().setFeatureInt(Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_ON);
		super.onCreate(savedInstanceState);
    	mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mazeview=new MazeView(this);//menuactivity=new MenuActivity();
		init(getApplicationContext());getMaxUnlockedLevel();

//    	mp_failed = MediaPlayer.create(this, R.raw.mp_picking_coin);
    	Audio = MediaPlayer.create(this, R.raw.mp_jmggs_com_music);
    	Audio.setLooping(true);
        	Audio.start();
//        try{
//        Intent music = new Intent();
//        music.setClass(this,MusicService.class);
//        startService(music);
//        if(!isFinishing()){
//        doBindService ();//mServ.start();
//        }
//        }catch(Exception ex){ex.printStackTrace();}
        
        if(mAccelerometer == null){ //should die here.
        	Log.v("Error", "Could not find an accelarometer.");
        	Toast.makeText(getApplicationContext(), "Could not find an accelarometer.", Toast.LENGTH_SHORT).show();
        }
        
        // Get an instance of the PowerManager
        PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);
        // Create a bright wake lock
        mWakeLock = powerManager.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK, getClass().getName());
        //below done ari030420141030tings
        //1//47
        //2//48
        //3//59
        //4//510
        //5//
        //5//
        // read the requested diff level from the bundle sent by the main menu
		Bundle extras = getIntent().getExtras();
		int nx = 15,ny = 20;//ok_hari
		if (extras != null){	
			diff = extras.getString("level");//15,20//19,25//22,30//7,11//10,14//11,15//13,18//19,24//
			if (diff.equalsIgnoreCase("diff1")) {nx = 11;ny = 14;}else if (diff.equalsIgnoreCase("diff2")) {nx = 11;ny = 14;}else if (diff.equalsIgnoreCase("diff3")) {nx = 11;ny = 15;}else if (diff.equalsIgnoreCase("diff4")) {nx = 13;ny = 18;}else if (diff.equalsIgnoreCase("diff5")) {nx = 15;ny = 20;
			}else if (diff.equalsIgnoreCase("diff6")) {nx = 11;ny = 16;}else if (diff.equalsIgnoreCase("diff7")) {nx = 15;ny = 20;}else if (diff.equalsIgnoreCase("diff8")) {nx = 15;ny = 20;}else if (diff.equalsIgnoreCase("diff9")) {nx = 15;ny = 20;}else if (diff.equalsIgnoreCase("diff10")) {nx = 15;ny = 20;
			}else if (diff.equalsIgnoreCase("diff11")) {nx = 15;ny = 20;}else if (diff.equalsIgnoreCase("diff12")) {nx = 15;ny = 20;}else if (diff.equalsIgnoreCase("diff13")) {nx = 15;ny = 20;}else if (diff.equalsIgnoreCase("diff14")) {nx = 15;ny = 20;}else if (diff.equalsIgnoreCase("diff15")) {nx = 15;ny = 20;
			}else if (diff.equalsIgnoreCase("diff16")) {nx = 19;ny = 24;}else if (diff.equalsIgnoreCase("diff17")) {nx = 19;ny = 24;}else if (diff.equalsIgnoreCase("diff18")) {nx = 19;ny = 24;}else if (diff.equalsIgnoreCase("diff19")) {nx = 19;ny = 24;}else if (diff.equalsIgnoreCase("diff20")) {nx = 19;ny = 24;}}
		mazeview = new MazeView(this);//mazeview.setBackgroundColor(0xFF);//
		mazeview.setGridDim(nx,ny);mazeview.setBallPosition(9,0);//mazeview.setBPosition(9, 9);
    	mview = new MView(this);//mview.setBackgroundColor(0xFF);//
		mview.setGridDim(nx,ny);mview.setBallPosition(18,13);
    	myview = new MyView(this);//myview.setBackgroundColor(0xFF);//
		myview.setGridDim(nx,ny);myview.setBallPosition(8,3 );
//    	mvEn3 = new MVEn3(this);//mvEn3.setBackgroundColor(0xFF);
//    	mvEn3.setGridDim(nx,ny);mvEn3.setBallPosition(2,13);
//    	mvEn4 = new MVEn4(this);//mvEn4.setBackgroundColor(0xFF);
//    	mvEn4.setGridDim(nx,ny);mvEn4.setBallPosition(7,11);
    	mvEn5 = new MVEn5(this);//mvEn5.setBackgroundColor(0xFF);
    	mvEn5.setGridDim(nx,ny);mvEn5.setBallPosition(10,5);
    	mvEn6 = new MVEn6(this);//mvEn6.setBackgroundColor(0xFF);
    	mvEn6.setGridDim(nx,ny);mvEn6.setBallPosition(9,4);
//    	mvEn7 = new MVEn7(this);mvEn7.setBackgroundColor(0xFF);
//    	mvEn7.setGridDim(nx,ny);mvEn7.setBallPosition(13,11);
//    	mvEn8 = new MVEn8(this);mvEn8.setBackgroundColor(0xFF);
//    	mvEn8.setGridDim(nx,ny);mvEn8.setBallPosition(2,5);
//    	mvEn9 = new MVEn9(this);mvEn9.setBackgroundColor(0xFF);
//    	mvEn9.setGridDim(nx,ny);mvEn9.setBallPosition(13,11);
//    	mvEn10 = new MVEn10(this);mvEn10.setBackgroundColor(0xFF);
//    	mvEn10.setGridDim(nx,ny);mvEn10.setBallPosition(13,11);
		
 	   RelativeLayout relParent = new RelativeLayout(MazeActivity.this);//relative parent layout for mazeview
//	    relParent.setBackgroundColor(Color.WHITE);
 	   relParent.setBackgroundResource(R.drawable.bg_gameplay);
       RelativeLayout.LayoutParams rlparent = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.MATCH_PARENT);
       rlparent.setMargins(0, 220, 0, 0);//hari left right top bottom
       relParent.setLayoutParams(rlparent);

       RelativeLayout relTop = new RelativeLayout(MazeActivity.this);
       RelativeLayout.LayoutParams rlpTop = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
       rlpTop.addRule(RelativeLayout.ALIGN_PARENT_TOP);
       rlpTop.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
       rlpTop.addRule(RelativeLayout.CENTER_IN_PARENT);

       RelativeLayout.LayoutParams rlpBottom = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
       rlpBottom.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
       rlpBottom.addRule(RelativeLayout.CENTER_IN_PARENT);
       
//       relTop.setLayoutParams(rlpTop);

       b1 = new Button(MazeActivity.this);
       b1.setText("B1");
       b1.setLayoutParams(rlpBottom);

       b2 = new Button(MazeActivity.this);
       b2.setText("B2");
       b2.setLayoutParams(rlpBottom);
//
       b3 = new Button(MazeActivity.this);
       b3.setText("B3");
       b3.setLayoutParams(rlpBottom);
       
       b4 = new ImageView(MazeActivity.this);
//       b4.setText("");
       b4.setBackgroundResource(R.drawable.btn_pause);
       b4.setLayoutParams(rlpTop);
//-----------------------------------------------------hari_textView--First
       txtTitle = new TextView(MazeActivity.this);
       RelativeLayout.LayoutParams relParam = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);

       relParam.addRule(RelativeLayout.CENTER_IN_PARENT);
		Typeface font = Typeface.createFromAsset(getAssets(),"fonts/cooprblk.ttf");//akbar.ttf");
//		Typeface font = Typeface.createFromAsset(getAssets(),"fonts/erbos_draco_1st_nbp.ttf");//akbar.ttf");
//		Typeface font = Typeface.createFromAsset(getAssets(),"fonts/digital_7_mono_italic.ttf");
		txtTitle.setTypeface(font);txtTitle.setText("");txtTitle.setLayoutParams(relParam);
       txtTitle.setTextColor(Color.BLUE);txtTitle.setTextSize(30);
       relTop.addView(txtTitle);
//-----------------------------------------------------hari hari_textView--First
       
//------------------------------------------------------end textView
       relParent.addView(relTop);
//       relParent.addView(b1);
//       relParent.addView(b2);
//       relParent.addView(b3);
       relParent.addView(b4);

//       setContentView(relParent);
       
       mazeview.setLayoutParams(rlparent);mview.setLayoutParams(rlparent);myview.setLayoutParams(rlparent);
//       mvEn3.setLayoutParams(rlparent);//mvEn4.setLayoutParams(rlparent);
       mvEn5.setLayoutParams(rlparent);mvEn6.setLayoutParams(rlparent);//mvEn7.setLayoutParams(rlparent);
       relParent.addView(mazeview);relParent.addView(mview);//relParent.addView(myview);relParent.addView(mvEn3);//relParent.addView(mvEn4);
       relParent.addView(mvEn5);relParent.addView(mvEn6);//relParent.addView(mvEn7);
       //relParent.addView(mvEn8);relParent.addView(mvEn9);relParent.addView(mvEn10);
//       relParent.addView(vv);
		setContentView(relParent);
		mazeview.setOnTouchListener(this);
		///////////////////////////hari_sep_contnt view//////////////////////////////////////ALL ACTION CODING HERE/////
  		 try{
   			 cdt = new CountDownTimer(TotalTime, sec) {
			 long now = 0, secs, mins;

			 public void onTick(long millisUntilFinished) {
				 now = millisUntilFinished / sec;
				 secs = now % 60;mins = now/60;
			       txtTitle.setTextColor(Color.BLUE);
			     txtTitle.setText(""+formatDigits(mins)+":"+formatDigits(secs));
			     millis_cdt=millisUntilFinished;
			 }

			 public void onFinish() {
			       txtTitle.setTextColor(Color.RED);
			     txtTitle.setText("Your Time's Up!"); mWakeLock.acquire();
////hari_action for dialog method one here method 1
//			     if(!((Activity) context).isFinishing())
//			     {
//			    	 gameOverDialog();//
			    	            if(!isFinishing()){
//			    	            AlertWin("Level Failed!");
					                Audio.stop();//System.gc();
					                Audio.release();
				                Intent intent = new Intent (MazeActivity.this, GameOver.class);
				                intent.putExtra("level", diff);
				                startActivity(intent);finish();
				                //mServ.stopMusic();
//				                onDestroy();
			    	            }
//			    	 }			     
			 	}  
			}.start();
		 }catch(Exception ex){ex.printStackTrace();}

  		 b4.setOnClickListener(this);
//  	    b4.setOnClickListener(new OnClickListener() {
//  			@Override
//  			public void onClick(View v) {
//  				if(timeCheck==false){
//  					if (cdt != null) {
//  						try{
//  							b4.setBackgroundResource(R.drawable.btn_resume);
////							mazeview.setBackgroundResource(R.drawable.bg_pause);
//				        cdt.pause();timeCheck=true;cdt.wait(millis);
//				        
////				        mSensorManager.unregisterListener(getApplicationContext());
////						mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_GAME);
//  						}catch(Exception ex){ex.printStackTrace();}
//  				    }
//  				}else if(timeCheck==true){
//						b4.setBackgroundResource(R.drawable.btn_pause);
////							mazeview.setBackgroundDrawable(null);
//  	  				cdt.resume();timeCheck=false;
//  					}
//  				}
//  	    	});
	}//endoncrea
	public boolean onKeyDown(int keycode, KeyEvent event ) {
		// device's menu button toggles magnification state
		if(keycode == KeyEvent.KEYCODE_MENU) {
			System.err.println ("MENU PRESSED");
//			mazeview.setMagnify();
		}
		return super.onKeyDown(keycode,event);  
	}

	public boolean onTouch(View v, MotionEvent event) {
		// touch handler for maze view
		if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
			int x = (int) event.getX();
			int y = (int) event.getY();
//			Log.v("maze", "touch x="+x+" y="+y);
			int w = v.getWidth();
			int h = v.getHeight();
			if (y <= h/4)
				mazeview.moveBallUp();
			else if (y >= 3*h/4)
				mazeview.moveBallDown();
			else if (x < w/2)
				mazeview.moveBallLeft();
			else
				mazeview.moveBallRight();
			return true;
		}
		return false;
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		mSensorManager.unregisterListener(this);
		mWakeLock.release();
	}

	@Override
	protected void onResume() {
		super.onResume();
		mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_GAME);
		mWakeLock.acquire();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Audio.release();
//		doUnbindService();
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}

	// last acceleration from sensor
	private float lastAccX, lastAccY;
	
	@Override
	public void onSensorChanged(SensorEvent event) {
		if (event.sensor.getType() != Sensor.TYPE_ACCELEROMETER)
            return;

//		System.out.println("x: "+ (event.values[0])+"  y: "+ (event.values[1]));
		float accx = event.values[0];
		float accy = event.values[1];
		float accz = event.values[2];
//		System.out.println("----------accX = "+accx );
//		System.out.println("----------accY = "+accy );
//		final float thresh = 3.0f;//hari
//		final float thresh2 = 4.7f;//hari_working_here
		
		// if acceleration is larger than a threshold, 
		// and the previous acceleration was lower than a threshold
		// then send the appropriate ball move command to the maze view
		
		//-------------------Starts_hari_codeing for accelerometer========>
		
		  float _x = accx, _y = accy,_z=accz;
		  if (Math.abs(_x) > Math.abs(_y)) {
			   if (_x < 0) {
//			    iv.setImageResource(R.drawable.right);
//				   System.out.println("____________right");
					fun_timer1();fun_pwr();
					mazeview.moveBallRight();
					mview.moveBallRight();mview.moveBallUp();mview.moveBallDown();
					myview.moveBallUp();myview.moveBallRight();myview.moveBallDown();
//					mvEn3.moveBallUp();mvEn3.moveBallDown();mvEn3.moveBallRight();
//					mvEn4.moveBallDown();mvEn4.moveBallRight();mvEn4.moveBallUp();
//					mvEn5.moveBallRight();mvEn5.moveBallUp();mvEn5.moveBallDown();
//					mvEn6.moveBallDown();mvEn6.moveBallRight();mvEn6.moveBallUp();
//					mvEn7.moveBallUp();mvEn7.moveBallDown();mvEn7.moveBallRight();
//				   mazeview.mBallBitmap=BitmapFactory.decodeResource(getResources(), R.drawable.ball_enemy1);
//					System.out.println("mazeview.X="+mazeview.X+",mazeview.Y="+mazeview.Y+",mazeview.mBallVX="+mazeview.mBallVX+",mazeview.mBallVX="+mazeview.mBallVX);
//		        	System.out.println("mazeview.(hx,hy)=("+mazeview.hx+","+mazeview.hy+")");
			   }
			   if (_x > 0) {
		//iv.setImageResource(R.drawable.left);
//				   System.out.println("____________left");
					fun_timer1();fun_pwr();
					mazeview.moveBallLeft();
					mview.moveBallUp();mview.moveBallLeft();mview.moveBallDown();
					myview.moveBallUp();myview.moveBallLeft();myview.moveBallDown();
//					mvEn3.moveBallDown();mvEn3.moveBallLeft();mvEn3.moveBallUp();
//					mvEn4.moveBallLeft();mvEn4.moveBallDown();mvEn4.moveBallUp();
//					mvEn5.moveBallLeft();mvEn5.moveBallUp();mvEn5.moveBallDown();
//					mvEn6.moveBallUp();mvEn6.moveBallDown();mvEn6.moveBallLeft();
//					mvEn7.moveBallUp();mvEn7.moveBallLeft();mvEn7.moveBallDown();
//					   mazeview.mBallBitmap=BitmapFactory.decodeResource(getResources(), R.drawable.ball_enemy2);
///////////////////////////hari_code to adding boosters in the application starts from here
			   }
			  } else {
			   if (_y < 0) {
//			    iv.setImageResource(R.drawable.top);
//				   System.out.println("____________up");
				   fun_timer1();fun_pwr();
					mazeview.moveBallUp();
					mview.moveBallRight();mview.moveBallLeft();mview.moveBallUp();
					myview.moveBallLeft();myview.moveBallRight();myview.moveBallUp();
//					mvEn3.moveBallLeft();mvEn3.moveBallUp();mvEn3.moveBallRight();
//					mvEn4.moveBallUp();mvEn4.moveBallLeft();mvEn4.moveBallRight();
//					mvEn5.moveBallUp();mvEn5.moveBallRight();mvEn5.moveBallLeft();
//					mvEn6.moveBallLeft();mvEn6.moveBallUp();mvEn6.moveBallRight();
//					mvEn7.moveBallLeft();mvEn7.moveBallRight();mvEn7.moveBallUp();
///////////////////////////hari_code to adding boosters in the application starts from here
			   }
			   if (_y > 0) {
				   
//			    iv.setImageResource(R.drawable.bottom);
//				   System.out.println("____________down");
				   fun_timer1();fun_pwr();
					mazeview.moveBallDown();
					mview.moveBallLeft();mview.moveBallRight();mview.moveBallDown();
					myview.moveBallRight();myview.moveBallDown();myview.moveBallLeft();
//					mvEn3.moveBallDown();mvEn3.moveBallRight();mvEn3.moveBallLeft();
//					mvEn4.moveBallLeft();mvEn4.moveBallDown();mvEn4.moveBallRight();
//					mvEn5.moveBallLeft();mvEn5.moveBallRight();mvEn5.moveBallDown();
//					mvEn6.moveBallRight();mvEn6.moveBallLeft();mvEn6.moveBallDown();
//					mvEn7.moveBallDown();mvEn7.moveBallLeft();mvEn7.moveBallRight();
///////////////////////////hari_code to adding boosters in the application starts from here
			   }
			  }
//				  if(_z>0)mazeview.moveBallUp();
//				  else if(_z<0)mazeview.moveBallDown();
				  
			  if (_x > (-2) && _x < (2) && _y > (-2) && _y < (2)) {
//			   iv.setImageResource(R.drawable.center);
//				   System.out.println("____________ccccccccc");
				   fun_timer1();fun_pwr();
					mvEn5.moveBallLeft();mvEn5.moveBallRight();
					mvEn5.moveBallUp();mvEn5.moveBallDown();
					mvEn6.moveBallRight();mvEn6.moveBallLeft();
					mvEn6.moveBallDown();mvEn6.moveBallUp();
				   
//				   if(mazeview.hx==mview.hx &&mazeview.hy==mview.hy || mazeview.hx==myview.hx &&mazeview.hy==myview.hy){
//			        	Toast.makeText(getApplicationContext(), "COLLISION WITH CAT\nGAME OVER!!!!!!.", Toast.LENGTH_SHORT).show();
//				   }
					   
			  }

//		if (accx > thresh && Math.abs(lastAccX) < thresh2){
//			mazeview.moveBallLeft();System.out.println("____________left");}
//		else if (accx < -thresh && Math.abs(lastAccX) < thresh2){
//			mazeview.moveBallRight();System.out.println("____________right");}
//		if (accy > thresh && Math.abs(lastAccY) < thresh2){
//			mazeview.moveBallDown();System.out.println("____________down");}
//		else if (accy < -thresh && Math.abs(lastAccY) < thresh2){
//			mazeview.moveBallUp();System.out.println("____________up");}
		//-------------------hari_initial_codeing for accelerometer_ends
		
		// save acceleration values
		lastAccX = accx;
		lastAccY = accy;
	}
	
	public void won()
	{
//		AlertWin("You Completed this Level!");
		mWakeLock.acquire();
        if(!isFinishing()){
//            AlertWin("Level Failed!");
            Intent intent = new Intent (MazeActivity.this, GameWin.class);
            intent.putExtra("level", diff);
            startActivity(intent);finish();
            Audio.stop();unlockNextLevel();
            //mServ.stopMusic();
//            onDestroy();
            }
	}	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		Intent intent = new Intent(MazeActivity.this, MenuActivity.class);
        startActivity(intent);finish();
        Audio.stop();//System.gc();
        //mServ.stopMusic();
//        onDestroy();
	}

//hari_inner dialog functions
//private void gameOverDialog(){
//AlertDialog.Builder builder = new AlertDialog.Builder(this);
//builder.setTitle("Mouse Maze")
////.setView(editText)
//.setMessage("Game Over!")
//.setCancelable(false)
//.setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
//@Override
//public void onClick(DialogInterface dialog, int arg1) {
//    //Do here whatever.....
//	dialog.cancel();
////	dialog.dismiss();
//    Intent intent = new Intent (MazeActivity.this, MazeActivity.class);
//    intent.putExtra("level", diff);
//    startActivity(intent);  
//    finish();
//	}
//});
//AlertDialog alert = builder.create();
//alert.show();
//	}
	/////////////////////////////////////////////////////////////////
//	public void AlertWin(String msg){
//    	AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
//        builder1.setTitle("Mouse Maze");
//    	builder1.setMessage(msg);
//        builder1.setCancelable(false);
//        builder1.setPositiveButton("Play Again",
//                new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int id) {
////              //Do here whatever.....
//            	dialog.cancel();
////            	dialog.dismiss();
//                Intent intent = new Intent (MazeActivity.this, MazeActivity.class);
//                intent.putExtra("level", diff);
//                startActivity(intent);  
//                finish();
//
////        		System.out.println("----------------exti---------------");//UC wb
////        		Context context=view.getContext();
////        		Intent thingyToInstall=new Intent(Intent.ACTION_VIEW);
////        		thingyToInstall.setDataAndType(Uri.parse(getURL), null);
////        		context.startActivity(thingyToInstall);
//            }
//        });
//        builder1.setNegativeButton("Main Menu",
//                new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int id) {
////                dialog.cancel();
//                dialog.cancel();
////              //Do here whatever.....
//                Intent intent = new Intent (MazeActivity.this, MenuActivity.class);
//                startActivity(intent);  
//                finish();
////                System.runFinalizersOnExit(true);
////                System.exit(0);
//            	
//            }
//        });
//
//        AlertDialog alert11 = builder1.create();
//        alert11.show();
//    }
	/////////////starts_custom)_alerts
	public void AlertCustomPaused(){
    final Dialog dialog = new Dialog(MazeActivity.this);
    
    //--------hari_extras1
    //setting custom layout to dialog
//    WindowManager.LayoutParams a = dialog.getWindow().getAttributes();
////  dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//    a.dimAmount = 0;
//    dialog.getWindow().setAttributes(a);
//    dialog.setCancelable(true);
//    dialog.getWindow().setLayout(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT);
    //--------hari_extras2
//    View title = getWindow().findViewById(android.R.id.title);
//    View titleBar = (View) title.getParent();
//    titleBar.setBackgroundColor(Color.BLACK);
//    titleBar.setVisibility(View.VISIBLE);
    
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
    dialog.setContentView(R.layout.custom);
    dialog.setCancelable(false);
//    dialog.setTitle("Mouse Maze**");

    //adding text dynamically
//    TextView txt = (TextView) dialog.findViewById(R.id.textView);
//    txt.setText("Game Paused..");

    ImageView image = (ImageView)dialog.findViewById(R.id.image);
//    image.setImageResource(R.drawable.ic_launcher);
    image.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_dialog_info));

    //adding button click event
    Button dismissButton = (Button) dialog.findViewById(R.id.button);
//    dismissButton.setBackgroundResource(R.drawable.btn_resume);
    dismissButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
			b4.setBackgroundResource(R.drawable.btn_pause);
//			mazeview.setBackgroundDrawable(null);
		cdt.resume();onResume();timeCheck=false;
		Audio.start();
//		mServ.resumeMusic();
            dialog.dismiss();
        }
    });
    dialog.show();
}
////////////////////////////////hari_end_all_alerts
	private String formatDigits(long num) {
		return (num < 10) ? "0" + num : new Long(num).toString();
	}
	
	@Override
	public void onClick(View v) {
		if(v==b4){
//				if(timeCheck==false){
  					if (cdt != null) {
  						try{
  							AlertCustomPaused();
//  							b4.setBackgroundResource(R.drawable.btn_resume);
				        cdt.pause();onPause();
				        Audio.pause();
				        //mServ.pauseMusic();//timeCheck=true;
  						}catch(Exception ex){ex.printStackTrace();}
//  				    }
//  				}else if(timeCheck==true){
//						b4.setBackgroundResource(R.drawable.btn_pause);
////							mazeview.setBackgroundDrawable(null);
//  	  				cdt.resume();onResume();timeCheck=false;
  					}
		}
	}
////////////////////////////hari_starts_funtions_from_here
	protected void fun_timer1(){
		if(bool_timer==false){
			   if(mazeview.mBallCellX==mvEn6.mBallCellX && mazeview.mBallCellY==mvEn6.mBallCellY ||
					   mazeview.mBallCellX==0 && mazeview.mBallCellY==0){
//				     mvEn6.mBallBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ball_invisible);
//  				     mazeview.bmg = BitmapFactory.decodeResource(getResources(), R.drawable.ball_invisible);
  				     cdt.mStopTimeInFuture=cdt.mStopTimeInFuture+20000;
  				     bool_timer=true;
			        Toast.makeText(getApplicationContext(), "Time added 20 seconds.", Toast.LENGTH_SHORT).show();
			   		}
				}
		else if(bool_timer==true){mvEn6.mBallBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ball_invisible);}
	}
	protected void fun_pwr(){
		if(bool_pwr==false){
			   if(mazeview.mBallCellX==mvEn5.mBallCellX && mazeview.mBallCellY==mvEn5.mBallCellY 
					   ){
 				  	mazeview.mBallBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ball_boosterrat);
//  				  	mvEn5.mBallBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ball_invisible);
//  				  mazeview.bmg = BitmapFactory.decodeResource(getResources(), R.drawable.ball_invisible);
//				   mazeview.bmg = BitmapFactory.decodeResource(null, 0);
					 	bool_pwr=true;
  				        Toast.makeText(getApplicationContext(), "Aquired power for 20 seconds.", Toast.LENGTH_SHORT).show();
		  			 cdt1 = new CountDownTimer(20000, 1000) {
		  				 public void onTick(long millisUntilFinished) {
		  					 	millis_cdt1=millisUntilFinished;
//			  				       txtTitle.setTextColor(Color.GREEN);
		  					 	ctr_timer++;
		  				 }
		  				 public void onFinish() {
//		  				       txtTitle.setTextColor(Color.BLUE);
		  				    	            if(!isFinishing()){
		  				  				     ctr_timer=0;
		  				  				     mazeview.mBallBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ball_left);
		  				    	            }
		  				 		}  
		  				}.start();
			   		}
				}
		else if(bool_pwr==true) {mvEn5.mBallBitmap=BitmapFactory.decodeResource(getResources(), R.drawable.ball_invisible);}
					if(ctr_timer==0){
					   if(mazeview.mBallCellX==mview.mBallCellX&&mazeview.mBallCellY==mview.mBallCellY || 
							   mazeview.mBallCellX==myview.mBallCellX&&mazeview.mBallCellY==myview.mBallCellY
//							   || 
//							   mazeview.mBallCellX==mvEn3.mBallCellX&&mazeview.mBallCellY==mvEn3.mBallCellY 
//							   || 
//							   mazeview.mBallCellX==mvEn4.mBallCellX&&mazeview.mBallCellY==mvEn4.mBallCellY 
							   ){
//				        	Toast.makeText(getApplicationContext(), "COLLISION\nGAME OVER!!!!!!.", Toast.LENGTH_SHORT).show();
		    	            if(!isFinishing()){
//			    	            AlertWin("Level Failed!");
				                Intent intent = new Intent (MazeActivity.this, GameOver.class);
				                intent.putExtra("level", diff);
				                startActivity(intent);finish();
				                Audio.stop();//System.gc();
//								mServ.stopMusic();
//				                onDestroy();
			    	            }
					   }
				}
		}
 	//-------------------------------------------------------------------------
 	//-------------------------------------------------------------------------
 	// 	ALL METHODS STARTS FROM HERE*******************************
 	//-------------------------------------------------------------------------
 	//-------------------------------------------------------------------------
 	public synchronized void init(Context pContext) {
 		if (mSettings == null) {
 		mSettings = pContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
 		mEditor = mSettings.edit();
 		mUnlockedLevels = mSettings.getInt(UNLOCKED_LEVEL_KEY, 1);
 		mSoundEnabled = mSettings.getBoolean(SOUND_KEY, true);
 			}
 		}
 	public synchronized int getMaxUnlockedLevel() {
 	return mUnlockedLevels;
 	}
 	public synchronized void unlockNextLevel() {
 	mUnlockedLevels++;
 	mEditor.putInt(UNLOCKED_LEVEL_KEY, mUnlockedLevels);
 	mEditor.commit();
 	}
}