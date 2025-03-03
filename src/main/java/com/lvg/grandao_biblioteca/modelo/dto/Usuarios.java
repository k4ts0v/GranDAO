package com.lvg.grandao_biblioteca.modelo.dto;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Clase que representa una colección de usuarios en el sistema.
 * Mapea a la estructura <usuarios> en XML, que contiene una lista de <usuario>.
 * @author Lucas Villa (k4ts0v@protonmail.com)
 * @since 1.0
 * @version 1.0
 */
@XmlRootElement(name = "usuarios")  // Mapea a <usuarios> en XML.
public class Usuarios {

    private List<Usuario> usuarioList;

    /**
     * Constructor vacío.
     *
     * @since 1.0
     */
    public Usuarios() {}

    /**
     * Constructor con parámetros.
     * @param usuarioList Lista de usuarios.
     * @since 1.0
     */
    public Usuarios(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    /**
     * Obtiene la lista de usuarios.
     *
     * @return Una lista con todos los usuarios.
     * @since 1.0
     */
    @XmlElement(name = "usuario")  // Mapea cada <usuario> al listado de usuarios.
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    /**
     * Establece la lista de usuarios.
     *
     * @param usuarioList La lista de usuarios.
     * @since 1.0
     */
    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }
}
