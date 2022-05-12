package com.microli.demo;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.microli.demo.clickevent.Click01Activity;
import com.microli.demo.clickevent.Click02Activity;
import com.microli.demo.clickevent.ClickActivity;
import com.microli.demo.fragment.FragmentActivity;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.FadeInAnimator;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;

/**
 * Copyright (c) 2021 Tencent. All rights reserved.
 * 类功能描述:
 * @Author microli
 * 2022/2/9
 *
 * 參考文章：
 * https://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2017/0807/8348.html
 */
public class RecyclerviewActivity extends BaseActivity {

    private RecyclerView mRecyclerview;
    List<MainBean> classes = new ArrayList<>();
    RecyclerviewAdapter mainAdapter = new RecyclerviewAdapter(classes);
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_ac);
        initView();
        initData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerview.setLayoutManager(linearLayoutManager);
        mRecyclerview.setItemViewCacheSize(6);
        mRecyclerview.setAdapter(mainAdapter);
        FadeInAnimator fadeInAnimator = new FadeInAnimator();
        fadeInAnimator.setAddDuration(30000);
        mRecyclerview.setItemAnimator(fadeInAnimator);
    }

    private void initView() {
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        button = findViewById(R.id.button);
    }

    private void initData() {
        classes.add(new MainBean("Recyclerview缓存", RecyclerviewActivity.class));
        classes.add(new MainBean("SharedPreferences", SharedPreferencesActivity.class));
        classes.add(new MainBean("DataBinding", DataBindingActivity.class));
        classes.add(new MainBean("LiveData", LiveDataActivity.class));
        classes.add(new MainBean("ViewModel", ViewModelActivity.class));
        classes.add(new MainBean("LifeCycle", LifeCycleActivity.class));
        classes.add(new MainBean("RxAndroid", RxActivity.class));
//        classes.add(new MainBean("Dagger2", Dagger2Activity.class));
//        classes.add(new MainBean("EventBus", EventbusActivity.class));
//        classes.add(new MainBean("okhttp", OkhttpActivity.class));
//        classes.add(new MainBean("apt", APTActivity.class));
//        classes.add(new MainBean("列表Glide", GlideListActivity.class));
//        classes.add(new MainBean("事件分发", Click02Activity.class));
//        classes.add(new MainBean("SeekBar", SeekBarActivity.class));
//        classes.add(new MainBean("click", Click01Activity.class));
//        classes.add(new MainBean("constraintlayout", ConstraintlayoutActivity.class));
//        classes.add(new MainBean("事件分发", ClickActivity.class));
//        classes.add(new MainBean("阴影", ShadowActivity.class));
//        classes.add(new MainBean("Fragment", FragmentActivity.class));
//        classes.add(new MainBean("动画", AnimActivity.class));
//        classes.add(new MainBean("TextView url 拦截", WebViewActivity.class));
//        classes.add(new MainBean("扩大点击区域", LargeViewBoundsActivity.class));
//        classes.add(new MainBean("View", ViewActivity.class));
//        classes.add(new MainBean("ANR", ANRActivity.class));
//        classes.add(new MainBean("HookActivity", HookActivity.class));
    }


    public void onClick(View view) {
        classes.add(0, new MainBean("click", WebViewActivity.class));
        mainAdapter.notifyItemInserted(0);
    }
}
