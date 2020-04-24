package com.hari.mousemaze;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.hari.mousemaze.view.GameView;

public class Game extends Activity {
//	private boolean moved =false;
    public GameView view;
	boolean hari= false;
	Button b2,b4;
	AccelerometerHandler accel;
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		final Maze maze = (Maze)extras.get("maze");
		view = new GameView(this,maze);
      setContentView(view);
      System.out.println("accelX"+accel.accelX);
      System.out.println("accelX"+accel.accelY);
      System.out.println("accelX"+accel.accelZ);

//	   RelativeLayout relParent = new RelativeLayout(Game.this);
//	    relParent.setBackgroundColor(Color.BLUE);
//       RelativeLayout.LayoutParams rlparent = new RelativeLayout.LayoutParams(
//                    RelativeLayout.LayoutParams.FILL_PARENT,
//                    RelativeLayout.LayoutParams.FILL_PARENT);
//       relParent.setLayoutParams(rlparent);

//       RelativeLayout relTop = new RelativeLayout(Game.this);
//       RelativeLayout.LayoutParams rlpTop = new RelativeLayout.LayoutParams(
//                    RelativeLayout.LayoutParams.FILL_PARENT,
//                    RelativeLayout.LayoutParams.WRAP_CONTENT);
//       rlpTop.addRule(RelativeLayout.ALIGN_PARENT_TOP);

//       RelativeLayout.LayoutParams rlpBottom = new RelativeLayout.LayoutParams(
//                    RelativeLayout.LayoutParams.WRAP_CONTENT,
//                    RelativeLayout.LayoutParams.WRAP_CONTENT);
//       rlpBottom.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
//       rlpBottom.addRule(RelativeLayout.CENTER_IN_PARENT);
//       
////       relTop.setLayoutParams(rlpTop);
//
//       Button b1 = new Button(Game.this);
//       b1.setText("B1");
//       b1.setLayoutParams(rlpBottom);
//
//       b2 = new Button(Game.this);
//       b2.setText("B2");
//       b2.setLayoutParams(rlpBottom);
//
//       Button b3 = new Button(Game.this);
//       b3.setText("B3");
//       b3.setLayoutParams(rlpBottom);
//       System.out.println("--------------0------hello----");
//       b4 = new Button(Game.this);
//       System.out.println("----------b4 button-------//"+b4);
//       b4.setText("B4");
//       b4.setLayoutParams(rlpBottom);
//       System.out.println("--------------1------hello----");
//-----------------------------------------------------
//       TextView txtTitle = new TextView(Game.this);
//       RelativeLayout.LayoutParams relParam = new RelativeLayout.LayoutParams(
//                    RelativeLayout.LayoutParams.WRAP_CONTENT,
//                    RelativeLayout.LayoutParams.WRAP_CONTENT);

//       relParam.addRule(RelativeLayout.CENTER_IN_PARENT);
//       txtTitle.setText("HomeScreen");
//       txtTitle.setLayoutParams(relParam);
//       txtTitle.setTextColor(Color.BLUE);
//       txtTitle.setTextSize(18);

//       relTop.addView(txtTitle);
//------------------------------------------------------
//       relParent.addView(relTop);
//       relParent.addView(b1);
//       relParent.addView(b2);
//       relParent.addView(b3);
//       relParent.addView(b4);
//
//       setContentView(relParent);
//       relParent.addView(vv);
//        setContentView(R.layout.buttons);
//		createLayoutDynamically(3);
//       System.out.println("--------------2------hello----");
//       b4.setOnClickListener(new OnClickListener() {
//    	   @Override
//			public void onClick(View v) {
////    		   System.out.println("-------------hair"+vv.down());
////    		   hari = vv.moved;
////    		   hari = vv.down();
////    		   KeyEvent evt;
////			   maze.move(Maze.DOWN);
//    		   vv.moved = maze.move(Maze.DOWN);
//    		   System.out.println("--------vv.up()-----button4"+vv.moved);
////			   System.out.println("-------------button4");
//			}
//		});

//       b2.setOnClickListener(new OnClickListener() {
//    	   @Override
//			public void onClick(View v) {
//    		    vv.moved = maze.move(Maze.DOWN);
////				maze.move(Maze.DOWN);
////    			hari = vv.moved;
////				hari = vv.up();
//				System.out.println("--------vv.up()-----button4"+vv.moved);
//			}
//		});

	}//endonc
	
	////////////////////////////////
}
