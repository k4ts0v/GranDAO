package com.lvg.grandao_biblioteca.modelo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Clase que representa un autor en el sistema.
 * Contiene información como el ID, nombre y país de origen del autor.
 * @author Lucas Villa (k4ts0v@protonmail.com)
 * @since 1.0
 * @version 1.0
 */
@Document(value = "autores")
public class Autor {

    @Id
    public String id;

    @Field(value = "nombre")
    @Pattern(regexp = "^[A-Za-z]+( [A-Za-z]+)*$", message = "Nombre del autor no válido")
    @NotNull(message = "El nombre del autor es obligatorio")
    public String nombre;

    @Field(value = "pais_origen")
    @Pattern(regexp = "^[A-Za-z]+( [A-Za-z]+)*$", message = "País de origen del autor no válido")
    @NotNull(message = "El país de origen del autor es obligatorio")
    public String paisOrigen;

    /**
     * Constructor vacío.
     *
     * @since 1.0
     */
    public Autor() {}

    /**
     * Constructor con parámetros.
     *
     * @param id ID del autor.
     * @param nombre Nombre del autor.
     * @param paisOrigen País de origen del autor.
     * @since 1.0
     */
    public Autor(String id, String nombre, String paisOrigen) {
        this.id = id;
        this.nombre = nombre;
        this.paisOrigen = paisOrigen;
    }

    /**
     * Obtiene el ID del autor.
     *
     * @return El ID del autor.
     * @since 1.0
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el ID del autor.
     *
     * @param id El ID del autor.
     * @since 1.0
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del autor.
     *
     * @return El nombre del autor.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del autor.
     *
     * @param nombre El nombre del autor.
     * @since 1.0
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el país de origen del autor.
     *
     * @return El país de origen del autor.
     * @since 1.0
     */
    public String getPaisOrigen() {
        return paisOrigen;
    }

    /**
     * Establece el país de origen del autor.
     *
     * @param paisOrigen El país de origen del autor.
     * @since 1.0
     */
    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
}
