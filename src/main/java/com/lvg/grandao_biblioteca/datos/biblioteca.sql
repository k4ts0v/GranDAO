-- Crear base de datos
CREATE DATABASE Biblioteca;
USE Biblioteca;

-- Tabla de Libros
CREATE TABLE Libros (
    libro_id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    genero VARCHAR(100),
    isbn VARCHAR(20) UNIQUE,
    cantidad INT
);

-- Insertar datos en la tabla Libros
INSERT INTO Libros (titulo, genero, isbn, cantidad) VALUES
    ('El Quijote', 'Ficción', '978-3-16-148410-0', 5),
    ('Cien Años de Soledad', 'Realismo mágico', '978-0-06-088328-7', 3),
    ('1984', 'Distopía', '978-0-452-28423-4', 4),
    ('Orgullo y Prejuicio', 'Romántico', '978-1-59308-201-1', 2),
    ('Crimen y Castigo', 'Psicológico', '978-0-14-044913-6', 3),
    ('Diálogos de Platón', 'Filosofía', '978-0-19-283617-3', 4);