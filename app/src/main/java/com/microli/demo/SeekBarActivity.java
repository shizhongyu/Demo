package com.microli.demo;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.SeekBar;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/**
 * Copyright (c) 2021 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @Author microli
 * 2021/11/25
 */
public class SeekBarActivity extends BaseActivity {

    private SeekBar mSeekbar;
    private FrameLayout mRootView;
    private Button mBtn01;
    private Button mBtn02;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seekbar_ac);
        initView();
    }

    private void initView() {
        mRootView = (FrameLayout) findViewById(R.id.root_view);
        mSeekbar = findViewById(R.id.seekbar);
        mBtn01 = (Button) findViewById(R.id.btn_01);
        mBtn02 = (Button) findViewById(R.id.btn_02);
        mSeekbar.setThumb(null);
        mBtn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                seekBarAnim();
                startPropertyAnim01();
            }
        });

        mBtn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                doIconAnimation();
                startPropertyAnim();
//                seekBarAnim();
            }
        });
    }

    private void seekBarAnim() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 10);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                ViewGroup.LayoutParams layoutParams = mSeekbar.getLayoutParams();
                layoutParams.height = (int) animation.getAnimatedValue();
                mSeekbar.setLayoutParams(layoutParams);
            }
        });
        valueAnimator.start();
    }


    // 动画实际执行
    private void startPropertyAnim01() {
        mSeekbar.setThumb(null);
        // 将一个TextView沿垂直方向先从原大小（1f）放大到5倍大小（5f），然后再变回原大小。
        ObjectAnimator anim = ObjectAnimator.ofFloat(mSeekbar, "scaleY", 0.5f, 1f);

        anim.setDuration(500);

//        // 回调监听，可以有也可以无。
//        // 根据情况，如果需要监听动画执行到何种“进度”，那么就监听之。
//        anim.addUpdateListener(new AnimatorUpdateListener() {
//
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                float value = (Float) animation.getAnimatedValue();
//                Log.d("zhangphil", value + "");
//            }
//        });

        // 正式开始启动执行动画
        anim.start();
    }

    private void startPropertyAnim02() {
        mSeekbar.setThumb(null);
        // 将一个TextView沿垂直方向先从原大小（1f）放大到5倍大小（5f），然后再变回原大小。
        ObjectAnimator anim = ObjectAnimator.ofFloat(mRootView, "eight", 0.5f, 1f);

        anim.setDuration(500);

//        // 回调监听，可以有也可以无。
//        // 根据情况，如果需要监听动画执行到何种“进度”，那么就监听之。
//        anim.addUpdateListener(new AnimatorUpdateListener() {
//
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                float value = (Float) animation.getAnimatedValue();
//                Log.d("zhangphil", value + "");
//            }
//        });

        // 正式开始启动执行动画
        anim.start();
    }


    // 动画实际执行
    private void startPropertyAnim() {
        // 将一个TextView沿垂直方向先从原大小（1f）放大到5倍大小（5f），然后再变回原大小。
        ObjectAnimator anim = ObjectAnimator.ofFloat(mSeekbar, "scaleY", 0f, 0.5f);

        anim.setDuration(500);

//        // 回调监听，可以有也可以无。
//        // 根据情况，如果需要监听动画执行到何种“进度”，那么就监听之。
//        anim.addUpdateListener(new AnimatorUpdateListener() {
//
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                float value = (Float) animation.getAnimatedValue();
//                Log.d("zhangphil", value + "");
//            }
//        });

        // 正式开始启动执行动画
        anim.start();
    }

    private void doIconAnimation() {
        final AnimationSet set = new AnimationSet(true);

        AlphaAnimation alphaAnimation = new AlphaAnimation(0f, 1.0f);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setFillAfter(true);

        ScaleAnimation scaleAnimation = new ScaleAnimation(mSeekbar.getScaleX(), mSeekbar.getScaleX(), 0f, 10.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(1000);
        scaleAnimation.setFillAfter(true);

        set.addAnimation(alphaAnimation);
        set.addAnimation(scaleAnimation);


        mSeekbar.clearAnimation();
        mSeekbar.startAnimation(set);

    }

}
