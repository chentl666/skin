package com.ctl.skin.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatViewInflater;

import com.ctl.skin.views.SkinnableButton;
import com.ctl.skin.views.SkinnableImageView;
import com.ctl.skin.views.SkinnableLinearLayout;
import com.ctl.skin.views.SkinnableRelativeLayout;
import com.ctl.skin.views.SkinnableTextView;


/**
 * 自定义控件加载器（可以考虑该类不被继承）
 */
public final class CustomAppCompatViewInflater extends AppCompatViewInflater {

    private String name; // 控件名
    private Context context; // 上下文
    private AttributeSet attrs; // 某控件对应所有属性

    public CustomAppCompatViewInflater(@NonNull Context context) {
        this.context = context;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttrs(AttributeSet attrs) {
        this.attrs = attrs;
    }

    /**
     * @return 自动匹配控件名，并初始化控件对象
     */
    public View autoMatch() {
        View view = null;
        switch (name) {
            case "LinearLayout":
                // view = super.createTextView(context, attrs); // 源码写法
                view = new SkinnableLinearLayout(context, attrs);
                this.verifyNotNull(view, name);
                break;
            case "RelativeLayout":
                view = new SkinnableRelativeLayout(context, attrs);
                this.verifyNotNull(view, name);
                break;
            case "TextView":
            case "androidx.appcompat.widget.AppCompatTextView":
                view = new SkinnableTextView(context, attrs);
                this.verifyNotNull(view, name);
                break;
            case "ImageView":
            case "androidx.appcompat.widget.AppCompatImageView":
                view = new SkinnableImageView(context, attrs);
                this.verifyNotNull(view, name);
                break;
            case "Button":
            case "androidx.appcompat.widget.AppCompatButton":
                view = new SkinnableButton(context, attrs);
                this.verifyNotNull(view, name);
                break;
        }

        return view;
    }

    /**
     * 校验控件不为空（源码方法，由于private修饰，只能复制过来了。为了代码健壮，可有可无）
     *
     * @param view 被校验控件，如：AppCompatTextView extends TextView（v7兼容包，兼容是重点！！！）
     * @param name 控件名，如："ImageView"
     */
    private void verifyNotNull(View view, String name) {
        if (view == null) {
            throw new IllegalStateException(this.getClass().getName() + " asked to inflate view for <" + name + ">, but returned null");
        }
    }
}
