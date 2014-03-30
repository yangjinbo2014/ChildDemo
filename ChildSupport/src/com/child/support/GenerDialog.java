package com.child.support;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;

/**
 * 弹出框的统一实现<br>
 * 
 * @author Owen
 * 
 */
public class GenerDialog extends Dialog
{
    
    public GenerDialog(Context context)
    {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }
    
}
