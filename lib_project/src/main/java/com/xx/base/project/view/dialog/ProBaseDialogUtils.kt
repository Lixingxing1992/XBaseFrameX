package com.xx.base.project.view.dialog

import android.app.Activity
import android.app.Dialog
import android.content.Context


/**
 * Created by lixingxing on 2019/4/25.
 */
object ProBaseDialogUtils {
    // 显示加载dialog
    fun showLoadDialog(context: Context, loadDialog: Dialog? = null): Dialog {
        var loadDialog = loadDialog
        if (loadDialog == null) {
            loadDialog = LoadDialog(context)
        }
        loadDialog.show()
        return loadDialog
    }

    // 显示项目的信息提示dialog
    fun showMyNormalDialog(
        context: Context,
        msg: String,
        title:String,
        onDoubleClickListener: MessageDialog.OnDoubleBtnClick? = null
    ) {
        if (context !is Activity) {
            return
        }
        MessageDialog(context)
            .setDialogTitle(title)
            .setDialogMsg(msg)
            .setDoubleBtn(onDoubleClickListener)
            .show()
    }

}
