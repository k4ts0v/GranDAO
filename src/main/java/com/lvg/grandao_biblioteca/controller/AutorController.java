package com.lvg.grandao_biblioteca.controller;

import com.lvg.grandao_biblioteca.modelo.dto.Autor;
import com.lvg.grandao_biblioteca.service.AutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador que maneja las operaciones CRUD relacionadas con los autores.
 * Permite realizar acciones como obtener, crear, actualizar y eliminar autores.
 *
 * @author Lucas Villa (k4ts0v@protonmail.com)
 * @since 1.0
 * @version 1.0
 */
@RestController
@RequestMapping("/api/autores")
public class AutorController {

    private final AutorService autorService;

    /**
     * Constructor del controlador.
     *
     * @param autorService Servicio para gestionar las operaciones relacionadas con los autores.
     * @since 1.0
     */
    @Autowired
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    /**
     * Obtiene una lista de todos los autores.
     * Si la lista está vacía, devuelve un estado 204 (No Content).
     * De lo contrario, devuelve la lista con un estado 200 (OK).
     *
     * @return Una lista de autores en formato JSON o un estado 204 (No Content) si no hay autores.
     * @since 1.0
     */
    @GetMapping
    public ResponseEntity<List<Autor>> obtenerAutores() {
        List<Autor> autores = autorService.obtenerAutores();
        if (autores.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
        }
        return new ResponseEntity<>(autores, HttpStatus.OK); // 200 OK
    }

    /**
     * Obtiene un autor específico por su ID.
     * Si el autor existe, devuelve un estado 200 (OK).
     * Si no se encuentra el autor, devuelve un estado 404 (Not Found).
     *
     * @param id El ID del autor que se desea obtener.
     * @return El autor en formato JSON, o un error 404 si no se encuentra.
     * @since 1.0
     */
    @GetMapping("/{id}")
    public ResponseEntity<Autor> obtenerAutorPorId(@PathVariable String id) {
        Optional<Autor> autor = autorService.obtenerAutorPorId(id);
        if (autor.isPresent()) {
            return new ResponseEntity<>(autor.get(), HttpStatus.OK); // 200 OK
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
    }

    /**
     * Crea un nuevo autor.
     * Si la creación es exitosa, devuelve un estado 201 (Created).
     *
     * @param autor El autor que se desea crear.
     * @return El autor creado en formato JSON.
     * @since 1.0
     */
    @PostMapping
    public ResponseEntity<Autor> crearAutor(@Valid @RequestBody Autor autor) {
        Autor createdAutor = autorService.crearAutor(autor);
        return new ResponseEntity<>(createdAutor, HttpStatus.CREATED); // 201 Created
    }

    /**
     * Actualiza un autor existente.
     * Si la actualización es exitosa, devuelve el autor actualizado con un estado 200 (OK).
     * Si el autor no se encuentra, devuelve un estado 404 (Not Found).
     *
     * @param id El ID del autor a actualizar.
     * @param autor El autor con la nueva información.
     * @return El autor actualizado en formato JSON o un error 404 si no se encuentra.
     * @since 1.0
     */
    @PutMapping("/{id}")
    public ResponseEntity<Autor> actualizarAutor(@Valid @PathVariable String id, @RequestBody Autor autor) {
        Autor updatedAutor = autorService.actualizarAutor(id, autor);
        if (updatedAutor != null) {
            return new ResponseEntity<>(updatedAutor, HttpStatus.OK); // 200 OK
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
    }

    /**
     * Elimina un autor por su ID.
     * Si el autor se elimina con éxito, devuelve un estado 204 (No Content).
     * Si el autor no se encuentra, devuelve un estado 404 (Not Found).
     *
     * @param id El ID del autor a eliminar.
     * @return Un estado indicando si la operación fue exitosa o no.
     * @since 1.0
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAutor(@PathVariable String id) {
        if (autorService.eliminarAutor(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
    }
}