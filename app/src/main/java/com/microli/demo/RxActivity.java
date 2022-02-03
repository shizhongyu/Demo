package com.microli.demo;

import android.os.Bundle;

import androidx.annotation.Nullable;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;


/**
 * Copyright (c) 2021 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @Author microli
 * 2022/2/2
 */
public class RxActivity extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rx_ac);
        doRxjava();
    }

    //第一步：创建被观察者：create
    Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
        @Override
        public void call(Subscriber<? super String> subscriber) {
            subscriber.onNext("Hello");
            subscriber.onNext("Imooc");
            subscriber.onCompleted();
        }
    });

    //通过just方法来创建被观察者
    Observable observableJust = Observable.just("hello", "Imooc");

    //通过from方法来创建被观察者
    String[] parameters = {"hello", "Imooc"};
    Observable observableFrom = Observable.from(parameters);

    //第二步：创建观察者
    Observer<Object> observer = new Observer<Object>() {

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(Object s) {
            ToastUtils.showLong(RxActivity.this, s.toString());
        }
    };

    public void doRxjava(){
        //第三步：订阅
        observable.subscribe(observer);
    }
}
