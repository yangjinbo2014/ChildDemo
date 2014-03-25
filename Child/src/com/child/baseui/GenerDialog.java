package com.child.baseui;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;

/**
 * 通用对话框
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
