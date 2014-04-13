package com.example.childplant.statusbar;

import java.text.DateFormatSymbols;
import java.util.Calendar;

import com.example.childplant.R;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.format.DateFormat;
import android.view.View;
import android.webkit.WebView.FindListener;
import android.widget.TextView;

public class StatusBarController {
	public final static String TAG = "StatusBarControl";

	public final static int UPDATE_TIME = 1;

	public final static int UPDATE_USER = 2;

	public final static int UPDATE_BATTERY = 3;

	public final static int RESERVED = 0;

	private Context mContext;

	private View mView;

	private TextView userName;

	private TextView userBean;

	private View batteryView;

	private TextView curTime;

	private BatteryController mBatteryControl;

	private TimeUpdate mTimeUpdate;

	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case UPDATE_TIME:
				refreshTime();
				break;
			case UPDATE_USER:
				refreshUserInfo();
				break;
			case UPDATE_BATTERY:
			default:
				break;
			}

		}
	};

	public StatusBarController(Context context, View view) {
		mContext = context;
		mView = view;
	}

	public void onCreate() {
		initTimeUpdate();
		initBatteryControl();
		initUserInfo();
	}

	public void onResume() {
		mTimeUpdate.timeStart();
		mBatteryControl.Start();
	}

	public void onPase() {
		mTimeUpdate.timeStop();
		mBatteryControl.Stop();
	}

	public void onStop() {

	}

	private void initTimeUpdate() {
		curTime = (TextView) mView.findViewById(R.id.system_time);
		mTimeUpdate = new TimeUpdate(mContext, curTime);
	}

	private void initBatteryControl() {
		batteryView = mView.findViewById(R.id.battery_info);
		mBatteryControl = new BatteryController(mContext, batteryView);
	}

	private void initUserInfo() {
		userName = (TextView) mView.findViewById(R.id.user_name);
		userBean = (TextView) mView.findViewById(R.id.user_bean_num);
	}

	public void refreshUserInfo() {

	}

	public void refreshTime() {
		mTimeUpdate.updateTime();
	}

	public void refreshBattery() {
		mBatteryControl.updateBattery();
	}

}
