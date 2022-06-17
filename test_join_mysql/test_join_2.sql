create database test_join;

use test_join;

CREATE TABLE pais (
    id INT AUTO_INCREMENT,
    nombre VARCHAR(50),
    PRIMARY KEY (id)
);

insert into pais values(null, 'Argentina');
insert into pais values(null, 'Chile');
insert into pais values(null, 'Perú');
insert into pais values(null, 'Venezuela');


create table partido(
	id INT AUTO_INCREMENT,
    local int,
    visita int,
    fecha datetime,
    PRIMARY KEY (id),
    foreign key(local) references pais(id),
    foreign key(visita) references pais(id)
);

insert into partido values(null, '1','2', now());
insert into partido values(null, '1','3', now());
insert into partido values(null, '1','4', now());
insert into partido values(null, '2','1', now());

select * from pais;
select * from partido;

SELECT 
	par.id,
    local.nombre AS 'Local',
    par.local AS 'Goles local',
    visita.nombre AS 'Visita',
    par.visita AS 'Goles visita'
FROM
	partido par
    INNER JOIN pais local ON local.id = par.local
    INNER JOIN pais visita ON visita.id = par.visita;
    
	

drop database test_join;




















DROP DATABASE bd_policial;

CREATE DATABASE bd_policial;

USE bd_policial;

/*------ CREACIÓN DE TABLAS --------*/
CREATE TABLE policia(
	id INT AUTO_INCREMENT,
    nombre VARCHAR(100),
    edad INT,
	sexo VARCHAR(1),
    PRIMARY KEY(id)
);

CREATE TABLE tipo_delito(
	id INT AUTO_INCREMENT,
	nombre VARCHAR(100),
    PRIMARY KEY(id)
);

CREATE TABLE caso(
	id INT AUTO_INCREMENT,
    nombre VARCHAR(100),
    fecha DATETIME,
    fecha_termino DATETIME, 
    tipo_delito INT,
    PRIMARY KEY(id),
    FOREIGN KEY(tipo_delito) REFERENCES tipo_delito(id)
);

/*1.- Listado de los casos con sus tipos de delito*/
select caso.id, caso.nombre, tipo_delito.nombre
from caso
inner join tipo_delito on caso.id_tipo_delito_fk = tipo_delito.id;

CREATE TABLE poli_caso(
	id INT AUTO_INCREMENT,
    policia INT,
    caso INT,
    PRIMARY KEY(id),
    FOREIGN KEY(policia) REFERENCES policia(id),
    FOREIGN KEY(caso) REFERENCES caso(id)
);
/*------ CREACIÓN DE TABLAS --------*/

/*------------ INSERTS --------------*/
INSERT INTO policia VALUES(NULL, 'Angel Huerta','25','m');
INSERT INTO policia VALUES(NULL, 'Manuel Sanchez', '32','m');
INSERT INTO policia VALUES(NULL, 'Maria Jara', '29','f');
INSERT INTO policia VALUES(NULL, 'Pedro Faune', '40','m');
INSERT INTO policia VALUES(NULL, 'Elias Gonzales', '52', 'm');
INSERT INTO policia VALUES(NULL, 'Josefina Aguilera', '33', 'f');
INSERT INTO policia VALUES(NULL, 'Francisca Torres', '40', 'f');
INSERT INTO policia VALUES(NULL, 'Oswaldo Brito', '70', 'm');
INSERT INTO policia VALUES(NULL, 'Alexandra Núñez', '30', 'f');
INSERT INTO policia VALUES(NULL, 'Arnoldo Covarrubias', '49', 'm');
INSERT INTO policia VALUES(NULL, 'Pablo Castro','25', 'm');
INSERT INTO policia VALUES(NULL, 'Estefania Galvez','27', 'f'); 
INSERT INTO policia VALUES(NULL, 'Elizabet Gonzales','29', 'f');

