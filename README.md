# scbc.liyongjie.mycinema
分片上传投稿+私人影片仓库管理+协同视频流播放/实时消息互动+好友管理+放映室管理

<a name="optEv"></a>

# 一.作品概述（功能介绍图）

![功能模块.svg](https://cdn.nlark.com/yuque/0/2022/svg/12390636/1649381265023-dd302af0-1345-4b50-8c01-0c88e9716739.svg#clientId=ud97ddaee-6568-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=400&id=u8acb47b2&name=%E5%8A%9F%E8%83%BD%E6%A8%A1%E5%9D%97.svg&originHeight=303&originWidth=748&originalType=binary&ratio=1&rotation=0&showTitle=true&size=1402958&status=done&style=shadow&taskId=u222ca7dc-cb3e-4179-b233-a8bba123098&title=%E5%8A%9F%E8%83%BD%E6%A8%A1%E5%9D%97&width=987 "功能模块")
<a name="khBtE"></a>

# 二.产生背景及发展前景

- 「 看电影是一种精神生活，和不同的观众共同观影，会产生不同结果的观感体验和感悟记忆。新冠疫情爆发使全球影院贸易受到明显影响，迫于疫情防控人们不得前往影院观影，互联网则为观众提供了一个更加自由、便捷的云端观影空间。通过协同放映室，人们可以在线上进行观影，区别于线下影院的是，线下影院为了大众观影的舒适感，限制人们无法自由言语，人们在观影过程中产生的想法无法得到交流，而线上影院的实时聊天功能则能突破这一界限，人们在观影过程中可以畅所欲言，可以与家人朋友畅聊影片内容，可以随时终止或更换影片，与一同观影的朋友们分享自己在观影过程中产生的所想。其次，由于院线电影的宣发费用巨大，一些中小成本的电影为了更好地平衡收益，会放弃院线渠道，选择直接在网络放映。由此一来，通过互联网为观众提供了更丰富的选择，满足了观众多样化的观影需求，同时也为更多中小成本的电影提供了开放、低成本的播映渠道。另外，网络平台可以通过算法大数据精准分发，将细分内容推送绘符合画像的用产群体，这也会大大提升电影的内容付费率。相对于以往传统院线单一的票旁回收方式,在互联网技术不断发展的背景下，电影的云端为内容制作者提供了更多的回收渠道，也将对于整个电影行业的票房增量起到不可估量的助推作用」

<a name="Q7EVa"></a>

#### 1.用户群体与核心体验

协同放映室面向广大群体，主要面向热爱电影且对社交具有一定积极性的青年群体<br />主要功能：<br />①账号注册及登录<br />②高效上传影片<br />②仓库式管理影片状态----「私人仓库」/「共享影片仓库」<br />③影片分享机制----可与好友之间「互相发起共享」指定私人仓库影片<br />④放映室「协同播放影片』---『实时聊天互动』<br />⑤『在线好友』/『离线好友列表』/『离线申请』/『在线申请』

<a name="LlaI9"></a>

#### 2.应用价值

「线上放映室带来的的便捷，加之其在观影过程中的互动感，云端观影赋予了观众对电影放映时间的控制权，打破了传统影院中放映机对电影的连续放映和常规的叙事流程。这种对电影放映时间控制权力的让渡让在线电影成为一种异时媒介，在线上观影过程中观众可以自主控制进度条，通过暂停、倍速、快进等方式将电影调整为适合自己的播放进度。不仅如此，云端观影不限制用户的观影时间和观影地点，云端观影的观众沉浸的不仅仅是电影的情节与画面，更沉浸在荧幕空间和集体共在的空间中，感受集体观影的热烈氛围，实现了主观心理和数字身体的“远距离”到场。」

<a name="N4rSd"></a>

#### 3.推广前景

「现如今，疫情发展己进入常态化阶段，受疫情影响而停业的电影院也在逐步恢复秩序。“云观影”虽然只是疫情时期的权宜之计，但是从线下影院的“面对面”到5G时代下云观影的“屏对屏”，电影放映模式面临着迭代升级的机会，我们也开始思考未来电影放映模式的更多种可能。本项目开发的协同放映室，用户可以自主上传影片，邀请好友一同观影，通过实时聊天给予用户沉浸式的电影体验。目前院线电影市场已趋于饱和，院线观影人数趋向稳定，但线上会员电影内容的正片播放增长迅速，用户线上观影需求及付费意愿持续提升。」

<a name="kUJVa"></a>

# 三.整体开发架构

<a name="PvMJJ"></a>

### 1.前后端分离开发

<a name="DAKW3"></a>

### 2.微服务架构

![Architecture diagram-2.svg](https://cdn.nlark.com/yuque/0/2022/svg/12390636/1649387333337-60aa1f21-c6af-4d9d-8103-507b0ac9aed7.svg#clientId=ud97ddaee-6568-4&crop=0&crop=0&crop=1&crop=1&from=drop&id=ue03faaef&name=Architecture%20diagram-2.svg&originHeight=427&originWidth=718&originalType=binary&ratio=1&rotation=0&showTitle=true&size=15268&status=done&style=shadow&taskId=u75be86e3-7b1c-4e96-8042-849d6c5e6fa&title=Architecture%20diagram "Architecture diagram")
<a name="cSwxd"></a>

# 四.使用工具/技术一览

![工具一览.svg](https://cdn.nlark.com/yuque/0/2022/svg/12390636/1648987328963-7089d5e1-3b68-4986-bf5a-230358ab17c6.svg#clientId=u6d4fe7d8-98d4-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=634&id=u8b96094b&name=%E5%B7%A5%E5%85%B7%E4%B8%80%E8%A7%88.svg&originHeight=532&originWidth=502&originalType=binary&ratio=1&rotation=0&showTitle=true&size=1536200&status=done&style=shadow&taskId=u2ada3677-51e0-41e2-a7be-f8ea7cd1d29&title=%E6%8A%80%E6%9C%AF%2F%E5%B7%A5%E5%85%B7%E4%B8%80%E8%A7%88&width=598 "技术/工具一览")
<a name="f1XHQ"></a>

# 五.核心技术攻关

<a name="nrB2b"></a>

### 1.高效上传

![未命名.gif](https://cdn.nlark.com/yuque/0/2022/gif/12390636/1649422598955-a137e876-0f46-47fd-a072-ac843a97aa9d.gif#clientId=u65024a6d-2268-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=471&id=u5dff01a3&name=%E6%9C%AA%E5%91%BD%E5%90%8D.gif&originHeight=1610&originWidth=2416&originalType=binary&ratio=1&rotation=0&showTitle=true&size=7204340&status=done&style=shadow&taskId=ub77917a6-0dc6-4e44-aa3d-ff1b22510c0&title=%E6%BC%94%E7%A4%BA%E5%9B%BE.gif&width=707 "演示图.gif")<br />**_我们所提供的核心体验之一就是自主上传影片，这是我们首要攻克的难点_**

      - 上传速度要快
      - 反馈体验要好
      - 能妙传判断/续传
      - 开发中----登出/意外断传，关闭窗口/的情况下能续传.....

<a name="LfIle"></a>

#### 初步优化:

「我们从一开始的一次性完整传输，到分片+并发+md5校验数据作妙传<br />前后端需要高度一致的配置，才能完成」<br />----本地平均250mb/s
<a name="G64gv"></a>

#### 进一步优化:

「后台对分片的合并操作利用Java Nio的 FileChannel的transferTo零拷贝优化合并操作，操作执行完毕后，后续的处理（DASH流/缩略图生成）异步多线程执行，快速反馈上传结果给用户」<br />----本300mb/s（极限可突破）
<a name="youjT"></a>

#### 后期的再优化（开发中）：

「尝试后台不再由SpringBoot内嵌的tomcat去处理分片接收,采用基于Netty搭建一个Http协议的分片上传服务器，尝试采用protostuff（可能web端的上传框架不方便使用）二进制流进行传输，在demo编写环节，后期会替换现有的策略」<br />----目标突破500mb/s的本地传输速率
<a name="rWzSm"></a>

### 2.如何执行生成MPEG-DASH流/影片缩略图

![image.png](https://cdn.nlark.com/yuque/0/2022/png/12390636/1649422743597-c88e77a7-1fe3-4543-8004-933867764227.png#clientId=u65024a6d-2268-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=195&id=uba8b0c74&name=image.png&originHeight=390&originWidth=2214&originalType=binary&ratio=1&rotation=0&showTitle=false&size=187251&status=done&style=shadow&taskId=u5d6b8184-f747-4a45-9b50-1e89c0cc12d&title=&width=1107)<br />「为了提高放映室的观影体验我们决定采用自适应比特流MPEG-DASH的技术，相比HLS，DASH更具有国际标准/更底的端对端延迟，bilibili与2018年全面采用了MPEG-DASH的技术，如果细心的小伙伴可以发现，看bilibili视频会先一开始模糊再到清楚，这就是自适应比特流」<br />参考文档pdf（来自谷歌百度）：<br />[https://www.w3.org/2019/03/23-chinese-web-jianqiang-bilibili.pdf](https://www.w3.org/2019/03/23-chinese-web-jianqiang-bilibili.pdf)

      - 工具选用阶段
      - 如何整合进工程内 
      - 如何保证用户反馈

<a name="Ii5Pc"></a>

#### 初步策略：

「采用FFmpeg生成MPEG-DASH流和缩略图的生成（默认为2min处截图），又Java去调用外部程序，执行FFmpeg的相关命令」
<a name="u7rCA"></a>

#### 初步优化:

「由于Java提供的执行外部程序的缺陷，经常会出现Runtime缓冲区问题导致的线程卡死，我们引用Apache Commons-Exec工具来执行外部程序，并且异步多线程的形式去执行DASH流生成以及缩略图生成的业务」
<a name="k6hDy"></a>

#### 整合策略:

「该两项业务与上传业务密切挂钩，但又属于相互独立的业务，以及微服务开发的架构，我们进行了业务拆分，将上传与该两项业务独立于两个SpringBoot工程，通过rpc相互调用，保证业务的完整性」
<a name="UvXGc"></a>

#### 优化RPC调用：

「初期采用Fegin来完成两项业务之间的调用，但经过调研和学习发现，谷歌提供的Grpc速度更快，效率更高，可以提高我们带给用户的反馈，我们决定选用Grpc作为我们远程调用的框架」<br />-----gRPC基于Netty+Http2.0+Protocol Buffers比传统的RPC要快60%以上
<a name="Ft6kG"></a>

#### 后期的再优化（开发学习当中）:

「通过cdn加速，视频点播服务，云存储技术优化用户的观影体验，还有视频存储的策略也需要升级改造，还有一系列的问题和考验需要我们去解决和面对」

<a name="pJo30"></a>

### 3.协同播放与实时通知

受文档大小限制画质会比较糊

![gif.gif](https://cdn.nlark.com/yuque/0/2022/gif/12390636/1649427054378-a7d98930-f27c-4148-8d8a-44fbcd6468ab.gif#clientId=ucdb44647-0ff4-4&crop=0&crop=0&crop=1&crop=1&from=drop&id=uba39a419&name=gif.gif&originHeight=400&originWidth=678&originalType=binary&ratio=1&rotation=0&showTitle=true&size=9724752&status=done&style=shadow&taskId=u1b2102b0-cf44-4c15-967e-454271e382f&title=%E5%8D%8F%E5%90%8C%2F%E5%AE%9E%E6%97%B6%E8%81%8A%E5%A4%A9%EF%BC%88%E9%80%9A%E7%9F%A5%EF%BC%89%E6%BC%94%E7%A4%BA.gif "协同/实时聊天（通知）演示.gif")<br />**_实时通知: 在该作品中会出现很多这种业务，好友申请发起/视频分享申请发起/放映室创建邀请发起/_**<br />**_实际上还有一个业务----__在线/离线 判断，__我们相对的业务逻辑也就不一样_**
<a name="Fl7oM"></a>

#### 策略：

「用SpringBoot整合一个基于Netty开发的WebSocket服务器，用来创建长连接，主动推       	送信息给客户端。利用这种特性，我们实时传播房主发出的开始/暂停等操作，从而实现协同        播放。」
<a name="R6XPI"></a>

##### 难点：

「需要维护一个User--Channel的双向映射的Map，才能完成精准的消息投送，服务器每接收到一个活跃的连接，首先需要客户端发送一个BindAskMessage来通知服务端将用户Channel绑定，用户的基本信息来自BindAskMessage实体类内部（这里对每一种消息类型都做了一个封装）」
<a name="m2eyY"></a>

##### 优化：

「我们将建立两个Netty搭建的WebSocket服务器，一个用于处理主页的相关事务，一个专门处理放映室协同播放/实时聊天的事务，减轻单个服务器连接的压力，和Bind信息混杂不好管理的问题」
<a name="hOkaO"></a>

##### 后期优化：

「协同播放追求低延时，在实时传递开始/暂停/实时聊天等业务的时候，传统的Json.xml.java对象不如protobuf的性能更高，延时也就更低，后期我们将放映室的数据传输用protobuf替代」
<a name="s7Xa4"></a>

### 4.UUID生成器

**_在该作品中存在很多需要UUID作为唯一标识的场景，视频uuid/仓库uuid/房间号uuid等等_**
<a name="kLQNl"></a>

#### 生成策略：

「采用github开源的JUG（java-uuid-generator）JUG 可以在每个内核每秒生成数百万个 UUID，有时达到每秒 1000 万个的理论极限」
<a name="ZxfbG"></a>

### 5.缓存

<a name="TvRkd"></a>

##### 策略:

「选用Redis作为缓存数据库，缓存一些离线消息/放映室的初始化数据/等等」
<a name="GOcaG"></a>

### 6.统一认证

<a name="LFBKM"></a>

##### 策略：

「Spring cloud gateway + JWT Token + Redis 的网关统一验证身份，在gatetway内构建一个Global Filter 用于拦截请求，验证token的时效性，合法性，redis在这用于缓存token---user相关信息以及token---secret」
<a name="YQUWX"></a>

# 六.Base-Api

![接口.svg](https://cdn.nlark.com/yuque/0/2022/svg/12390636/1648988679247-4d7ccc32-6099-47b4-9bad-a17ca38b13ba.svg#clientId=u19c087cc-baa2-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=562&id=u6862a639&name=%E6%8E%A5%E5%8F%A3.svg&originHeight=483&originWidth=450&originalType=binary&ratio=1&rotation=0&showTitle=true&size=5380000&status=done&style=shadow&taskId=u5608844c-5051-48bc-b2d6-5e717730957&title=api%20-%20all&width=524 "api - all")
<a name="bMyMp"></a>


<a name="xRJR0"></a>

