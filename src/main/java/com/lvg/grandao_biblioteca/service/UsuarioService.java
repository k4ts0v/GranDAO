package com.lvg.grandao_biblioteca.service;

import com.lvg.grandao_biblioteca.modelo.dao.UsuarioDAO;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import com.lvg.grandao_biblioteca.modelo.dto.Usuario;
import com.lvg.grandao_biblioteca.modelo.dto.Usuarios;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * Servicio encargado de gestionar las operaciones relacionadas con los usuarios.
 * Permite obtener la lista de usuarios y agregar nuevos usuarios al sistema.
 * @author Lucas Villa (k4ts0v@protonmail.com)
 * @since 1.0
 * @version 1.0
 */
@Service
public class UsuarioService {

    private UsuarioDAO usuarioDAO;

    /**
     * Constructor vacío para la inicialización por Spring.
     * @since 1.0
     */
    public UsuarioService() {
        this.usuarioDAO = new UsuarioDAO();
    }


    /**
     * Obtiene la lista de todos los usuarios.
     *
     * @return Una lista con todos los usuarios almacenados.
     * @throws JAXBException Si ocurre un error al leer el archivo XML.
     * @since 1.0
     */
    public List<Usuario> obtenerUsuarios() throws JAXBException {
        return usuarioDAO.obtenerUsuarios();
    }

    /**
     * Agrega un nuevo usuario al sistema.
     *
     * @param usuario El objeto usuario que se desea agregar.
     * @throws JAXBException Si ocurre un error al escribir el archivo XML.
     * @since 1.0
     */
    public void agregarUsuario(Usuario usuario) throws JAXBException {
        usuarioDAO.agregarUsuario(usuario);
    }
}
