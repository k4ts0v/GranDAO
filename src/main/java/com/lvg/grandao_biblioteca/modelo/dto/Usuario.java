package com.lvg.grandao_biblioteca.modelo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Clase que representa un usuario en el sistema.
 * Contiene información como el ID de usuario, nombre, correo y teléfono.
 * @author Lucas Villa (k4ts0v@protonmail.com)
 * @since 1.0
 * @version 1.0
 */
@XmlRootElement(name = "usuario")  // Mapea a <usuario> en XML
public class Usuario {

    private Integer usuarioId;

    @NotNull(message = "El nombre de usuario es obligatorio")
    @Pattern(regexp = "^[A-Za-z]+( [A-Za-z]+)*$", message = "Nombre de usuario no válido")
    private String nombreUsuario;

    @NotNull(message = "El correo es obligatorio")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Correo no válido")
    private String correo;

    @NotNull(message = "El teléfono es obligatorio")
    @Pattern(regexp = "^([67]\\d{2} \\d{2} \\d{2} \\d{2})$", message = "Teléfono no válido")
    private String telefono;

    /**
     * Constructor vacío.
     *
     * @since 1.0
     */
    public Usuario() {}

    /**
     * Constructor con todos los parámetros.
     * @param usuarioId ID del usuario.
     * @param nombreUsuario Nombre del usuario.
     * @param correo Correo del usuario.
     * @param telefono Teléfono del usuario.
     * @since 1.0
     */
    public Usuario(Integer usuarioId, String nombreUsuario, String correo, String telefono) {
        this.usuarioId = usuarioId;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.telefono = telefono;
    }

    /**
     * Obtiene el ID del usuario.
     *
     * @return El ID del usuario.
     * @since 1.0
     */
    @XmlElement(name = "usuario_id")  // Mapea a <usuario_id> en XML
    public Integer getUsuarioId() {
        return usuarioId;
    }

    /**
     * Establece el ID del usuario.
     *
     * @param usuarioId El ID del usuario.
     * @since 1.0
     */
    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     * @since 1.0
     */
    @XmlElement(name = "nombre_usuario")  // Mapea a <nombre_usuario> en XML
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombreUsuario El nombre del usuario.
     * @since 1.0
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Obtiene el correo del usuario.
     *
     * @return El correo del usuario.
     * @since 1.0
     */
    @XmlElement(name = "correo")  // Mapea a <correo> en XML
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo del usuario.
     *
     * @param correo El correo del usuario.
     * @since 1.0
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el teléfono del usuario.
     *
     * @return El teléfono del usuario.
     * @since 1.0
     */
    @XmlElement(name = "telefono")  // Mapea a <telefono> en XML
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del usuario.
     *
     * @param telefono El teléfono del usuario.
     * @since 1.0
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}