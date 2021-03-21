# chatRoomDev多人聊天室

一直没有用心开发项目，决定趁这次机会为开源社区持续贡献绿色

想来想去做了一个基于springboot开发的聊天系统，感觉网络编程这一块比较能学到技术，其中大部分借鉴于大佬**Kanarien** 的开源版本，做了适当改进QwQ

贴出大佬的github地址(づ￣ 3￣)づhttps://github.com/Kanarienvogels

参考博客https://segmentfault.com/a/1190000015681145

[TOC]

## 1.项目技术支持

>开发工具：IDEA2019.3
>
>JDK：jdk1.8
>
>浏览器：chrome浏览器
>
>数据库：mysql5.7，redis
>
>其他技术
>
>>springboot
>>
>>mybatis
>>
>>Netty 4
>>
>>WebSocket + HTTP
>>
>>JQuery
>>
>>Bootstrap 3 + Bootstrap-fileinput（前端不太会写，原封不动搬QvQ（大佬对不起
>>
>>Maven

## 2.项目设计

Netty是一个高性能、异步事件驱动的NIO框架，它提供了对TCP、UDP和文件传输的支持，作为一个异步NIO框架，Netty的所有IO操作都是异步非阻塞的，通过Future-Listener机制，用户可以方便的主动获取或者通过通知机制获得IO操作结果。作为当前最流行的NIO框架，Netty在互联网领域、大数据分布式计算领域、游戏行业、通信行业等获得了广泛的应用，一些业界著名的开源组件也基于Netty的NIO框架构建。

Netty，为了尽可能提升性能，Netty采用了串行无锁化设计，在I/O线程内部进行串行操作，避免多线程竞争导致的性能下降。表面上看，串行化设计似乎CPU利用率不高，并发程度不够。但是，通过调整NIO线程池的线程参数，可以同时启动多个串行化的线程并行运行，这种局部无锁化的串行线程设计相比一个队列-多个工作线程模型性能更优。——摘取自《Netty高性能之道》

选netty来处理网络事件的连接和业务处理主要是为了提高服务器性能QvQ，不然我这菜鸡项目撑不了太多并发

![img](https://www.write-bug.com/upload/image/128/380603e195adb95159d7c48534ee3342.png)



Websocket是html5提出的一个协议规范，是为解决客户端与服务端实时通信而产生的技术。websocket协议本质上是一个基于tcp的协议，是先通过HTTP/HTTPS协议发起一条特殊的http请求进行握手后创建一个用于交换数据的TCP连接，此后服务端与客户端通过此TCP连接进行实时通信。

WebSocket API最伟大之处在于服务器和客户端可以在给定的时间范围内的任意时刻，相互推送信息。 浏览器和服务器只需要要做一个握手的动作，在建立连接之后，服务器可以主动传送数据给客户端，客户端也可随时向服务器发送数据。

选择websocket做通信协议是因为这样可以建立持久的浏览器服务器连接，而且服务器还可以主动向浏览器发送消息，这样像是群组聊天，服务器可以主动检测所有在线用户逐个发送消息

![img](https://www.write-bug.com/upload/image/128/0f026bf514652d686de425471811fd18.png)

数据库的选择

除了用传统的mysql我还用了redis用来保存离线消息和群组消息缓存

Redis特点：
Redis支持数据的持久化，可以将内存中的数据保存在磁盘中，重启的时候可以再次加载进行使用。

Redis不仅仅支持简单的key-value类型的数据，同时还提供String，list，set，zset，hash等数据结构的存储。

Redis支持数据的备份，即master-slave模式的数据备份。

性能极高 – Redis能读的速度是110000次/s,写的速度是81000次/s 。


## 3.项目结构

![Image](http://ww1.sinaimg.cn/large/006LiLY3ly1goryipyi1ij309u0cwgly.jpg)





B/S架构，配置文件（config），dao，mapper（持久层），model（实体类），service（服务层），util（工具类），web（控制层，拦截器，服务器业务设计）

## 4.项目展示

先从配置文件配置数据库参数和文件保存地址

文件上传路径

![img](http://ww1.sinaimg.cn/large/006LiLY3ly1goryoov27ej30ku01pa9x.jpg)

mysql数据库

![img](http://ww1.sinaimg.cn/large/006LiLY3ly1goryooworjj30zn04awer.jpg)

redis数据库

![img](http://ww1.sinaimg.cn/large/006LiLY3ly1goryooxjzaj30ec07zaao.jpg)

导入mysql数据库文件（chatroom.sql)，保存了用户的信息，用来登录

![img](http://ww1.sinaimg.cn/large/006LiLY3ly1goryoow1x0j30js049wel.jpg)

启动入口

![img](http://ww1.sinaimg.cn/large/006LiLY3ly1goryoowu1xj30y706h0t0.jpg)

开两个浏览器线程,一个登录001,另一个002

![img](http://ww1.sinaimg.cn/large/006LiLY3ly1goryopaax5j30ro0nfqgw.jpg)

001向在线的002发送消息

![img](http://ww1.sinaimg.cn/large/006LiLY3ly1goryop58zbj30sp0lwq6o.jpg)

002接收回复

![img](http://ww1.sinaimg.cn/large/006LiLY3ly1goryopa6eaj30s20gldj9.jpg)

001向共享群聊发送消息(群聊消息被缓存,方便下次查看)

![img](http://ww1.sinaimg.cn/large/006LiLY3ly1goryopbahfj30sk0hp78t.jpg)

002向离线的003发送消息(因为003离线,消息缓存)

![img](http://ww1.sinaimg.cn/large/006LiLY3ly1goryop8jh1j30rg0exgok.jpg)

003上线,看到新消息并接收

![img](http://ww1.sinaimg.cn/large/006LiLY3ly1goryophhaaj30sv0jwjul.jpg)

![img](http://ww1.sinaimg.cn/large/006LiLY3ly1goryopjrvjj30sd0irgpl.jpg)

![img](http://ww1.sinaimg.cn/large/006LiLY3ly1goryopjf81j30s30hhtd4.jpg)

功能展示完成

## 5.结语

以上是聊天室的全部功能,还有很多可以改进的地方,欢迎提交bug,此项目将长期维护并用于开源学习

