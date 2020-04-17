package com.ctl.skin_tast;

import android.app.Application;

import com.ctl.skin.SkinManager;

/**
 * created by : chentl
 * Date: 2020/04/16
 */
public class SkinApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SkinManager.init(this);
    }
}
