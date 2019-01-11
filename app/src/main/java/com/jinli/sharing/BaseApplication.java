package com.jinli.sharing;

import android.app.Application;
import android.util.Log;

/**
 * Created by Jin on 1/10/2019
 */
public class BaseApplication extends Application {
    private static String TAG = "BaseApplication";
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"onCreate");
    }
}
