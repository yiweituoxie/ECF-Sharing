package com.jinli.sharing.internet;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.jinli.sharing.http.BaseObserver;
import com.jinli.sharing.http.HttpManager;
import com.jinli.sharing.model.response.LoginResponse;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Jin on 1/10/2019
 */
public class HttpTestViewModel extends ViewModel {

    public MutableLiveData<LoginResponse> userLiveData = new MutableLiveData();

    private Disposable mDisposable = null;


    public void loadUser() {

        mDisposable = HttpManager.login().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new BaseObserver<LoginResponse>() {
                    @Override
                    public void onNext(LoginResponse loginResponse) {
                        userLiveData.setValue(loginResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        LoginResponse user = new LoginResponse();
                        user.setName("null");
                        user.setAge(0);
                        userLiveData.setValue(user);
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                    }
                });
    }

    @Override
    protected void onCleared() {
        mDisposable.dispose();
        super.onCleared();
    }
}
