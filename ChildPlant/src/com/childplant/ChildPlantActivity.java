package com.childplant;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.childplant.R;

public class ChildPlantActivity extends Activity
{
	FlyView flyView;
	ImageView catchButton;
	ImageView againButton;
	
	public static int WIDTH = 800;
	public static int HEIGHT = 480;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_plant);
        FrameLayout view = (FrameLayout)findViewById(R.id.fly_region);
        flyView = new FlyView(this, WIDTH, HEIGHT);
//        setContentView(flyView);
        view.addView(flyView);
        flyView.setDuration(30);
        flyView.setFlySpeed(32);
        catchButton = (ImageView) findViewById(R.id.catch_button);
        catchButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
					flyView.FlyCatch();
			}
		});
        
        againButton = (ImageView) findViewById(R.id.again_button);
        againButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
					flyView.FlyStart();
			}
		});
    }
    
    
    @Override
    public void onResume(){
    	super.onResume();
    	flyView.FlyStart();
    }
    
    @Override
    public void onPause() {
    	super.onPause();
    	flyView.FlyStop();
    }
    
}
