# skin

动态换肤框架

基于androidx库开发
	
1.先在项目根目录的 build.gradle 的 repositories 添加:
```
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```

2.然后在dependencies添加:
```
dependencies {
	...
	implementation 'com.github.chentl666:skin:1.0.0'
}
```

3.Application
```
public class SkinApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SkinManager.init(this);
    }
}

```

3.activity继承SkinActivity：
```

 skinDynamic(skinPath, R.color.skin_item_color);
 传入皮肤包路径和主题色。

 defaultSkin(R.color.colorPrimary);
 恢复原始主题

 在activity中重写openChangeSkin()。
     @Override
     protected boolean openChangeSkin() {
         return true;
     }


```
4.打一个相同资源名称的apk，修改名称存放到手机中，获取资源包的路径


5.判断是否默认包
    SkinManager.getInstance().isDefaultSkin();


说明：本项目基于androidx库开发，所以组件必须是androidx..AppCompat***,否则不支持换肤。
...

自定义控件实现com.ctl.skin.core.ViewsMatch接口，重写skinnableView()方法
```
    @Override
    public void skinnableView() {
        // 根据自定义属性，获取styleable中的circleColor属性
        int key = R.styleable.CustomCircleView[0]; // = R.styleable.CustomCircleView_circleColor
        int resourceId = attrsBean.getViewResource(key);
        if (resourceId > 0) {
            if (SkinManager.getInstance().isDefaultSkin()) {
                int color = ContextCompat.getColor(getContext(), resourceId);
                mTextPain.setColor(color);
            } else {
                int color = SkinManager.getInstance().getColor(resourceId);
                mTextPain.setColor(color);
            }
        }
        invalidate();
    }
```
