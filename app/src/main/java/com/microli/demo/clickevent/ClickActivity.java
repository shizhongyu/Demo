package com.microli.demo.clickevent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemChildLongClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.microli.demo.MainActivity;
import com.microli.demo.MainAdapter;
import com.microli.demo.MainBean;
import com.microli.demo.R;

import java.util.ArrayList;
import java.util.List;

public class ClickActivity extends AppCompatActivity {
    List<ClickBean> classes = new ArrayList<>();
    ClickAdapter mainAdapter = new ClickAdapter(R.layout.click_item, classes);
    private RecyclerView mRecyclerview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.click_activity);
        classes.add(ClickBean.ClickBeanBuilder.aClickBean().withName("test").build());
        classes.add(ClickBean.ClickBeanBuilder.aClickBean().withName("test1").build());
        classes.add(ClickBean.ClickBeanBuilder.aClickBean().withName("test2").build());
        classes.add(ClickBean.ClickBeanBuilder.aClickBean().withName("test3").build());
        initView();
    }

    private void initView() {
        mRecyclerview = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecyclerview.setLayoutManager(linearLayoutManager);
        mRecyclerview.setAdapter(mainAdapter);
        mainAdapter.addChildClickViewIds(R.id.btn);
        mainAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                com.microli.demo.ToastUtils.showLong(view.getContext(), classes.get(position).name);
            }
        });
        mainAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                com.microli.demo.ToastUtils.showLong(view.getContext(), classes.get(position).name + "----------item");
            }
        });
        mainAdapter.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                com.microli.demo.ToastUtils.showLong(view.getContext(), classes.get(position).name + "---------long----------item");
                return true;
            }
        });
    }
}
