package com.lvg.grandao_biblioteca.service;

import com.lvg.grandao_biblioteca.modelo.dao.CategoriaDAO;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio encargado de gestionar las operaciones relacionadas con las categorías.
 * Permite obtener categorías y agregar nuevas categorías al sistema.
 * @author Lucas Villa (k4ts0v@protonmail.com)
 * @since 1.0
 * @version 1.0
 */
@Service
public class CategoriaService {

    private CategoriaDAO categoriaDAO;

    /**
     * Constructor vacío para la inicialización por Spring.
     * @since 1.0
     */
    public CategoriaService() {
        this.categoriaDAO = new CategoriaDAO();
    }


    /**
     * Obtiene la lista de todas las categorías.
     *
     * @return Una lista con todas las categorías almacenadas.
     * @since 1.0
     */
    public List<String> obtenerCategorias() {
        return categoriaDAO.obtenerCategorias();
    }

    /**
     * Agrega una nueva categoría al sistema.
     *
     * @param categoria El nombre de la categoría que se desea agregar.
     * @since 1.0
     */
    public void agregarCategoria(String categoria) {
        categoriaDAO.agregarCategoria(categoria);
    }
}
