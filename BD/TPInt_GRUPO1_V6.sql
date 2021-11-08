CREATE DATABASE  IF NOT EXISTS `tpint_grupo1_V2`; 
USE `tpint_grupo1_V2`;
CREATE TABLE `tipomovimiento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `tipocuenta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `nacionalidad` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Nacionalidad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `rol` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(45) DEFAULT NULL,
  `Estado` boolean not NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `telefonos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Numero` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;
CREATE TABLE `datospersonales` (
  `Dni` int NOT NULL,
  `Cuil` double NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Apellido` varchar(45) DEFAULT NULL,
  `Sexo` varchar(45) DEFAULT NULL,
  `FechaNacimiento` date DEFAULT NULL,
  `Direccion` varchar(45) DEFAULT NULL,
  `Localidad` varchar(45) DEFAULT NULL,
  `Provincia` varchar(45) DEFAULT NULL,
  `Mail` varchar(45) DEFAULT NULL,
  `FK_Nacionalidad` int NOT NULL,
  `FK_idTelefono` int NOT NULL,
  PRIMARY KEY (`Dni`),
  KEY `FK_Nacionalidad_idx` (`FK_Nacionalidad`),
  KEY `FK_idTelefono_idx` (`FK_idTelefono`),
  CONSTRAINT `FK_idTelefono` FOREIGN KEY (`FK_idTelefono`) REFERENCES `telefonos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Nacionalidad` FOREIGN KEY (`FK_Nacionalidad`) REFERENCES `nacionalidad` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE `cuentas` (
  `NumeroCuenta` int NOT NULL AUTO_INCREMENT,
  `Cbu` double NOT NULL,
  `FechaCreacion` date DEFAULT NULL,
  `Saldo` decimal(10,3) DEFAULT NULL,
  `Estado` boolean not NULL,
  `FK_idTipoCuenta` int NOT NULL,
  `FK_DniCliente` int NOT NULL,
  PRIMARY KEY (`NumeroCuenta`,`Cbu`),
  KEY `FK_idTipoCuenta_idx` (`FK_idTipoCuenta`),
  KEY `FK_DniCliente_idx` (`FK_DniCliente`),
  CONSTRAINT `FK_DniCliente` FOREIGN KEY (`FK_DniCliente`) REFERENCES `datospersonales` (`Dni`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_idTipoCuenta` FOREIGN KEY (`FK_idTipoCuenta`) REFERENCES `tipocuenta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ;
CREATE TABLE `movimientos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Detalle` varchar(45) DEFAULT NULL,
  `Fecha` date DEFAULT NULL,
  `Importe` decimal(10,3) DEFAULT NULL,
  `FK_IdTipoMovimiento` int NOT NULL,
  `FK_IdCuentas` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_IdTipoMovimiento_idx` (`FK_IdTipoMovimiento`),
  KEY `FK_IdCuentas_idx` (`FK_IdCuentas`),
  CONSTRAINT `FK_IdTipoMovimiento` FOREIGN KEY (`FK_IdTipoMovimiento`) REFERENCES `tipomovimiento` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_IdCuentas` FOREIGN KEY (`FK_IdCuentas`) REFERENCES `cuentas` (`NumeroCuenta`) ON DELETE CASCADE ON UPDATE CASCADE
) ;
CREATE TABLE `prestamos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cuotasPagas` int DEFAULT NULL,
  `cuotasTotal` int DEFAULT NULL,
  `importeCuota` decimal(10,3) DEFAULT NULL,
  `importePedido` decimal(10,3) DEFAULT NULL,
  `FechaUltimoPago` date DEFAULT NULL,
  `FK_NumeroCuenta` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_NumeroCuenta_idx` (`FK_NumeroCuenta`),
  CONSTRAINT `FK_NumeroCuenta` FOREIGN KEY (`FK_NumeroCuenta`) REFERENCES `cuentas` (`NumeroCuenta`) ON DELETE CASCADE ON UPDATE CASCADE
); 
CREATE TABLE `solicitud` (
  `idSolicitud` int NOT NULL AUTO_INCREMENT,
  `FK_NCuenta` int NOT NULL,
  `Montosolicitado` decimal(10,3) DEFAULT NULL,
  `CantCuotasSolicitadas` int DEFAULT NULL,
  `EstadoSolicitud` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idSolicitud`),
  KEY `FK_NumeroCuenta_idx` (`FK_NCuenta`),
  CONSTRAINT `FK_NCuenta` FOREIGN KEY (`FK_NCuenta`) REFERENCES `cuentas` (`NumeroCuenta`) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `NombreUsuario` varchar(45) DEFAULT NULL,
  `Contraseña` varchar(45) DEFAULT NULL,
  `FK_idRol` int NOT NULL,
  `FK_DniDP` int NOT NULL,
  `Estado` boolean not NULL,
  PRIMARY KEY (`id`),
  KEY `FK_idRol_idx` (`FK_idRol`),
  KEY `FK_DniDP_idx` (`FK_DniDP`),
  CONSTRAINT `FK_DniDP` FOREIGN KEY (`FK_DniDP`) REFERENCES `datospersonales` (`Dni`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_idRol` FOREIGN KEY (`FK_idRol`) REFERENCES `rol` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO `nacionalidad`(Nacionalidad) VALUES ('Afganistán'),('Albania'),('Alemania'),('Andorra'),('Angola'),('Antigua y Barbuda'),('Arabia Saudita'),
('Argelia'),('Argentina'),('Armenia'),('Australia'),('Austria'),('Azerbaiyán'),('Bahamas'),('Bahréin'),('Bangladés'),('Barbados'),('Bielorrusia'),
('Bélgica'),('Belice'),('Benín'),('Bután'),('Bolivia'),('Bosnia-Herzegovina'),('Botsuana'),('Brasil'),('Brunéi'),('Bulgaria'),('Burkina Faso'),
('Burundi'),('Burundi'),('Cabo Verde'),('Camboya'),('Camerún'),('Canadá'),('Chad'),('República Checa'),('Chequia'),('Chile'),('China'),('Chipre'),
('Colombia'),('Comoras'),('Congo'),('Corea del Norte'),('Corea del Sur'),('Costa Rica'),('Costa de Marfil'),('Croacia'),('Cuba'),('Dinamarca'),
('Dominica'),('Ecuador'),('El Salvador'),('España'),('Estados Unidos'),('Guatemala'),('Francia'),('Honduras'),('Israel'),('Italia'),('Jamaica'),
('México'),('Nicaragua'),('Noruega'),('Panamá'),('Paraguay'),('Perú'),('Portugal'),('República Dominicana'),('Rusia'),('Suiza'),('Uruguay'),
('Zimbabue');
insert into `tipomovimiento`(Descripcion) values('Alta de cuenta'),(' Alta de un préstamo'),('Pago de préstamo'),('Transferencia'),('Extraccion'),('Deposito');
insert into `tipocuenta`(Descripcion) values ('Caja de ahorro'),('Cuenta corriente');
insert into `rol` (Descripcion,Estado)values ('Adminitrativo',true),('Cliente',true),('Gerente',false);

insert into `telefonos`(Numero) values(44444444);
insert into `datospersonales`(Dni, Cuil, Nombre, Apellido, Sexo, FechaNacimiento, Direccion, Localidad, Provincia, Mail, FK_Nacionalidad, FK_idTelefono)
values(30000000,20300000006,'Admin','Admin','Femenino','1980/1/1','corrientes 455','CABA','Buenos Aires','admin@admin.com',12,1),
(31000000,20300000016,'Cliente','Cliente','Masculino','1980/1/1','cordoba 455','CABA','Buenos Aires','cliente@cliente.com',12,1);

insert into `usuario` (NombreUsuario, Contraseña, FK_idRol, FK_DniDP, Estado)
values('300AdmAdm','1234',1,30000000,true), ('310CliCLi','1234',2,31000000,true);