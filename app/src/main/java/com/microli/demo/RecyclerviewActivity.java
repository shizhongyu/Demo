package com.microli.demo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.microli.demo.clickevent.Click01Activity;
import com.microli.demo.clickevent.Click02Activity;
import com.microli.demo.clickevent.ClickActivity;
import com.microli.demo.fragment.FragmentActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2021 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @Author microli
 * 2022/2/9
 */
public class RecyclerviewActivity extends BaseActivity {

    private RecyclerView mRecyclerview;
    List<MainBean> classes = new ArrayList<>();
    RecyclerviewAdapter mainAdapter = new RecyclerviewAdapter(classes);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_ac);
        initView();
        initData();
        initData();
        GridLayoutManager linearLayoutManager = new GridLayoutManager(this, 5);
        mRecyclerview.setLayoutManager(linearLayoutManager);
        mRecyclerview.setItemViewCacheSize(6);
        mRecyclerview.setAdapter(mainAdapter);
    }

    private void initView() {
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
    }

    private void initData() {
        classes.add(new MainBean("Recyclerview缓存", RecyclerviewActivity.class));
        classes.add(new MainBean("SharedPreferences", SharedPreferencesActivity.class));
        classes.add(new MainBean("DataBinding", DataBindingActivity.class));
        classes.add(new MainBean("LiveData", LiveDataActivity.class));
        classes.add(new MainBean("ViewModel", ViewModelActivity.class));
        classes.add(new MainBean("LifeCycle", LifeCycleActivity.class));
        classes.add(new MainBean("RxAndroid", RxActivity.class));
        classes.add(new MainBean("Dagger2", Dagger2Activity.class));
        classes.add(new MainBean("EventBus", EventbusActivity.class));
        classes.add(new MainBean("okhttp", OkhttpActivity.class));
        classes.add(new MainBean("apt", APTActivity.class));
        classes.add(new MainBean("列表Glide", GlideListActivity.class));
        classes.add(new MainBean("事件分发", Click02Activity.class));
        classes.add(new MainBean("SeekBar", SeekBarActivity.class));
        classes.add(new MainBean("click", Click01Activity.class));
        classes.add(new MainBean("constraintlayout", ConstraintlayoutActivity.class));
        classes.add(new MainBean("事件分发", ClickActivity.class));
        classes.add(new MainBean("阴影", ShadowActivity.class));
        classes.add(new MainBean("Fragment", FragmentActivity.class));
        classes.add(new MainBean("动画", AnimActivity.class));
        classes.add(new MainBean("TextView url 拦截", WebViewActivity.class));
        classes.add(new MainBean("扩大点击区域", LargeViewBoundsActivity.class));
        classes.add(new MainBean("View", ViewActivity.class));
        classes.add(new MainBean("ANR", ANRActivity.class));
        classes.add(new MainBean("HookActivity", HookActivity.class));
    }
}
