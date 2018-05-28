-- MySQL Administrator dump 1.4
-- Host: localhost    Database: manageruser_nguyentruongquan
-- ------------------------------------------------------
-- Server version	5.0.45-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema manageuser
--

CREATE DATABASE IF NOT EXISTS `manageruser_nguyentruongquan` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE manageruser_nguyentruongquan;

--
-- Table structure for table `mst_group`
--

DROP TABLE IF EXISTS `mst_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mst_group` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(255) NOT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mst_group`
--

LOCK TABLES `mst_group` WRITE;
/*!40000 ALTER TABLE `mst_group` DISABLE KEYS */;
INSERT INTO `mst_group` VALUES (1,'Group 1'),(2,'Group 2'),(3,'Group 3'),(4,'Group 4');
/*!40000 ALTER TABLE `mst_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mst_japan`
--

DROP TABLE IF EXISTS `mst_japan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mst_japan` (
  `code_level` varchar(15) NOT NULL,
  `name_level` varchar(255) NOT NULL,
  PRIMARY KEY (`code_level`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mst_japan`
--

LOCK TABLES `mst_japan` WRITE;
/*!40000 ALTER TABLE `mst_japan` DISABLE KEYS */;
INSERT INTO `mst_japan` VALUES ('N1','Level 1'),('N2','Level 2'),('N3','Level 3'),('N4','Level 4'),('N5','Level 5');
/*!40000 ALTER TABLE `mst_japan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_detail_user_japan`
--

DROP TABLE IF EXISTS `tbl_detail_user_japan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_detail_user_japan` (
  `detail_user_japan_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `code_level` varchar(15) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `total` int(11) NOT NULL,
  PRIMARY KEY (`detail_user_japan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_detail_user_japan`
--

LOCK TABLES `tbl_detail_user_japan` WRITE;
/*!40000 ALTER TABLE `tbl_detail_user_japan` DISABLE KEYS */;
INSERT INTO `tbl_detail_user_japan` VALUES (1,1,'N5','2015-07-06','2017-07-06',290),(2,2,'N5','2015-07-06','2014-07-06',290),(3,2,'N3','2015-07-06','2017-07-06',280);
/*!40000 ALTER TABLE `tbl_detail_user_japan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_user`
--

DROP TABLE IF EXISTS `tbl_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `login_name` varchar(15) NOT NULL,
  `password` varchar(50) NOT NULL,
  `check_account` int(2) DEFAULT NULL,
  `full_name` varchar(255) NOT NULL,
  `full_name_kana` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `tel` varchar(15) NOT NULL,
  `birthday` date NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user`
--

LOCK TABLES `tbl_user` WRITE;
/*!40000 ALTER TABLE `tbl_user` DISABLE KEYS */;
INSERT INTO `tbl_user` VALUES (1,1,'admin','admin',0,'Nguyễn Trường Quân','グエン·チュオンミリタリー','nguyentruongquan.bg@gmail.com','0947017140','1991-03-20'),(2,1,'login1','123456',1,'Lê Đình Hải','ルディンハイ','leanhhai666@gmail.com','0904323879','1994-04-04'),(3,1,'login2','123456',1,'Bùi Thị Hạnh','ブイティハン','hanhit.cv@gmail.com','01656208243','1993-05-05'),(4,2,'login3','123456',1,'Nguyễn Thị Phượng','グエン·ティ·フォン','phuongot270994@gmail.com','01666373071','1994-09-27'),(5,3,'login4','123456',1,'Nguyễn Đức Tuấn','グエン·ドゥック·トゥアン','nguyenductuan0402@gmail.com','0978255162','1989-02-04'),(6,2,'login5','123456',1,'Nguyễn Minh Quân','グエン·ミン泉','minhquan.nuce@gmail.com','01663821839','1991-03-29'),(7,1,'login6','123456',1,'Nguyễn Huy Dũng','グエン·フイ·ズン','dungnh2202@gmail.com','097500300','1988-02-22'),(8,1,'login7','123456',1,'Nguyễn Tiến Đạt','グエン·ティエンダット','boylucky.love.money@gmail.com','01646434244','1992-11-06');
/*!40000 ALTER TABLE `tbl_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
