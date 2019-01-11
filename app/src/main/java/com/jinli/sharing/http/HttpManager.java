package com.jinli.sharing.http;

import com.jinli.sharing.model.response.LoginResponse;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jin on 10/15/2018
 */
public class HttpManager {

    private static OkHttpClient getMockClient() {
        OkHttpClient mockClient = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS).build();
        return mockClient;
    }

    private static HttpInterface serviceMock =
            new Retrofit.Builder()
                    .client(getMockClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl("https://easy-mock.com/mock/5b90c4a3c5ecb256d33e4bc9/ljj/mock/")
                    .build()
                    .create(HttpInterface.class);


    public static Observable<LoginResponse> login() {
        return serviceMock.login();
    }
}