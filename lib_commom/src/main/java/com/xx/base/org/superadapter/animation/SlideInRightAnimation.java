package com.xx.base.org.superadapter.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

/**
 * @Author: lixingxing
 * @Created: 16/6/28 17:28.
 */
public class SlideInRightAnimation implements BaseAnimation {
    @Override
    public Animator[] getAnimators(View view) {
        return new Animator[]{
                ObjectAnimator.ofFloat(view, "translationX", view.getRootView().getWidth(), 0)
        };
    }
}
