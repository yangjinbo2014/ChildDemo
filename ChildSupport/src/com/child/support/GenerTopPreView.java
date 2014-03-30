package com.child.support;

import android.content.Context;
import android.view.LayoutInflater;

import com.child.support.impl.BaseView;
import com.childsupport.R;

/**
 * 顶部按钮统一实现<br>
 * 
 * @author Owen
 * 
 */
public class GenerTopPreView extends BaseView
{
    private Context context = null;
    
    public GenerTopPreView(Context context)
    {
        this.context = context;
        setView(LayoutInflater.from(context).inflate(R.layout.gener_top_pre_view, null));
    }
    
}
