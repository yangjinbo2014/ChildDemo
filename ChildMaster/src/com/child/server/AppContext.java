package com.child.server;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

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
    
    private UserManager userManager = null;
    
    private ArrayList<String> packetList = null;
    
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
                }
            }
        }
        return instance;
    }
    
    public void initAppContext()
    {
        soundManager = new SoundManager(context);
        userManager = new UserManager();
        getInstallPacketList();
    }
    
    public void destoryAppContext()
    {
        soundManager.destorySoundManager();
        this.context = null;
        instance = null;
    }
    
    private ArrayList<String> getInstallPacketList()
    {
        List<PackageInfo> info = getContext().getPackageManager().getInstalledPackages(PackageManager.GET_ACTIVITIES);
        packetList = new ArrayList<>();
        for (PackageInfo item : info)
        {
            packetList.add(item.packageName);
        }
        
        return packetList;
    }
    
    public boolean isInstallPacket(String pkt)
    {
        return getInstallPacketList().contains(pkt);
    }
    
}
