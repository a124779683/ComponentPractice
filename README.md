# 一、项目整体框架介绍

* 为了更好的实现并行开发，提高编译和开发效率，项目采用组件化结构，每一个模块都可以单独进行编译运行，通过config.gradle中buildAllModule可以开启和关闭。新增的模块要按照可用模块的gradle进行单独配置。

* 整个项目大致分为三层，即基础层，业务层，应用层。基础层包含工具，UI等通用组件。底层为上层服务，依赖为单向。

## 项目各模块说明结构
1. main

	主工程，可以按照项目名称命名

2. CommonLib(基础组件组成的通用业务框架)

	通用类库，所有模块都必须依赖的类库。该模块主要包含常用的v4,v7包，
	RxJava,Retrofit等网络图片模块，具体请自己查看依赖。并且提供使用频率高的控件和工具方法，主要的主题样式。（下面三个类库也属于commonlibrary的依赖）

    1. fragmentation(基础组件)
    封装了对fragment的操作，由commonlibrary依赖。并且依赖了换肤changeSkin模块，如无需要，可去除，并将SupportActivity直接集成AppCompatActivity
    
    2. RxErrorHandlerModule(基础组件)
    处理Rx错误库
    
    3. changeskin(基础组件)
    换肤库

3. DBModule(基础组件)

    数据库模块，按需引用。由于使用的是orm框架，相关实体都定义在entity下。可能依赖会有点严重。后期考虑解决方式
    
4. OkHttpMockModule(基础组件)
    
    网络请求模拟库，按需引用
5. UtilModule(基础组件)
    
    工具类
6. UIModule(基础组件)
    
    通用UI组件
7. HyBirdModule(基础组件)

    混合组件，webview等于H5交互的组件
    
## 组件化遇到的问题
1. 模块之间清单文件的设置

	类似commonlibrary的纯类库，清单文件尽量留空，否则合并清单文件容易出错。如果是组件清单文件要有debug和release两种，其中release参照纯类库设置，debug设置成普通的清单文件，以便可以单独启动。可参考home组件的工程结构和gradle设置方式。**需要检查我们在子工程中清单文件中声明的activity 权限等同时在主工程中声明**
2. 组件资源冲突

	通过给每一个组件资源设置前缀解决 resourcePrefix "xxModule_"
3. freeline 的使用问题

    每次切换工程都需要重新初始化工程，并且不能使用插件形式运行，只能使用命令行运行。
4. android.library依赖注入问题
    暂不支持ButterKnife.

5. module 中 Application 使用的问题
    
    组件中尽量避免调用application方法。否则在主工程中会出现转换错误，又会导致耦合度的增加。另外在主工程打包时要剔除掉我们子工程中测试的application(另外其他只是调试使用的类全部放入debug文件夹)，另外我们需要将我们在application中初始化的代码同时在主工程中初始化
        注意：由于Tinker要求Application是不能够修改的，所以我们组件中如果有需要在Application中初始化的代码需要再AppLike中再维护一份,不要修改Real和BaseApplication。然后BaseApplication完成像网络请求 图片加载库，LOG等通用的库初始化。关于tinker的依赖都放入到commonlibrary中，不在主工程依赖
    
6. 各组件之间的通信问题

    理想状态下各组件之间应该是相互独立的，但是业务需求注定了他们之间需要有相互联系的桥梁。一个合理的路由机制能够解决跨 module 的 Activity 或 Fragment 跳转问题

7. 组件的划分范围
    
    最头疼的就是这个问题了，因为数据和业务关系紧密。为了保证组件间相互隔离，想破了头，我觉得在业务划分上必须要确立一个原则，就是互相间有相关性的划分到一个组件中。具体实践的话，以使用的实体类为一个界限来找。
    
## Junit和Espresso测试
每个模块提供Test和AndroidTest，分别对应测试基于纯JVM和Android的测试用例。


//            manifest.srcFile 'AndroidManifest.xml'//指定AndroidManifest文件
//            java.srcDirs = ['src']//指定source目录
//            resources.srcDirs = ['src']//指定source目录
//            aidl.srcDirs = ['src']//指定source目录
//            renderscript.srcDirs = ['src']//指定source目录
//            res.srcDirs = ['res']//指定资源目录
//            assets.srcDirs = ['assets']//指定assets目录
//            jniLibs.srcDirs = ['libs']//指定lib库目录

