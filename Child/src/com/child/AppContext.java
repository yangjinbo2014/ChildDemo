package com.child;

import android.content.Context;

/**
 * ȫ��������<br>
 * ��ʱ�գ�������ҵ��ľ��������ţ�
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
        /* ˫���� */
        if (instance == null)
        {
            synchronized (AppContext.class)
            {
                if (instance == null)
                {
                    instance = new AppContext();
                    System.out.println("������ʵ��");
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
