package com.microli.demo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 * Copyright (c) 2021 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @Author microli
 * 2021/12/13
 */
public class MyTvView extends TextView {
    private static final String TAG = "Cannot invoke method length() on null object";
    public MyTvView(Context context) {
        super(context);
    }

    public MyTvView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTvView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d(TAG, "dispatchTouchEvent() called with: event = [" + event + "]" +super.dispatchTouchEvent(event));
        return super.dispatchTouchEvent(event);
    }
}
