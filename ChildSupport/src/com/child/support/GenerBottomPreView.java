package com.child.support;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.childsupport.R;

/**
 * @author Owen
 * 
 */
public class GenerBottomPreView extends BaseView
{
    private Context context = null;
    
    public GenerBottomPreView(Context context)
    {
        this.context = context;
        setView(LayoutInflater.from(context).inflate(R.layout.gener_bottom_pre_view, null));
        
        initListener();
    }
    
    public void initListener()
    {
        ((Button)getView().findViewById(R.id.button_skip)).setOnClickListener(new OnClickListener()
        {
            
            @Override
            public void onClick(View v)
            {
                getView().setVisibility(View.GONE);
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
            getView().findViewById(R.id.relativeLayout_person_are).setLayoutParams(layoutParams);
        }
        else
        {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(300, 500);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            getView().findViewById(R.id.relativeLayout_person_are).setLayoutParams(layoutParams);
        }
    }
    
    public void setPersonImage(int res)
    {
        ((RelativeLayout)getView().findViewById(R.id.relativeLayout_person_are)).setBackgroundResource(res);
    }
    
    public void setPersonName(String s)
    {
        TextView textView = (TextView)getView().findViewById(R.id.textView_person_name);
        textView.setText(s);
    }
    
    public void setIntroduceStr(String s)
    {
        TextView textView = (TextView)getView().findViewById(R.id.textView_context);
        textView.setText(s);
    }
    
}
