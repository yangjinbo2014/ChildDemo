package com.child.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.child.R;
import com.child.server.AppContext;
import com.child.server.CCoreService;

public class MainActivity extends Activity
{
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        AppContext.getInstance().setContext(getApplicationContext());
        AppContext.getInstance().initAppContext();
        
        startService(new Intent(MainActivity.this, CCoreService.class));
        
        if (AppContext.getInstance().isInstallPacket("com.android.onetimeinitializer"))
        {
            Toast.makeText(getApplicationContext(), "com.android.onetimeinitializer", Toast.LENGTH_LONG).show();
        }
        
        initView();
        
        refreshChildPacketState();
    }
    
    private void initView()
    {
        ((LinearLayout)findViewById(R.id.main_page_horizontalScrollView_linear)).addView(new PageLeftView(
            getApplicationContext()).getView());
        ((LinearLayout)findViewById(R.id.main_page_horizontalScrollView_linear)).addView(new PageMidView(
            getApplicationContext()).getView());
        ((LinearLayout)findViewById(R.id.main_page_horizontalScrollView_linear)).addView(new PageRightView(
            getApplicationContext()).getView());
    }
    
    private void refreshChildPacketState()
    {
        
    }
}
