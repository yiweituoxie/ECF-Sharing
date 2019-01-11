package com.jinli.sharing.http;


import com.jinli.sharing.model.response.LoginResponse;

import io.reactivex.Observable;
import retrofit2.http.POST;

/**
 * Created by Jin on 10/15/2018
 */
interface HttpInterface {

    @POST("login")
    public Observable<LoginResponse> login();
}