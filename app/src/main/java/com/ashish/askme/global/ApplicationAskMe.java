package com.ashish.askme.global;

import android.app.Application;

import com.ashish.askme.activity.BaseActivity;

/**
 * Created by akohlikashish on 20/04/16.
 */
public class ApplicationAskMe extends Application {
    private static ApplicationAskMe mInstance;
    private BaseActivity mActivity;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static ApplicationAskMe getmInstance() {
        return mInstance;
    }


    public void saveActivity(BaseActivity a) {
        this.mActivity = a;
    }

    public BaseActivity getmActivity() {
        return this.mActivity;
    }
}
