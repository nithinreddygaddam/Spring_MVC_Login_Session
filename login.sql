CREATE SCHEMA IF NOT EXISTS `login` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `login` ;

-- -----------------------------------------------------
-- Table `login`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `login`.`user` (
  `userId` VARCHAR(45) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `userId_UNIQUE` (`userId` ASC))
ENGINE = InnoDB;
