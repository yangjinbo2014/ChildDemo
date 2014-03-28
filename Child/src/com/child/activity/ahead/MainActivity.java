package com.child.activity.ahead;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.child.server.AppContext;
import com.example.child.R;

public class MainActivity extends Activity
{
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        /* 初始化全局上下文及句柄 */
        AppContext.getInstance().setContext(getApplicationContext());
        AppContext.getInstance().initAppContext();
        
        ((LinearLayout)findViewById(R.id.main_page_horizontalScrollView_linear)).addView(new PageLeftView(
            getApplicationContext()).getView());
        ((LinearLayout)findViewById(R.id.main_page_horizontalScrollView_linear)).addView(new PageMidView(
            getApplicationContext()).getView());
        ((LinearLayout)findViewById(R.id.main_page_horizontalScrollView_linear)).addView(new PageRightView(
            getApplicationContext()).getView());
        
        // ((Button)findViewById(R.id.button_play)).setOnClickListener(new OnClickListener()
        // {
        //
        // @Override
        // public void onClick(View v)
        // {
        // Intent intent = new Intent();
        // intent.setClass(MainActivity.this, AnimalActivity.class);
        // startActivity(intent);
        // }
        // });
        
    }
}
