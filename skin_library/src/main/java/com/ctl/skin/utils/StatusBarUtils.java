package com.ctl.skin.utils;

import android.annotation.TargetApi;
import android.content.res.TypedArray;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class StatusBarUtils {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void forStatusBar(AppCompatActivity activity) {
        TypedArray a = activity.getTheme().obtainStyledAttributes(0, new int[]{
                android.R.attr.statusBarColor
        });
        int color = a.getColor(0, 0);
        activity.getWindow().setStatusBarColor(color);
        a.recycle();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void forStatusBar(AppCompatActivity activity, int skinColor) {
        activity.getWindow().setStatusBarColor(skinColor);
    }
}
