package com.example.childplant.statusbar;

import java.util.ArrayList;

import com.example.childplant.R;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Handler;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class BatteryController {

	private Handler mHandler;

	private Context mContext;

	private View mView;

	private boolean mStart = false;

	private int mLevel;

	private int mStatus;
	
	private boolean charging;

	private ImageView battery01;
	
	private ImageView battery02;
	
	private ImageView battery03;
	
	private ImageView battery04;
	
	private ArrayList<ImageView> batteryIcon = new ArrayList<ImageView>();
	
	public BatteryController(Context context, View view) {
		mContext = context;
		mView = view;
		battery01 = (ImageView) mView.findViewById(R.id.battery01);
		battery02 = (ImageView) mView.findViewById(R.id.battery02);
		battery03 = (ImageView) mView.findViewById(R.id.battery03);
		battery04 = (ImageView) mView.findViewById(R.id.battery04);
		batteryIcon.add(battery01);
		batteryIcon.add(battery02);
		batteryIcon.add(battery03);
		batteryIcon.add(battery04);
	}

	private final BroadcastReceiver mIntentReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			final String action = intent.getAction();
			if (action.equals(Intent.ACTION_BATTERY_CHANGED)) {
				final int level = intent.getIntExtra(
						BatteryManager.EXTRA_LEVEL, 0);
				final int status = intent.getIntExtra(
						BatteryManager.EXTRA_STATUS,
						BatteryManager.BATTERY_STATUS_UNKNOWN);
				final boolean plugged =  ((intent.getIntExtra(
						BatteryManager.EXTRA_PLUGGED, 
						0) & 0x07) > 0) ;
				
				if (level == mLevel && status == mStatus) {
					return;
				}
				mLevel = level;
				mStatus = status;

				switch (status) {
				case BatteryManager.BATTERY_STATUS_CHARGING:
				case BatteryManager.BATTERY_STATUS_FULL:
					charging = true;
					break;
				}
				if (plugged) {
					charging = true;
				}
			}
			updateBattery();
		}
	};

	public void Start() {
		if (!mStart) {
			mStart = true;
			IntentFilter filter = new IntentFilter();
			filter.addAction(Intent.ACTION_BATTERY_CHANGED);
			mContext.registerReceiver(mIntentReceiver, filter, null, null);
		}
	}

	protected void Stop() {
		if (mStart) {
			mContext.unregisterReceiver(mIntentReceiver);
			mStart = false;
		}
	}

	
	public void updateBattery() {

			int filled = R.drawable.ic_battery_normal;
			int empty = R.drawable.ic_battery_empty;
			int full = R.drawable.ic_battery_full;
			if (charging) {
				filled = R.drawable.ic_battery_charging;
				battery01.setImageResource(filled);
				battery02.setImageResource(filled);
				battery03.setImageResource(filled);
				battery04.setImageResource(filled);
				return;
			}
			
			if (mLevel < 15) {
				battery01.setImageResource(empty);
				battery02.setImageResource(empty);
				battery03.setImageResource(empty);
				battery04.setImageResource(empty);
			} else if (mLevel < 35) {
				battery01.setImageResource(filled);
				battery02.setImageResource(empty);
				battery03.setImageResource(empty);
				battery04.setImageResource(empty);
			} else if (mLevel < 55) {
				battery01.setImageResource(filled);
				battery02.setImageResource(filled);
				battery03.setImageResource(empty);
				battery04.setImageResource(empty);
			} else if (mLevel < 75) {
				battery01.setImageResource(filled);
				battery02.setImageResource(filled);
				battery03.setImageResource(filled);
				battery04.setImageResource(empty);
			} else if (mLevel < 95 ) {
				battery01.setImageResource(filled);
				battery02.setImageResource(filled);
				battery03.setImageResource(filled);
				battery04.setImageResource(filled);
			} else {
				battery01.setImageResource(full);
				battery02.setImageResource(full);
				battery03.setImageResource(full);
				battery04.setImageResource(full);
			}
	}
}
