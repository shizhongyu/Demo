package com.microli.demo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class EditActivity extends BaseActivity {

    private TextView mTv01;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_activity);


        initView();
    }

    private void initView() {
        mTv01 = (TextView) findViewById(R.id.tv_01);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        mTv01.requestFocus();
    }
}
