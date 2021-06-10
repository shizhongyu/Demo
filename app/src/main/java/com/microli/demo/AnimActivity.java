package com.microli.demo;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.Nullable;

public class AnimActivity extends BaseActivity {

    private Button mBtn;
    private long systemTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anim);
        initView();
    }

    private void initView() {
        mBtn = (Button) findViewById(R.id.btn);
        //1.ValueAnimator用法
        ValueAnimator animator = ValueAnimator.ofInt(500);
        animator.setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
                long time = System.currentTimeMillis() - systemTime;
                Log.d(TAG, "onAnimationUpdate() returned: " + value + "---" + time);
                systemTime = System.currentTimeMillis();
                mBtn.setX(value);
            }
        });
        animator.start();
    }
}
