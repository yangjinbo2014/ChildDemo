package com.child.baseui;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;

/**
 * ͨ�öԻ���
 * 
 * @author Owen
 * 
 */
public class GenerDialog extends Dialog
{
    
    public GenerDialog(Context context)
    {
        super(context);
        /* ģ̬�Ի��� */
        // setCanceledOnTouchOutside(false);
        /* �ޱ��� */
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }
    
}
