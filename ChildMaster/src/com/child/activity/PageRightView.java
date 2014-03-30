package com.child.activity;

import android.content.Context;
import android.view.LayoutInflater;

import com.child.R;
import com.child.generui.BaseView;

public class PageRightView extends BaseView
{
    public PageRightView(Context context)
    {
        setView(LayoutInflater.from(context).inflate(R.layout.page_right_view, null));
    }
}
