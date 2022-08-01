package com.microli.demo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

public class BitmapActivity extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bitmap_layout);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.big);
        ToastUtils.showLong(this, bitmap.getAllocationByteCount() + "");
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + bitmap.getAllocationByteCount() + "]");
    }
}
