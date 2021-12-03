package com.microli.demo;

import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;

public class LargeViewBoundsActivity extends BaseActivity {

    private Button mBtn;
    private SimpleDraweeView mImageview;

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
        mImageview = findViewById(R.id.imageview);
        Uri uri = Uri.parse("http://puui.qpic.cn/qqvideo_ori/0/w00400y30sh_496_280/0");
        mImageview.setImageURI(uri);

    }
}
