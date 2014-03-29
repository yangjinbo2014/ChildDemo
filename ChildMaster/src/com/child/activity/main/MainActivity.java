package com.child.activity.main;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

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
        
        if (AppContext.getInstance().isInstallPacket("com.android.onetimeinitializer"))
        {
            Toast.makeText(getApplicationContext(), "com.android.onetimeinitializer", Toast.LENGTH_LONG).show();
        }
        
        ((LinearLayout)findViewById(R.id.main_page_horizontalScrollView_linear)).addView(new PageLeftView(
            getApplicationContext()).getView());
        ((LinearLayout)findViewById(R.id.main_page_horizontalScrollView_linear)).addView(new PageMidView(
            getApplicationContext()).getView());
        ((LinearLayout)findViewById(R.id.main_page_horizontalScrollView_linear)).addView(new PageRightView(
            getApplicationContext()).getView());
        
    }
}
