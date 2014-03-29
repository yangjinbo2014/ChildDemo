package com.child.server;

import java.io.IOException;
import java.util.HashMap;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;

public class SoundManager
{
    private Context context;
    
    private SoundPool pool;
    
    public HashMap<String, Integer> soundMap = new HashMap<>();
    
    public SoundManager(Context context)
    {
        this.context = context;
        pool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
        pool.setOnLoadCompleteListener(new OnLoadCompleteListener()
        {
            
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status)
            {
                System.out.println("º”‘ÿÕÍ≥… : " + sampleId + "//" + status);
            }
        });
        
        addSound("1.mp3", 1);
        addSound("2.mp3", 2);
        addSound("3.mp3", 3);
    }
    
    public void addSound(String fileName, int key)
    {
        try
        {
            pool.load(context.getAssets().openFd(fileName), key);
            soundMap.put(fileName, (Integer)key);
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
