package com.child.generui;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;

/**
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
