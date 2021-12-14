package com.microli.demo.clickevent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.microli.demo.BaseActivity;
import com.microli.demo.R;
import com.microli.demo.view.RootView;
import com.microli.demo.view.View02;

/**
 * Copyright (c) 2021 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @Author microli
 * 2021/12/13
 */
public class Click02Activity extends BaseActivity {

    private RootView mRootView;
    private TextView mTv01;
    private View02 mView01;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.click_02);
        initView();


    }

    private void initView() {
        mRootView = (RootView) findViewById(R.id.root_view);
        mTv01 = (TextView) findViewById(R.id.tv_01);
        mView01 = (View02) findViewById(R.id.view01);
        mTv01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick() called with: v           = [" + v + "]");
            }
        });

//        mView01.textView = mTv01;
        mView01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick() called with: v = [" + v + "]");
            }
        });
        mTv01.setOnClickListener(null);
        mTv01.setClickable(false);
        mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick() called with: v ------------- = [" + v + "]");
            }
        });
    }
}
