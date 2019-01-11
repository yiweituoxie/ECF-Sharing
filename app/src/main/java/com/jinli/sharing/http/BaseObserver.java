package com.jinli.sharing.http;


import io.reactivex.observers.DisposableObserver;

/**
 * Created by Jin on 10/15/2018
 */
public abstract class BaseObserver<T> extends DisposableObserver<T>{
    @Override
    public void onComplete() {

    }
}