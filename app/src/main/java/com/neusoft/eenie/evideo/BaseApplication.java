package com.neusoft.eenie.evideo;

import android.app.Application;

import org.xutils.x;

import cn.bmob.v3.Bmob;

/**
 * Created by Eenie on 2015/12/3.
 *
 */
public class BaseApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, "1fa3a09461a2ce601181c164d2aafd40");
        x.Ext.init(this);
    }
}
