package com.lvg.grandao_biblioteca.controller;

import com.lvg.grandao_biblioteca.modelo.dto.Usuario;
import com.lvg.grandao_biblioteca.service.UsuarioService;
import jakarta.validation.Valid;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador que maneja las operaciones CRUD relacionadas con los usuarios.
 * Permite realizar acciones como obtener y agregar usuarios.
 *
 * @author Lucas Villa (k4ts0v@protonmail.com)
 * @since 1.0
 * @version 1.0
 */
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    /**
     * Constructor del controlador.
     *
     * @param usuarioService Servicio para gestionar las operaciones relacionadas con los usuarios.
     * @since 1.0
     */
    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * Obtiene una lista de todos los usuarios.
     * Si la lista está vacía, devuelve un estado 204 (No Content).
     * De lo contrario, devuelve la lista con un estado 200 (OK).
     *
     * @return Una lista de usuarios en formato JSON o un estado 204 (No Content) si no hay usuarios.
     * @throws JAXBException Si ocurre un error al procesar la lista de usuarios.
     * @since 1.0
     */
    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerUsuarios() throws JAXBException {
        List<Usuario> usuarios = usuarioService.obtenerUsuarios();
        if (usuarios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
        }
        return new ResponseEntity<>(usuarios, HttpStatus.OK); // 200 OK
    }

    /**
     * Agrega un nuevo usuario.
     * Si la adición es exitosa, devuelve un estado 201 (Created).
     *
     * @param usuario El usuario que se desea agregar.
     * @return Un estado indicando si la operación fue exitosa o no.
     * @throws JAXBException Si ocurre un error al agregar el usuario.
     * @since 1.0
     */
    @PostMapping
    public ResponseEntity<Void> agregarUsuario(@Valid @RequestBody Usuario usuario) throws JAXBException {
        usuarioService.agregarUsuario(usuario);
        return new ResponseEntity<>(HttpStatus.CREATED); // 201 Created
    }
}