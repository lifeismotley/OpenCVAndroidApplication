package com.example.camera_application;

import android.os.Bundle;

import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends SingleFragmentActivity {// implements OnGesturePerformedListener {
	GestureDetector gestureDetector;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        // hide the window title.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // hide the status bar and other OS-level chrome
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        gestureDetector = new GestureDetector(this, new GestureListener());
        super.onCreate(savedInstanceState);
    }
    
    @Override
    protected Fragment createFragment() {
    	
        return new CameraFragment();
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        return gestureDetector.onTouchEvent(e);
    }


    private class GestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }
        // event when double tap occurs
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            float x = e.getX();
            float y = e.getY();

            Log.d("Double Tap", "Tapped at: (" + x + "," + y + ")");

            return true;
        }
    }
    
}
