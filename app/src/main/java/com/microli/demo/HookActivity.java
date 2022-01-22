package com.microli.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.microli.demo.hook.HookHelp;
import com.microli.demo.hook.HookSetOnClickListenerHelper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import okhttp3.OkHttpClient;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;

public class HookActivity extends BaseActivity {
    private Button view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hook_activity);
        initView();
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort(HookActivity.this, "click");
            }
        };
        view.setOnClickListener(onClickListener);
        HookHelp hookHelp = new HookHelp(onClickListener);
        ClassLoader classLoader = onClickListener.getClass().getClassLoader();
        Object object
                = Proxy.newProxyInstance(classLoader, new Class[]{View.OnClickListener.class}, hookHelp);

        //------------------------------
        Method method = null;
        try {
            method = View.class.getDeclaredMethod("getListenerInfo");
            method.setAccessible(true);//由于getListenerInfo()方法并不是public的，所以要加这个代码来保证访问权限
            Object mListenerInfo = method.invoke(view);//这里拿到的就是mListenerInfo对象，也就是点击事件的持有者

            //要从这里面拿到当前的点击事件对象
            Class<?> listenerInfoClz = Class.forName("android.view.View$ListenerInfo");// 这是内部类的表示方法
            Field field = listenerInfoClz.getDeclaredField("mOnClickListener");
            field.set(mListenerInfo, object);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //-----------------------------------------------------------

        HookSetOnClickListenerHelper.hook(this, view);
    }

    private void initView() {
        view = findViewById(R.id.view);
    }
}
