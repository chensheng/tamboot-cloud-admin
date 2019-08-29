# tamboot-cloud-admin

Tamboot Cloud Admin是一个基于 [tamboot cloud](https://github.com/chensheng/tamboot-cloud.git)（一个基于[spring cloud](https://spring.io/projects/spring-cloud)的微服务框架） 的微服务脚手架项目，实现了常见的用户管理、角色管理、权限管理、菜单管理等基本功能，开发者可基于此快速搭建微服务系统。

* [模块介绍](#模块介绍)
* [模块命名](#模块命名)
* [快速上手](#快速上手)
* [tamboot cloud教程](https://github.com/chensheng/tamboot-cloud/wiki)
* [tamboot教程](https://github.com/chensheng/tamboot/wiki)
* [前端项目](https://github.com/chensheng/tamboot-cloud-admin-frontend)


## 模块介绍

### tamboot-cloud-admin-eureka-server
Eureka服务注册中心：集成了服务权限校验功能，当配置项`spring.security.user.name`和`spring.security.user.password`存在时，自动开启服务权限校验功能。如果服务权限校验功能开启，则服务消费端的eureka配置地址需添加权限信息，如：` http://user:password@localhost:8761/eureka/`。

### tamboot-cloud-admin-security
系统权限校验模块：在需要权限校验的应用中引入该模块，系统自动根据配置的权限信息来校验用户的访问权限。

### tamboot-cloud-admin-system-ms
系统微服务：提供用户、角色、菜单、权限等基础服务，在`tamboot-cloud-admin-security`、`tamboot-cloud-admin-system-app`模块中均有使用这些服务。

### tamboot-cloud-admin-system-app
系统应用：实现了用户管理、角色管理、菜单管理、权限管理等后台管理功能。


## 模块命名
原则上微服务模块命名以ms（microservice）结尾，应用模块命名以app结尾。


## 快速上手
* [安装依赖](#安装依赖)
* [下载项目](#下载项目)
* [创建数据库](#创建数据库)
* [启动redis](#启动redis)
* [运行服务注册中心](#运行服务注册中心)
* [运行系统服务](#运行系统服务)
* [运行系统应用](#运行系统应用)
* [返回值](#返回值)
* [状态码](#状态码)
* [初始用户](#初始用户)

### 安装依赖
由于[tamboot](https://github.com/chensheng/tamboot.git)和[tamboot cloud](https://github.com/chensheng/tamboot-cloud.git)尚未发布到maven仓库，因此运行项目前，需要先在本地编译安装。

```bash
$ git clone https://github.com/chensheng/tamboot.git
$ cd tamboot
$ mvn install
```

```bash
$ git clone https://github.com/chensheng/tamboot-cloud.git
$ cd tamboot-cloud
$ mvn install
```

### 下载项目
```bash
$ git clone https://github.com/chensheng/tamboot-cloud-admin.git
```

### 创建数据库
数据库初始化文件在项目的`sql/`目录下。

### 启动redis
由于系统的权限信息存储在redis中，所以需要启动redis，具体的redis安装启动步骤可查看[redis官网](https://redis.io/)。

### 运行服务注册中心
运行完，可访问`http://localhost:8761/`验证。
```bash
cd tamboot-cloud-admin-eureka-server
mvn spring-boot:run
```

### 运行系统服务
运行完，可查看服务注册中心后台，验证服务是否注册成功。
```bash
cd tamboot-cloud-admin-system-ms
mvn spring-boot:run
```

### 运行系统应用
```bash
cd tamboot-cloud-admin-system-app
mvn spring-boot:run
```

### 返回值
所有接口统一返回json格式数据，返回格式如下：
```json
{
  "code": "1",
  "msg": "success",
  "data": null
}
```

字段|说明
-----|-----
code|状态码。除了使用框架定义的状态码，开发者也可以自定义状态码。具体见下表。
msg|提示信息
data|数据。不同接口返回不同数据。

### 状态码
code|说明
-----|-----
0|失败
1|成功
1001|未登录
1002|无权限
9999|系统异常

### 初始用户
系统初始用户：admin，初始密码：Tamboot@123456