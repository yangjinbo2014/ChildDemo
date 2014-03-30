package com.child.activity;

import android.content.Context;
import android.view.LayoutInflater;

import com.child.R;
import com.child.generui.BaseView;

public class PageMidView extends BaseView
{
    public PageMidView(Context context)
    {
        setView(LayoutInflater.from(context).inflate(R.layout.page_mid_view, null));
    }
}
