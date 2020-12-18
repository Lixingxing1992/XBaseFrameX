package com.xx.base.project;

import android.content.Context;
import android.graphics.Color;

import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshFooter;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshFooterCreator;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshHeaderCreator;
import com.xx.base.org.util.BaseUtils;
import com.xx.base.org.util.image.BaseImageUtils;
import com.xx.base.org.util.image.impl.GlideUtils;
import com.xx.base.project.util.file.ProFileConfig;
import com.xx.base.ui.util.BaseStatusBarUtils;


/**
 * 根据不同项目进行初始化和设置
 * Created by lixingxing on 2019/5/30.
 */
public class BaseProjectUtils {
    private static BaseProjectUtils baseProjectUtils = null;
    public static  BaseProjectUtils getInstance(Context context){
        baseProjectUtils = new BaseProjectUtils(context);
        return baseProjectUtils;
    }
    private Context context;
    private BaseProjectUtils(Context context){
        this.context = context;
    }
    public BaseProjectUtils init(){
        String packageName = context.getPackageName();
        settting(context);
        return this;
    }

    private void settting(Context context){
        // 设置全局上下文和一些属性

        /********* lib_commom **********/
        // 初始化全局基础工具类
        BaseUtils.init(context);
        // 设置项目图片加载库
        BaseImageUtils.init(new GlideUtils());
        // 设置网络请求
//        BaseHttpUtils.init(context,BuildConfig.DEBUG);
//        BaseHttpUtils.init(TDHttpService.class,TDDataListener.class);
//        BaseHttpUtils.initFile(DefaultFileService.class,TDDataListener.class);
        // 设置项目在SD卡上的文件夹名称
        ProFileConfig.init("xbaseframe","xbaseframe_default");
        // 设置 SmartRefreshLayout 的 header 和 footer
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(android.R.color.white);//全局设置主题颜色
                return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });



        /********** lib_ui ****/
        // 设置状态栏默认颜色
        BaseStatusBarUtils.init(Color.parseColor("#ff9480"),0);
    }
}
