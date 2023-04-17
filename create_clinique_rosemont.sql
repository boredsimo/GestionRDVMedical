-- Tables MySQL Workbench

SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE =
        'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


-- -----------------------------------------------------
--  Table priseRdv
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `priseRdv`;


CREATE SCHEMA IF NOT EXISTS `priseRdv` DEFAULT CHARACTER SET utf8;
USE `priseRdv`;


-- -----------------------------------------------------
-- Table `priserdv`.`patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `priseRdv`.`patient`
(
    `id`                   INT         NOT NULL AUTO_INCREMENT,
    `nom`             VARCHAR(45) NOT NULL,
    `prenom`            VARCHAR(45) NOT NULL,
    `codeAssuranceMaladie`   VARCHAR(45) NOT NULL,
    `numeroAssuranceMaladie` INT         NOT NULL,
    `dateNaissance`            DATE        NOT NULL,
    `sexe`                  VARCHAR(45) NOT NULL,
    `email`                VARCHAR(45) NOT NULL,
    `motdepasse`             VARCHAR(45) NOT NULL,
    `admin`                TINYINT(1)  NOT NULL,
    `medecin_id`            INT             NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `idpatient_UNIQUE` (`id` ASC),
    UNIQUE INDEX `_UNIQUE` (`codeAssuranceMaladie` ASC),
    UNIQUE INDEX `email_UNIQUE` (`email` ASC),
    INDEX `fk_patient_medecin1_idx` (`medecin_id` ASC),

    CONSTRAINT `fk_patient_medecin_idx`
        FOREIGN KEY (`medecin_id`)
            REFERENCES `priseRdv`.`medecin` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1
    DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `priseRdv`.`clinique`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `priseRdv`.`clinique`
(
    `id`            INT         NOT NULL AUTO_INCREMENT,
    `email`         VARCHAR(45) NOT NULL,
    `motdepasse`      VARCHAR(45) NOT NULL,
    `nomClinique`    VARCHAR(45) NOT NULL,
    `adresseRue` VARCHAR(45) NOT NULL,
    `zip`           VARCHAR(45) NOT NULL,
    `pays`       VARCHAR(45) NOT NULL,
    `ville`          VARCHAR(45) NOT NULL,
    `province`      VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `idClinique_UNIQUE` (`id` ASC),
    UNIQUE INDEX `clinicName_UNIQUE` (`nomClinique` ASC)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1
    DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `priseRdv`.`medecin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `priseRdv`.`medecin`
