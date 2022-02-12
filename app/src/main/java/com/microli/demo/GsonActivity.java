package com.microli.demo;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.google.gson.Gson;

/**
 * Copyright (c) 2021 Tencent. All rights reserved.
 * 类功能描述:
 * 更多使用请查看 https://github.com/google/gson/blob/master/UserGuide.md
 *
 * @Author microli
 * 2022/2/12
 */
public class GsonActivity extends BaseActivity {

    private TextView mText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gson_ac);


        // Serialization
        initView();
        BagOfPrimitives obj = new BagOfPrimitives();
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        Log.d(TAG, "onCreate() returned: " + json);
        mText.setText(json);
        BagOfPrimitives bagOfPrimitives = gson.fromJson(json, BagOfPrimitives.class);
        Log.d(TAG, "onCreate: " + bagOfPrimitives);

        BagOfPrimitives bagOfPrimitives1 = new BagOfPrimitives();
        bagOfPrimitives1.bagOfPrimitives = bagOfPrimitives;
    }

    private void initView() {
        mText = (TextView) findViewById(R.id.text);
    }


    static class BagOfPrimitives {
        private int value1 = 1;
        private String value2 = "abc";
        private transient int value3 = 3;
        private Book book = new Book();

        /**
         * 特别注意这里
         */
        public BagOfPrimitives bagOfPrimitives;

        BagOfPrimitives() {
            // no-args constructor
        }
    }

    static class Book {
        String name = "book";
    }


}
