###原型模式

在我们应用程序可能有某些对象的结构比较复杂，但是我们又需要频繁的使用它们，如果这个时候我们来不断的新建这个对象势必会大大损耗系统内存的，这个时候我们需要使用原型模式来对这个结构复杂又要频繁使用的对象进行克隆。所以原型模式就是用原型实例指定创建对象的种类，并且通过复制这些原型创建新的对象。

它主要应用与那些创建新对象的成本过大时。它的主要优点就是简化了新对象的创建过程，提高了效率，同时原型模式提供了简化的创建结构。UML结构图：

![Alt text](https://images2017.cnblogs.com/blog/401339/201709/401339-20170929205441153-1950745368.png)


 
~~~~
模式结构
原型模式包含如下角色：
Prototype：抽象原型类
ConcretePrototype：具体原型类
Client：客户类
~~~~