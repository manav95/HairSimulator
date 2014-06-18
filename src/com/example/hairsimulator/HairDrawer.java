package com.example.hairsimulator;

import com.example.hairsimulator.model.ClassOval;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class HairDrawer {
	 private Canvas canvas;
	 private Paint paint;
	 private ClassOval oval;
	 private Bitmap bit;
     public HairDrawer(Canvas c, Paint p, ClassOval o, Bitmap bitmap) {
    	  canvas = c;
    	  paint = p;
    	  oval = o;
    	  this.bit = bitmap;
     }
     public void drawHairOval() {
    	  int [][] points = oval.getPoints();
    	  bit.setPixel(points[0][0], points[0][1],Color.GREEN);
    	  RectF flail = new RectF(points[0][0],points[1][1],points[2][0],points[3][1]);
    	  
    	  canvas.drawOval(flail,paint);
     }
}
