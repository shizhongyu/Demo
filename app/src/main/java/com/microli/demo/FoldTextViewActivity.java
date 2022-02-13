package com.microli.demo;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import com.microli.demo.view.FoldTextView;

/**
 * Copyright (c) 2021 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @Author microli
 * 2022/2/13
 */
public class FoldTextViewActivity extends BaseActivity {

    private FrameLayout mParent3;
    private FoldTextView mText3;
    String text = "君不见黄河之水天上来，奔流到海不复回。" +
            "君不见高堂明镜悲白发，朝如青丝暮成雪。" +
            "人生得意须尽欢，莫使金樽空对月。" +
            "天生我材必有用，千金散尽还复来。" +
            "烹羊宰牛且为乐，会须一饮三百杯。" +
            "岑夫子，丹丘生，将进酒，君莫停。" +
            "与君歌一曲，请君为我侧耳听。" +
            "钟鼓馔玉不足贵，但愿长醉不愿醒。" +
            "古来圣贤皆寂寞，惟有饮者留其名。" +
            "陈王昔时宴平乐，斗酒十千恣欢谑。" +
            "主人何为言少钱，径须沽取对君酌。" +
            "五花马，千金裘，呼儿将出换美酒，与尔同销万古愁。";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fold_ac);
        initView();
        mText3.setText(text);
    }

    private void initView() {
        mParent3 = (FrameLayout) findViewById(R.id.parent3);
        mText3 = (FoldTextView) findViewById(R.id.text3);
    }
}
