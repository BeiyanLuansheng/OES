# OES 文档
在线教育系统 **O**nline **E**ducation **S**ystem

## 项目准备

先导入数据库，sql脚本在 db 文件夹下

然后用 IDEA 以maven项目方式打开本项目的工程文件

然后在 oes-start/src/main/resources 文件夹下打开 application-dev.yml，修改下面的几个字段

```yml
spring:
  datasource:
    druid:
      url: 
      username: 
      password: 
  mail:
    username:
    password:

oes:
  minio:
    endpoint: 
    root-user: 
    root-password: 
```

设置成自己数据库的值


## 项目启动

在 oes-start/src/main/java/org/oes/start 目录下有 Application.java

可以在 IDEA 中直接启动

## 访问

工程默认端口为 8089，所有提供的服务都在 oes-start 模块下 Controller 包中，测试服务在 test 包中
