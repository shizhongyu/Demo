package com.microli.demo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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

    SharedPreferences sharedPreferences ;
    SharedPreferences.Editor editor ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharedpreferences_ac);
        sharedPreferences = getSharedPreferences("gityuan", Context.MODE_PRIVATE);
        editor =  sharedPreferences.edit();;
    }

    private void putValue(boolean commit) {

        float time = System.nanoTime();
        editor.putString(time + "", time + "");
        Log.d(TAG, "putValue() called with: commit = [" + commit + "]" + time);
        editor.putInt("years", 3);
        if (commit) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    private String getValue() {
        SharedPreferences sharedPreferences = getSharedPreferences("gityuan", Context.MODE_PRIVATE);
        return sharedPreferences.getString("blog", "null");
    }

    public void onClick(View view) {
        ToastUtils.showShort(this, getValue());
    }

    public void commit(View view) {
        putValue(true);
    }

    public void apply(View view) {
        putValue(false);
    }
}
