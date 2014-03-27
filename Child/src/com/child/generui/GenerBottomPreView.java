package com.child.generui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.child.AppContext;
import com.example.child.R;

/**
 * 通用的人物出场介绍类<br>
 * 包括语音的初始化，向上的动画显示，人物，内容，语音的设定<br>
 * 
 * @author Owen
 * 
 */
public class GenerBottomPreView
{
    private View view;
    
    private Context context;
    
    public GenerBottomPreView(Context context)
    {
        this.context = context;
        view = LayoutInflater.from(context).inflate(R.layout.gener_bottom_pre_view, null);
        
        ((Button)view.findViewById(R.id.button_skip)).setOnClickListener(new OnClickListener()
        {
            
            @Override
            public void onClick(View v)
            {
                AppContext.getInstance().getSoundManager().stopSound("1.mp3");
                view.setVisibility(View.GONE);
            }
        });
        
    }
    
    public void setPersonPosition(boolean isLeft)
    {
        if (isLeft)
        {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(300, 500);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            view.findViewById(R.id.relativeLayout_person_are).setLayoutParams(layoutParams);
        }
        else
        {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(300, 500);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            view.findViewById(R.id.relativeLayout_person_are).setLayoutParams(layoutParams);
        }
    }
    
    public void setPersonImage()
    {
        
    }
    
    public void setPersonName(String s)
    {
        TextView textView = (TextView)view.findViewById(R.id.textView_person_name);
        textView.setText(s);
    }
    
    public void setIntroduceStr(String s)
    {
        TextView textView = (TextView)view.findViewById(R.id.textView_context);
        textView.setText(s);
    }
    
    public View getView()
    {
        return view;
    }
    
}
