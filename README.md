# 一、项目整体框架介绍
记录项目搭建使用到的框架和项目整体框架结构，方便查阅。

* 为了更好的实现并行开发，提高编译和开发效率，项目采用组件化结构，每一个模块都可以单独进行编译运行，通过config.gradle中buildAllModule可以开启和关闭。新增的模块要按照可用模块的gradle进行单独配置。

## 项目各模块说明结构
1. main

	主模块名，可以按照项目名称命名

2. commonlibrary

	通用类库，所有模块都必须依赖的类库。该模块主要v4,v7包，RxJava,Retrofit等具体请自己查看依赖。并且提供使用频率高的控件和工具方法，主要的主题样式。（下面三个类库也属于commonlibrary的依赖）

    1. fragmentation
    封装了对fragment的操作，由commonlibrary依赖。并且依赖了换肤changeSkin模块，如无需要，可去除，并将SupportActivity直接集成AppCompatActivity
    
    2. rxerrorhandler
    处理Rx错误库
    
    3. changeskin
    换肤库

## 组件化遇到的问题
1. 模块之间清单文件的设置

	类似commonlibrary的纯类库，清单文件尽量留空，否则合并清单文件容易出错。其他清单文件要有debug和release两种，其中release参照纯类库设置，debug设置成普通的清单文件，以便可以单独启动

2. 组件资源冲突
	
	通过给每一个组件资源设置前缀解决 resourcePrefix "xxModule_"
## Junit和Espresso测试
每个模块提供Test和AndroidTest，分别对应测试基于纯JVM和Android的测试用例。

