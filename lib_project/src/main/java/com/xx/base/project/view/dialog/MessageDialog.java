package com.xx.base.project.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xx.base.project.R;

/**
 * Created by lixingxing on 2019/4/25.
 */
public class MessageDialog extends Dialog {

    Context context;

    // 这三个控件是一起的，代表一左一右两个按钮的布局
    public LinearLayout linear_double;
    public Button btn_double_left, btn_double_right;
    public Button btn_single;
    TextView dialog_title, dialog_msg;

    int isTitleVisible = View.GONE;
    String textTitle = "";

    int isMsgVisible = View.GONE;
    String textMsg = "";

    int isDoubleBtnVisible = View.GONE;

    public MessageDialog(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_dialog_message_default);
        this.setCancelable(false);  // 设置点击屏幕Dialog不消失

        dialog_title = findViewById(R.id.dialog_msg_title);
        dialog_title.setVisibility(isTitleVisible);
        dialog_title.setText(textTitle);

        dialog_msg = findViewById(R.id.dialog_msg);
        dialog_msg.setVisibility(isMsgVisible);
        dialog_msg.setText(textMsg);

        linear_double = findViewById(R.id.linear_double);
        btn_double_left = findViewById(R.id.btn_double_left);
        btn_double_right = findViewById(R.id.btn_double_right);
        linear_double.setVisibility(isDoubleBtnVisible);
        if (isDoubleBtnVisible == View.VISIBLE) {
            btn_double_left.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dismiss();
                    if (null != onDoubleBtnClick) {
                        onDoubleBtnClick.onClickLeft(view);
                    }
                }
            });
            btn_double_right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dismiss();
                    if (null != onDoubleBtnClick) {
                        onDoubleBtnClick.onClickRight(view);
                    }
                }
            });

        }

    }

    @Override
    public void dismiss() {
        try {
            if (context != null && !((Activity) context).isFinishing()) {
                super.dismiss();    //调用超类对应方法
            }
        } catch (Exception e) {

        }
    }

    @Override
    public void show() {
        try {
            if (null != context && !((Activity) context).isFinishing()) {
                super.show();    //调用超类对应方法
            }
        } catch (Exception e) {

        }
    }

    ImageView dialog_image;

    /**
     * @return
     */
    public MessageDialog setDialogTitle(String titleText) {
        this.textTitle = titleText;
        if (textTitle != null && !textTitle.equals("")) {
            isTitleVisible = View.VISIBLE;
        } else {
            isTitleVisible = View.GONE;
        }
        return this;
    }

    /**
     * @return
     */
    public MessageDialog setDialogMsg(String textMsg) {
        this.textMsg = textMsg;
        if (textMsg != null && !textMsg.equals("")) {
            isMsgVisible = View.VISIBLE;
        } else {
            isMsgVisible = View.GONE;
        }
        return this;
    }

    /**
     * @return
     */
    public MessageDialog setDoubleBtn(OnDoubleBtnClick onDoubleBtnClick) {
        isDoubleBtnVisible = View.VISIBLE;
        this.onDoubleBtnClick = onDoubleBtnClick;
        return this;
    }

    private OnDoubleBtnClick onDoubleBtnClick;

    public interface OnDoubleBtnClick {
        void onClickLeft(View v);

        void onClickRight(View v);
    }
}