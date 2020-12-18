package com.xx.base.org.page;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * 延时加载的 Fragment, 只有显示的时候才会去加载视图和数据请求等操作
 */
public abstract class BaseFragment extends Fragment {
    private String tag = "BaseFragment";
    protected View view = null;
    protected Context baseContext = null;
    protected int resId = 0;

    protected BaseFragment(){
    }

    protected BaseFragment(@LayoutRes int resId){
        this.resId = resId;
    }

    // 方便集成的子类传入 tag进行调试
    protected BaseFragment(String tag){
        this.tag = tag;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        baseContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            hasBundle(args);
        }
    }
    protected void hasBundle(Bundle args){

    }

    public int getFragmentViewRes(){return 0;}

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(tag,tag + " onCreateView");
        if(null == view){
            if(resId == 0){
                resId = getFragmentViewRes();
            }
            view = inflater.inflate(resId,container,false);
            isCreateView = true;
        }
        return view;
    }

    // 是否已经生成了View
    protected boolean isCreateView;
    protected boolean isFirstShow;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(tag,tag + " onActivityCreated");
        initCreateView();
    }

    protected synchronized void initCreateView() {
    }

    protected void onShow(){}
    protected void onHide(){}
    // 第一次显示时初始化 view
    protected abstract void firstInitViews(View view);
    // 第一次显示
    protected abstract void onFirstUserVisible();
    // 第二次显示
    protected abstract void onUserVisible();
    protected abstract void onUserInvisible();


    @Override
    public void onStart() {
        Log.i(tag,tag + " onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(tag,tag + " onResume");
        if(!isFirstShow && isCreateView){
            isFirstShow = true;
            Log.i(tag,tag + " firstInitViews");
            firstInitViews(view);
            Log.i(tag,tag + " onFirstUserVisible");
            onFirstUserVisible();
        }else{
            Log.i(tag,tag + " onUserVisible");
            onUserVisible();
        }
        Log.i(tag,tag + " onShow");
        onShow();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(tag,tag + " onPause");
        Log.i(tag,tag + " onUserInvisible");
        onUserInvisible();
        Log.i(tag,tag + " onHide");
        onHide();
    }

    @Override
    public void onDestroyView() {
        Log.i(tag,tag + " onDestroyView");
        Log.i(tag,tag + " DetoryViewAndThing");
        DetoryViewAndThing();
        super.onDestroyView();

    }
    protected abstract void DetoryViewAndThing();

}