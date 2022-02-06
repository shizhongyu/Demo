package com.microli.demo;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableInt;

import com.microli.demo.databinding.DatabindingAcBinding;
import com.microli.demo.databingding.ObservableField;

/**
 * Copyright (c) 2021 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @Author microli
 * 2022/2/6
 */
public class DataBindingActivity extends BaseActivity{

    private ObservableField observableField = new ObservableField("test", new ObservableInt(0));

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabindingAcBinding binding = DataBindingUtil.setContentView(this, R.layout.databinding_ac);
        binding.setUser(observableField);
    }

    public void onLike(View view) {
        observableField.likes.set(observableField.likes.get() + 1);
    }
}
