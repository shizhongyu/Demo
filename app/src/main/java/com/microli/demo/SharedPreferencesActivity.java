package com.microli.demo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Copyright (c) 2021 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @Author microli
 * 2022/2/8
 */
public class SharedPreferencesActivity extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharedpreferences_ac);
        putValue();
    }

    private void putValue() {
        SharedPreferences sharedPreferences = getSharedPreferences("gityuan", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("blog", "www.gityuan.com");
        editor.putInt("years", 3);
        editor.commit();
    }

    private String getValue() {
        SharedPreferences sharedPreferences = getSharedPreferences("gityuan", Context.MODE_PRIVATE);
        return sharedPreferences.getString("blog", "null");
    }

    public void onClick(View view) {
        ToastUtils.showShort(this, getValue());
    }
}
