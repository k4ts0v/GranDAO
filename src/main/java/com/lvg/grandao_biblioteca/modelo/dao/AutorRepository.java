package com.lvg.grandao_biblioteca.modelo.dao;

import com.lvg.grandao_biblioteca.modelo.dto.Autor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * Repositorio para realizar operaciones CRUD sobre los autores en la base de datos.
 * Extiende de MongoRepository para manejar la persistencia en MongoDB.
 * @author Lucas Villa (k4ts0v@protonmail.com)
 * @since 1.0
 * @version 1.0
 */
public interface AutorRepository extends MongoRepository<Autor, String> {

    /**
     * Busca un autor por su ID.
     *
     * @param id El ID del autor a buscar.
     * @return Un Optional con el autor encontrado, o vacío si no se encuentra.
     * @since 1.0
     */
    Optional<Autor> findAutorById(String id);

    /**
     * Elimina un autor por su ID.
     *
     * @param id El ID del autor a eliminar.
     * @since 1.0
     */
    void deleteAutorById(String id);
}
