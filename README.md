# springboot-web

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg?label=license)](https://github.com/KimZing/springboot-web/blob/master/LICENSE)

## 项目简介

SpringBoot Web项目，包含各种Web功能示例

## 分支说明

> master

* 基础Web项目

## 技术选型

- Java 1.8
- SpringBoot 2.2.2
- SpringMVC

## 脚本命令

- 运行(cmd/run.sh)

```bash
mvn clean spring-boot:run -Dmaven.test.skip=true -Dprofile.active=dev
```

- 打包(cmd/package.sh)

```bash
mvn clean package -Dmaven.test.skip=true -Dprofile.active=dev
```

## 领域模型

- User 用户

## 技术架构

无

## 部署架构

无

## 外部依赖

无

## 环境信息

- 本地环境

> http://localhost:8080/info

## 项目规约

### 数据库

数据库如果存在则统一使用`springboot`数据库，并将建表和数据sql放入`resources/db`目录下，分为`*_create.sql`与`*_data.sql`

### 公共包结构

> 多领域模型使用模型名称进行分包

```bash
├── config                              # 项目配置
│   ├── log
├── controller                          # 控制层
├── domain                              # 领域对象
│   ├── dto                             # 数据传输对象
│   ├── event                           # 事件对象
│   ├── po                              # 持久化对象
│   └── vo                              # 值对象
├── feign                               # 外部服务调用类
├── listener                            # 事件监听入口
├── repository                          # 存储层
│   ├── impl
├── service                             # 服务层
│   ├── impl
└── utils                               # 工具类

```

### 分支命名规范

学习分支

> learn/知识点

功能分支

> feature/功能点

## FAQ

### 1. 项目配置文件中有`@project.name@`类似的配置，是如何工作的呢？

类似于`@*@`的配置会在编译时会从pom.xml中读取对应的属性值进行替换，该项目模板将`spring.application.name`、`server.port`等配置为从
`pom.xml`中进行读取，进行统一管理，也可以根据个人喜好进行修改。

### 2. 如何进行多环境的配置管理？

> 默认使用的profile环境为`dev`

- 在`pom.xml`中的`<profiles></profiles>`节点中已经内置了`dev`,`sit`,`pro`三种环境(可根据情况进行增删)，每种环境包含`profile.port`、
`profile.path`、`profile.active`属性，请确保其存在并正确。

- 编写的对应的springboot配置文件, 例如sit环境对应的配置文件为`application-sit.yml`，拉下来对其进行配置即可。

### 3. 项目中的各个配置文件是如何拆分的，如何使用？

为了具备生产级别的可用性，根据profile(环境)和feature(功能)对配置文件进行了拆分和管理。

* `application.yml`

    * 管理项目的默认配置选项，同时依赖maven的属性注入能力进行了`spring.profiles.active`的配置，以此来激活对应的profile文件

* `application-dev.yml`

    * 当`spring.profiles.active=dev`时，激活此配置文件，此配置文件主要引用了相应的feature配置文件，如`application-dev-base.yml`(base模块配置),
`application-dev-datasource.yml`(数据源配置)，这样可以灵活的组装与拆分不同的配置。

    * 例如: 需要连接某供应商(alibaba)的接口，也可以单独编写一个配置文件`application-dev-alibaba.yml`, 随后在application-dev.yml中
添加`spring.profiles.include:dev-base,dev-datasource,dev-alibaba`。

当然，如果你不喜欢这样拆分或者配置项不复杂，也可以在`application-dev.yml`进行所有的配置。
