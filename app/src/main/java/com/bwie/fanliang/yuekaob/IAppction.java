package com.bwie.fanliang.yuekaob;

import android.app.Application;

import org.xutils.x;

/**
 * Created by lenovo-pc on 2017/5/28.
 */

public class IAppction extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        x.Ext.init(this);


    }
}
