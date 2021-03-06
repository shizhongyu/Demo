package com.microli.demo.clickevent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import com.microli.demo.BaseActivity;
import com.microli.demo.R;
import com.microli.demo.ToastUtils;

/**
 * Copyright (c) 2021 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @Author microli
 * 2021/12/3
 */
public class Click01Activity extends BaseActivity {

    private FrameLayout mRootView;
    private View mView;
    private View mView01;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.click_01);
        initView();
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(TAG, "onClick() called with: v = [" + v + "]");
        }
    };

    private void initView() {
        mRootView = (FrameLayout) findViewById(R.id.root_view);
        mView = (View) findViewById(R.id.view);

        mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showLong(mRootView.getContext(), "root");
            }
        });
        mView.setOnClickListener(clickListener);
        mView01 = (View) findViewById(R.id.view01);
        mView01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick() called with:       01v = [" + v + "]" );
            }
        });
    }
}
