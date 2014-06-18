package com.example.hairsimulator;

import com.example.hairsimulator.model.ClassOval;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class JobListener implements View.OnTouchListener {
	   private boolean activated;
	   private ClassPointHolder[] holder;
	   private int size;
       public JobListener(boolean stuff) {
    	   activated = stuff;
    	   holder = new ClassPointHolder[8];
    	   size = 0;
       }
       public boolean onTouch(View v, MotionEvent event) {
    	   if (activated == false) {
    		   return false;
    	   }
    	   else {
    		 int x = (int) event.getX();  
    		 int y = (int) event.getY();
    		 holder[size] = new ClassPointHolder(x,y);
    		 size = size + 1;
    		 if (size == 8) {
    			 activated = false;
    			 ClassOval oval = new ClassOval(holder);
    			 ((CustView)v).setDefPaint();
    			 ((CustView)v).setOval(oval);
    			 ((CustView)v).specialDraw();
    		 }
    		 return true;
    	   }
       }
       public void setActivated(boolean a) {
    	   activated = a;
       }
}
