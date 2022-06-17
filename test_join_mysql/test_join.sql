CREATE DATABASE test_join;

USE test_join;

CREATE TABLE ciudad(
	id 		INT AUTO_INCREMENT,
    nombre 	VARCHAR(100),
    PRIMARY KEY(id)
);

INSERT INTO ciudad VALUES 
(NULL, 'Arica'		),
(NULL, 'Santiago'	),
(NULL, 'Rancagua'	),
(NULL, 'Rengo'		), 
(NULL, 'Talca'		),
(NULL, 'Puerto Mont'),
(NULL, 'Santa Cruz'	);

CREATE TABLE persona(
	id 			INT AUTO_INCREMENT,
    nombre 		VARCHAR(100),
    fkCiudad 	INT,
    PRIMARY KEY(id),
    FOREIGN KEY(fkCiudad) REFERENCES ciudad(id)
);

INSERT INTO persona VALUES 
(NULL, 'Linda Pérez Pinto',		5),
(NULL, 'Gabriel Rojas Rojas',	5),
(NULL, 'Ángeles Ubilla Pérez',	5),
(NULL, 'Yenis Pérez Pinto',		5),
(NULL, 'Gaspar Rojas Pérez',	5),
(NULL, 'Gilda Pinto Caña',		4),
(NULL, 'Julia Muñoz Ampuero',	3),
(NULL, 'Patricio Pérez Pinto',	3),
(NULL, 'Raúl Pérez Hermosilla',	7),
(NULL, 'Juanito Pérez',			5),
(NULL, 'María Pérez',			5);

CREATE TABLE casa(
	id 			INT AUTO_INCREMENT,
    direccion 	VARCHAR(100),
    PRIMARY KEY(id)
);

INSERT INTO casa VALUES
(NULL, 'Casa de Linda y Gabriel en Talca'			),
(NULL, 'Casa de Gilda Pinto Caña en Rengo'			),
(NULL, 'Casa de Gianina Muñoz en Santiago'			),
(NULL, 'Casa de Pato y Fabi en Rancagua'			),
(NULL, 'Casa de Raúl Pérez Hermosilla en Santa Cruz');

CREATE TABLE persona_casa(
	id 			INT AUTO_INCREMENT,
    fkPersona 	INT,
    fkCasa 		INT,
    PRIMARY KEY(id),
    FOREIGN KEY(fkCasa) 	REFERENCES casa(id),
    FOREIGN KEY(fkPersona) 	REFERENCES persona(id)
);

INSERT INTO persona_casa VALUES
(NULL, 1,1),(NULL, 2,1),
(NULL, 3,1),(NULL, 4,1),
(NULL, 5,1),(NULL, 6,2),
(NULL, 7,4),(NULL, 8,4),
(NULL, 9,5);

SELECT * FROM ciudad;
SELECT * FROM persona;
SELECT * FROM casa;
SELECT * FROM persona_casa;

/*1.- Listado de personas y sus ciudades*/
SELECT 
	p.id AS 'ID Persona',
    p.nombre AS 'Nombre Persona',
    c.nombre AS 'Ciudad Persona'
FROM 
	persona p
INNER JOIN 
	ciudad c ON p.fkCiudad = c.id;
    



/*Listado de las personas y sus direcciones*/
SELECT 
	p.id AS 'ID Persona',
    p.nombre AS 'Nombre Persona',
    c.direccion AS 'Dirección'
FROM
	persona p
INNER JOIN 
	persona_casa pc ON p.id = pc.fkPersona
INNER JOIN 
	casa c ON pc.fkCasa = c.id;



    
/*3.- Listado de ciudades que no tienen personas asignadas*/
SELECT 
	c.id AS 'ID Ciudad',
    c.nombre AS 'Ciudad'
FROM 
	ciudad c
LEFT JOIN
	persona p ON p.fkCiudad = c.id
WHERE
	p.id IS NULL;



    
/*4.- Listado de casas sin personas*/
SELECT 
	c.id AS 'ID Casa',
    c.direccion AS 'Dirección Casa'
FROM 
	casa c
LEFT JOIN 
	persona_casa pc ON c.id = pc.fkCasa
WHERE
	pc.id IS NULL;




/*5.- Listado de personas sin casa*/
SELECT
	p.id AS 'ID Persona',
    p.nombre AS 'Nombre Persona'
FROM 
	persona p 
LEFT JOIN
	persona_casa pc ON pc.fkPersona = p.id
WHERE 
	pc.id IS NULL;




