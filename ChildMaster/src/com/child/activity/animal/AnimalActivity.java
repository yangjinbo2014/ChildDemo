package com.child.activity.animal;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.child.generui.GenerBottomPreView;
import com.child.generui.GenerTopSelectView;
import com.child.server.AppContext;
import com.example.child.R;

public class AnimalActivity extends Activity
{
    public GenerBottomPreView bottomPreView;
    
    public GenerTopSelectView topSelectView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
        
        System.out.println("=====================================");
        
        topSelectView = new GenerTopSelectView(this);
        bottomPreView = new GenerBottomPreView(this);
        
        bottomPreView.setPersonPosition(true);
        
        ((RelativeLayout)findViewById(R.id.animal_top_are)).addView(topSelectView.getView());
        ((RelativeLayout)findViewById(R.id.animal_bottom_are)).addView(bottomPreView.getView());
        
        AppContext.getInstance().getSoundManager().playSound("3.mp3");
    }
    
}
