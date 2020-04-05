### 适配器模式
在我们的应用程序中我们可能需要将两个不同接口的类来进行通信，在不修改这两个的前提下我们可能会需要某个中间件来完成这个衔接的过程。这个中间件就是适配器。所谓适配器模式就是将一个类的接口，转换成客户期望的另一个接口。它可以让原本两个不兼容的接口能够无缝完成对接。

作为中间件的适配器将目标类和适配者解耦，增加了类的透明性和可复用性。

![Alt text](https://images2017.cnblogs.com/blog/401339/201709/401339-20170929205627606-1781915371.png)


 
~~~~
适配器模式包含如下角色：
Target：目标抽象类
Adapter：适配器类
Adaptee：适配者类
Client：客户类
~~~~