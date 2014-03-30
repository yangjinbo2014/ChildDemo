package com.childanimal.ui;

import android.content.Context;
import android.view.LayoutInflater;

import com.child.support.impl.BaseView;
import com.childanimal.R;

public class ChildAnimalView extends BaseView
{
    private Context context = null;
    
    public ChildAnimalView(Context context)
    {
        this.context = context;
        setView(LayoutInflater.from(context).inflate(R.layout.child_animal_view, null));
    }
}
