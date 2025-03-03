package com.lvg.grandao_biblioteca.controller;

import com.lvg.grandao_biblioteca.modelo.dto.Libro;
import com.lvg.grandao_biblioteca.service.LibroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador que maneja las operaciones CRUD relacionadas con los libros.
 * Permite realizar acciones como obtener, crear, actualizar y eliminar libros.
 *
 * @author Lucas Villa (k4ts0v@protonmail.com)
 * @since 1.0
 * @version 1.0
 */
@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService libroService;

    /**
     * Constructor del controlador.
     *
     * @param libroService Servicio para gestionar las operaciones relacionadas con los libros.
     * @since 1.0
     */
    @Autowired
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    /**
     * Obtiene una lista de todos los libros.
     * Si la lista está vacía, devuelve un estado 204 (No Content).
     * De lo contrario, devuelve la lista con un estado 200 (OK).
     *
     * @return Una lista de libros en formato JSON o un estado 204 (No Content) si no hay libros.
     * @since 1.0
     */
    @GetMapping
    public ResponseEntity<List<Libro>> obtenerLibros() {
        List<Libro> libros = libroService.obtenerLibros();
        if (libros.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
        }
        return new ResponseEntity<>(libros, HttpStatus.OK); // 200 OK
    }

    /**
     * Obtiene un libro específico por su ID.
     * Si el libro existe, devuelve un estado 200 (OK).
     * Si no se encuentra el libro, devuelve un estado 404 (Not Found).
     *
     * @param id El ID del libro que se desea obtener.
     * @return El libro en formato JSON, o un error 404 si no se encuentra.
     * @since 1.0
     */
    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerLibroPorIsbn(@PathVariable Integer id) {
        Optional<Libro> libro = libroService.obtenerLibroPorId(id);
        if (libro.isPresent()) {
            return new ResponseEntity<>(libro.get(), HttpStatus.OK); // 200 OK
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
    }

    /**
     * Crea un nuevo libro.
     * Si la creación es exitosa, devuelve un estado 201 (Created).
     *
     * @param libro El libro que se desea crear.
     * @return El libro creado en formato JSON.
     * @since 1.0
     */
    @PostMapping
    public ResponseEntity<Libro> crearLibro(@Valid @RequestBody Libro libro) {
        Libro createdLibro = libroService.crearLibro(libro);
        return new ResponseEntity<>(createdLibro, HttpStatus.CREATED); // 201 Created
    }

    /**
     * Actualiza un libro existente.
     * Si la actualización es exitosa, devuelve el libro actualizado con un estado 200 (OK).
     * Si el libro no se encuentra, devuelve un estado 404 (Not Found).
     *
     * @param id El ID del libro a actualizar.
     * @param libro El libro con la nueva información.
     * @return El libro actualizado en formato JSON o un error 404 si no se encuentra.
     * @since 1.0
     */
    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(@Valid @PathVariable Integer id, @RequestBody Libro libro) {
        Libro updatedLibro = libroService.actualizarLibro(id, libro);
        if (updatedLibro != null) {
            return new ResponseEntity<>(updatedLibro, HttpStatus.OK); // 200 OK
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
    }

    /**
     * Elimina un libro por su ID.
     * Si el libro se elimina con éxito, devuelve un estado 204 (No Content).
     * Si el libro no se encuentra, devuelve un estado 404 (Not Found).
     *
     * @param id El ID del libro a eliminar.
     * @return Un estado indicando si la operación fue exitosa o no.
     * @since 1.0
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Integer id) {
        if (libroService.eliminarLibro(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
    }
}