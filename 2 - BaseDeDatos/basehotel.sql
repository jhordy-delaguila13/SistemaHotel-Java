SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `BaseHotel` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `BaseHotel` ;

-- -----------------------------------------------------
-- Table `BaseHotel`.`Cliente`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BaseHotel`.`Cliente` (
  `idCliente` CHAR(8) NOT NULL ,
  `Nombre` VARCHAR(45) NULL ,
  `Apellidos` VARCHAR(100) NULL ,
  `Direccion` VARCHAR(100) NULL ,
  `telefono` VARCHAR(20) NULL ,
  `Nacionalidad` VARCHAR(45) NULL ,
  `DNI` CHAR(8) NULL ,
  PRIMARY KEY (`idCliente`) ,
  UNIQUE INDEX `DNI_UNIQUE` (`DNI` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BaseHotel`.`Categoria`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BaseHotel`.`Categoria` (
  `idCategoria` CHAR(8) NOT NULL ,
  `Descripcion` VARCHAR(45) NULL ,
  `nombre` VARCHAR(100) NULL ,
  PRIMARY KEY (`idCategoria`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BaseHotel`.`Habitacion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BaseHotel`.`Habitacion` (
  `idHabitacion` CHAR(8) NOT NULL ,
  `Numero` INT NOT NULL ,
  `Estado` VARCHAR(45) NOT NULL ,
  `Costo` DOUBLE NOT NULL ,
  `Descripcion` VARCHAR(45) NOT NULL ,
  `Tipo_idTipo` CHAR(8) NOT NULL ,
  PRIMARY KEY (`idHabitacion`, `Tipo_idTipo`) ,
  INDEX `fk_Habitacion_Tipo1_idx` (`Tipo_idTipo` ASC) ,
  CONSTRAINT `fk_Habitacion_Tipo1`
    FOREIGN KEY (`Tipo_idTipo` )
    REFERENCES `BaseHotel`.`Categoria` (`idCategoria` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BaseHotel`.`Recepcionista`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BaseHotel`.`Recepcionista` (
  `idRecepcionista` CHAR(8) NOT NULL ,
  `Nombre` VARCHAR(45) NOT NULL ,
  `Apellidos` VARCHAR(100) NOT NULL ,
  `Direccion` VARCHAR(100) NOT NULL ,
  `DNI` CHAR(8) NOT NULL ,
  `Telefono` VARCHAR(20) NOT NULL ,
  `Correo` VARCHAR(200) NOT NULL ,
  PRIMARY KEY (`idRecepcionista`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BaseHotel`.`Reserva`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BaseHotel`.`Reserva` (
  `idReserva` CHAR(8) NOT NULL ,
  `fechaEntrada` DATE NULL ,
  `costoTotal` DECIMAL(9,2) NULL ,
  `idRecepcionista` CHAR(8) NOT NULL ,
  `idCliente` CHAR(8) NOT NULL ,
  PRIMARY KEY (`idReserva`, `idRecepcionista`, `idCliente`) ,
  INDEX `fk_Reserva_Recepcionista2_idx` (`idRecepcionista` ASC) ,
  INDEX `fk_Reserva_Cliente2_idx` (`idCliente` ASC) ,
  CONSTRAINT `fk_Reserva_Recepcionista2`
    FOREIGN KEY (`idRecepcionista` )
    REFERENCES `BaseHotel`.`Recepcionista` (`idRecepcionista` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Cliente2`
    FOREIGN KEY (`idCliente` )
    REFERENCES `BaseHotel`.`Cliente` (`idCliente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BaseHotel`.`Reserva_has_Habitacion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BaseHotel`.`Reserva_has_Habitacion` (
  `idReserva` CHAR(8) NOT NULL ,
  `idHabitacion` CHAR(8) NOT NULL ,
  PRIMARY KEY (`idReserva`, `idHabitacion`) ,
  INDEX `fk_Reserva_has_Habitacion1_Habitacion1_idx` (`idHabitacion` ASC) ,
  INDEX `fk_Reserva_has_Habitacion1_Reserva1_idx` (`idReserva` ASC) ,
  CONSTRAINT `fk_Reserva_has_Habitacion1_Reserva1`
    FOREIGN KEY (`idReserva` )
    REFERENCES `BaseHotel`.`Reserva` (`idReserva` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_has_Habitacion1_Habitacion1`
    FOREIGN KEY (`idHabitacion` )
    REFERENCES `BaseHotel`.`Habitacion` (`idHabitacion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BaseHotel`.`Servicios_has_Reserva`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BaseHotel`.`Servicios_has_Reserva` (
  `Servicios_idServicios` CHAR(8) NOT NULL ,
  `Reserva_idReserva` CHAR(8) NOT NULL ,
  PRIMARY KEY (`Servicios_idServicios`, `Reserva_idReserva`) ,
  INDEX `fk_Servicios_has_Reserva_Reserva1_idx` (`Reserva_idReserva` ASC) ,
  CONSTRAINT `fk_Servicios_has_Reserva_Reserva1`
    FOREIGN KEY (`Reserva_idReserva` )
    REFERENCES `BaseHotel`.`Reserva` (`idReserva` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BaseHotel`.`Reserva`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BaseHotel`.`Reserva` (
  `idReserva` CHAR(8) NOT NULL ,
  `fechaEntrada` DATE NULL ,
  `costoTotal` DECIMAL(9,2) NULL ,
  `idRecepcionista` CHAR(8) NOT NULL ,
  `idCliente` CHAR(8) NOT NULL ,
  PRIMARY KEY (`idReserva`, `idRecepcionista`, `idCliente`) ,
  INDEX `fk_Reserva_Recepcionista2_idx` (`idRecepcionista` ASC) ,
  INDEX `fk_Reserva_Cliente2_idx` (`idCliente` ASC) ,
  CONSTRAINT `fk_Reserva_Recepcionista2`
    FOREIGN KEY (`idRecepcionista` )
    REFERENCES `BaseHotel`.`Recepcionista` (`idRecepcionista` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Cliente2`
    FOREIGN KEY (`idCliente` )
    REFERENCES `BaseHotel`.`Cliente` (`idCliente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BaseHotel`.`ComprobantePago`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BaseHotel`.`ComprobantePago` (
  `idComprobantePago` CHAR(8) NOT NULL ,
  `descripcion` VARCHAR(45) NOT NULL ,
  `fecha` DATE NOT NULL ,
  `Reserva_idReserva` CHAR(8) NOT NULL ,
  `idReserva` CHAR(8) NOT NULL ,
  PRIMARY KEY (`idComprobantePago`, `Reserva_idReserva`, `idReserva`) ,
  INDEX `fk_ComprobantePago_Reserva1_idx` (`Reserva_idReserva` ASC) ,
  INDEX `fk_ComprobantePago_Reserva2_idx` (`idReserva` ASC) ,
  CONSTRAINT `fk_ComprobantePago_Reserva1`
    FOREIGN KEY (`Reserva_idReserva` )
    REFERENCES `BaseHotel`.`Reserva` (`idReserva` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ComprobantePago_Reserva2`
    FOREIGN KEY (`idReserva` )
    REFERENCES `BaseHotel`.`Reserva` (`idReserva` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BaseHotel`.`Reserva_has_Habitacion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BaseHotel`.`Reserva_has_Habitacion` (
  `idReserva` CHAR(8) NOT NULL ,
  `idHabitacion` CHAR(8) NOT NULL ,
  PRIMARY KEY (`idReserva`, `idHabitacion`) ,
  INDEX `fk_Reserva_has_Habitacion1_Habitacion1_idx` (`idHabitacion` ASC) ,
  INDEX `fk_Reserva_has_Habitacion1_Reserva1_idx` (`idReserva` ASC) ,
  CONSTRAINT `fk_Reserva_has_Habitacion1_Reserva1`
    FOREIGN KEY (`idReserva` )
    REFERENCES `BaseHotel`.`Reserva` (`idReserva` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_has_Habitacion1_Habitacion1`
    FOREIGN KEY (`idHabitacion` )
    REFERENCES `BaseHotel`.`Habitacion` (`idHabitacion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
