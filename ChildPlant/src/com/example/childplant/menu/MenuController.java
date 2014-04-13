package com.example.childplant.menu;

import java.util.ArrayList;

import com.example.childplant.R;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MenuController {
	private Context mContext;
	private View mView;
	private ImageButton backBtn;
	private LinearLayout mMenuContent;
	private boolean showing = true;
	private ImageButton functionBtnC1;
	private ImageButton functionBtnC2;
	private ImageButton functionBtnC3;
	private ImageButton functionBtnC4;
	private ImageButton functionBtnC5;
	private ImageButton functionBtnC6;
	private ImageButton functionBtnC7;
	private ImageButton functionBtnC8;
	private ImageButton functionBtnC9;
	private ImageButton functionBtnC10;
	private ArrayList<ImageButton> expandFunctionList;
	private MarginLayoutParams mlp;
	
	private OnClickListener mListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if (v == backBtn) {
				showMenu(false);
			} else if (v == functionBtnC1) {

			} else if (v == functionBtnC2) {

			} else if (v == functionBtnC3) {

			} else if (v == functionBtnC4) {

			} else if (v == functionBtnC5) {

			} else if (v == functionBtnC6) {

			} else if (v == functionBtnC7) {

			} else if (v == functionBtnC8) {

			} else if (v == functionBtnC9) {

			} else if (v == functionBtnC10) {

			}
		}
	};

	public MenuController(Context context, View view) {
		mContext = context;
		mView = view;
		expandFunctionList = new ArrayList<ImageButton>();
		mMenuContent = (LinearLayout) mView.findViewById(R.id.function_content);
		backBtn = (ImageButton)mView.findViewById(R.id.back_button);
		functionBtnC1 = (ImageButton) mView
				.findViewById(R.id.function_button_c1);
		functionBtnC2 = (ImageButton) mView
				.findViewById(R.id.function_button_c2);
		functionBtnC3 = (ImageButton) mView
				.findViewById(R.id.function_button_c3);
		functionBtnC4 = (ImageButton) mView
				.findViewById(R.id.function_button_c4);
		functionBtnC5 = (ImageButton) mView
				.findViewById(R.id.function_button_c5);
		functionBtnC6 = (ImageButton) mView
				.findViewById(R.id.function_button_c6);
		functionBtnC7 = (ImageButton) mView
				.findViewById(R.id.function_button_c7);
		functionBtnC8 = (ImageButton) mView
				.findViewById(R.id.function_button_c8);
		functionBtnC9 = (ImageButton) mView
				.findViewById(R.id.function_button_c9);
		functionBtnC10 = (ImageButton) mView
				.findViewById(R.id.function_button_c10);

		backBtn.setOnClickListener(mListener);
		functionBtnC1.setOnClickListener(mListener);
		functionBtnC2.setOnClickListener(mListener);
		functionBtnC3.setOnClickListener(mListener);
		functionBtnC4.setOnClickListener(mListener);
		functionBtnC5.setOnClickListener(mListener);
		functionBtnC6.setOnClickListener(mListener);
		functionBtnC7.setOnClickListener(mListener);
		functionBtnC8.setOnClickListener(mListener);
		functionBtnC9.setOnClickListener(mListener);
		functionBtnC10.setOnClickListener(mListener);

	}
	
	public void addFunctionButton(ImageButton btn){
		expandFunctionList.add(btn);
		
	}

	public void showMenu(boolean show) {
		showing = show;
		if (show) {
			mView.setVisibility(View.VISIBLE);
		} else {
			mView.setVisibility(View.GONE);
		}
	}

}
