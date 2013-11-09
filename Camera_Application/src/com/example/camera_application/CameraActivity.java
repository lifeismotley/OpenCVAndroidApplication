package com.example.camera_application;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class CameraActivity extends FragmentActivity implements GalleryFragment.ViewChangedListener {
    GestureDetector gestureDetector;
    
    public void viewChanged(String message) {
    	 ViewFragment fragment = (ViewFragment) getSupportFragmentManager().findFragmentById(R.id.imageView);
    	 fragment.updateImage(message);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragmentContainer);
        
        if (fragment == null) {
            fragment = createFragment();
            manager.beginTransaction().add(R.id.fragmentContainer, fragment).commit();//new CameraFragment()).commit(); 
        }
        
        // hide the window title.
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // hide the status bar and other OS-level chrome
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        gestureDetector = new GestureDetector(this, new GestureListener());
//        super.onCreate(savedInstanceState);
    }
    
    protected Fragment createFragment() {
        return new CameraFragment();
    }
    
    public boolean onTouchEvent(MotionEvent e) {
        return gestureDetector.onTouchEvent(e);
    }
    

    public class GestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }
        
        @Override
        public void onLongPress(MotionEvent e) {
        	float x = e.getX();
            float y = e.getY();
            Log.d("Long Tap", "Tapped at: (" + x + "," + y + ")");
        	
        }
        // event when double tap occurs
        @Override
        public boolean onDoubleTap(MotionEvent e) {
        	
        	FragmentManager manager = getSupportFragmentManager();
        	manager.beginTransaction().replace(R.id.fragmentContainer, new GalleryFragment()).commit();
        	float x = e.getX();
            float y = e.getY();
            Log.d("Double Tap", "Tapped at: (" + x + "," + y + ")");

            return true;
        }
    }

}
