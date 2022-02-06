package com.microli.demo.databingding;

import androidx.databinding.ObservableInt;

/**
 * Copyright (c) 2021 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @Author microli
 * 2022/2/6
 */
public class ObservableField {
    public String name;
    public ObservableInt likes;


    public ObservableField(String name, ObservableInt likes) {
        this.name = name;
        this.likes = likes;
    }
}
