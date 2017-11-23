package com.example.cc.mddemo.listener;

import android.support.v7.widget.RecyclerView;

/**
 * Created by cc on 2017/11/22.
 */

public class FabScrollListener extends RecyclerView.OnScrollListener {

    public static final int THRESHOLD = 15;
    private int mDistance = 0;

    private boolean visible = true;

    private OnHideOrShowListener mOnHideOrShowListener = null;

    public FabScrollListener(OnHideOrShowListener onHideOrShowListener) {
        mOnHideOrShowListener = onHideOrShowListener;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);


        if (mDistance > THRESHOLD && visible) {
            //影藏
            mOnHideOrShowListener.onHide();
            visible = false;
            mDistance = 0;
        } else if (mDistance < -THRESHOLD && !visible) {
            //显示动画
            mOnHideOrShowListener.onShow();
            visible = true;
            mDistance = 0;
        }
        if ((dy > 0 && visible) || (dy < 0 && !visible)) {
            mDistance += dy;
        }


    }
}
