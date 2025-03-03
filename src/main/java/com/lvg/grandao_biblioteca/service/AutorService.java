package com.lvg.grandao_biblioteca.service;

import com.lvg.grandao_biblioteca.modelo.dao.AutorRepository;
import com.lvg.grandao_biblioteca.modelo.dto.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio encargado de gestionar las operaciones relacionadas con los autores.
 * Incluye métodos para crear, leer, actualizar y eliminar autores en la base de datos.
 * @author Lucas Villa (k4ts0v@protonmail.com)
 * @since 1.0
 * @version 1.0
 */
@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    /**
     * Crea un nuevo autor en la base de datos.
     *
     * @param autor El autor que se desea crear.
     * @return El autor creado, que incluye el ID asignado por la base de datos.
     * @since 1.0
     */
    public Autor crearAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    /**
     * Obtiene la lista completa de autores.
     *
     * @return Una lista de todos los autores almacenados en la base de datos.
     * @since 1.0
     */
    public List<Autor> obtenerAutores() {
        return autorRepository.findAll();
    }

    /**
     * Obtiene un autor por su ID.
     *
     * @param id El identificador del autor a buscar.
     * @return Un objeto Optional que puede contener el autor si se encuentra,
     *         o estar vacío si no se encuentra el autor con ese ID.
     * @since 1.0
     */
    public Optional<Autor> obtenerAutorPorId(String id) {
        return autorRepository.findAutorById(id);
    }

    /**
     * Actualiza la información de un autor existente.
     *
     * @param id El identificador del autor que se desea actualizar.
     * @param autorActualizado El objeto autor con la nueva información.
     * @return El autor actualizado, o null si el autor con el ID proporcionado no existe.
     * @since 1.0
     */
    public Autor actualizarAutor(String id, Autor autorActualizado) {
        if (autorRepository.existsById(id)) {
            autorActualizado.setId(id);
            return autorRepository.save(autorActualizado);
        }
        return null;
    }

    /**
     * Elimina un autor de la base de datos.
     *
     * @param id El identificador del autor que se desea eliminar.
     * @return true si el autor fue eliminado con éxito, o false si el autor no existe.
     * @since 1.0
     */
    public boolean eliminarAutor(String id) {
        if (autorRepository.existsById(id)) {
            autorRepository.deleteAutorById(id);
            return true;
        }
        return false;
    }
}