INSERT INTO tipo_delito VALUES(NULL, 'Robo armado');
INSERT INTO tipo_delito Values(NULL, 'Violación');
INSERT INTO tipo_delito Values(NULL, 'Robo');
INSERT INTO tipo_delito Values(NULL, 'Femisidio');
INSERT INTO tipo_delito VALUES(NULL, 'Homicidio frustrado');
INSERT INTO tipo_delito VALUES(NULL, 'Traficante de drogas');
INSERT INTO tipo_delito VALUES(NULL, 'Trafico de armas');
INSERT INTO tipo_delito VALUES(NULL, 'Robo a mano armada');
INSERT INTO tipo_delito VALUES(NULL, 'Robo con violencia');
INSERT INTO tipo_delito VALUES(NULL, 'Robo a lugar no habitado');
INSERT INTO tipo_delito VALUES(NULL, 'Falcificacion de documentos informaticos');
INSERT INTO tipo_delito VALUES(NULL, 'Terrorismo');
INSERT INTO tipo_delito VALUES(NULL, 'Pornografia infantil');
INSERT INTO tipo_delito VALUES(NULL, 'Coecho');
INSERT INTO tipo_delito VALUES(NULL, 'Corrupcion');
INSERT INTO tipo_delito VALUES(NULL, 'Crimen Organizado');

INSERT INTO caso VALUES(NULL, 'LyloShops gate', '2017-09-11 10:00:00', '2018-09-11 10:00:00', '14');
INSERT INTO caso VALUES(NULL, 'Caso Franco.net','2017-08-04 13:24:32','2017-09-11 10:03:05','11');
INSERT INTO caso VALUES(NULL, 'Caso Pato','2017-04-09 17:44:02','2017-09-11 15:01:05','14');
INSERT INTO caso VALUES(NULL, 'Caso Piñera','2014-03-24 18:44:42','2017-09-02 07:23:55','15');
INSERT INTO caso VALUES(NULL, 'Asalto calle Estado', '2017-06-11 10:00:00','2017-12-03 05:00:00','8');
INSERT INTO caso VALUES(NULL, 'Robo Tía Julia', '2013-09-11 10:00:00','2014-01-21 11:00:00','8');
INSERT INTO caso VALUES(NULL, 'Los Caretusca de la Villa Cordillera', '2017-03-29 10:00:00','2017-09-11 17:00:00','8');
INSERT INTO caso VALUES(NULL,'Caso Agusto','2009-03-07 14:05:10','2020-01-01 12:00:00','2');
INSERT INTO caso VALUES(NULL,'Caso Frustado de Gobierno','2014-10-18 17:25:10','2017-10-10 21:00:00','3');
INSERT INTO caso VALUES(NULL,'Caso Traficante de drogas','2017-11-26 21:30:25','2019-01-01 22:00:00','6');
INSERT INTO caso VALUES(NULL, 'Zamudio', '2017-08-09 14:00:00' , '2018-10-09 02:00:00 ', '2');
INSERT INTO caso VALUES(NULL, 'Violacion quintuple', '2017-08-09 14:00:00' , '2018-2-09 15:00:00 ', '2');
INSERT INTO caso VALUES(NULL, 'Guare', '2017-08-05 16:00:00' , '2018-5-09 17:00:00 ', '2');
INSERT INTO caso values(NULL, 'Soquimich','2017-09-11 10:01:00', '2017-09-12 10:01:01','2');
INSERT INTO caso values(NULL, 'Penta','2017-12-11 11:01:00', '2017-12-09 11:01:10','12');
INSERT INTO caso values(NULL, 'Confort','2017-07-11 01:01:13', '2017-03-11 01:02:13','16');
INSERT INTO caso values(NULL, 'CONFORT II','2017-07-11 01:01:13', '2017-03-11 01:02:13',null);

