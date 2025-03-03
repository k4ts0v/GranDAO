package com.lvg.grandao_biblioteca.service;

import com.lvg.grandao_biblioteca.modelo.dao.LibroRepository;
import com.lvg.grandao_biblioteca.modelo.dto.Libro;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio encargado de gestionar las operaciones relacionadas con los libros.
 * Incluye métodos para crear, obtener, actualizar y eliminar libros.
 * @author Lucas Villa (k4ts0v@protonmail.com)
 * @since 1.0
 * @version 1.0
 */
@Service
@Transactional // Esta anotación se pone para indicar que deben realizarse transacciones para las operaciones indicadas.
public class LibroService {

    private final LibroRepository libroRepository;

    /**
     * Constructor para inyección de dependencias.
     *
     * @param libroRepository El repositorio de libros para interactuar con los datos.
     * @since 1.0
     */
    @Autowired
    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    /**
     * Crea un nuevo libro en el sistema.
     *
     * @param libro El objeto libro que se desea crear.
     * @return El libro creado, incluyendo el ID asignado.
     * @since 1.0
     */
    public Libro crearLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    /**
     * Obtiene todos los libros almacenados en la base de datos.
     *
     * @return Una lista con todos los libros.
     * @since 1.0
     */
    public List<Libro> obtenerLibros() {
        return libroRepository.findAll();
    }

    /**
     * Obtiene un libro por su ID.
     *
     * @param id El identificador del libro a buscar.
     * @return Un objeto Optional que puede contener el libro si se encuentra, o estar vacío si no existe.
     * @since 1.0
     */
    public Optional<Libro> obtenerLibroPorId(Integer id) {
        return libroRepository.findLibroById(id);
    }

    /**
     * Actualiza la información de un libro existente.
     *
     * @param id El identificador del libro a actualizar.
     * @param libro El objeto libro con la nueva información.
     * @return El libro actualizado, o lanza una excepción si el libro no existe.
     * @throws RuntimeException Si el libro con el ID proporcionado no se encuentra.
     * @since 1.0
     */
    public Libro actualizarLibro(Integer id, Libro libro) {
        if (libroRepository.existsById(id)) {
            libro.setId(id);
            return libroRepository.save(libro);
        } else {
            throw new RuntimeException("Libro no encontrado con id: " + id);
        }
    }

    /**
     * Elimina un libro por su ID.
     *
     * @param id El identificador del libro a eliminar.
     * @return true si el libro fue eliminado correctamente, false si el libro no existe.
     * @since 1.0
     */
    public boolean eliminarLibro(Integer id) {
        if (libroRepository.existsById(id)) {
            libroRepository.deleteLibroById(id);
            return true;
        }
        return false;
    }
}