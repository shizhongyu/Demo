package com.microli.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

public class ViewActivity extends BaseActivity {

    private FrameLayout mRootView;
    View view;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_activity);
        initView();
        addView();
    }

    private void addView() {
        mRootView.removeView(view);
        view = new View(this);
        view.setBackgroundColor(Color.RED);
        view.setLayoutParams(new FrameLayout.LayoutParams(300, ViewGroup.LayoutParams.WRAP_CONTENT));
        mRootView.addView(view);
        mRootView.removeView(view);
        view = new View(this);
        mRootView.addView(view);
        mRootView.removeView(view);
        view = new View(this);
        mRootView.addView(view);
        Log.d(TAG, "addView() called" + mRootView.getChildCount());
    }

    private void initView() {
        mRootView = (FrameLayout) findViewById(R.id.root_view);
    }
}
