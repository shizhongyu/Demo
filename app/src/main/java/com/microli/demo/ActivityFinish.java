package com.microli.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 * Copyright (c) 2021 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @Author microli
 * @date 2022/3/15
 */
public class ActivityFinish extends BaseActivity {

    private TextView mText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        initView();
    }

    public void finish(View view) {
        finish();
        mText.setText("finish");
        ToastUtils.showShort(this, "" + mText.getText());
    }

    private void initView() {
        mText = (TextView) findViewById(R.id.text);
    }
}
