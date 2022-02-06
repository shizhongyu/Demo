package com.microli.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.microli.demo.clickevent.Click01Activity;
import com.microli.demo.clickevent.Click02Activity;
import com.microli.demo.clickevent.ClickActivity;
import com.microli.demo.fragment.FragmentActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<MainBean> classes = new ArrayList<>();
    MainAdapter mainAdapter = new MainAdapter(R.layout.main_item, classes);
    private RecyclerView mRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initView() {
        mRecyclerview = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecyclerview.setLayoutManager(linearLayoutManager);

        mRecyclerview.setAdapter(mainAdapter);
        mainAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                Intent intent = new Intent(MainActivity.this, classes.get(position).className);
                startActivity(intent);
            }
        });
    }

    private void initData() {
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