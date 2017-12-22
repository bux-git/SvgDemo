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


  [1]: http://www.iconfont.cn
  [2]: http://fontello.com/
  [3]: http://icomoon.io/
  [4]: http://app.fontastic.me/

 2. 在Android中使用SVG图标

     **step1:** 从iconfont平台选择要使用到的图标，并下载至本地；复制字体文件到项目 assets 目录；

    **step2:** 打开下载下来的文件，并在目录中打开demo.html，找到图标相对应的 HTML 实体字符码

    **step3:** 打开 res/values/strings.xml，添加 string 值

   **step4:**打开 activity_main.xml，添加 string 值到 TextView：

    <TextView
        android:id="@+id/like"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/icons" />


    **step5:**为 TextView 指定文字： 
     Typeface iconfont = Typeface.createFromAsset(getAssets(), "iconfont/iconfont.ttf");
     TextView textview = (TextView)findViewById(R.id.like);
    textview.setTypeface(iconfont);



