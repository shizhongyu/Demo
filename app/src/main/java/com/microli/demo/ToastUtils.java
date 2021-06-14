package com.microli.demo;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {
    public static final void showLong(Context context, String string) {
        Toast.makeText(context, string, Toast.LENGTH_LONG).show();
    }

    public static final void showShort(Context context, String string) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
    }

}
