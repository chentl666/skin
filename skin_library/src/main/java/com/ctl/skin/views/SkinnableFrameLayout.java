package com.ctl.skin.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.ctl.skin.R;
import com.ctl.skin.SkinManager;
import com.ctl.skin.core.ViewsMatch;
import com.ctl.skin.model.AttrsBean;

/**
 * created by : chentl
 * Date: 2020/04/17
 */
public class SkinnableFrameLayout extends FrameLayout implements ViewsMatch {

    private AttrsBean attrsBean;

    public SkinnableFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public SkinnableFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SkinnableFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        attrsBean = new AttrsBean();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SkinnableFrameLayout, defStyleAttr, 0);
        attrsBean.saveViewResource(typedArray, R.styleable.SkinnableFrameLayout);
        typedArray.recycle();
    }


    @Override
    public void skinnableView() {
        int key = R.styleable.SkinnableFrameLayout[R.styleable.SkinnableFrameLayout_android_background];
        int resource = attrsBean.getViewResource(key);
        if (resource > 0) {
            if (SkinManager.getInstance().isDefaultSkin()) {
                Drawable drawable = ContextCompat.getDrawable(getContext(), resource);
                setBackground(drawable);
            } else {

                Object src = SkinManager.getInstance().getBackgroundOrSrc(resource);
                if (src instanceof Integer) {
                    int color = (int) src;
                    setBackgroundColor(color);
                } else {
                    Drawable drawable = (Drawable) src;
                    setBackground(drawable);
                }
            }
        }
    }
}
