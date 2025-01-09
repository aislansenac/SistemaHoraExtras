DROP DATABASE IF EXISTS pi_bd_aislan_penha;
CREATE DATABASE pi_bd_aislan_penha;
USE pi_bd_aislan_penha;

CREATE TABLE `cargos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `funcionarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `data_nascimento` date NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `salario` decimal(7,2) NOT NULL,
  `status` int NOT NULL,
  `senha` varchar(50) NOT NULL,
  `cargo_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf` (`cpf`),
  KEY `fk_cargos_funcionarios_idx` (`cargo_id`),
  CONSTRAINT `fk_cargo_id` FOREIGN KEY (`cargo_id`) REFERENCES `cargos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `horas_extras` (
  `id` int NOT NULL AUTO_INCREMENT,
  `criador_id` int NOT NULL,
  `data` date NOT NULL,
  `hora_inicio` time NOT NULL,
  `hora_fim` time NOT NULL,
  `observacao` varchar(500) DEFAULT NULL,
  `inscrito` int DEFAULT '0',
  `aprovada` int DEFAULT '0',
  `verificada` int DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_criador_idx` (`criador_id`),
  CONSTRAINT `fk_criador` FOREIGN KEY (`criador_id`) REFERENCES `funcionarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `funcionarios_horaextras` (
  `id` int NOT NULL AUTO_INCREMENT,
  `funcionario_id` int NOT NULL,
  `horaextra_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_funcionario_idx` (`funcionario_id`),
  KEY `fk_horaextra_idx` (`horaextra_id`),
  CONSTRAINT `fk_funcionario` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionarios` (`id`),
  CONSTRAINT `fk_horaextra` FOREIGN KEY (`horaextra_id`) REFERENCES `horas_extras` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

