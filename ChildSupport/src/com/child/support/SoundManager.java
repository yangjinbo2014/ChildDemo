package com.child.support;

import java.io.IOException;
import java.util.HashMap;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

/**
 * Sound����������<br>
 * 
 * @author Owen
 * 
 */
public class SoundManager
{
    private Context context;
    
    private SoundPool pool;
    
    public HashMap<String, Integer> soundMap = new HashMap<>();
    
    public int keyCount = 1;
    
    public SoundManager(Context context)
    {
        setContext(context);
        pool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
    }
    
    public void setContext(Context context)
    {
        this.context = context;
    }
    
    public void addSound(String fileName)
    {
        try
        {
            pool.load(context.getAssets().openFd(fileName), keyCount);
            soundMap.put(fileName, (Integer)keyCount);
            keyCount++;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public void playSound(String fileName)
    {
        if (soundMap.containsKey(fileName))
        {
            pool.play(soundMap.get(fileName), 1, 1, 0, 0, 1);
        }
    }
    
    public void stopSound(String fileName)
    {
        pool.stop(soundMap.get(fileName));
    }
    
    public void destorySoundManager()
    {
        
    }
    
}
