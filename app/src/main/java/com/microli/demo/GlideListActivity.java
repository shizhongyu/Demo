package com.microli.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.microli.demo.view.MyImageView;
import com.microli.demo.view.MyRecyclerview;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2021 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @Author microli
 * 2022/1/12
 */
public class GlideListActivity extends BaseActivity {
    private MyRecyclerview mRecyclerview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        initView();
    }

    private void initView() {
        mRecyclerview = (MyRecyclerview) findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecyclerview.setLayoutManager(linearLayoutManager);

//        mRecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                boolean sIsScrolling = false;
//                if (newState == RecyclerView.SCROLL_STATE_DRAGGING || newState == RecyclerView.SCROLL_STATE_SETTLING) {
//                    sIsScrolling = true;
//                    Glide.with(GlideListActivity.this).pauseRequests();
//                } else if (newState == RecyclerView.SCROLL_STATE_IDLE) {
//                    if (sIsScrolling == true) {
//                        Glide.with(GlideListActivity.this).resumeRequests();
//
//                    }
//                    sIsScrolling = false;
//                }
//            }
//
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//            }
//        });
        List<String> urls = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            urls.add("https://pic3.zhimg.com/v2-3b4fc7e3a1195a081d0259246c38debc_720w.jpg?source=172ae18b");
        }
        mRecyclerview.setAdapter(new DemoAdapter(urls));

    }

    public class DemoAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public List<String> urls;
        /**
         * 构造方法，此示例中，在实例化Adapter时就传入了一个List。
         * 如果后期设置数据，不需要传入初始List，直接调用 super(layoutResId); 即可
         */
        public DemoAdapter(List<String> urls) {
            super(R.layout.item_layout, urls);
        }

        /**
         * 在此方法中设置item数据
         */
        @Override
        protected void convert( BaseViewHolder helper,  String item) {
            MyImageView imageView = helper.itemView.findViewById(R.id.image);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
//            ViewTarget viewTarget = new ViewTarget(imageView) {
//                @Override
//                public void onResourceReady(@NonNull Object resource, @Nullable Transition transition) {
//                          imageView.setImageDrawable((Drawable) resource);
//                }
//            };
//            viewTarget.clearOnDetach();
//            imageView.setTag(item);
            Glide.with(imageView.getContext()).load(item).into(imageView);
        }
    }
}
