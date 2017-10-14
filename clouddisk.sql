/*
SQLyog Ultimate v9.20 
MySQL - 5.7.18 : Database - clouddisk
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`clouddisk` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `clouddisk`;

/*Table structure for table `app_user` */

DROP TABLE IF EXISTS `app_user`;

CREATE TABLE `app_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `account_no` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone_no` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=140 DEFAULT CHARSET=utf8 COMMENT='用来保存用户信息';

/*Data for the table `app_user` */

insert  into `app_user`(`user_id`,`user_name`,`gender`,`birthday`,`account_no`,`password`,`email`,`phone_no`) values (123,'什么时候','f',NULL,NULL,NULL,NULL,NULL),(124,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(125,'','',NULL,'dsfa','afds','',''),(126,'','',NULL,'adsfafds','','',''),(127,'','',NULL,'234234',',','',''),(128,'','m',NULL,'','','',''),(129,'','m',NULL,'','123','',''),(130,'','m',NULL,'0000','1234','',''),(131,'','m',NULL,'123','123','',''),(132,'','m',NULL,'123','123','',''),(133,'','m',NULL,'123','123','',''),(134,'','m',NULL,'1244','1234','',''),(135,'','m',NULL,'123','123','',''),(136,'','m',NULL,'123','aaa','',''),(138,'','m',NULL,'adsf','adsf','',''),(139,'','m',NULL,'test001','1234','','');

/*Table structure for table `file_index` */

DROP TABLE IF EXISTS `file_index`;

CREATE TABLE `file_index` (
  `file_index_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `p_file_index_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `is_file` char(1) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`file_index_id`),
  KEY `FK_Reference_1` (`user_id`),
  KEY `FK_Reference_3` (`p_file_index_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`user_id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`p_file_index_id`) REFERENCES `p_file_index` (`p_file_index_id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8 COMMENT='用户的逻辑目录信息';

/*Data for the table `file_index` */

insert  into `file_index`(`file_index_id`,`user_id`,`p_file_index_id`,`name`,`path`,`parent_id`,`is_file`,`create_time`,`delete_flag`) values (1,139,NULL,'','/',NULL,'1','2017-05-26 03:49:23',NULL),(30,139,NULL,'a','/a',1,'1','2017-05-25 16:30:29',NULL),(31,139,NULL,'b','/b',1,'1','2017-05-25 16:30:31',NULL),(32,139,NULL,'c','/c',1,'1','2017-05-25 16:30:34',NULL),(33,139,NULL,'d','/d',1,'1','2017-05-25 16:30:36','1'),(34,139,NULL,'c1','/c/c1',32,'1','2017-05-25 08:34:11',NULL),(35,139,NULL,'c2','/a/c2',30,'1','2017-05-25 08:34:13',NULL),(36,139,NULL,'c3aa','/c/c3aa',32,'1','2017-05-25 08:34:15',NULL),(37,139,NULL,'c21','/a/c2/c21',35,'1','2017-05-25 08:34:16',NULL),(38,139,NULL,'c222','/a/c2/c222',35,'1','2017-05-25 08:34:19',NULL),(39,139,NULL,'fe','/c/c3aa/fe',36,'1','2017-05-25 16:42:31',NULL),(40,139,NULL,'fse','/a/fse',30,'1','2017-05-25 16:42:36',NULL),(41,139,1,'a.jpg','/b/a.jpg',31,'0','2017-05-26 03:53:22',NULL),(42,139,NULL,'e','/e',1,'1','2017-05-25 17:18:56','1'),(43,139,NULL,'e1','/e/e1',42,'1','2017-05-25 17:19:05','1'),(45,139,1,'a.gif','/b/a.jpg',31,'0','2017-05-27 06:33:21',NULL),(46,139,1,'c.jpg','/b/a.jpg',31,'0','2017-05-27 06:33:09',NULL),(47,139,1,'a.php','/b/a.jpg',31,'0','2017-05-27 06:33:02',NULL),(48,139,1,'a.java','/b/a.jpg',31,'0','2017-05-27 06:32:52',NULL),(49,139,1,'a.mkv','/b/a.jpg',31,'0','2017-05-27 06:32:48',NULL),(50,139,1,'a.doc','/b/a.jpg',31,'0','2017-05-27 06:32:44',NULL),(51,139,1,'a.mp4','/b/a.jpg',31,'0','2017-05-27 06:32:39',NULL),(52,139,1,'a.png','/b/a.jpg',31,'0','2017-05-26 03:53:22',NULL),(53,139,1,'a.psng','/b/a.jpg',31,'0','2017-05-26 03:53:22',NULL);

/*Table structure for table `friend_relationship` */

DROP TABLE IF EXISTS `friend_relationship`;

CREATE TABLE `friend_relationship` (
  `friend_relationship_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `friend_user_id` bigint(20) DEFAULT NULL,
  `begin_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`friend_relationship_id`),
  KEY `FK_Reference_2` (`user_id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `friend_relationship` */

/*Table structure for table `p_file_index` */

DROP TABLE IF EXISTS `p_file_index`;

CREATE TABLE `p_file_index` (
  `p_file_index_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `p_name` varchar(255) DEFAULT NULL,
  `p_path` varchar(255) DEFAULT NULL,
  `file_size` bigint(20) DEFAULT NULL,
  `file_md5` varchar(255) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`p_file_index_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='即hdfs上文件的信息';

/*Data for the table `p_file_index` */

insert  into `p_file_index`(`p_file_index_id`,`p_name`,`p_path`,`file_size`,`file_md5`,`create_time`) values (1,'wallhaven-1857.jpg','/couddisk/wallhaven-1857.jpg',4884031,'1f614a517fae3a1c663399e1387d8505','2017-05-23 17:36:50'),(2,'wallhaven-6546.jpg','/couddisk/wallhaven-6546.jpg',285554,'b6f20ab4c0e703ff95ada76a8c2f97c2','2017-05-23 18:06:52'),(3,'wallhaven-23060.jpg','/couddisk/wallhaven-23060.jpg',905743,'46d2002284c0bfed97d7f50712f22dd5','2017-05-23 18:07:06'),(4,'wallhaven-24690.jpg','/couddisk/wallhaven-24690.jpg',1352873,'6bb8d35de1a2e8edcafd5a7bb3f3ddb4','2017-05-23 18:13:36');

/*Table structure for table `share_file` */

DROP TABLE IF EXISTS `share_file`;

CREATE TABLE `share_file` (
  `share_file_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `share_user_id` bigint(20) DEFAULT NULL,
  `accept_user_id` bigint(20) DEFAULT NULL,
  `share_fi_id` bigint(20) DEFAULT NULL,
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`share_file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `share_file` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
