package com.example.hairsimulator;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Core;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
    private ImageView view;
    private static Activity myActivity;
    private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status) {
                case LoaderCallbackInterface.SUCCESS:   Log.i("OpenCV", "OpenCV loaded successfully");
                                                        break;
                default:  super.onManagerConnected(status);
                          break;
            }
        }
    };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		myActivity = this;
		setContentView(R.layout.activity_main);
		view = (CustView) findViewById(R.id.imageView1);
		AssetManager manager = getAssets();
        Bitmap bitmap;
	    // read a Bitmap from Assets
	    InputStream open = null;
	    try {
	      open = manager.open("back.png");
	      bitmap = BitmapFactory.decodeStream(open);
	      view.setImageBitmap(bitmap);
	      ((CustView) view).setBits(bitmap);
	    }
	    catch (IOException e) {
	        e.printStackTrace();
	      } 
	    finally {
	        if (open != null) {
	          try {
	            open.close();
	          } catch (IOException e) {
	            e.printStackTrace();
	          }
	        }
	    }
    }
	
    public static Activity getActivity() {
    	return myActivity;
    }
    
    @Override
    public void onResume()
    {
        super.onResume();
        if (!OpenCVLoader.initDebug()) {
            Log.d("Attitude", "Internal OpenCV library not found. Using OpenCV Manager for initialization");
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_2_4_8, this, mLoaderCallback);
        }
        else {
            Log.d("Attitude", "OpenCV library found inside package. Using it!");
            mLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS);
        }
    }
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void startUp(View v) {
		view.setOnTouchListener(new JobListener(true)); 
	}
} 
