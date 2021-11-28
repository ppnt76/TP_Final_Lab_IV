
insert into `datospersonales`(Dni, Cuil, Nombre, Apellido, Sexo, FechaNacimiento, Direccion, Localidad, Provincia, Mail, FK_Nacionalidad, FK_idTelefono)
values(40000000,20400000006,'Alma','Pla','Femenino','1970/1/1','Chile 455','Tigre','Buenos Aires','apla@gmail.com',22,1),
(41000000,20410000016,'Serena','Blanco','Femenino','1975/1/1','Andorra 455','Escobar','Buenos Aires','sblanco@gmail.com',2,1),
(42000000,20420000016,'Tiago','Pieruzzini','Masculino','1982/1/1','Callao 455','Pilar','Buenos Aires','apla@gmail.com',1,1),
(43000000,20430000016,'Natalia','Lopez','Femenino','1979/9/24','Paz 455','Garin','Buenos Aires','nlopez@gmail.com',20,2),
(44000000,20440000016,'Jano','Pieru','Masculino','1983/2/1','Marmol 455','Pilar','Buenos Aires','jpieru@gmail.com',11,1),
(45000000,20450000016,'Alejandra','Banco','Femenino','1972/1/3','Cosquin 455','Caba','Buenos Aires','abanco@gmail.com',32,1),
(46000000,20460000016,'Tomas','Vino','Masculino','1976/3/22','Andalgala 455','Pilar','Buenos Aires','tvino@gmail.com',31,1),
(47000000,20470000016,'Sabrina','Lgona','Femenino','1978/10/12','Porrini 455','Escobar','Buenos Aires','slgona@gmail.com',42,1),
(48000000,20480000016,'Nicolas','Perez','Masculino','1962/12/10','Rivadavia 455','Pilar','Buenos Aires','nperez@gmail.com',9,1),
(49000000,20490000016,'Isabel','Gomez','Femenino','1975/10/21','Chubut 455','Escobar','Buenos Aires','igomez@gmail.com',9,1),
(50000000,20500000016,'Ivan','Dalico','Masculino','1982/2/12','Arduino 455','Pilar','Buenos Aires','idalico@gmail.com',9,1),
(51000000,20510000016,'Estela','Dias','Femenino','1965/8/22','9 de Julio 455','Escobar','Buenos Aires','edias@gmail.com',9,1),
(52000000,20520000016,'Jorge','Gerez','Masculino','1972/3/31','Rojas 455','Pilar','Buenos Aires','jgerez@gmail.com',9,1),
(53000000,20530000016,'Nestor','Pedero','Masculino','1976/10/20','Manzanares 455','Pilar','Buenos Aires','npedero@gmail.com',9,1);

insert into `usuario` (NombreUsuario, Contraseña, FK_idRol, FK_DniDP, Estado)
values('Alma1','1234',2,40000000,true), 
('Serena2','1234',2,41000000,true), 
('Tiago3','1234',2,42000000,true), 
('Natalia4','1234',2,43000000,true),
 ('Jano5','1234',2,44000000,true), 
 ('Alejandra6','1234',2,45000000,true), 
 ('Tomas7','1234',2,46000000,true), 
 ('Sabrina8','1234',2,47000000,true), 
 ('Nicolas9','1234',2,48000000,true), 
 ('Isabel1','1234',2,49000000,true), 
 ('Ivan2','1234',2,50000000,true), 
 ('Estela3','1234',2,51000000,true), 
 ('Jorge4','1234',2,52000000,true), 
 ('Nestor5','1234',2,53000000,true);

select * from `usuario`

