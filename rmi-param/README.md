## 动态类加载 ##

当一个远程对象，作为远程方法的参数或者返回值，传递给另一个程序时，该程序必须拥有此远程对象的类文件。

假设服务器端创建并返回一个对象（比如某接口的实现类），而客户端从未见过该对象所对应的类，而且根本不知道在哪能找到这个类。

客户端需要拥有在运行时加载额外类的能力，客户端使用了与 RMI 注册表相同的机制，即类由 Web 服务器提供服务，RMI 服务器类将 URL 传递给客户端，客户端创建要求下载这些类文件的 HTTP 请求。该过程与运行在浏览器中的 applet 类加载过程类似。

当程序从网络上的另一个地方加载新的代码时，总会遇到安全问题。因此，在RMI客户端应用程序需要使用安全管理器（security manager）。

这种安全机制可以保护存根代码中的程序免受病毒攻击。对特定的程序，程序员可以替换它们的类加载器和安全管理器。

不过，RMI系统提供的类加载器与安全管理器已经能够满足通常的应用了。


## 远程方法中的参数传递 ##


开始进行远程方法调用时，调用参数需要从客户端的虚拟机移动到服务器的虚拟机中。在调用完成之后，返回值需要进行反方向传递。

对于从一个虚拟机向另一个虚拟机传值，可区分为两种情况：传递远程对象和传递非远程对象。

### 传递远程对象

当一个远程对象的引用从一个虚拟机传递到另一个虚拟机时，该远程对象的发送者和接收者都持有对同一个实例的引用。

这个引用并非是一个内存位置（内存位置在单个虚拟机内才有意义），而是由网络地址和该远程对象的惟一标识符构成的。这个信息封装在存根对象中。

从概念上讲，传递远程引用与在虚拟机内部传递本地对象引用很相似，但远程引用上的方法调用要慢得多，也更不可靠。


### 传递非远程对象

使用远程方法调用时，可以传递/返回任何对象，不仅仅是实现了 Remote 接口的对象。当一个不是远程对象的对象，需要从一个虚拟机传送到另一个虚拟机时，第一个虚拟机会制作一份该对象的拷贝，然后将此拷贝通过网络连接发送到另一个虚拟机。

RMI 机制可以复制更复杂的对象，只要它们是可序列化的（实现 Serializable 接口），RMI 使用序列化机制通过网络连接发送对象。


总之，远程对象是作为存根通过网络传递的，而非远程对象则是复制的。所有这些都是自动的，无需程序员干涉。

当调用远程方法时，存根就将所有参数值的副本打包，发送给服务器，其中用到了对象序列化机制来编组参数。在服务器端将解除这些编组，这个过程会很慢，尤其是参数对象很大的时候。


### 远程对象激活

初始化大量的远程对象，是一种浪费，因为无论客户端是否使用它们，它们都在一直等待连接。
激活机制（activation）允许延迟构造远程对象，仅当至少有一个客户端调用远程对象上的远程方法时，才真正去构造该远程对象。

为此，服务器程序需要由一个激活程序来代替，该程序构造了对象的激活描述符。第一次对这样的对象进行方法调用时，激活描述符中的信息将会用来构造该对象。