INSERT INTO poli_caso VALUES(NULL, '3', '1');
INSERT INTO poli_caso VALUES(NULL, '1', '1');
INSERT INTO poli_caso VALUES(NULL, '2', '1');
INSERT INTO poli_caso VALUES(NULL, '1','2');
INSERT INTO poli_caso VALUES(NULL, '3','2');
INSERT INTO poli_caso VALUES(NULL, '4','2');
INSERT INTO poli_caso VALUES(NULL, '5','2');
INSERT INTO poli_caso VALUES(NULL, '6','2');
INSERT INTO poli_caso VALUES(NULL, '6', '3');
INSERT INTO poli_caso VALUES(NULL, '5', '3');
INSERT INTO poli_caso VALUES(NULL, '5', '4');
INSERT INTO poli_caso VALUES(NULL, '7', '4');
INSERT INTO poli_caso VALUES(NULL, '8', '4');
INSERT INTO poli_caso VALUES(NULL, '11', '4');
INSERT INTO poli_caso VALUES(NULL, '1', '4');
INSERT INTO poli_caso VALUES(NULL, '8', '5');
INSERT INTO poli_caso VALUES(NULL, '4', '6');
INSERT INTO poli_caso VALUES(NULL, '6', '6');
INSERT INTO poli_caso VALUES(NULL, '8', '6');
INSERT INTO poli_caso VALUES(NULL, '12', '6');
INSERT INTO poli_caso VALUES(NULL, '11', '6');
INSERT INTO poli_caso VALUES(NULL, '4', '7');
INSERT INTO poli_caso VALUES(NULL, '2', '7');
INSERT INTO poli_caso VALUES(NULL, '1', '7');
INSERT INTO poli_caso VALUES(NULL, '7', '7');
INSERT INTO poli_caso VALUES(NULL, '3', '7');
INSERT INTO poli_caso VALUES(NULL, '11', '7');
INSERT INTO poli_caso VALUES(NULL, '4', '8');
INSERT INTO poli_caso VALUES(NULL, '6', '8');
INSERT INTO poli_caso VALUES(NULL, '7', '8');
INSERT INTO poli_caso VALUES(NULL, '2', '9');
INSERT INTO poli_caso VALUES(NULL, '1', '9');
INSERT INTO poli_caso VALUES(NULL, '6', '9');
INSERT INTO poli_caso VALUES(NULL, '5', '9');
INSERT INTO poli_caso VALUES(NULL, '7', '9');
INSERT INTO poli_caso VALUES(NULL, '3', '9');
INSERT INTO poli_caso VALUES(NULL, '4', '9');
INSERT INTO poli_caso VALUES(NULL, '9', '9');
INSERT INTO poli_caso VALUES(NULL, '10', '9');
INSERT INTO poli_caso VALUES(NULL, '3','10');
INSERT INTO poli_caso VALUES(NULL, '9','10');
INSERT INTO poli_caso VALUES(NULL, '3', '11');
INSERT INTO poli_caso VALUES(NULL, '2', '12');
INSERT INTO poli_caso VALUES(NULL, '6', '12');
INSERT INTO poli_caso VALUES(NULL, '7', '12');
INSERT INTO poli_caso VALUES(NULL, '3', '12');
INSERT INTO poli_caso VALUES(NULL, '5', '12');
INSERT INTO poli_caso values(NULL, '7','13');
INSERT INTO poli_caso values(NULL, '4','13');
INSERT INTO poli_caso values(NULL, '9','13');
INSERT INTO poli_caso VALUES(NULL, '5', '14');
INSERT INTO poli_caso VALUES(NULL, '6', '14');
INSERT INTO poli_caso VALUES(NULL, '7', '14');
INSERT INTO poli_caso VALUES(NULL, '13','14');
INSERT INTO poli_caso VALUES(NULL, '2', '14');
INSERT INTO poli_caso VALUES(NULL, '3', '15');
INSERT INTO poli_caso VALUES(NULL, '1', '15');
INSERT INTO poli_caso VALUES(NULL, '2', '15');
INSERT INTO poli_caso VALUES(NULL, '7','16');
INSERT INTO poli_caso VALUES(NULL, '13','16');


/*1.- Listado de los casos con sus tipos de delito*/
select caso.id, caso.nombre, tipo_delito.nombre
from caso
inner join tipo_delito on caso.tipo_delito = tipo_delito.id;

/*2.- Listado de los casos con sus tipos de delito.
Añadiendo los casos que no tienen delito*/
select caso.id, caso.nombre, tipo_delito.nombre
from caso
left join tipo_delito on caso.tipo_delito = tipo_delito.id;

/*3.- Listado de los casos con sus tipos de delito.
Añadiendo los tipos de delito que no tienen caso*/
select caso.id, caso.nombre, tipo_delito.nombre
from caso
right join tipo_delito on caso.tipo_delito = tipo_delito.id
order by caso.nombre asc;

/*4.- Listado de nombres de policias , sus casos y tipos de delito*/
SELECT 
    policia.nombre AS 'Policia',
    caso.nombre AS 'Caso',
    tipo_delito.nombre AS 'Tipo de delito'
FROM
    policia
        INNER JOIN
    poli_caso ON policia.id = poli_caso.policia
        INNER JOIN
    caso ON poli_caso.caso = caso.id
        INNER JOIN
    tipo_delito ON caso.tipo_delito = tipo_delito.id
ORDER BY policia.nombre ASC;