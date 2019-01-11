package com.jinli.sharing.mvvm;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by Jin on 1/10/2019
 */
public class MvvmTestViewModel extends ViewModel {

    private MutableLiveData<User> userLiveData;

    public LiveData<User> getUser(){
        if (userLiveData == null){
            userLiveData = new MutableLiveData<>();
            loadUser();
        }
        return userLiveData;
    }

    public void loadUser() {
        User user = new User();
        user.setAge(25);
        user.setName("Jin");
        userLiveData.setValue(user);
    }


}
