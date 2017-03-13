#一、项目整体框架
记录项目搭建使用到的框架和项目整体框架结构，方便查阅。
## 项目的结构
1. App Module
	* core （APP最核心的模块，包含最基础业务和配置的包）
	* db （数据库模块）
	* entity （实体包）
	* exception （自定义异常包）
	* widget（控件）
		* pulltorefresh & easyrecyclerview （封装刷新控件）对之前控件做了封装
	* utils （与业务有关的工具类）
	* dependencies
	 	* espresso&junit（测试库）
	 	* tinker（热修复）
	 	* greendao（数据库）
	 	* butterknife (控件注入库)
	 	* simplifyspan
2. commonLib Module （不依赖任何业务的组件）
	* adapter （适配器所有基类和工具）
	* core （Fragment和Activity基类，生命周期和管理方法）
	* entity
	* permission（权限管理，仅支持API LEVEL15+）
	* util （通用工具类）
	 * cache （缓存包）
	 * dataprocess （提供数据序列化和反序列化包）
	 * image （只提供接口的图片处理包，隔离具体实现方式）
	 * regex（正则工具）
	 * widget （通用控件包）
		 * fontview（自定义字体控件）
 	* dependencies
	 	* gson（JSON库）
	 	* glide（图片库）
	 	* logger（日志库）
	 	* nineoldandroids(动画库)



## Junit和Espresso测试
每个模块提供Test和AndroidTest，分别对应测试基于纯JVM和Android的测试用例。

