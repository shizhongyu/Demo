package com.microli.demo;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MainAdapter extends BaseQuickAdapter<MainBean, BaseViewHolder> {

    public MainAdapter(int layoutResId, @Nullable List<MainBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, MainBean mainBean) {
        baseViewHolder.setText(R.id.btn, mainBean.name);
    }
}
