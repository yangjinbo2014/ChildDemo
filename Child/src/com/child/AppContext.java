package com.child;

import android.content.Context;

/**
 * 全局上下文<br>
 * 暂时空，后续有业务的句柄往里面放；
 * 
 * @author Owen
 * 
 */
public class AppContext
{
    private static AppContext instance = null;
    
    private Context context = null;
    
    private SoundManager soundManager = null;
    
    public SoundManager getSoundManager()
    {
        return soundManager;
    }
    
    public void setSoundManager(SoundManager soundManager)
    {
        this.soundManager = soundManager;
    }
    
    public Context getContext()
    {
        return context;
    }
    
    public void setContext(Context context)
    {
        this.context = context;
    }
    
    public static AppContext getInstance()
    {
        /* 双重锁 */
        if (instance == null)
        {
            synchronized (AppContext.class)
            {
                if (instance == null)
                {
                    instance = new AppContext();
                    System.out.println("创建新实例");
                }
            }
        }
        return instance;
    }
    
    public void initAppContext()
    {
        soundManager = new SoundManager(context);
    }
    
    public void destoryAppContext()
    {
        soundManager.destorySoundManager();
        this.context = null;
        instance = null;
    }
    
}
