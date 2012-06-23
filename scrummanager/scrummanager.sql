-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: scrummanager
-- ------------------------------------------------------
-- Server version	5.5.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `abilities`
--

DROP TABLE IF EXISTS `abilities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `abilities` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '',
  `level` int(10) unsigned NOT NULL DEFAULT '0',
  `people` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abilities`
--

LOCK TABLES `abilities` WRITE;
/*!40000 ALTER TABLE `abilities` DISABLE KEYS */;
/*!40000 ALTER TABLE `abilities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conference`
--

DROP TABLE IF EXISTS `conference`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conference` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `approved` varchar(255) DEFAULT NULL,
  `approvedReason` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `identification` varchar(255) DEFAULT NULL,
  `registrationDate` datetime DEFAULT NULL,
  `sprintReview` varchar(255) DEFAULT NULL,
  `project` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKA231213CDDAF13BD` (`project`),
  CONSTRAINT `FKA231213CDDAF13BD` FOREIGN KEY (`project`) REFERENCES `project` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conference`
--

LOCK TABLES `conference` WRITE;
/*!40000 ALTER TABLE `conference` DISABLE KEYS */;
INSERT INTO `conference` VALUES (1,'false','','Definição de recursos necessários para o projeto.','RECRUTAMENTO-01','2012-04-01 00:00:00','false',3),(2,'false','','Apresentação das funcionalidades principais do sistema.','APRESENTACAO-01','2012-04-01 00:00:00','false',3);
/*!40000 ALTER TABLE `conference` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `impediment`
--

DROP TABLE IF EXISTS `impediment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `impediment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `identification` varchar(255) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `registrationDate` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `project` int(11) DEFAULT NULL,
  `requirement` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKCC0CDEDC20007891` (`requirement`),
  KEY `FKCC0CDEDCDDAF13BD` (`project`),
  CONSTRAINT `FKCC0CDEDC20007891` FOREIGN KEY (`requirement`) REFERENCES `requirement` (`id`),
  CONSTRAINT `FKCC0CDEDCDDAF13BD` FOREIGN KEY (`project`) REFERENCES `project` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `impediment`
--

LOCK TABLES `impediment` WRITE;
/*!40000 ALTER TABLE `impediment` DISABLE KEYS */;
INSERT INTO `impediment` VALUES (1,'Autenticação no sistema está lenta. É preciso fazer uma otimização.','DESEMPENHO','','2012-04-28 17:45:11','Pendente',3,1);
/*!40000 ALTER TABLE `impediment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `knowledge`
--

DROP TABLE IF EXISTS `knowledge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `knowledge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `knowledge`
--

LOCK TABLES `knowledge` WRITE;
/*!40000 ALTER TABLE `knowledge` DISABLE KEYS */;
INSERT INTO `knowledge` VALUES (1,'Design'),(2,'Spring'),(3,'Java'),(4,'Padrão de Projeto'),(5,'Hibernate'),(6,'JPA'),(7,'Conhecimento de Negócio');
/*!40000 ALTER TABLE `knowledge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ocuppation`
--

DROP TABLE IF EXISTS `ocuppation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ocuppation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ocuppation`
--

LOCK TABLES `ocuppation` WRITE;
/*!40000 ALTER TABLE `ocuppation` DISABLE KEYS */;
INSERT INTO `ocuppation` VALUES (1,'Desenvolvedor'),(2,'Gerente de Projero'),(3,'Arquiteto Java'),(4,'Arquiteto de Solução'),(5,'WebMaster');
/*!40000 ALTER TABLE `ocuppation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `people`
--

DROP TABLE IF EXISTS `people`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `people` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '',
  `email` varchar(45) NOT NULL DEFAULT '',
  `phone` varchar(45) NOT NULL DEFAULT '',
  `project` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8E471EAFDDAF13BD` (`project`),
  CONSTRAINT `FK8E471EAFDDAF13BD` FOREIGN KEY (`project`) REFERENCES `project` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `people`
--

LOCK TABLES `people` WRITE;
/*!40000 ALTER TABLE `people` DISABLE KEYS */;
INSERT INTO `people` VALUES (38,'Rodolfo Chaves Fernandes','chavesrodolfo@gmail.com','(41) 9999-2744',NULL),(39,'Lais Zanfolim','lzanfolim@gmail.com','(41) 9988-7755',NULL);
/*!40000 ALTER TABLE `people` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `closingDate` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `openingDate` datetime DEFAULT NULL,
  `identification` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (3,'2012-12-21 00:00:00','Projeto Scrum Manager - Gestão de Projetos inspirado na metodologia Scrum.',NULL,'2012-04-01 00:00:00','PJ-SM'),(4,'2012-11-30 00:00:00','Projeto Paga EU - Gerenciamento de contas a pagar e receber.',NULL,'2012-04-01 00:00:00','PAGAEU');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requirement`
--

DROP TABLE IF EXISTS `requirement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requirement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `effortHours` varchar(255) DEFAULT NULL,
  `identification` varchar(255) DEFAULT NULL,
  `roi` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `project` int(11) DEFAULT NULL,
  `sprint` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK79128423DDAF13BD` (`project`),
  KEY `FK7912842319702949` (`sprint`),
  CONSTRAINT `FK7912842319702949` FOREIGN KEY (`sprint`) REFERENCES `sprint` (`id`),
  CONSTRAINT `FK79128423DDAF13BD` FOREIGN KEY (`project`) REFERENCES `project` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requirement`
--

LOCK TABLES `requirement` WRITE;
/*!40000 ALTER TABLE `requirement` DISABLE KEYS */;
INSERT INTO `requirement` VALUES (1,'Manter usuários do sistema. Determinar perfil de acesso.','40','BL01',NULL,'Pendente',3,NULL),(2,'Página de apresentação com informações sobre o sistema.','8','BL02',NULL,'Pendente',3,NULL);
/*!40000 ALTER TABLE `requirement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill`
--

DROP TABLE IF EXISTS `skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level` varchar(255) DEFAULT NULL,
  `knowledge` int(11) DEFAULT NULL,
  `people` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4C3DA3151A817C7` (`knowledge`),
  CONSTRAINT `FK4C3DA3151A817C7` FOREIGN KEY (`knowledge`) REFERENCES `knowledge` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill`
--

LOCK TABLES `skill` WRITE;
/*!40000 ALTER TABLE `skill` DISABLE KEYS */;
INSERT INTO `skill` VALUES (1,'Júnior',1,38),(2,'Pleno',3,38),(3,'Senior',7,38),(4,'Pleno',2,38),(5,'Júnior',1,39),(6,'Pleno',5,38),(7,'Senior',7,39),(8,'Pleno',4,39);
/*!40000 ALTER TABLE `skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sprint`
--

DROP TABLE IF EXISTS `sprint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sprint` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `closingDate` datetime DEFAULT NULL,
  `deliveryDate` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `openingDate` datetime DEFAULT NULL,
  `project` int(11) DEFAULT NULL,
  `INDEX_COL` int(11) DEFAULT NULL,
  `identification` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9401EE3ADDAF13BD` (`project`),
  CONSTRAINT `FK9401EE3ADDAF13BD` FOREIGN KEY (`project`) REFERENCES `project` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sprint`
--

LOCK TABLES `sprint` WRITE;
/*!40000 ALTER TABLE `sprint` DISABLE KEYS */;
INSERT INTO `sprint` VALUES (7,'2012-04-06 00:00:00','2012-04-13 00:00:00','Fazer otimização da autenticação do sistema.',NULL,'2012-04-03 00:00:00',3,NULL,'DESEMPENHO-AUTENTICACAO'),(8,'2012-04-06 00:00:00','2012-04-06 00:00:00','Definir Layout das páginas que o sistema já possui. (elaborar novamente).',NULL,'2012-04-03 00:00:00',3,NULL,'DEFINICAO-LAYOUT');
/*!40000 ALTER TABLE `sprint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `effortHours` varchar(255) DEFAULT NULL,
  `identification` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `statusTest` varchar(255) DEFAULT NULL,
  `sprint` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK27A9A519702949` (`sprint`),
  CONSTRAINT `FK27A9A519702949` FOREIGN KEY (`sprint`) REFERENCES `sprint` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (1,' Revisao do algoritmo de autenticacao.','4','T001-Revisao','Pendente','Pendente',7);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `authority` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'ROLE_ADMIN','admin@scrummanager.com','admin','Administrador','admin'),(2,'ROLE_USER','chavesrodolfo@gmail.com','chavesrodolfo','Rodolfo Chaves','123');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-04-29 12:13:22
