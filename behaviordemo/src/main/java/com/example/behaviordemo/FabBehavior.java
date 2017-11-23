package com.example.behaviordemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/**
 * Created by cc on 2017/11/22.
 */

public class FabBehavior extends FloatingActionButton.Behavior {

    private boolean visible = true;

    public FabBehavior() {
    }

    public FabBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        //观察View开始滑动的时候回调
        Log.d("123", "开始滑动");
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild,
                target, axes,type);
    }

    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton child, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
        //正在滑动
        Log.d("123", "onNestedScroll: " + "dyConsumed:" + dyConsumed + ",dyUnconsumed:" + dyUnconsumed);

        if (dyConsumed > 0 && visible) {
            //隐藏
            visible = false;
            onHide(child);
        } else if (dyConsumed < 0 && !visible) {
            //显示
            visible = true;
            onShow(child);
        }
    }

    private void onShow(FloatingActionButton child) {
        ViewCompat.animate(child).translationY(0).setInterpolator(new DecelerateInterpolator(3)).start();
    }

    private void onHide(FloatingActionButton child) {

        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) child.getLayoutParams();

        ViewCompat.animate(child).translationY(child.getHeight() + layoutParams.bottomMargin).setInterpolator(new AccelerateInterpolator(3)).start();
    }
}
