package com.child.activity;

import android.content.Context;
import android.view.LayoutInflater;

import com.child.R;
import com.child.generui.BaseView;

public class PageLeftView extends BaseView
{
    public PageLeftView(Context context)
    {
        setView(LayoutInflater.from(context).inflate(R.layout.page_left_view, null));
    }
}
