package com.microli.demo;

import android.content.Context;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


/**
 * Android：这是一份全面 & 详细的Webview使用攻略
 * https://www.jianshu.com/p/3c94ae673e2a
 */
public class WebViewActivity extends BaseActivity {
    private static final String TAG = "WebViewActivity";
    private TextView mText;
    private WebView mWebview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
        mWebview = (WebView) findViewById(R.id.webview);
        mWebview.loadUrl("http://www.baidu.com/");

//声明WebSettings子类
        WebSettings webSettings = mWebview.getSettings();

//如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);
// 若加载的 html 里有JS 在执行动画等操作，会造成资源浪费（CPU、电量）
// 在 onStop 和 onResume 里分别把 setJavaScriptEnabled() 给设置成 false 和 true 即可

//设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小

//缩放操作
        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件

//其他细节操作
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式

        mWebview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        initView();
    }

    private void initView() {
        mText = (TextView) findViewById(R.id.text);
        CharSequence text = mText.getText();
        if (text instanceof Spannable) {
            int end = text.length();
            Spannable sp = (Spannable) text;
            URLSpan[] urls = sp.getSpans(0, end, URLSpan.class);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
            spannableStringBuilder.clearSpans();
            for (URLSpan urlSpan : urls) {
                //拦截点击
                InterceptLinkSpan interceptUrlSpan = new InterceptLinkSpan(urlSpan.getURL()) {
                };
                Log.d(TAG, "initView() called" + urlSpan.getURL());
                spannableStringBuilder.setSpan(interceptUrlSpan, sp.getSpanStart(urlSpan),
                        sp.getSpanEnd(urlSpan), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
            }
            mText.setText(spannableStringBuilder);
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
            spannableStringBuilder.clearSpans();
            mText.setText(spannableStringBuilder);
        }
    }

    public class InterceptLinkSpan extends ClickableSpan {

        private Context mContext;
        private String mUrl;

        public InterceptLinkSpan(String mUrl) {
            this.mUrl = mUrl;
        }

        public InterceptLinkSpan(Context mContext, String mUrl) {
            this.mContext = mContext;
            this.mUrl = mUrl;
        }

        @Override
        public void onClick(@NonNull View widget) {
            Log.d(TAG, "onClick() returned: " + mUrl);
            mWebview.loadUrl(mUrl);
        }
    }
}
