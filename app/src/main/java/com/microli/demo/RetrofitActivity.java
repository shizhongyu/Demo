package com.microli.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

/**
 * Copyright (c) 2021 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @Author microli
 * 2022/1/27
 */
public class RetrofitActivity extends BaseActivity {

    private Button mBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrofit_ac);
        initView();
    }

    private void initView() {
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


}
