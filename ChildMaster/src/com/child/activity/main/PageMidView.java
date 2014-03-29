package com.child.activity.main;

import android.content.Context;
import android.view.LayoutInflater;

import com.child.generui.BaseView;
import com.example.child.R;

public class PageMidView extends BaseView
{
    public PageMidView(Context context)
    {
        setView(LayoutInflater.from(context).inflate(R.layout.page_mid_view, null));
    }
}
