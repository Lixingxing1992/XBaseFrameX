package com.xx.base.project.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;

import com.xx.base.project.R;

/**
 * Created by lixingxing on 2019/4/25.
 */
public class LoadDialog extends Dialog {

    Context context;
    ImageView imageView ;
    AnimationDrawable animationDrawable;

    public LoadDialog(Context context) {
        this(context, R.style.dialog_tran);
    }

    public LoadDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_dialog_default);
        this.setCancelable(false);  // 设置点击屏幕Dialog不消失
        imageView = (ImageView)findViewById(R.id.load);
        imageView.setImageResource(R.drawable.dialog_wait_anim);
        setOnShowListener(new OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                animationDrawable = (AnimationDrawable) imageView.getDrawable();
                animationDrawable.start();
            }
        });
        this.setOnKeyListener(onKeyListener);
        this.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                animationDrawable.stop();
            }
        });
    }

    @Override
    public void dismiss() {
        try{
            if (context != null && !((Activity)context).isFinishing())
            {
                super.dismiss();    //调用超类对应方法
            }
        }catch (Exception e){

        }
    }

    @Override
    public void show() {
        try{
            if ( null != context && !((Activity)context).isFinishing())
            {
                super.show();    //调用超类对应方法
            }
        }catch (Exception e){

        }
    }

    /**
     * add a keylistener for progress dialog
     */
    private OnKeyListener onKeyListener = new OnKeyListener() {
        @Override
        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
                dismiss();
                Activity activity = (Activity)context;
                if(!activity.getClass().getName().contains("MainActivity")){
                    ((Activity)context).finish();
                }
            }
            return false;
        }
    };

}