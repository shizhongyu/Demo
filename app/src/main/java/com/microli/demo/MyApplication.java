package com.microli.demo;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.github.moduth.blockcanary.BlockCanary;
import com.squareup.leakcanary.LeakCanary;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        LeakCanary.install(this);
        BlockCanary.install(this, new AppBlockCanaryContext()).start();
        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this);
    }
}
