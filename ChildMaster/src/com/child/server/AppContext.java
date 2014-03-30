package com.child.server;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * 
 * @author Owen
 * 
 */
public class AppContext
{
    private static AppContext instance = null;
    
    private Context context = null;
    
    private UserManager userManager = null;
    
    private ArrayList<String> packetList = null;
    
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
        userManager = new UserManager();
        getInstallPacketList();
    }
    
    public void destoryAppContext()
    {
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
