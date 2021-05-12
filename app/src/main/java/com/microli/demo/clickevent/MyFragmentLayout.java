package com.microli.demo.clickevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyFragmentLayout extends FrameLayout {
    private static final String TAG = "MyFragmentLayout";
    private boolean mLongPressTriggered;
    private boolean clickHandleEvent;

    public MyFragmentLayout(@NonNull Context context) {
        super(context);
    }

    public MyFragmentLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyFragmentLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        clickHandleEvent = true;
        int  mask = ev.getActionMasked();
        if(mask == MotionEvent.ACTION_DOWN) {
            mLongPressTriggered = false;
        }
        boolean handle = super.dispatchTouchEvent(ev);
        if(mask == MotionEvent.ACTION_DOWN) {
            if(isLongClickable() && clickHandleEvent) {
                scheduleLongPress();
            }
        }
        if(ev.getActionMasked() == MotionEvent.ACTION_UP
                || ev.getActionMasked() == MotionEvent.ACTION_CANCEL) {
            removeLongPress();
        }
        return handle;
    }

    private void scheduleLongPress() {
        postDelayed(longClickRunnable, ViewConfiguration.getLongPressTimeout());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        clickHandleEvent = false;
        if (mLongPressTriggered && event.getActionMasked() == MotionEvent.ACTION_UP) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    private final Runnable longClickRunnable = new Runnable() {
        @Override
        public void run() {
            mLongPressTriggered = performLongClick();
            Log.d(TAG, "run() called" + mLongPressTriggered);
        }
    };

    private void removeLongPress() {
        removeCallbacks(longClickRunnable);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (mLongPressTriggered && ev.getActionMasked() == MotionEvent.ACTION_UP) {
            return true;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
