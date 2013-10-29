package com.example.camera_application;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;


public class GalleryFragment extends Fragment implements OnItemClickListener{
	private String dir="/mnt/sdcard/DCIM/Camera";
	private List<String> item = null;
	private GridView lv1;
	GestureDetector gestureDetector;
	ViewChangedListener listener;
	//private List<String> path = null;
	
//	public interface ViewChangedListener {
//		public void viewChanged(String message);
//	}
//	
//	public void onAttach(Activity activity){
//		super.onAttach(activity);
//		if (activity instanceof ViewChangedListener){
//			listener = (ViewChangedListener) activity;
//		} else {
//			throw new ClassCastException(activity.toString());
//		}
//	}
	
	public interface ViewChangedListener {
		public void viewChanged(String message);	
		}
	
	public void updateView(String message) {
		listener.viewChanged(message);		
		}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
	    View view = inflater.inflate(R.layout.fragment_gallery, container, false);
//	    GridView gridView = (GridView) view.findViewById(R.id.photogridview);
//        gridView.setAdapter(new ImageAdapter(view.getContext()))
//      
	    item = new ArrayList<String>();
	    File f = new File(dir);
	    File[] files = f.listFiles();
	    
	    for(int i=0; i < files.length; i++)
	    {
	      File file = files[i];
	      item.add(file.getName());
	      Log.d("FILE NAME: ", file.getName());
	    }
	    
	    lv1 = (GridView) view.findViewById(R.id.gallery_view);
	    lv1.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
				Log.d("Clicked Item", "Click!");
				FragmentManager manager = getActivity().getSupportFragmentManager();
	        	//manager.beginTransaction().replace(R.id.fragmentContainer, manager.findFragmentById(R.id.imageView)).commit();//new ViewFragment()).commit();
	        	manager.beginTransaction().replace(R.id.fragmentContainer, new ViewFragment()).commit();
			}
	    });
	    
	    ArrayAdapter<String> fileList = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1 , item);
	    lv1.setAdapter(fileList);
	    return view;
	 }

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		//ViewFragment viewFragment = (ViewFragment) getFragmentManager().findFragmentById(R.id.imageView);
		// TODO Auto-generated method stub
		
	}
    public boolean onTouchEvent(MotionEvent e) {
        return gestureDetector.onTouchEvent(e);
    }
	 
}
