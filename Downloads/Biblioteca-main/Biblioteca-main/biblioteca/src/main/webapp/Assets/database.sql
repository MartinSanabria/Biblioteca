CREATE DATABASE biblioteca;

USE biblioteca;

CREATE TABLE roles (
    id_rol INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    username VARCHAR(50) UNIQUE NOT NULL,
    estado CHAR,
    password_user VARCHAR(255) NOT NULL,
    id_rol INT NOT NULL,
    FOREIGN KEY (id_rol) REFERENCES roles(id_rol)
);


CREATE TABLE prestamo (
    id_prestamo INT AUTO_INCREMENT PRIMARY KEY,
    fecha_sistema TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado CHAR,
    id_usuario INT,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

CREATE TABLE categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    estado CHAR,
    edicion VARCHAR(20) NOT NULL
);

CREATE TABLE libros (
    id_libro INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    cantidad INT NOT NULL,
    foto VARCHAR(255),
    estado CHAR,
    id_categoria INT,
    FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
);
CREATE TABLE det_prestamo (
    id_det_prestamo INT AUTO_INCREMENT PRIMARY KEY,
    cantidad INT NOT NULL,
    estado CHAR,
    id_libro INT,
    id_prestamo INT,
    FOREIGN KEY (id_libro) REFERENCES libros(id_libro),
    FOREIGN KEY (id_prestamo) REFERENCES prestamo(id_prestamo)
);


INSERT INTO `roles`( `nombre`) VALUES ('Admin');

INSERT INTO `roles`( `nombre`) VALUES ('Usuario');

