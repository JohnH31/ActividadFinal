CREATE DATABASE bd_actividad;

USE bd_actividad;

/*Crear tabla*/
CREATE TABLE tbl_usuario(
	id_usuario INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nombre_usuario VARCHAR(35) NOT NULL,
	apellido_usuario VARCHAR(35) NOT NULL,
	edad_autor INT,
	usuario VARCHAR(25),
	contraseña VARCHAR(25), 
	id_estado_fk INT,
	id_tipo_usuario_fk INT
);

ALTER	TABLE	tbl_usuario CHANGE edad_autor edad_usuario INT;

SELECT
id_usuario, 
nombre_usuario,
apellido_usuario,
edad_usuario,
usuario,
id_estado_fk,
id_tipo_usuario_fk
FROM
tbl_usuario;

SELECT 
id_score,
punteo_score
FROM
tbl_score;

CREATE TABLE tbl_estado(
	id_estado INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nombre_estado VARCHAR(35) NOT NULL,
	descripcion_estado VARCHAR(35) NOT NULL
);

CREATE TABLE tbl_tipo_usuario(
	id_tipo_usuario INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nombre_tipo_usuario VARCHAR(35) NOT NULL,
	descripcion_tipo_usuario VARCHAR(35) NOT NULL
);

CREATE TABLE tbl_score(
	id_score INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	punteo_score VARCHAR(35) NOT NULL,
	id_usuario_fk INT
);

ALTER	TABLE	tbl_score CHANGE punteo_score punteo_score INT;

ALTER TABLE tbl_usuario ADD FOREIGN KEY (id_estado_fk)
REFERENCES tbl_estado (id_estado);

ALTER TABLE tbl_usuario ADD FOREIGN KEY (id_tipo_usuario_fk)
REFERENCES tbl_tipo_usuario (id_tipo_usuario);

ALTER TABLE tbl_score ADD FOREIGN KEY (id_usuario_fk)
REFERENCES tbl_usuario (id_usuario);

SELECT * FROM tbl_estado;
SELECT * FROM tbl_tipo_usuario;
SELECT * FROM tbl_score;
SELECT * FROM tbl_usuario;

INSERT INTO tbl_estado (nombre_estado, descripcion_estado)
VALUES ('Activo', 'Usuario en el juego'), ('Inactivo', 'Usuario finalizo Juego');

INSERT INTO tbl_tipo_usuario (nombre_tipo_usuario, descripcion_tipo_usuario)
VALUES ('Administrador', 'Ingreso de usuarios'), 
('Principiante', 'Nivel 1'), 
('Intermedio', 'Nivel 2'), 
('Avanzado', 'Nivel 3');

INSERT INTO tbl_usuario (nombre_usuario, apellido_usuario,edad_usuario,usuario,contraseña,id_estado_fk,id_tipo_usuario_fk)
VALUES ('Jonathan','Herrera',28,'Administrador',1234,1,1);

SELECT usuario, contraseña, id_tipo_usuario_fk  FROM tbl_usuario WHERE usuario = 'Benjamin' AND contraseña = '1234';

SELECT 
id_usuario, 
nombre_usuario,
apellido_usuario,
edad_usuario,
usuario,
id_estado_fk,
id_tipo_usuario_fk,
id_score,
punteo_score
FROM tbl_usuario E
INNER JOIN tbl_score P
ON E.id_usuario = P.id_usuario_fk

SELECT 

