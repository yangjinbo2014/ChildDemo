package com.child.baseui;

import java.io.IOException;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.child.R;

/**
 * 通用的人物出场介绍类<br>
 * 包括语音的初始化，向上的动画显示，人物，内容，语音的设定<br>
 * 
 * @author Owen
 * 
 */
public class GenerBottomPreView
{
    private View view;
    
    private MediaPlayer mediaPlayer;
    
    private Context context;
    
    public GenerBottomPreView(Context context)
    {
        this.context = context;
        view = LayoutInflater.from(context).inflate(R.layout.gener_bottom_pre_view, null);
        mediaPlayer = new MediaPlayer();
    }
    
    public void setPersonPosition(boolean isLeft)
    {
        view.findViewById(R.id.relativeLayout_person_are).setLayoutParams(null);
        view.findViewById(R.id.relativeLayout_person_name_are).setLayoutParams(null);
    }
    
    public void setPersonImage()
    {
        
    }
    
    public void setPersonName(String s)
    {
        TextView textView = (TextView)view.findViewById(R.id.textView_person_name);
        textView.setText(s);
    }
    
    public void setContextIntro(String s)
    {
        TextView textView = (TextView)view.findViewById(R.id.textView_context);
        textView.setText(s);
    }
    
    public void initMediaRes(String s)
    {
        mediaPlayer.reset();
        
        try
        {
            mediaPlayer.setDataSource(context.getAssets().openFd(s).getFileDescriptor());
            mediaPlayer.prepareAsync();
            // mediaPlayer.prepare();
        }
        catch (IllegalArgumentException | IllegalStateException | IOException e)
        {
            e.printStackTrace();
        }
        
    }
    
    public void startVoicePlay()
    {
        mediaPlayer.start();
    }
    
    public void stopVoicePlay()
    {
        mediaPlayer.stop();
        mediaPlayer.release();
    }
    
    public View getView()
    {
        return view;
    }
    
}
