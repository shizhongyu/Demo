package com.microli.demo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Copyright (c) 2021 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @Author microli
 * 2022/1/22
 */
public class APTActivity extends BaseActivity{
    @BindView(R.id.tv)
    TextView name;
    @BindView(R.id.btn)
    Button btn;

    @OnClick(R.id.btn) void submit() {
        ToastUtils.showLong(this, "click");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
        setContentView(R.layout.apt_ac);
        ButterKnife.bind(this);
        name.setText(this.getLocalClassName());
    }
}
