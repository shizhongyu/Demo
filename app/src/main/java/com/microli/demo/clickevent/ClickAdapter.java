package com.microli.demo.clickevent;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.microli.demo.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ClickAdapter extends BaseQuickAdapter<ClickBean, BaseViewHolder> {
    public ClickAdapter(int layoutResId, @Nullable List<ClickBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, ClickBean clickBean) {
        baseViewHolder.setText(R.id.btn, clickBean.name);
    }
}
