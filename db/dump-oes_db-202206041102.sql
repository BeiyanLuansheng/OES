-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 121.40.126.91    Database: oes_db
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `banner`
--

DROP TABLE IF EXISTS `banner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `banner` (
  `banner_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `picture_url` varchar(100) DEFAULT NULL,
  `course_id` bigint unsigned DEFAULT NULL,
  PRIMARY KEY (`banner_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banner`
--

LOCK TABLES `banner` WRITE;
/*!40000 ALTER TABLE `banner` DISABLE KEYS */;
/*!40000 ALTER TABLE `banner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `category_id` bigint NOT NULL AUTO_INCREMENT COMMENT '类目ID',
  `category_name` varchar(100) NOT NULL COMMENT '类目名',
  `parent_id` bigint DEFAULT NULL COMMENT '父类ID',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `course_id` bigint NOT NULL AUTO_INCREMENT COMMENT '课程编号',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `category_id` bigint NOT NULL COMMENT '类目编号',
  `teacher_id` bigint NOT NULL COMMENT '开课教师编号',
  `gmt_start` datetime DEFAULT NULL COMMENT '开课时间',
  `gmt_end` datetime DEFAULT NULL COMMENT '结课时间',
  `status` varchar(100) NOT NULL COMMENT '课程状态',
  `is_free` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'Y' COMMENT '是否付费',
  `price` bigint DEFAULT NULL COMMENT '付费价格',
  `course_name` varchar(100) NOT NULL COMMENT '课程名',
  `description` varchar(4096) NOT NULL COMMENT '课程简介',
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'2021-11-30 00:00:00','2021-11-30 00:00:00',0,0,'2021-11-30 00:00:00','2021-11-30 00:00:00','1','Y',NULL,'',''),(2,'2021-12-02 10:28:46','2021-12-02 10:28:46',0,0,'2021-12-02 10:28:46','2021-12-02 10:28:46','1','Y',NULL,'',''),(3,'2021-12-02 10:47:35','2021-12-02 10:47:36',0,0,'2021-12-02 10:47:36','2021-12-02 10:47:36','1','Y',NULL,'',''),(4,'2021-12-02 10:49:33','2021-12-02 10:49:34',0,0,'2021-12-02 10:49:34','2021-12-02 10:49:34','1','Y',NULL,'',''),(5,'2021-12-02 10:54:39','2021-12-02 10:54:40',0,0,'2021-12-02 10:54:40','2021-12-02 10:54:40','1','Y',NULL,'',''),(6,'2021-12-03 10:30:23','2021-12-03 10:30:23',0,0,'2021-12-03 10:30:23','2021-12-03 10:30:23','1','Y',NULL,'',''),(7,'2021-12-03 10:31:53','2021-12-03 10:31:53',0,0,'2021-12-03 10:31:53','2021-12-03 10:31:53','1','Y',NULL,'',''),(8,'2021-12-03 10:32:25','2021-12-03 10:32:25',0,0,'2021-12-03 10:32:25','2021-12-03 10:32:25','1','Y',NULL,'','');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_chapter`
--

DROP TABLE IF EXISTS `course_chapter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_chapter` (
  `course_chapter_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '章节号',
  `course_id` bigint unsigned NOT NULL COMMENT '课程号',
  `chapter_id` bigint unsigned NOT NULL COMMENT '章节序号',
  `chapter_name` varchar(100) NOT NULL COMMENT '章节名',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`course_chapter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_chapter`
--

LOCK TABLES `course_chapter` WRITE;
/*!40000 ALTER TABLE `course_chapter` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_chapter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_comment`
--

DROP TABLE IF EXISTS `course_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_comment` (
  `comment_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '评论标识',
  `content` varchar(2048) NOT NULL COMMENT '评论内容',
  `course_file_id` bigint unsigned NOT NULL COMMENT '评论视频',
  `user_id` bigint unsigned NOT NULL COMMENT '用户ID',
  `gmt_create` datetime NOT NULL COMMENT '评论时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `reference_id` bigint unsigned DEFAULT NULL COMMENT '回复评论',
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_comment`
--

LOCK TABLES `course_comment` WRITE;
/*!40000 ALTER TABLE `course_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_file`
--

DROP TABLE IF EXISTS `course_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_file` (
  `course_chapter_id` bigint unsigned NOT NULL,
  `file_id` bigint NOT NULL,
  `course_file_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`course_file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_file`
--

LOCK TABLES `course_file` WRITE;
/*!40000 ALTER TABLE `course_file` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam` (
  `question_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `course_id` bigint unsigned DEFAULT NULL,
  `course_chapter_id` bigint unsigned DEFAULT NULL,
  `question` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `answer` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `a_option` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `b_option` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `c_option` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `d_option` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `e_option` varchar(1024) DEFAULT NULL,
  `f_option` varchar(1024) DEFAULT NULL,
  `g_option` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `h_option` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam`
--

LOCK TABLES `exam` WRITE;
/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `file` (
  `file_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '文件编号',
  `file_name` varchar(100) NOT NULL COMMENT '文件名',
  `file_type` varchar(100) NOT NULL COMMENT '文件类型，图片，视频，文档',
  `file_url` varchar(100) NOT NULL COMMENT '文件链接',
  `user_id` bigint NOT NULL COMMENT '上传者',
  `gmt_create` datetime NOT NULL COMMENT '上传时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `description` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '文件描述',
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notice` (
  `notice_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `course_id` bigint unsigned NOT NULL,
  `content` varchar(1024) NOT NULL,
  `user_id` bigint unsigned NOT NULL COMMENT '公告发布者',
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `order_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `course_id` bigint unsigned NOT NULL,
  `price` bigint unsigned NOT NULL,
  `status` varchar(100) NOT NULL,
  `user_id` bigint unsigned NOT NULL COMMENT '订单创建者',
  `gmt_create` datetime NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissions`
--

DROP TABLE IF EXISTS `permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permissions` (
  `permissions_id` bigint NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `permissions` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '权限',
  `permissions_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '权限名',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '权限描述',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`permissions_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10015 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissions`
--

LOCK TABLES `permissions` WRITE;
/*!40000 ALTER TABLE `permissions` DISABLE KEYS */;
INSERT INTO `permissions` VALUES (10001,'permissions:list','查看权限','查看权限列表','2021-12-20 20:13:04','2021-12-20 20:13:04'),(10002,'permissions:add','新增权限','创建新权限','2021-12-20 20:13:49','2021-12-20 20:13:49'),(10003,'permissions:update','更新权限','更新已有权限信息','2021-12-20 20:14:06','2021-12-20 20:14:06'),(10004,'permissions:delete','删除权限','删除已有权限','2021-12-20 20:14:29','2021-12-20 20:14:29'),(10005,'role:list','查看角色','查看角色列表','2021-12-20 20:15:09','2021-12-20 20:15:09'),(10006,'role:add','新增角色','创建新角色','2021-12-20 20:15:19','2021-12-20 20:15:19'),(10007,'role:update','更新角色','更新角色信息','2021-12-20 20:15:54','2021-12-20 20:15:54'),(10008,'role:delete','删除角色','删除已有角色','2021-12-20 20:16:09','2021-12-20 20:16:09'),(10009,'role:perms:add','角色权限','给角色授权','2021-12-20 20:16:53','2021-12-20 20:16:53'),(10010,'role:perms:remove','移除角色权限','创建新用户','2021-12-20 20:17:26','2021-12-20 20:17:26'),(10011,'user:list','查看用户','查看用户列表','2021-12-20 20:17:59','2021-12-20 20:17:59'),(10012,'user:add','创建用户','创建新用户','2021-12-20 20:18:19','2021-12-20 20:18:19'),(10013,'user:update','更新用户','更新用户信息','2021-12-20 20:23:10','2021-12-20 20:23:10'),(10014,'user:delete','删除用户','删除已有用户','2021-12-20 20:25:12','2021-12-20 20:25:12');
/*!40000 ALTER TABLE `permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色名',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '角色描述',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10004 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (10001,'ADMINISTRATOR','管理员角色','2021-12-13 21:39:43','2021-12-13 21:40:43'),(10002,'TEACHER','教师角色','2021-12-13 22:05:02','2021-12-13 22:05:02'),(10003,'STUDENT','学生角色','2021-12-13 22:05:31','2021-12-13 22:05:31');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_permissions`
--

DROP TABLE IF EXISTS `role_permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_permissions` (
  `role_id` bigint NOT NULL COMMENT '角色ID',
  `permissions_id` bigint NOT NULL COMMENT '权限ID',
  `gmt_create` datetime NOT NULL COMMENT '授权时间',
  PRIMARY KEY (`role_id`,`permissions_id`),
  KEY `role_permissions_FK` (`permissions_id`),
  CONSTRAINT `role_permissions_FK` FOREIGN KEY (`permissions_id`) REFERENCES `permissions` (`permissions_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `role_permissions_FK_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_permissions`
--

LOCK TABLES `role_permissions` WRITE;
/*!40000 ALTER TABLE `role_permissions` DISABLE KEYS */;
INSERT INTO `role_permissions` VALUES (10001,10001,'2021-12-20 20:29:32'),(10001,10002,'2021-12-20 20:29:37'),(10001,10003,'2021-12-20 20:29:40'),(10001,10004,'2021-12-20 20:29:43'),(10001,10005,'2021-12-20 20:29:47'),(10001,10006,'2021-12-20 20:29:49'),(10001,10007,'2021-12-20 20:29:53'),(10001,10008,'2021-12-20 20:29:57'),(10001,10009,'2021-12-20 20:30:01'),(10001,10010,'2021-12-20 20:30:07'),(10001,10011,'2021-12-20 20:30:11'),(10001,10012,'2021-12-20 20:30:14');
/*!40000 ALTER TABLE `role_permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_course`
--

DROP TABLE IF EXISTS `student_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_course` (
  `user_id` bigint NOT NULL,
  `course_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`course_id`),
  KEY `student_course_FK_1` (`course_id`),
  CONSTRAINT `student_course_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_course_FK_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_course`
--

LOCK TABLES `student_course` WRITE;
/*!40000 ALTER TABLE `student_course` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `role_id` bigint NOT NULL DEFAULT '10003' COMMENT '角色',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账号（邮箱）',
  `avatar` varchar(100) DEFAULT NULL COMMENT '头像',
  `school` varchar(100) DEFAULT NULL COMMENT '学校',
  `sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '自我简介',
  `gmt_create` datetime NOT NULL COMMENT '账号创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '账号修改时间',
  `status` varchar(2) NOT NULL COMMENT '账号状态',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'oes_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-04 11:02:50
