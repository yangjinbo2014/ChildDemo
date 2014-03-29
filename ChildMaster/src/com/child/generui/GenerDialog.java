package com.child.generui;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;

/**
 * 通用对话框<br>
 * 用于显示弹出内容，归一化抽象处理<br>
 * 
 * @author Owen
 * 
 */
public class GenerDialog extends Dialog
{
    
    public GenerDialog(Context context)
    {
        super(context);
        /* 模态对话框 */
        // setCanceledOnTouchOutside(false);
        /* 无标题 */
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }
    
}
