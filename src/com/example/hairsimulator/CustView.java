package com.example.hairsimulator;

import java.io.IOException;
import java.io.InputStream;

import com.example.hairsimulator.model.ClassOval;

import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import 	android.graphics.drawable.BitmapDrawable;

public class CustView extends ImageView{
     private Paint mPaint;
     private Paint mNew;
     private Canvas canv;
     private ClassOval oval;
     private Bitmap bit;
	 public CustView(Context context, AttributeSet attrs) {
	        super(context, attrs);
	 }
	 public void setOval(ClassOval o) {
		  oval = o;
	 }
	 public void setDefPaint() {
		   mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		   mPaint.setColor(Color.YELLOW);
	 }
	 protected void onDraw(Canvas canvas) {
		 super.onDraw(canvas);
		 canv = canvas;
	 }
	 public void setBits(Bitmap b) {
		 bit = b;
	 }
	 public void specialDraw() {
		 if (oval != null) {
			 HairDrawer drawer = new HairDrawer(canv, mPaint, oval, bit);
			 try {
			     drawer.drawHairOval();
			 }
			 catch (IllegalStateException e) {
				 Log.d("The Hell", e.getMessage());
			 }
		 }
		 }
	 }
