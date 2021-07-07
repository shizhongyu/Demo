package com.microli.demo;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ANRActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "ANRActivity";
    private static final String GRADLE_TASK_TREE_LOG = "android.txt";

    private Button mClick01;
    private Button mClick02;
    private Button mClick03;
    private Object lock1 = new Object();
    private Object lock2 = new Object();
    private Button mClick04;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anr_activity);
        initView();
    }

    private void initView() {
        mClick01 = (Button) findViewById(R.id.click_01);
        mClick02 = (Button) findViewById(R.id.click_02);
        mClick03 = (Button) findViewById(R.id.click_03);
        mClick04 = (Button) findViewById(R.id.click_04);
        mClick01.setOnClickListener(this::onClick);
        mClick02.setOnClickListener(this::onClick);
        mClick03.setOnClickListener(this::onClick);
        mClick04.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.click_01:
                for (; ; ) {
                    Log.d(TAG, "onClick() called with: v = [" + v + "]");
                }
            case R.id.click_02:
                for (int i = 0; i < 100; i++) {
                    copyFile();
                    Log.d(TAG, "onClick() -- called with: v = [" + v + "]");
                }
                break;
            case R.id.click_03:
//                try {
//                    Thread.sleep(1000000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                threadAnr();
                break;
            case R.id.click_04:
                ToastUtils.showShort(this, "Toast");
                break;
        }
    }

    private void copyFile() {
        Log.i(TAG, "io on main thread, start at :" + System.currentTimeMillis());
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            AssetManager assetManager = getAssets();
            inputStream = assetManager.open(GRADLE_TASK_TREE_LOG);
            fileOutputStream = new FileOutputStream(new File(Environment.getExternalStorageDirectory()
                    + File.separator + GRADLE_TASK_TREE_LOG));
            byte[] buffer = new byte[1024];
            int byteCount = 0;
            while ((byteCount = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, byteCount);
            }
            fileOutputStream.flush();//刷新缓冲区
        } catch (IOException e) {
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
                inputStream = null;
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                }
                fileOutputStream = null;
            }
        }
        Log.i(TAG, "io on main thread, end at :" + System.currentTimeMillis());
    }

    private void threadAnr() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2) {
                    Log.i(TAG, "worker thread got lock2");
                    try {
                        Thread.sleep(7000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock1) {
                        Log.i(TAG, "worker thread got lock1");
                    }
                }
            }
        }).start();
        synchronized (lock1) {
            Log.i(TAG, "main thread got lock1");
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2) {
                Log.i(TAG, "main thread got lock2");
            }
        }
    }
}
