#SVG使用
----------

Google在Android 5.X中提供了两个新API来帮助支持SVG:
__1. VectorDrawable__
__2. AnimatedVectorDrawable__
__目前主要记录，SVG日常使用，具体API后续在做学习__

## 1.什么是SVG
SVG (Scalable Vector Graphics, 可伸缩矢量图形) 是W3C 推出的一种开放标准的文本式矢量图形描述语言,
他是基于XML的、专门为网络而设计的图像格式，SVG是一种采用XML来描述二维图形的语言，所以它可以直接打开xml文件来修改和编辑

    矢量图有以下等优点：
    1、矢量图是用点和线来描述图形，所以文件会比较小，同时也能提供高清晰的画面
    2、矢量图缩放自由且不会失真，完全适配于任何分辨率的屏幕
    3、矢量图的是以xml语言来描述的，所以它修改自如
    4、矢量图色彩分辨率非常高清，同时支持滤镜
    5、跨平台，因为矢量图是纯文本格式来描述的，所以不受平台的限制

    《Path》：
    M = moveto(M X,Y) ：将画笔移动到指定的坐标位置
    L = lineto(L X,Y) ：画直线到指定的坐标位置
    H = horizontal lineto(H X)：画水平线到指定的X坐标位置
    V = vertical lineto(V Y)：画垂直线到指定的Y坐标位置
    C = curveto(C X1,Y1,X2,Y2,ENDX,ENDY)：三次贝赛曲线
    S = smooth curveto(S X2,Y2,ENDX,ENDY)：三次贝赛曲线
    Q = quadratic Belzier curve(Q X,Y,ENDX,ENDY)：二次贝赛曲线
    T = smooth quadratic Belzier curveto(T ENDX,ENDY)：映射前面路径后的终点
    A = elliptical Arc(A RX,RY,XROTATION,FLAG1,FLAG2,X,Y)：弧线

## 2.SVG使用

 1. 常用获取SVG资源库
 [阿里巴巴适量图标库][1]
 [Fontello][2]
 [IcoMoon][3]
 [Fontastic][4]
图片转SVG path　格式可以使用VectorMagic


 2. 在Android中使用SVG图标


**1.作为Drawable使用**

>  1.将.svg文件转换成Android Drawable文件，可以使用第三方工具如：[SVG To Android][5]
或者Ａndroid Studio 自带工具
![svg1](svg)
![svg2]()

> 2. 生成Drawable后，就可以像使用Drawable资源一样在Android中使用

```
             <ImageView android:layout_width="wrap_content"
               android:layout_height="wrap_content"
               android:src="@drawable/ic_svg_test_drawable"/>
```

**2.使用PathVieW**
这个框架主要是svg通过path来绘制动画，Github地址为：https://github.com/geftimov/android-pathview

**3.创建自定义字体使用**

**step1:** 从iconfont平台选择要使用到的图标，并下载至本地；复制字体文件到项目 assets 目录；

**step2:** 打开下载下来的文件，并在目录中打开demo.html，找到图标相对应的 unicode 实体字符码

**step3:** 打开 res/values/strings.xml，添加 string 值


```
 <string name="test_font">&#xe66e;</string>
```

 **step4:** 打开 activity_main.xml，添加 string 值到 TextView：

    <TextView
        android:id="@+id/like"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/icons" />


   **step5:** 为 TextView 指定文字

```
      Typeface iconfont = Typeface.createFromAsset(getAssets(), "iconfont/iconfont.ttf");
    TextView textview = (TextView)findViewById(R.id.like);
    textview.setTypeface(iconfont);
```

