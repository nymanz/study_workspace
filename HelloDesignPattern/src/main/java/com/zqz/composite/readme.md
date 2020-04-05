### 组合模式
组合模式组合多个对象形成树形结构以表示“整体-部分”的结构层次。它定义了如何将容器对象和叶子对象进行递归组合，使得客户在使用的过程中无须进行区分，可以对他们进行一致的处理。在使用组合模式中需要注意一点也是组合模式最关键的地方：叶子对象和组合对象实现相同的接口。这就是组合模式能够将叶子节点和对象节点进行一致处理的原因。

虽然组合模式能够清晰地定义分层次的复杂对象，也使得增加新构件也更容易，但是这样就导致了系统的设计变得更加抽象，如果系统的业务规则比较复杂的话，使用组合模式就有一定的挑战了。

![Alt text](https://images2017.cnblogs.com/blog/401339/201709/401339-20170929210011122-1282025445.png)


 
~~~~
 模式结构
组合模式包含如下角色：
Component: 抽象构件
Leaf: 叶子构件
Composite: 容器构件
Client: 客户类
~~~~

使用场景：需求中是体现部分与整体层次的结构时，以及希望用户可以忽略组合对象与单个对象的不同，统一地使用组合结构中的所有对象时，应考虑组合模式