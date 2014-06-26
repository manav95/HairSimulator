package com.example.hairsimulator;

import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.Blobs;
import org.bytedeco.javacv.CanvasFrame;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_highgui.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;

import com.example.hairsimulator.model.ClassOval;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.ImageView;

public class HairDrawer {
	 private Canvas canvas;
	 private Paint paint;
	 private ClassOval oval;
	 private Bitmap bit;
	 private IplImage image;
     public HairDrawer(Canvas c, Paint p, ClassOval o, Bitmap bitmap) {
    	  canvas = c;
    	  paint = p;
    	  oval = o;
    	  this.bit = bitmap;
    	  image = IplImage.create(bit.getWidth(), bit.getHeight(), IPL_DEPTH_8U, 4);
    	  bit.copyPixelsToBuffer(image.getByteBuffer());
     }
     public void drawHairOval() {
    	  int [][] points = oval.getPoints();
    	  CvPoint p1 = new CvPoint();
    	  CvPoint p2 = new CvPoint();
          p1.x(points[0][0]);
          p1.y(points[0][1]);
          p2.x(points[3][0]);
          p2.y(points[3][1]);
          cvRectangle(image, p1, p2, CV_RGB(255, 0, 0), 2, 8, 0);
          ImageView view = (CustView) MainActivity.getActivity().findViewById(R.id.imageView1);
          bit.copyPixelsFromBuffer(image.getByteBuffer());  
          view.setImageBitmap(bit);
	      ((CustView) view).setBits(bit);
    	  
     }
}
