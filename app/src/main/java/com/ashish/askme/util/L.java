package com.ashish.askme.util;

import android.util.Log;

import com.ashish.askme.BuildConfig;

/**
 * Created by akohlikashish on 20/04/16.
 */
public class L {
    private static final String TAG = "##Askme";


    public static void v(String msg) {
        if (BuildConfig.DEBUG) {
            Log.v(TAG, msg);
        }

    }

    public static void v(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            Log.v(tag, msg);
        }

    }

    public static void e(String msg) {
        if (BuildConfig.DEBUG) {
            Log.e(TAG, msg);
        }
    }
}
