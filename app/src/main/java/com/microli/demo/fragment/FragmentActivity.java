package com.microli.demo.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.microli.demo.BaseActivity;
import com.microli.demo.R;
import com.microli.demo.databinding.ViewBindingBinding;

public class FragmentActivity extends BaseActivity implements View.OnClickListener{

    private static final String TAG = FragmentActivity.class.getCanonicalName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity);
        Button button = (Button) findViewById(R.id.button);
        findViewById(R.id.button_1).setOnClickListener(this);
        button.setOnClickListener(this);
        if (savedInstanceState == null) {
            replaceFragment(new LeftFragment());
            FragmentActivity.class.getCanonicalName();
            Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                replaceFragment(new LeftFragment());
                break;
            case R.id.button_1:
                replaceFragment(new RightFragment());
                break;
            default:
                break;
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();   // 开启一个事务
        transaction.replace(R.id.right_layout, fragment);
        transaction.commitNowAllowingStateLoss();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }
}
