package com.example.hairsimulator;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
    private ImageView view;
    private static Activity myActivity;
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

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void startUp(View v) {
		view.setOnTouchListener(new JobListener(true)); 
	}
	

}
