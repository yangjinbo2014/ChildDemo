package com.childplant;

import java.util.ArrayList;
import java.util.Random;

import com.example.childplant.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

public class FlyControl {

	public static String TAG = "FlyControl";

	private Context mContext;

	private Paint mPaint;

	private Canvas mCanvas;

	private Bitmap fly01;

	private Bitmap fly02;

	private Bitmap myBitmap;

	private Bitmap mBG;

	private View mView;
	
	private int mDuration;

	private boolean mFlowerEnbale = false;

	private boolean mFlyEnable = false;

	private Thread mThread;

	private ArrayList<FlyPosition> flyLine;

	private boolean running = false;
	
	private int mWidth = 800;
	private int mHeight = 480;

	private FlyPosition defaultStartPos = new FlyPosition(800, 360);
	
	int left;
	int right;
	int top;
	int bottom;

	int mLastPositionX = 0;
	int mLastPositionY = 0;
	int mSpeed = 32;
	int flowerFrameCount = 0;

	private static int startUI = 1001;
	private static int stopUI = 1002;
	private static int stopFly = 1003;

	boolean moveLeft = true;
	boolean moveBottom = true;
	
	int curDirect;
	int curPosition;

	Random random = new Random(Integer.MAX_VALUE);

	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (msg.what == startUI) {
				updateUI();
			} else if (msg.what == stopUI) {
				stopUI();
			} else if (msg.what == stopFly) {
				enableFly(false);
			}
		}
	};

	public FlyControl(Context context) {
		this(context, null, 0, 0);
	}
	
	public FlyControl(Context context,View view, int width, int height) {
		mContext = context;
		mView = view;
		mCanvas = new Canvas();
		mPaint = new Paint(Paint.FILTER_BITMAP_FLAG | Paint.DITHER_FLAG);

		fly01 = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.fly01);

		fly02 = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.fly02);

		mBG = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.bg);

		myBitmap = Bitmap
				.createBitmap(mWidth, mHeight, Bitmap.Config.ARGB_8888);

		mCanvas.setBitmap(myBitmap);
		right = mWidth;
		bottom = mHeight;
		mLastPositionX = defaultStartPos.x;
		mLastPositionY = defaultStartPos.y;
	}

	public void setDuration(int duration) {
		mDuration = duration;
	}

	public void setFlySpeed(int speed) {
		mSpeed = speed;
	}

	int num = 0;
	int offset = 0x0F;

	private void updateFlower() {
		if (mFlowerEnbale) {
			mCanvas.drawColor(Color.BLACK);
			offset = offset << 4;
			Log.v(TAG, "color" + (Color.BLACK | offset));
			flowerFrameCount++;
			if (flowerFrameCount > 8) {
				mFlowerEnbale = false;
				offset = 0x0F;
				flowerFrameCount = 0;
			}
		} else {
			mCanvas.drawBitmap(mBG, 0, 0, mPaint);
		}

	}

	private void updateFly() {
		if (!mFlyEnable) {
			return;
		}

		getNewPosition();
		if ((num % 2) == 0) {
			Log.e("yangjinbo", "fly01" + fly01);
			mCanvas.drawBitmap(fly01, mLastPositionX, mLastPositionY, mPaint);
		} else {
			Log.e("yangjinbo", "fly02" + fly02);
			mCanvas.drawBitmap(fly02, mLastPositionX, mLastPositionY, mPaint);
		}
	}

	public void updateUI() {
		num++;
		updateFlower();
		updateFly();
//		mCanvas.drawColor(Color.RED);
		Log.e("yangjinbo", "update :" + num);
		mView.setBackground(new BitmapDrawable(myBitmap));
		Log.e("yangjinbo", "position X:" + mLastPositionX + " Y:"
				+ mLastPositionY);

		if (!mFlowerEnbale && !mFlyEnable) {
			flyStop();
		}
	}

	public void enableFlower(boolean enable) {
		mFlowerEnbale = enable;
		if (!running) {
			start();
		}
	}

	public void enableFly(boolean enable) {
		mFlyEnable = enable;
		if (!running) {
			start();
		}
	}

	private void stopUI() {
		mCanvas.drawBitmap(mBG, 0, 0, mPaint);
		mView.setBackground(new BitmapDrawable(myBitmap));
	}

	public boolean isRunning() {
		return running;
	}

	private void getNewPosition() {
		if (flyLine != null) {
			mLastPositionX = flyLine.get(curPosition).x;
			mLastPositionY = flyLine.get(curPosition).y;
		} else {
			getRandomPosition(mSpeed);
		}
	}
	
	private void getRandomPosition(int speed) {
		int moveX = Math.abs(random.nextInt() % speed);
		int moveY = Math.abs(random.nextInt() % speed) / 2;
		int X = mLastPositionX + moveX;
		int Y = mLastPositionY + moveY;

		if (moveLeft) {
			X = mLastPositionX - moveX;

		} else {
			X = mLastPositionX + moveX;
		}

		Y = mLastPositionY - moveY;
		if (Y < top + 100 || Y > bottom + 100) {
			Y = mLastPositionY + 2 * moveY;
		}

		if (X < left) {
			moveLeft = false;
		}
		if (X > right) {
			Log.v(TAG, "X"+X + "right" + right);
			mFlyEnable = false;
		}

		mLastPositionX = X;
		mLastPositionY = Y;
	}



	public void start() {
		if (running) {
			return;
		}
		Log.v(TAG, "start fly!");
		mThread = new Thread("fly") {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(mDuration);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (running) {
						// update();
						mHandler.sendEmptyMessage(startUI);
					} else {
						break;
					}
				}
			}
		};
		running = true;
		mThread.start();
	}

	public void stop() {
		mHandler.sendEmptyMessage(stopUI);
	}

	boolean catching = false;
	
	int catchRegionLeft =200;
	int catchRegionRight= 600;
	int catchRegionTop = 100;
	int catchRegionBottom = 400;
	
	
	public void setCatchRegion(int left, int top, int right, int bottom){
	
	}
	

	public void flyStart() {
		mFlyEnable=true;
		mLastPositionX = defaultStartPos.x;
		mLastPositionY = defaultStartPos.y;
		moveLeft = true;
		start();
	}

	public void flyStop() {
		Log.v(TAG, "stop fly!");
		running = false;
		mFlyEnable = false;
		mFlowerEnbale = false;
		mThread = null;
		curDirect = 0;
		stop();
	}

	public boolean flyCatch() {
		if (mFlowerEnbale)
		{
			return false;
		}
		enableFlower(true);
		
		if (mLastPositionX > catchRegionLeft && mLastPositionX < catchRegionRight)
		{
			mHandler.sendEmptyMessageDelayed(stopFly, mDuration*4);
		}
		return false;
		
	}

	public void setFlyLine(ArrayList<FlyPosition> line) {
		flyLine = line;
	}
	
	public static interface Callback {
		public void finishFly();
	}
}
