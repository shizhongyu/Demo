package com.microli.demo;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Copyright (c) 2021 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @Author microli
 * 2022/2/11
 */
@Route(path = "/test/ArouterActivity")
public class ArouterActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arouter_ac);
    }

    public void onClick(View view) {
        ARouter.getInstance().build("/test/ArouterTestActivity")
                .withLong("key1", 666L)
                .withString("key3", "888")
                .navigation();
    }
}
