package com.child.generui;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;

/**
 * ͨ�öԻ���<br>
 * ������ʾ�������ݣ���һ��������<br>
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
