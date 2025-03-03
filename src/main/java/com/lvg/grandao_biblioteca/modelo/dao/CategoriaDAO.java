package com.lvg.grandao_biblioteca.modelo.dao;

import com.lvg.grandao_biblioteca.modelo.dto.Categoria;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO (Data Access Object) que maneja la lectura y escritura de categorías en un archivo de texto.
 * Utiliza un archivo plano para almacenar las categorías.
 * @author Lucas Villa (k4ts0v@protonmail.com)
 * @since 1.0
 * @version 1.0
 */
public class CategoriaDAO {

    private static final String FILE_PATH = "src/main/java/com/lvg/grandao_biblioteca/datos/categorias.txt";

    /**
     * Lee las categorías desde el archivo de texto y las retorna como una lista.
     *
     * @return Una lista de categorías leídas del archivo.
     * @throws IOException Excepción lanzada si ha habido un error accediendo al fichero o a su contenido.
     * @since 1.0
     */
    public List<String> obtenerCategorias() {
        // Se crea una lista de categorías, para guardar ahí las categorías leídas desde el fichero.
        List<String> categorias = new ArrayList<>();
        // Se crea un bufferedReader a partir de un FileReader del fichero.
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            // Si hay línea, se añade a la lista.
            while ((line = reader.readLine()) != null) {
                categorias.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return categorias;
    }

    /**
     * Agrega una nueva categoría al archivo de texto.
     *
     * @param categoria La categoría que se desea agregar.
     * @throws IOException Excepción lanzada si ha habido un error accediendo al fichero o a su contenido.
     * @since 1.0
     */
    public void agregarCategoria(Categoria categoria) {
        // Generamos la representación en string de la categoría a partir de su toString().
        String categoriaStr = categoria.toString();

        // Se crea un BufferedWriter a partir de un FileWriter del fichero, en modo append para no sobreescribir.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            // Se escribe la categoría y un salto de línea.
            writer.write(categoriaStr);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}