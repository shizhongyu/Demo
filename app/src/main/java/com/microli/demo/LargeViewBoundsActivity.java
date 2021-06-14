package com.microli.demo;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class LargeViewBoundsActivity extends BaseActivity {

    private Button mBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.large_bounds);

        initView();
        mBtn.post(new Runnable() {
            @Override
            public void run() {
                setTouchDelegate(mBtn, 200);
            }
        });

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort(v.getContext(), "click");
            }
        });
    }

    public static void setTouchDelegate(final View view, final int expandTouchWidth) {
        final View parentView = (View) view.getParent();
        parentView.post(new Runnable() {
            @Override
            public void run() {
                final Rect rect = new Rect();
                view.getHitRect(rect); // view构建完成后才能获取，所以放在post中执行
                // 4个方向增加矩形区域
                rect.top -= expandTouchWidth;
                rect.bottom += expandTouchWidth;
                rect.left -= expandTouchWidth;
                rect.right += expandTouchWidth;

                parentView.setTouchDelegate(new TouchDelegate(rect, view));
            }
        });
    }

    private void initView() {
        mBtn = (Button) findViewById(R.id.btn);
    }
}
