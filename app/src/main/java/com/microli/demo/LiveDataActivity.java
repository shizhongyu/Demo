package com.microli.demo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * Copyright (c) 2021 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @Author microli
 * 2022/2/6
 */
public class LiveDataActivity extends BaseActivity {

    private NameViewModel model;
    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.live_data);
        initView();
        // Other code to setup the activity...

        // Get the ViewModel.
        model = new ViewModelProvider(this).get(NameViewModel.class);

        // Create the observer which updates the UI.
        final Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String newName) {
                // Update the UI, in this case, a TextView.
                mText.setText(newName);
            }
        };

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        model.getCurrentName().observe(this, nameObserver);
        initView();
    }

    private void initView() {
        mText = (TextView) findViewById(R.id.text);
    }

    public class NameViewModel extends ViewModel {

        // Create a LiveData with a String
        private MutableLiveData<String> currentName;

        public MutableLiveData<String> getCurrentName() {
            if (currentName == null) {
                currentName = new MutableLiveData<String>();
            }
            return currentName;
        }

// Rest of the ViewModel...
    }
}