(
    `id`                   INT         NOT NULL AUTO_INCREMENT,
    `nom`             VARCHAR(45) NOT NULL,
    `prenom`            VARCHAR(45) NOT NULL,
    `numeroMedecin`   INT         NOT NULL,
    `email`                VARCHAR(45) NOT NULL,
    `motdepasse`             VARCHAR(45) NOT NULL,
    `appointmentPrice`     FLOAT       NOT NULL,
    `estDisponibleLundi`    BOOLEAN     NOT NULL,
    `estDisponibleMardi`   BOOLEAN     NOT NULL,
    `estDisponibleMercredi` BOOLEAN     NOT NULL,
    `estDisponibleJeudi`  BOOLEAN     NOT NULL,
    `estDisponibleVendredi`    BOOLEAN     NOT NULL,
    `estDisponibleSamedi`  BOOLEAN     NOT NULL,
    `estDisponibleDimanche`    BOOLEAN     NOT NULL,
    `specialisation_id`    INT         NOT NULL,
    `clinique_id`            INT         NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `idDoctor_UNIQUE` (`id` ASC),
    UNIQUE INDEX `numeroMedecin_UNIQUE` (`numeroMedecin` ASC),

    INDEX `fk_medecin_clinique1_idx` (`clinique_id` ASC),
    INDEX `fk_medecin_specialisation1_idx` (`specialisation_id` ASC),
    CONSTRAINT `fk_medecin_clinique1`
        FOREIGN KEY (`clinique_id`)
            REFERENCES `priseRdv`.`clinique` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_medecin_specialisation1_idx`
        FOREIGN KEY (`specialisation_id`)
            REFERENCES `monrdv`.`specialisation` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1
    DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `priseRdv`.`rendezvous`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `priseRdv`.`rendezvous`
(
    `id`                   INT          NOT NULL AUTO_INCREMENT,
    `heure`           TIMESTAMP(6) NOT NULL,
    `raison`               VARCHAR(45)  NOT NULL,
    `precision`            VARCHAR(100)  NULL,
    `patient_id`           INT          NOT NULL,
    `medecin_id`            INT          NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_RendezVous_patient1_idx` (`patient_id` ASC),
    INDEX `fk_RendezVous_medecin1_idx` (`medecin_id` ASC),
    CONSTRAINT `fk_RendezVous_patient1`
        FOREIGN KEY (`patient_id`)
            REFERENCES `priseRdv`.`patient` (`id`),
    CONSTRAINT `fk_RendezVous_medecin1`
        FOREIGN KEY (`medecin_id`)
            REFERENCES `priseRdv`.`medecin` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1
    DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `priseRdv`.`specialisation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `priseRdv`.`specialisation`
(
    `id`                 INT         NOT NULL AUTO_INCREMENT,
    `titreSpecialisation` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1
    DEFAULT CHARACTER SET = utf8mb3;

INSERT INTO `patient` (`nom`, `prenom`, `codeAssuranceMaladie`, `numeroAssuranceMaladie`, `dateNaissance`, `sexe`, `email`, `motdepasse`, `admin`, `medecin_id`)
VALUES 
('Smith', 'John', '12345', 6789, '1990-06-01', 'M', 'jsmith@gmail.com', 'password123', 0, NULL),
('Doe', 'Jane', '67890', 1234, '1995-08-23', 'F', 'jdoe@gmail.com', 'mypassword', 0, NULL),
('Lee', 'David', '54321', 9876, '1987-03-12', 'M', 'dlee@gmail.com', 'securepassword', 0, NULL),
('Kim', 'Sophia', '24680', 1357, '2000-11-30', 'F', 'skim@gmail.com', 'password123', 0, NULL),
('Chen', 'Ming', '13579', 2468, '1993-02-17', 'M', 'mchen@gmail.com', 'mypassword', 0, NULL);





INSERT INTO `clinique` (`email`, `motdepasse`, `nomClinique`, `adresseRue`, `zip`, `pays`, `ville`, `province`)
VALUES
('admin@healthclinic.com', 'password123', 'Health Clinic', '123 Main St', 'M1M 1M1', 'Canada', 'Toronto', 'Ontario'),
('admin@dentalclinic.com', 'securepassword', 'Dental Clinic', '456 Elm St', 'M2M 2M2', 'Canada', 'Toronto', 'Ontario'),
('admin@wellnessclinic.com', 'mypassword', 'Wellness Clinic', '789 Maple St', 'M3M 3M3', 'Canada', 'Toronto', 'Ontario');

INSERT INTO `medecin` (`nom`, `prenom`, `numeroMedecin`, `email`, `motdepasse`, `appointmentPrice`, `estDisponibleLundi`, `estDisponibleMardi`, `estDisponibleMercredi`, `estDisponibleJeudi`, `estDisponibleVendredi`, `estDisponibleSamedi`, `estDisponibleDimanche`, `specialisation_id`, `clinique_id`)
VALUES
('Johnson', 'Andrew', 123456, 'ajohnson@healthclinic.com', 'password123', 150.00, 1, 1, 0, 1, 0, 0, 0, 1, 1),
('Garcia', 'Maria', 789012, 'mgarcia@dentalclinic.com', 'securepassword', 200.00, 0, 1, 1, 0, 0, 0, 0, 2, 2),
('Li', 'Emily', 345678, 'eli@wellnessclinic.com', 'mypassword', 100.00, 1, 0, 0, 1, 1, 0, 0, 3, 3),
('Park', 'David', 901234, 'dpark@healthclinic.com', 'password123', 175.00, 1, 0, 0, 1, 0, 0, 0, 3, 3);


SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;
