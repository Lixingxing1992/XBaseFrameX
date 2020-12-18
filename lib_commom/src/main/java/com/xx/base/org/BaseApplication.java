package com.xx.base.org;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

/**
 * Created by lixingxing on 2019/4/24.
 */
public class BaseApplication extends Application implements ViewModelStoreOwner {
    private static Application app;
    public static Application getInstance(){
        return app;
    }

    private ViewModelStore mAppViewModelStore;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        mAppViewModelStore = new ViewModelStore();
    }

    @NonNull
    @Override
    public ViewModelStore getViewModelStore() {
        return mAppViewModelStore;
    }
}
