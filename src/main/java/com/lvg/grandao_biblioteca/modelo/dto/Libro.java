package com.lvg.grandao_biblioteca.modelo.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase que representa un libro en el sistema.
 * Contiene información como el ID, título, género, ISBN, y la cantidad de copias disponibles.
 * @author Lucas Villa (k4ts0v@protonmail.com)
 * @since 1.0
 * @version 1.0
 */
@Entity
@Table(name = "Libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "libro_id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "titulo", nullable = false)
    @Pattern(regexp = "^[A-Za-z]+( [A-Za-z]+)*$", message = "Título del libro no válido")
    @NotNull(message = "El título del libro es obligatorio")
    private String titulo;

    @Size(max = 100)
    @Column(name = "genero", length = 100)
    @NotNull(message = "El género del libro es obligatorio")
    private String genero;

    @Size(max = 20)
    @Column(name = "isbn", length = 20)
    @NotNull(message = "El ISBN del libro es obligatorio")
    private String isbn;

    @Column(name = "cantidad")
    @NotNull(message = "La cantidad de libros es obligatoria")
    private Integer cantidad;

    /**
     * Constructor vacío.
     *
     * @since 1.0
     */
    public Libro() {}

    /**
     * Constructor con todos los parámetros.
     *
     * @param id ID del libro.
     * @param titulo Título del libro.
     * @param genero Género del libro.
     * @param isbn ISBN del libro.
     * @param cantidad Cantidad del libro.
     * @since 1.0
     */
    public Libro(Integer id, String titulo, String genero, String isbn, Integer cantidad) {
        setId(id);
        setTitulo(titulo);
        setGenero(genero);
        setIsbn(isbn);
        setCantidad(cantidad);
    }

    /**
     * Obtiene el ID del libro.
     *
     * @return El ID del libro.
     * @since 1.0
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el ID del libro.
     *
     * @param id El ID del libro.
     * @since 1.0
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el título del libro.
     *
     * @return El título del libro.
     * @since 1.0
     */
    public @Size(max = 255) @NotNull String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del libro.
     *
     * @param titulo El título del libro.
     * @since 1.0
     */
    public void setTitulo(@Size(max = 255) @NotNull String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el género del libro.
     *
     * @return El género del libro.
     * @since 1.0
     */
    public @Size(max = 100) String getGenero() {
        return genero;
    }

    /**
     * Establece el género del libro.
     *
     * @param genero El género del libro.
     * @since 1.0
     */
    public void setGenero(@Size(max = 100) String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene el ISBN del libro.
     *
     * @return El ISBN del libro.
     * @since 1.0
     */
    public @Size(max = 20) String getIsbn() {
        return isbn;
    }

    /**
     * Establece el ISBN para el libro, validando previamente que sea un ISBN válido.
     *
     * @param isbn El ISBN del libro.
     * @since 1.0
     */
    public void setIsbn(@Size(max = 20) String isbn) {
        if (verificarIsbn(isbn)) {
            this.isbn = isbn;
        } else {
            throw new IllegalArgumentException("El ISBN del libro no es válido");
        }
    }

    /**
     * Obtiene la cantidad de copias del libro.
     *
     * @return La cantidad de copias disponibles del libro.
     * @since 1.0
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de copias del libro.
     *
     * @param cantidad La cantidad de copias disponibles.
     * @since 1.0
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

        /**
         * Verifica si el ISBN proporcionado es válido.
         * Soporta tanto ISBN-10 como ISBN-13.
         *
         * @param isbn El ISBN a verificar.
         * @return {@code true} si el ISBN es válido, {@code false} si no lo es.
         * @since 1.0
         */
        public boolean verificarIsbn(String isbn) {
            // Primero, eliminamos los guiones y espacios en blanco
            isbn = isbn.replaceAll("[^0-9X]", "");

            // Verificar si es un ISBN-13 (13 dígitos)
            if (isbn.length() == 13 && isbn.matches("\\d{13}")) {
                return validarIsbn13(isbn);
            }

            // Verificar si es un ISBN-10 (10 dígitos, con la posibilidad de que el último sea 'X')
            if (isbn.length() == 10 && isbn.matches("\\d{9}[0-9X]")) {
                return validarIsbn10(isbn);
            }

            // Si no es ni ISBN-10 ni ISBN-13 válido
            return false;
        }

        /**
         * Valida un ISBN-13 usando el algoritmo estándar.
         * La validación se realiza sumando los dígitos del ISBN con pesos alternados de 1 y 3,
         * y verificando si la suma es divisible por 10.
         *
         * @param isbn El ISBN-13 a validar.
         * @return {@code true} si el ISBN-13 es válido, {@code false} si no lo es.
         * @since 1.0
         */
        private boolean validarIsbn13(String isbn) {
            int suma = 0;
            for (int i = 0; i < 13; i++) {
                int digito = Character.getNumericValue(isbn.charAt(i));
                if (i % 2 == 0) {
                    suma += digito; // Suma de los dígitos en las posiciones impares (empezando en 0)
                } else {
                    suma += digito * 3; // Suma de los dígitos en las posiciones pares multiplicados por 3
                }
            }
            return suma % 10 == 0;
        }

        /**
         * Valida un ISBN-10 usando el algoritmo estándar.
         * La validación se realiza sumando los primeros 9 dígitos con pesos decrecientes del 10 al 2,
         * y luego añadiendo el último dígito, que puede ser un número o 'X'.
         * Si el último dígito es 'X', se considera como 10.
         * La suma total debe ser divisible por 11.
         *
         * @param isbn El ISBN-10 a validar.
         * @return {@code true} si el ISBN-10 es válido, {@code false} si no lo es.
         * @since 1.0
         */
        private boolean validarIsbn10(String isbn) {
            int suma = 0;
            for (int i = 0; i < 9; i++) {
                suma += (10 - i) * Character.getNumericValue(isbn.charAt(i));
            }

            // El último dígito puede ser 'X' (representa el 10 en el cálculo)
            int ultimoDigito = isbn.charAt(9) == 'X' ? 10 : Character.getNumericValue(isbn.charAt(9));
            suma += ultimoDigito;

            return suma % 11 == 0;
        }
}
