package com.child.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.child.AppContext;
import com.child.activity.animal.AnimalActivity;
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
        
        // ImageView imageView = new ImageView(this);
        // try
        // {
        // imageView.setImageBitmap(BitmapFactory.decodeStream(getAssets().open("demo.jpeg")));
        // }
        // catch (IOException e)
        // {
        // e.printStackTrace();
        // }
        //
        // GenerDialog dialog = new GenerDialog(this);
        // dialog.setContentView(imageView);
        // dialog.show();
        
        ((Button)findViewById(R.id.button_play)).setOnClickListener(new OnClickListener()
        {
            
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, AnimalActivity.class);
                startActivity(intent);
            }
        });
        
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
        
    }
    
}
