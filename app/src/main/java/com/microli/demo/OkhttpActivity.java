package com.microli.demo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Copyright (c) 2021 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @Author microli
 * 2022/1/22
 */
public class OkhttpActivity extends BaseActivity {
    private final OkHttpClient mOkHttpClient = new OkHttpClient();
    private Button mBtn;
    private Button mBtn01;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ok_ac);
        initView();

    }

    private void syncRequest() {
        String url = "https://www.jianshu.com/p/227666f390f1";
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            Log.d(TAG, "syncRequest() returned: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void asyncRequest() {
        String url = "https://www.jianshu.com";
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
           @Override
           public void onFailure(Call call, IOException e) {

           }

           @Override
           public void onResponse(Call call, Response response) throws IOException {
               Log.d(TAG, "onResponse() returned: " + response);
           }
       });
    }

    private void initView() {
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        syncRequest();
                    }
                }).start();
            }
        });
        mBtn01 = (Button) findViewById(R.id.btn_01);
        mBtn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asyncRequest();
            }
        });
    }
}
