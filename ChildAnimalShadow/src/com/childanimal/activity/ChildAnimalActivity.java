package com.childanimal.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.child.support.GenerBottomPreView;
import com.child.support.GenerTopPreView;
import com.child.support.SoundManager;
import com.childanimal.R;
import com.childanimal.ui.ChildAnimalView;

/**
 * @author Owen
 * 
 */
public class ChildAnimalActivity extends Activity
{
    public SoundManager soundManager = null;
    
    public GenerBottomPreView bottomPreView = null;
    
    public GenerTopPreView topPreView = null;
    
    public ChildAnimalView animalView = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_animal);
        
        /* Sound */
        initSound();
        
        /* View */
        initView();
        
    }
    
    private void initView()
    {
        /* 初始化SKIP */
        bottomPreView = new GenerBottomPreView(getApplicationContext());
        ((RelativeLayout)findViewById(R.id.bottom_are)).addView(bottomPreView.getView());
        bottomPreView.setPersonImage(R.drawable._2);
        bottomPreView.setPersonName("都教授");
        bottomPreView.setIntroduceStr("让我们来猜猜这些影子吧");
        
        /* 初始化主体 */
        animalView = new ChildAnimalView(getApplicationContext());
        ((RelativeLayout)findViewById(R.id.body_are)).addView(animalView.getView());
        
        /* 初始化顶部 */
        topPreView = new GenerTopPreView(getApplicationContext());
        ((RelativeLayout)findViewById(R.id.top_are)).addView(topPreView.getView());
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
