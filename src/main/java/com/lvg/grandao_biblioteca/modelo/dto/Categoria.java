package com.lvg.grandao_biblioteca.modelo.dto;

import jakarta.validation.constraints.NotNull;

/**
 * Clase que representa una categoría de libros en el sistema.
 * Contiene el ID y nombre de la categoría.
 * @author Lucas Villa (k4ts0v@protonmail.com)
 * @since 1.0
 * @version 1.0
 */
public class Categoria {

    @NotNull(message = "El ID de la categoria es obligatorio")
    private Long categoriaId;

    @NotNull(message = "El nombre de la categoria es obligatorio")
    private String nombreCategoria;

    /**
     * Constructor vacío.
     *
     * @since 1.0
     */
    public Categoria() {}

    /**
     * Constructor con parámetros.
     *
     * @since 1.0
     */
    public Categoria(Long categoriaId, String nombreCategoria) {
        this.categoriaId = categoriaId;
        this.nombreCategoria = nombreCategoria;
    }

    /**
     * Obtiene el ID de la categoría.
     *
     * @return El ID de la categoría.
     * @since 1.0
     */
    public Long getCategoriaId() {
        return categoriaId;
    }

    /**
     * Establece el ID de la categoría.
     *
     * @param categoriaId El ID de la categoría.
     * @since 1.0
     */
    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    /**
     * Obtiene el nombre de la categoría.
     *
     * @return El nombre de la categoría.
     * @since 1.0
     */
    public String getNombreCategoria() {
        return nombreCategoria;
    }

    /**
     * Establece el nombre de la categoría.
     *
     * @param nombreCategoria El nombre de la categoría.
     * @since 1.0
     */
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}
