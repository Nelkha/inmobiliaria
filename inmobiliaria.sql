-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: inmobiliaria
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `contrato`
--

DROP TABLE IF EXISTS `contrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contrato` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `ALTA` tinyint(1) NOT NULL DEFAULT '0',
  `FECHAFIN` date NOT NULL,
  `FECHAINICIO` date NOT NULL,
  `INDEXACIONMESES` int NOT NULL,
  `MONTOALQUILER` double NOT NULL,
  `inmueble_id` bigint DEFAULT NULL,
  `inquilino_id` bigint DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_CONTRATO_inquilino_id` (`inquilino_id`),
  KEY `FK_CONTRATO_inmueble_id` (`inmueble_id`),
  CONSTRAINT `FK_CONTRATO_inmueble_id` FOREIGN KEY (`inmueble_id`) REFERENCES `inmueble` (`ID`),
  CONSTRAINT `FK_CONTRATO_inquilino_id` FOREIGN KEY (`inquilino_id`) REFERENCES `inquilino` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contrato`
--

LOCK TABLES `contrato` WRITE;
/*!40000 ALTER TABLE `contrato` DISABLE KEYS */;
INSERT INTO `contrato` VALUES (1,1,'2026-07-31','2023-08-01',6,70000,1,1),(2,1,'2026-07-31','2023-08-01',3,120000,3,2),(3,1,'2026-07-31','2023-08-01',3,120000,3,2);
/*!40000 ALTER TABLE `contrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `importes_alquiler`
--

DROP TABLE IF EXISTS `importes_alquiler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `importes_alquiler` (
  `contrato_id` bigint DEFAULT NULL,
  `importe` double DEFAULT NULL,
  KEY `FK_importes_alquiler_contrato_id` (`contrato_id`),
  CONSTRAINT `FK_importes_alquiler_contrato_id` FOREIGN KEY (`contrato_id`) REFERENCES `contrato` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `importes_alquiler`
--

LOCK TABLES `importes_alquiler` WRITE;
/*!40000 ALTER TABLE `importes_alquiler` DISABLE KEYS */;
INSERT INTO `importes_alquiler` VALUES (2,120000),(3,120000);
/*!40000 ALTER TABLE `importes_alquiler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inmueble`
--

DROP TABLE IF EXISTS `inmueble`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inmueble` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `ALTA` tinyint(1) NOT NULL DEFAULT '0',
  `DIRECCION` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inmueble`
--

LOCK TABLES `inmueble` WRITE;
/*!40000 ALTER TABLE `inmueble` DISABLE KEYS */;
INSERT INTO `inmueble` VALUES (1,1,'LAS HERAS 825'),(2,1,'CALLE DEL INMUEBLE ALTURA'),(3,1,'LAPRIDA 1215'),(4,1,'LAS HERAS 755'),(5,1,'CALLE FALSA 123');
/*!40000 ALTER TABLE `inmueble` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inquilino`
--

DROP TABLE IF EXISTS `inquilino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inquilino` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `APELLIDO` varchar(255) NOT NULL,
  `CUIT` varchar(255) NOT NULL,
  `NOMBRE` varchar(255) NOT NULL,
  `TELEFONO` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `CUIT` (`CUIT`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inquilino`
--

LOCK TABLES `inquilino` WRITE;
/*!40000 ALTER TABLE `inquilino` DISABLE KEYS */;
INSERT INTO `inquilino` VALUES (1,'Gallego','2036573105','Mario','3774447234'),(2,'ROMERO','20449024509','MARCELINI','3774446963');
/*!40000 ALTER TABLE `inquilino` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-08 13:53:06
