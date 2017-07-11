-- ---
-- Globals
-- ---

-- SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
-- SET FOREIGN_KEY_CHECKS=0;

-- ---
-- Table 'Providers'
--
-- ---

DROP TABLE IF EXISTS `Providers`;

CREATE TABLE `Providers` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `name` VARCHAR NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
KEY ()
);

-- ---
-- Table 'patients'
--
-- ---

DROP TABLE IF EXISTS `patients`;

CREATE TABLE `patients` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `name` VARCHAR NULL DEFAULT NULL,
  `dob` DATE NULL DEFAULT NULL,
  `providersId` INTEGER NULL DEFAULT NULL,
  `specalityId` INTEGER NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `specalityId`)
);

-- ---
-- Table 'Admin'
--
-- ---

DROP TABLE IF EXISTS `Admin`;

CREATE TABLE `Admin` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'specality'
--
-- ---

DROP TABLE IF EXISTS `specality`;

CREATE TABLE `specality` (
  `id` INTEGER NULL DEFAULT NULL,
  `dental` VARCHAR NULL DEFAULT NULL,
  `rhmatology` VARCHAR NULL DEFAULT NULL,
  `cardio` VARCHAR NULL DEFAULT NULL,
  `providersId` INTEGER NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `providersId`)
);

-- ---
-- Foreign Keys
-- ---

ALTER TABLE `patients` ADD FOREIGN KEY (providersId) REFERENCES `Providers` (`id`);
ALTER TABLE `specality` ADD FOREIGN KEY (id) REFERENCES `patients` (`specalityId`);
ALTER TABLE `specality` ADD FOREIGN KEY (providersId) REFERENCES `Providers` (`id`);

-- ---
-- Table Properties
-- ---

-- ALTER TABLE `Providers` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `patients` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `Admin` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `specality` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ---
-- Test Data
-- ---

-- INSERT INTO `Providers` (`id`,`name`) VALUES
-- ('','');
-- INSERT INTO `patients` (`id`,`name`,`dob`,`providersId`,`specalityId`) VALUES
-- ('','','','','');
-- INSERT INTO `Admin` (`id`) VALUES
-- ('');
-- INSERT INTO `specality` (`id`,`dental`,`rhmatology`,`cardio`,`providersId`) VALUES
-- ('','','','','');
