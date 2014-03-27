package com.child.generui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.child.R;

/**
 * ͨ�ö������ܰ�ť��<br>
 * ��ʾͳһ�Ĺ�����������Intent�¼��ĵ���<br>
 * 
 * @author Owen
 * 
 */
public class GenerTopSelectView
{
    private View view;
    
    private Button btn1, btn2;
    
    private TextView tv;
    
    public GenerTopSelectView(Context context)
    {
        view = LayoutInflater.from(context).inflate(R.layout.gener_top_select_view, null);
        
        btn1 = (Button)view.findViewById(R.id.button1);
        btn2 = (Button)view.findViewById(R.id.button2);
        tv = (TextView)view.findViewById(R.id.textView1);
    }
    
    public void setTittle(String s)
    {
        tv.setText(s);
    }
    
    public void setLeftOnClickListener(android.view.View.OnClickListener onClickListener)
    {
        btn1.setOnClickListener(onClickListener);
    }
    
    public void setRightOnClickListener(android.view.View.OnClickListener onClickListener)
    {
        btn2.setOnClickListener(onClickListener);
    }
    
    public void setLeftButtonText(String s)
    {
        btn1.setText(s);
    }
    
    public void setRightButtonText(String s)
    {
        btn2.setText(s);
    }
    
    public View getView()
    {
        return view;
    }
    
}
