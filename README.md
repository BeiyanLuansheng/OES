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

分别设置成自己 数据库、邮箱、minio服务器 的值


## 项目启动

在 oes-start/src/main/java/org/oes/start 目录下有 Application.java

可以在 IDEA 中直接启动

## 访问

工程默认端口为 8089，所有提供的服务都在 oes-start 模块下 Controller 包中，测试服务在 test 包中

## 功能实现

### 管理员

- [x] 权限管理
- [x] 课程审核
- [x] 视频审核
- [ ] 首页轮播

### 教师

- [x] 注册
- [ ] 教师认证
- [ ] 账号绑定
- [ ] 个人信息
- [ ] 账号密码
- [x] 开设课程
- [x] 章节管理
- [x] 视频发布
- [x] 视频更新
- [x] 习题发布
- [ ] 成绩统计
- [ ] 发布公告

### 学生

- [x] 注册
- [ ] 账号绑定
- [ ] 个人信息
- [ ] 账号密码
- [ ] 查看课程
- [ ] 加入课程
- [ ] 购买课程
- [x] 观看视频
- [x] 下载附件
- [ ] 完成习题
- [x] 课程评论
- [ ] 课程推荐



----------

Mapper 方法

新增：insert(course)
删除：deleteById(course)
修改：updateById(course); fullUpdateById(course);
查找：findCourseList(course);
