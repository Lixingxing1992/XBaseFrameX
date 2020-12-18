package com.xx.base.org.superadapter;

import androidx.recyclerview.widget.RecyclerView;

import com.xx.base.org.superadapter.animation.BaseAnimation;


/**
 * Animation interface for adapter.
 * <p>
 * Created by Lixingxing on 16/6/28.
 */
interface IAnimation {

    void enableLoadAnimation();

    void enableLoadAnimation(long duration, BaseAnimation animation);

    void cancelLoadAnimation();

    void setOnlyOnce(boolean onlyOnce);

    void addLoadAnimation(RecyclerView.ViewHolder holder);

}
