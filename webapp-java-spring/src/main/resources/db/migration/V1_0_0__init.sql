/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;

CREATE TABLE IF NOT EXISTS `appointment` (
  `id`          BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `when_date`   DATETIME     NOT NULL,
  `calendar_id` BIGINT(20)   NOT NULL,
  `what`        VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_sosid5yitbmsmdgkxrd7ers0m` (`calendar_id`),
  CONSTRAINT `FK_sosid5yitbmsmdgkxrd7ers0m` FOREIGN KEY (`calendar_id`) REFERENCES `calendar` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `calendar` (
  `id`        BIGINT(20) NOT NULL AUTO_INCREMENT,
  `person_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_s76pcapv9hyqv1secxlo17y7j` (`person_id`),
  CONSTRAINT `FK_s76pcapv9hyqv1secxlo17y7j` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `person` (
  `id`         BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `last_name`  VARCHAR(255) NOT NULL,
  `first_name` VARCHAR(255) NOT NULL,
  `gender`     VARCHAR(255) NOT NULL,
  `birthday`   DATE                  DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*!40101 SET SQL_MODE = IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS = IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
