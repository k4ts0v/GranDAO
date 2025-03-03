package com.lvg.grandao_biblioteca.controller;

import com.lvg.grandao_biblioteca.modelo.dto.Categoria;
import com.lvg.grandao_biblioteca.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador que maneja las operaciones CRUD relacionadas con las categorías.
 * Permite realizar acciones como obtener y agregar categorías.
 *
 * @author Lucas Villa (k4ts0v@protonmail.com)
 * @since 1.0
 * @version 1.0
 */
@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    /**
     * Constructor del controlador.
     *
     * @param categoriaService Servicio para gestionar las operaciones relacionadas con las categorías.
     * @since 1.0
     */
    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    /**
     * Obtiene una lista de todas las categorías.
     * Si la lista está vacía, devuelve un estado 204 (No Content).
     * De lo contrario, devuelve la lista con un estado 200 (OK).
     *
     * @return Una lista de categorías en formato JSON o un estado 204 (No Content) si no hay categorías.
     * @since 1.0
     */
    @GetMapping
    public ResponseEntity<List<String>> obtenerCategorias() {
        List<String> categorias = categoriaService.obtenerCategorias();
        if (categorias.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
        }
        return new ResponseEntity<>(categorias, HttpStatus.OK); // 200 OK
    }

    /**
     * Agrega una nueva categoría.
     * Si la adición es exitosa, devuelve un estado 201 (Created).
     *
     * @param categoria La categoría que se desea agregar.
     * @return Un estado indicando si la operación fue exitosa o no.
     * @since 1.0
     */
    @PostMapping
    public ResponseEntity<Void> agregarCategoria(@Valid @RequestBody Categoria categoria) {
        categoriaService.agregarCategoria(categoria);
        return new ResponseEntity<>(HttpStatus.CREATED); // 201 Created
    }
}