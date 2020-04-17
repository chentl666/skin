package com.ctl.skin.utils;

import android.annotation.TargetApi;
import android.content.res.TypedArray;
import android.os.Build;

import androidx.appcompat.app.AppCompatActivity;

public class NavigationUtils {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void forNavigation(AppCompatActivity activity) {
        TypedArray a = activity.getTheme().obtainStyledAttributes(0, new int[]{
                android.R.attr.statusBarColor
        });
        int color = a.getColor(0, 0);
        activity.getWindow().setNavigationBarColor(color);
        a.recycle();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void forNavigation(AppCompatActivity activity, int skinColor) {
        activity.getWindow().setNavigationBarColor(skinColor);
    }
}
