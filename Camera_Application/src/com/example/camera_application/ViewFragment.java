package com.example.camera_application;

import android.support.v4.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class ViewFragment extends Fragment {
	  @Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
	    View view = inflater.inflate(R.layout.fragment_view, container, false);
	    return view;
	  }
	  
	  public void updateImage(String imgPath) {
		  ImageView jpgView = (ImageView) getActivity().findViewById (R.id.imageView);
		  Bitmap bitmap = BitmapFactory.decodeFile(imgPath);
		  jpgView.setImageBitmap(bitmap);
	  }

}
