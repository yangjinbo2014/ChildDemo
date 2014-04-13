package com.example.childplant;

import com.example.childplant.R;
import com.example.childplant.fly.FlyControl;
import com.example.childplant.menu.MenuController;
import com.example.childplant.statusbar.BatteryController;
import com.example.childplant.statusbar.StatusBarController;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;


public class ChildPlantActivity extends Activity
{
	FlyControl flyControl;
	ImageView catchButton;
	ImageView againButton;
	View mFlyView;
	StatusBarController statusBar;
	MenuController menuController;
	View statusBarView;
	View functionMenu;
	
	public static int WIDTH = 800;
	public static int HEIGHT = 480;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        initFly();
        setContentView(R.layout.sub_main);
        statusBarView = findViewById(R.id.status_bar_view);
        functionMenu = findViewById(R.id.functions_menu_view);
        menuController = new MenuController(this, functionMenu);
        statusBar = new StatusBarController(this, statusBarView);

        statusBar.onCreate();
    }
    
    private void initFly(){
        setContentView(R.layout.activity_child_plant);
        catchButton = (ImageView) findViewById(R.id.catch_button);
        catchButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
					flyControl.flyCatch();
			}
		});
        
        againButton = (ImageView) findViewById(R.id.again_button);
        againButton.setOnClickListener(new OnClickListener() {
        	
			@Override
			public void onClick(View v) {
					flyControl.flyStart();
			}
		});
        FrameLayout view = (FrameLayout)findViewById(R.id.fly_region);
        mFlyView = new View(this);
        flyControl = new FlyControl(this,mFlyView, WIDTH, HEIGHT);
//        setContentView(flyView);
        view.addView(mFlyView, WIDTH, HEIGHT);
        flyControl.setDuration(30);
        flyControl.setFlySpeed(32);
        int flag = View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
//        android.provider.Settings.System.putInt(getContentResolver(), "status_bar_auto_hide", 1);
        getWindow().getDecorView().setSystemUiVisibility(flag);
    }
    
    @Override
    public void onResume(){
    	super.onResume();
    	statusBar.onResume();
//    	flyControl.flyStart();
    }
    
    @Override
    public void onPause() {
    	super.onPause();
    	statusBar.onPase();
//    	flyControl.flyStop();
    }
    
}
