#=================================================================== SCHEMA `depo`======================================
CREATE SCHEMA `depo` ;

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

# ================================================================== `depo`.`users` ====================================
CREATE TABLE `depo`.`users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nume` varchar(255) NOT NULL,
  `prenume` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `parola` varchar(255) NOT NULL,
  `mail` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `accNonExp` bit(1) NOT NULL,
  `accNonLocked` bit(1) NOT NULL,
  `credNonExpired` bit(1) NOT NULL,
  `id_role` bigint(20) NOT NULL,
  `id_unit` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `role_fk_idx` (`id_role`),
  KEY `id_unit_fk_idx` (`id_unit`),
  CONSTRAINT `id_role_fk` FOREIGN KEY (`id_role`) REFERENCES `depo`.`role` (`id`),
  CONSTRAINT `id_unit_fk` FOREIGN KEY (`id_unit`) REFERENCES `depo`.`unit` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
