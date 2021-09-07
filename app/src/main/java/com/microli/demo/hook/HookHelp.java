package com.microli.demo.hook;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HookHelp implements InvocationHandler {
    private static final String TAG = "HookHelp";
    private Object object;

    public HookHelp(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(object, args);
        if(method.getName().equals("onClick")) {
            Log.d(TAG, "invoke() called with: proxy = [" + proxy + "], method = [" + method + "], args = [" + args + "]");
        }
        return result;
    }
}
