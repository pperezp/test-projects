CREATE DATABASE testSpringBoot;

USE testSpringBoot;

CREATE TABLE president (
    id INT AUTO_INCREMENT,
    name VARCHAR(100),
    year INT,
    PRIMARY KEY (id)
);

INSERT INTO president(name, year) VALUES
('Manuel Blanco Encalada', 1826),
('Agustín Eyzaguirre', 1826),
('Francisco Antonio Pinto Díaz', 1827);

SELECT * FROM president;

-- https://es.wikipedia.org/wiki/Anexo:Presidentes_de_Chile
-- http://www.memoriachilena.gob.cl/602/w3-article-3573.html#cronologia