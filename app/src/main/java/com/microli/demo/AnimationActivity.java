package com.microli.demo;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;

import androidx.annotation.Nullable;

/**
 * Copyright (c) 2021 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @Author microli
 * @date 2022/5/10
 */
public class AnimationActivity extends BaseActivity {
    private Button mBtn;
    private Button mBtnClick;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anim_layout);
        initView();
    }

    private void initView() {
        mBtn = (Button) findViewById(R.id.btn);
        mBtnClick = (Button) findViewById(R.id.btn_click);
        mBtnClick.setOnClickListener(v -> {
//            scaleAnim();
            rotationAnim();
        });
    }

    private void scaleAnim() {
        //缩放动画
        ScaleAnimation animation = new ScaleAnimation(1,1.2f,1,1);
        animation.setDuration(100);
        animation.setFillAfter(true);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setRepeatCount(1);
        mBtn.startAnimation(animation);
    }

    private void rotationAnim() {
        RotateAnimation animation = new RotateAnimation(0,180f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animation.setDuration(5000);
        animation.setFillAfter(true);
        animation.setRepeatMode(Animation.RESTART);
        mBtn.startAnimation(animation);
    }
}
