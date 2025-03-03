package com.lvg.grandao_biblioteca.modelo.dao;

import com.lvg.grandao_biblioteca.modelo.dto.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repositorio para realizar operaciones CRUD sobre los libros en la base de datos.
 * Extiende de JpaRepository para manejar la persistencia en una base de datos relacional.
 * @author Lucas Villa (k4ts0v@protonmail.com)
 * @since 1.0
 * @version 1.0
 */
public interface LibroRepository extends JpaRepository<Libro, Integer> {

    /**
     * Busca un libro por su ID.
     *
     * @param id El ID del libro a buscar.
     * @return Un Optional con el libro encontrado, o vacío si no se encuentra.
     * @since 1.0
     */
    Optional<Libro> findLibroById(Integer id);

    /**
     * Elimina un libro por su ID.
     *
     * @param id El ID del libro a eliminar.
     * @since 1.0
     */
    void deleteLibroById(Integer id);
}
