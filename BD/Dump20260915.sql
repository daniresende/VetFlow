-- MySQL dump 10.13  Distrib 8.0.45, for Win64 (x86_64)
--
-- Host: localhost    Database: vetflow
-- ------------------------------------------------------
-- Server version	8.0.45

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
-- Table structure for table `cadastropet`
--

DROP TABLE IF EXISTS `cadastropet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cadastropet` (
  `nomeAnimal` varchar(255) DEFAULT NULL,
  `cpfTutor` varchar(14) DEFAULT NULL,
  `especie` varchar(255) DEFAULT NULL,
  `raca` varchar(255) DEFAULT NULL,
  `corPelagem` varchar(255) DEFAULT NULL,
  `peso` float DEFAULT NULL,
  `sexo` varchar(255) DEFAULT NULL,
  `idade` int DEFAULT NULL,
  `idAnimal` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idAnimal`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cadastrotutor`
--

DROP TABLE IF EXISTS `cadastrotutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cadastrotutor` (
  `nome` varchar(255) DEFAULT NULL,
  `cpf` varchar(14) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `contato` varchar(20) DEFAULT NULL,
  `dataNascimento` date DEFAULT NULL,
  `sexo` varchar(255) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `cep` varchar(9) DEFAULT NULL,
  `pessoaEmergencia` varchar(255) DEFAULT NULL,
  `contatoEmergencia` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `usuario` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `idLogin` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idLogin`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `relatorio`
--

DROP TABLE IF EXISTS `relatorio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `relatorio` (
  `idRelatorio` int NOT NULL AUTO_INCREMENT,
  `idAnimal` int DEFAULT NULL,
  `idVeterinario` int DEFAULT NULL,
  `dataConsulta` date DEFAULT NULL,
  `queixaPrincipal` varchar(255) DEFAULT NULL,
  `historico` text,
  `temperatura` float DEFAULT NULL,
  `peso` float DEFAULT NULL,
  `diagnostico` text,
  `tratamento` text,
  `observacoes` text,
  PRIMARY KEY (`idRelatorio`),
  KEY `idAnimal` (`idAnimal`),
  KEY `idVeterinario` (`idVeterinario`),
  CONSTRAINT `relatorio_ibfk_1` FOREIGN KEY (`idAnimal`) REFERENCES `cadastropet` (`idAnimal`),
  CONSTRAINT `relatorio_ibfk_2` FOREIGN KEY (`idVeterinario`) REFERENCES `veterinario` (`idVeterinario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `veterinario`
--

DROP TABLE IF EXISTS `veterinario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `veterinario` (
  `idVeterinario` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `crmv` varchar(20) DEFAULT NULL,
  `especialidade` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `contato` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idVeterinario`),
  UNIQUE KEY `crmv` (`crmv`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-09-15 22:28:00
