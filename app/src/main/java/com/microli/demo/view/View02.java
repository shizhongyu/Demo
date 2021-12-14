package com.microli.demo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 * Copyright (c) 2021 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @Author microli
 * 2021/12/13
 */
public class View02 extends View {

    public TextView textView;
    public View02(Context context) {
        super(context);
    }

    public View02(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public View02(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if(textView != null) {
            return textView.dispatchTouchEvent(event);
        }
        return super.dispatchTouchEvent(event);
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }
}
