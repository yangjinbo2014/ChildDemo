package com.child.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class CCoreService extends Service
{
    
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }
    
    @Override
    public void onCreate()
    {
        super.onCreate();
    }
    
    @Override
    @Deprecated
    public void onStart(Intent intent, int startId)
    {
        super.onStart(intent, startId);
    }
    
    @Override
    public void onDestroy()
    {
        super.onDestroy();
    }
    
    @Override
    public boolean onUnbind(Intent intent)
    {
        return super.onUnbind(intent);
    }
    
}
