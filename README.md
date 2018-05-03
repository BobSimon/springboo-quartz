### 项目结构
```java
├── demoeee
│   ├── com   //启动整个项目的moudle   
│         └── example
│              └── demo
│                    ├──aop //个人定义的写的自定义注解
│                    ├──api //swagger API 访问地址：http://localhost:8080/quartz/swagger-ui.html
│                    ├──command //命令开发模式
│                    ├──commonfactory//普通工厂开发模式
│                    ├──decorate //装饰者开发模式
│                    ├──observer //观察者开发模式
│                    ├──lambda //java8的一个新特性
│                    ├──config //定时任务的配置
│                    ├──controller //任务控制层
│                    ├──dao //对应mybatis xml的配置文件
│                    ├──entity //实体类
│                    ├──interceptor //实体类
│                    ├──service //业务逻辑层
│                    ├──util //帮助类
│                    ├──需要执行的job //实体类
│                    └──DemoApplication.java //整个项目的启动类  
│            └── resources
│            │     ├── application-dev.properties  //开发环境
│            │     ├── application-prod.properties //生产环境
│            │     ├── application-test.properties //测试环境
│            │     ├── application.properties  //配置总文件
│            │     ├── quartz.properties  //定时任务配置文件
│            │     ├── mapper //mybatis的配置文件
│            │     ├── docker-compose.yml //docker配置文件
│            │     ├── sql //建库文件
│            │     ├── static //图片，js,css等页面需要的元素
│            │     └── templates//页面代码
│   └── pom启动整个项目的依赖 //

```

# spring-boot-quartz

## 这里本人模仿科帮网弄了quartz

基于spring-boot+quartz的CRUD动态任务管理系统，适用于中小项目。


基于spring-boot 2.x +quartz 的CRUD任务管理系统：https://gitee.com/52itstyle/spring-boot-task


## 几种任务调度

- Timer，简单无门槛，一般也没人用。

- spring @Scheduled注解，一般集成于项目中，小任务很方便。

- 开源工具 Quartz，分布式集群开源工具，以下两个分布式任务应该都是基于Quartz实现的，可以说是中小型公司必选，当然也视自身需求而定。

- 分布式任务 XXL-JOB，是一个轻量级分布式任务调度框架，支持通过 Web 页面对任务进行 CRUD 操作，支持动态修改任务状态、暂停/恢复任务，以及终止运行中任务，支持在线配置调度任务入参和在线查看调度结果。

- 分布式任务 Elastic-Job，是一个分布式调度解决方案，由两个相互独立的子项目 Elastic-Job-Lite 和 Elastic-Job-Cloud 组成。定位为轻量级无中心化解决方案，使用 jar 包的形式提供分布式任务的协调服务。支持分布式调度协调、弹性扩容缩容、失效转移、错过执行作业重触发、并行调度、自诊。


## 开发环境

JDK1.8、Maven、IDEA

## 技术栈

SpringBoot1.5.10、thymeleaf、quartz2.3.0、iview、vue、layer、AdminLTE、bootstrap、lombok、aop

## 启动说明
- 项目使用的数据库为MySql，选择resources/sql中的tables_mysql_innodb.sql文件初始化数据库信息。
- 在resources/application.properties文件中替换为自己的数据源。
- 在resources/quartz.properties文件中替换为自己的数据源。
- 运行Application main方法，启动项目。
- 项目访问地址：http://localhost:8080/quartz
- API接口地址：http://localhost:8080/quartz/swagger-ui.html

## 友情提示
由于工作原因，项目正在完善中（仅供参考），随时更新日志。

## 项目截图

![输入图片说明](/doc/pic1.png "登录界面")

![输入图片说明](/doc/主页面.png "主页面")

![输入图片说明](/doc/个人主页.png "个人主页")

![输入图片说明](/doc/任务页面.png "任务页面")

![输入图片说明](/doc/表达式.png "表达式生成器页面")

![输入图片说明](/doc/添加定时任务.png "添加定时任务界面")

![表达式生成器](/doc/页面配色.png "配色页面")


## 已实现功能

- 任务列表
- 任务新增和修改
- 任务执行
- 表达式生成器(集成：https://gitee.com/finira/cronboot)
- 任务移除
- Job中注入service为空的问题
- 系统启动，如果数据库任务为零则初始化测试任务，用于测试
