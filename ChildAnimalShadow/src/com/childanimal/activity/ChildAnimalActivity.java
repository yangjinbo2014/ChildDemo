package com.childanimal.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.child.support.GenerBottomPreView;
import com.child.support.SoundManager;
import com.childanimal.R;

/**
 * @author Owen
 * 
 */
public class ChildAnimalActivity extends Activity
{
    public SoundManager soundManager = null;
    
    public GenerBottomPreView bottomPreView = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_animal);
        
        /* 初始化SKIP */
        bottomPreView = new GenerBottomPreView(getApplicationContext());
        ((RelativeLayout)findViewById(R.id.bottom_are)).addView(bottomPreView.getView());
        
        /* Sound */
        initSound();
        
    }
    
    /**
     * 初始化声音<br>
     * 将本模块需要的多个音频资源从assets中读取<br>
     * 暂时由外部控制，达到解耦<br>
     */
    private void initSound()
    {
        soundManager = new SoundManager(getApplicationContext());
        soundManager.addSound("1.mp3");
        soundManager.playSound("1.mp3");
    }
}
