package com.example.childplant.statusbar;

import java.util.Calendar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;

public class TimeUpdate {

	private Context mContext;
	
	private Calendar mCalendar;
	
	private TextView clock;

	private boolean mStart = false;

	public TimeUpdate(Context context, TextView view) {
		mContext = context;
		clock = view;
		mCalendar = Calendar.getInstance();
	}

	private final BroadcastReceiver mIntentReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            updateTime();
        }
    };

	
	public void timeStart() {
		if (!mStart) {
			mStart = true;
			IntentFilter filter = new IntentFilter();
			filter.addAction(Intent.ACTION_TIME_TICK);
			filter.addAction(Intent.ACTION_CONFIGURATION_CHANGED);
			mContext.registerReceiver(mIntentReceiver, filter, null,
					null);
		}
		updateTime();
	}

	protected void timeStop() {
		if (mStart) {
			mContext.unregisterReceiver(mIntentReceiver);
			mStart = false;
		}
	}

	public void updateTime() {
        mCalendar.setTimeInMillis(System.currentTimeMillis());

        boolean b24 = DateFormat.is24HourFormat(mContext);
        String format;
        if (b24) {
        	format = "HH : mm";
        } else {
        	format = "a hh : mm";
        }
    
        clock.setText( DateFormat.format(format, mCalendar));
	}

}
