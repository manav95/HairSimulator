package com.example.hairsimulator;

import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.Blobs;
import org.bytedeco.javacv.CanvasFrame;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_highgui.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;

import com.example.hairsimulator.model.ClassOval;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.ImageView;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.MatOfRect;

public class HairDrawer {
	 private Canvas canvas;
	 private Paint paint;
	 private ClassOval oval;
	 private Bitmap bit;
	 private Mat mat;
     public HairDrawer(Canvas c, Paint p, ClassOval o, Bitmap bitmap) {
    	  canvas = c;
    	  paint = p;
    	  oval = o;
    	  this.bit = bitmap;
    	  mat = new Mat();
    	  Utils.bitmapToMat(bit, mat);
     }
     public void drawHairOval() {
    	  int [][] points = oval.getPoints();
    	  Point p1 = new Point();
    	  Point p2 = new Point();
          p1.x = points[0][0];
          p1.y = points[0][1];
          p2.x = points[3][0];
          p2.y = points[3][1];
          int height = mat.height();
          int width = mat.width();
          for (int i = (int) p1.x; i < (int) p2.x; i++) {
             for (int j = (int) p1.y; j < (int) p2.y; j++) {
                 double [] data = mat.get(i,j);
                 data[0] = 255;
                 data[1] = 255;
                 data[2] = 255;
                 mat.put(i, j, data);
             }
          }
          Utils.matToBitmap(mat, bit);
          ImageView view = (CustView) MainActivity.getActivity().findViewById(R.id.imageView1); 
          view.setImageBitmap(bit);
	      ((CustView) view).setBits(bit);
    	  
     }
}
