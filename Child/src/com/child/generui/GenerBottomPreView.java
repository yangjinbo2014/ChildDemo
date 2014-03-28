package com.child.generui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.child.server.AppContext;
import com.example.child.R;

/**
 * ͨ�õ��������������<br>
 * ���������ĳ�ʼ�������ϵĶ�����ʾ��������ݣ��������趨<br>
 * 
 * @author Owen
 * 
 */
public class GenerBottomPreView extends BaseView
{
    private Context context;
    
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
                AppContext.getInstance().getSoundManager().stopSound("1.mp3");
                getView().setVisibility(View.GONE);
            }
        });
    }
    
    /**
     * ������������λ������
     * 
     * @param isLeft
     */
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
    
    /**
     * ����������Դ
     * 
     * @param res
     */
    public void setPersonImage(int res)
    {
        ((RelativeLayout)getView().findViewById(R.id.relativeLayout_person_are)).setBackgroundResource(res);
    }
    
    /**
     * ������������
     * 
     * @param s
     */
    public void setPersonName(String s)
    {
        TextView textView = (TextView)getView().findViewById(R.id.textView_person_name);
        textView.setText(s);
    }
    
    /**
     * ���ý����ı�
     * 
     * @param s
     */
    public void setIntroduceStr(String s)
    {
        TextView textView = (TextView)getView().findViewById(R.id.textView_context);
        textView.setText(s);
    }
    
}
