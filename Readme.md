# StarView

> 简述：关于星星的View，满足你对所有个角的星星的幻想。


## 描述

项目包括StarView，StarDrawable，PathStarView。

StarView由普通图片绘制而成。

StaDrawable是一个Drawable类。支持任意多个角（Angular）。

PathStarView 支持任意多个角（Angular） 的星星View。

[注]
为支持任意多个角度的星星，经过了一系列复杂的数学运算，这将在文末有说明。

## 预览

它们的效果如下。

![000](https://raw.githubusercontent.com/Mingyueyixi/StarView/master/preview/000.png)

**StarView**

---
![001](https://raw.githubusercontent.com/Mingyueyixi/StarView/master/preview/001.png)

**StarDrawable**

---

![002](https://raw.githubusercontent.com/Mingyueyixi/StarView/master/preview/002.png)

**PathStarView**

---

![003](https://raw.githubusercontent.com/Mingyueyixi/StarView/master/preview/003.png)

**PathStarView -- depth参数**

---

![004](https://raw.githubusercontent.com/Mingyueyixi/StarView/master/preview/004.png)

**PathStarView -- rotate参数**

---

![006](https://raw.githubusercontent.com/Mingyueyixi/StarView/master/preview/006.png)

**PathStarView -- size参数**

---

![007](https://raw.githubusercontent.com/Mingyueyixi/StarView/master/preview/007.png)

**PathStarView -- horm参数**

---

![005](https://raw.githubusercontent.com/Mingyueyixi/StarView/master/preview/005.png)

**PathStarView -- 综合效果**

---

## 相关算法说明

### 正多角星

多角星星在计算时，通过圆内接正多边形减去特定弧度的三角形而成，因此，这样的星星被我称为正多角星。

至于非正多角星。因为可以随手画出，不能归纳为数学函数。因此，不做研究。


### 涉及公式

涉及最多的是圆的函数公式，衍生的公式（弧的计算，三角函数等），以及勾股定理。

### 推导图

Android的屏幕坐标与常规坐标不同，其Y轴完全相反，在计算上会带来一定的困惑性。
下面是我计算正多角星的图解：

![]()

## 其他

- 这个计算可能存在其他方式，期待能看到其他的算法实现。

- 项目仅仅能跑而已，代码结构等还有待改进。



