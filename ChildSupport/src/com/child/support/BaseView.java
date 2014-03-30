package com.child.support;

import android.view.View;

public abstract class BaseView
{
    private View view;
    
    public View getView()
    {
        return view;
    }
    
    public void setView(View view)
    {
        this.view = view;
    }
    
}