**使用第三方View简化自定义字体步骤**
[Android-Iconics](https://github.com/mikepenz/Android-Iconics)
使用Android-Iconics可以简化自定义字体的步骤，同时它还提供了很多不同的已经创建好的字体库供使用

**使用步骤**

**step 1** 加入核心依赖

```
implementation "com.mikepenz:iconics-core:3.0.0@aar"
```
**step 2** 加入自定义View依赖

```
implementation "com.mikepenz:iconics-views:3.0.0@aar"
```

**step 3** 可以选择字体库依赖，也可以使用自定义字体库，不选择这里提供的

```
implementation 'com.mikepenz:google-material-typeface:3.0.1.2.original@aar'
implementation 'com.mikepenz:material-design-iconic-typeface:2.2.0.4@aar'
implementation 'com.mikepenz:fontawesome-typeface:4.7.0.2@aar'
implementation 'com.mikepenz:octicons-typeface:3.2.0.4@aar'
implementation 'com.mikepenz:meteocons-typeface:1.1.0.4@aar'
implementation 'com.mikepenz:community-material-typeface:2.0.46.1@aar'
implementation 'com.mikepenz:weather-icons-typeface:2.0.10.4@aar'
implementation 'com.mikepenz:typeicons-typeface:2.0.7.4@aar'
implementation 'com.mikepenz:entypo-typeface:1.0.0.4@aar'
implementation 'com.mikepenz:devicon-typeface:2.0.0.4@aar'
implementation 'com.mikepenz:foundation-icons-typeface:3.0.0.4@aar'
implementation 'com.mikepenz:ionicons-typeface:2.0.1.4@aar'
implementation 'com.mikepenz:pixeden-7-stroke-typeface:1.2.0.2@aar'
```
**step 4** 在activity中设置布局填充


```
@Override
protected void onCreate(Bundle savedInstanceState) {
    LayoutInflaterCompat.setFactory2(getLayoutInflater(), new IconicsLayoutInflater2(getDelegate()));
    //...
    super.onCreate(savedInstanceState);
    //...
}
```
或者

```
@Override
protected void onCreate(Bundle savedInstanceState) {
    LayoutInflaterCompat.setFactory(getLayoutInflater(), new IconicsLayoutInflater(getDelegate()));
    //...
    super.onCreate(savedInstanceState);
    //...
}
```

**step 5**  在代码中使用，获取字符对应的Drawable 然后设置:

```
new IconicsDrawable(this)
    .icon(FontAwesome.Icon.faw_android)
    .color(Color.RED)
    .sizeDp(24)
```
在布局文件中使用，使用提供字体库的图标名称规则 gmd-favorite --> fontId-iconName：
在代码中找到com.mikepenz:**==ionicons==**-typeface字体库对应类中Icon 枚举有对应的名称和对应的unicode编码

```
<ImageView
        android:layout_width="48dp"
        android:layout_height="48dp"
        app:ico_color="@color/colorAccent"
        app:ico_icon="ion-android-alarm-clock"
        app:ico_size="48dp"/>

        <TextView
        android:text="{ion-android-alarm-clock} Chart"
        android:textColor="@android:color/black"
        android:layout_width="wrap_content"
        android:layout_height="56dp"
        android:textSize="16sp"/>
```

如果是使用自定义控件库控件 就不需要操作step 4

```
<com.mikepenz.iconics.view.IconicsImageView
    android:layout_width="72dp"
    android:layout_height="72dp"
    app:iiv_color="@android:color/holo_red_dark"
    app:iiv_icon="gmd-favorite" />

    <com.mikepenz.iconics.view.IconicsTextView
        android:text="abc{hif-test}defgh{faw-adjust}ijk{fon-test1}lmnopqrstuv{fon-test2}wxyz"
        android:textColor="@android:color/black"
        android:layout_width="wrap_content"
        android:layout_height="56dp"
        android:textSize="16sp"/>

        <com.mikepenz.iconics.view.IconicsButton
        android:text="{faw-adjust} Button"
        android:layout_width="120dp"
        android:layout_height="60dp"/>

        //可以使用一下类来为TextView中的图片设置显示格式等等
        new Iconics.IconicsBuilder().ctx(this)
                .style(new ForegroundColorSpan(Color.WHITE), new BackgroundColorSpan(Color.BLACK), new RelativeSizeSpan(2f))
                .styleFor(FontAwesome.Icon.faw_adjust, new BackgroundColorSpan(Color.RED))
                .on(tv1)
                .build();
```

**使用自定义字体库**
使用：[创建自定义字体](http://android-iconics.mikepenz.com/) 传入 *.ttf and *.css 文件，即可制作出对应规则的字体库
使用自定义字体需要设置：

```
public class CustomApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //only required if you add a custom or generic font on your own
        Iconics.init(getApplicationContext());

        //register custom fonts like this (or also provide a font definition file)
        Iconics.registerFont(new CustomFont());
    }
}
```




  [1]: http://www.iconfont.cn
  [2]: http://fontello.com/
  [3]: http://icomoon.io/
  [4]: http://app.fontastic.me/
  [5]: http://oss.chengxingyao.cn/