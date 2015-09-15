#=================================================================== SCHEMA `depo`======================================
DROP DATABASE IF EXISTS `depo`;
CREATE SCHEMA `depo` ;
USE `depo`;

# ================================================================== `depo`.`role` =====================================
CREATE TABLE `depo`.`role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_UNIQUE` (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# ================================================================== `depo`.`unit` =====================================
CREATE TABLE `depo`.`unit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `unit` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`unit`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# ================================================================== `depo`.`county` ===================================
CREATE TABLE IF NOT EXISTS `depo`.`county` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(2) NOT NULL,
  `name` varchar(64) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `account_county_52094d6e` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=43 ;

# ================================================================== `depo`.`city` =====================================
CREATE TABLE IF NOT EXISTS `depo`.`city` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `county_id` BIGINT(20) NOT NULL,
  `siruta` bigint(20) NOT NULL,
  `longitude` decimal(18,16) NOT NULL,
  `latitude` decimal(18,16) NOT NULL,
  `name` varchar(64) NOT NULL,
  `region` varchar(64) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `account_city_3a0d0688` (`county_id`),
  KEY `account_city_52094d6e` (`name`),
  CONSTRAINT `county_id_refs_id_2bce4446` FOREIGN KEY (`county_id`) REFERENCES `depo`.`county` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13750 ;

# ================================================================== `depo`.`users` ====================================
CREATE TABLE `depo`.`users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `accNonExp` bit(1) NOT NULL,
  `accNonLocked` bit(1) NOT NULL,
  `credNonExpired` bit(1) NOT NULL,
  `id_role` bigint(20) NOT NULL,
  `id_unit` bigint(20) NOT NULL,
  `createdAt` datetime DEFAULT CURRENT_TIMESTAMP,
  `modifiedAt` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `createdBy` varchar(255) NOT NULL,
  `modifiedBy` varchar(255) DEFAULT NULL,
  `id_city` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `role_fk_idx` (`id_role`),
  KEY `id_unit_fk_idx` (`id_unit`),
  KEY `id_city_idx` (`id_city`),
  CONSTRAINT `id_city` FOREIGN KEY (`id_city`) REFERENCES `depo`.`city` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `id_role_fk` FOREIGN KEY (`id_role`) REFERENCES `depo`.`role` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `id_unit_fk` FOREIGN KEY (`id_unit`) REFERENCES `depo`.`unit` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
