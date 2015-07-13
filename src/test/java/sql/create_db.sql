#=================================================================== SCHEMA `testdepo`======================================
CREATE SCHEMA `testdepo` ;

# ================================================================== `testdepo`.`role` =====================================
CREATE TABLE `testdepo`.`role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_UNIQUE` (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# ================================================================== `testdepo`.`unit` =====================================
CREATE TABLE `testdepo`.`unit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `unit` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`unit`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# ================================================================== `testdepo`.`users` ====================================
CREATE TABLE `testdepo`.`users` (
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `role_fk_idx` (`id_role`),
  KEY `id_unit_fk_idx` (`id_unit`),
  CONSTRAINT `id_role_fk` FOREIGN KEY (`id_role`) REFERENCES `testdepo`.`role` (`id`),
  CONSTRAINT `id_unit_fk` FOREIGN KEY (`id_unit`) REFERENCES `testdepo`.`unit` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;