package com.example.zy_manage.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class FixedViewPager extends ViewPager {
    private boolean canSwipe = true;//禁止左右滑动
    public FixedViewPager(@NonNull Context context) {

        super(context);
    }

    public void setCanSwipe(boolean canSwipe)
    {
        this.canSwipe = canSwipe;
    }

    public FixedViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setCurrentItem(int item) {

        super.setCurrentItem(item,false);
    }

    //禁用滑动
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return canSwipe && super.onTouchEvent(ev);
    }
    //禁用长滑
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return canSwipe && super.onInterceptTouchEvent(ev);
    }

}
