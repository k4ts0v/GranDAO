package com.lvg.grandao_biblioteca.modelo.dao;

import com.lvg.grandao_biblioteca.modelo.dto.Usuario;
import com.lvg.grandao_biblioteca.modelo.dto.Usuarios;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.List;

/**
 * DAO (Data Access Object) que maneja la lectura y escritura de usuarios en un archivo XML.
 * Utiliza JAXB para convertir entre objetos Java y representación XML.
 * @author Lucas Villa (k4ts0v@protonmail.com)
 * @since 1.0
 * @version 1.0
 */
public class UsuarioDAO {

    private static final String FILE_PATH = "src/main/java/com/lvg/grandao_biblioteca/datos/usuarios.xml";

    /**
     * Lee los usuarios desde un archivo XML y los convierte en una lista de objetos Usuario.
     * Este método utiliza JAXB para deserializar el XML a un objeto Java.
     *
     * @return Una lista de usuarios leída desde el archivo XML.
     * @throws JAXBException Si ocurre un error al procesar el archivo XML.
     * @since 1.0
     */
    public List<Usuario> obtenerUsuarios() throws JAXBException {
        // Creación de un contexto JAXB para la clase Usuarios.
        // El contexto JAXB es responsable de gestionar el proceso de conversión entre XML y objetos Java.
        JAXBContext context = JAXBContext.newInstance(Usuarios.class);

        // Crea un Unmarshaller para convertir un XML a un objeto Java.
        // Unmarshaller es utilizado para deserializar (convertir) datos XML en objetos Java.
        Unmarshaller unmarshaller = context.createUnmarshaller();

        // Carga el archivo XML desde el sistema de archivos.
        File xmlFile = new File(FILE_PATH);

        // Deserializa el archivo XML en un objeto Usuarios.
        // Esto convierte el XML en un objeto de tipo Usuarios que contiene una lista de usuarios.
        Usuarios usuarios = (Usuarios) unmarshaller.unmarshal(xmlFile);

        // Devuelve la lista de usuarios obtenida del objeto Usuarios.
        return usuarios.getUsuarioList();
    }

    /**
     * Agrega un nuevo usuario al archivo XML.
     * Este método utiliza JAXB para deserializar el XML, agregar un nuevo usuario y luego serializar de nuevo el objeto Java a XML.
     *
     * @param usuario El usuario a agregar al archivo XML.
     * @throws JAXBException Si ocurre un error al procesar el archivo XML.
     * @since 1.0
     */
    public void agregarUsuario(Usuario usuario) throws JAXBException {
        // Creación de un contexto JAXB para la clase Usuarios.
        // El contexto JAXB es necesario para manejar la conversión de objetos Java a XML y viceversa.
        JAXBContext context = JAXBContext.newInstance(Usuarios.class);

        // Crea un Marshaller para convertir un objeto Java en XML.
        // Marshaller es responsable de serializar (convertir) objetos Java en representación XML.
        Marshaller marshaller = context.createMarshaller();

        // Crea un Unmarshaller para convertir XML en objetos Java.
        Unmarshaller unmarshaller = context.createUnmarshaller();

        // Carga el archivo XML desde el sistema de archivos.
        File xmlFile = new File(FILE_PATH);

        // Deserializa el XML existente en un objeto Usuarios.
        // Este paso convierte el archivo XML en un objeto Java, que contiene la lista actual de usuarios.
        Usuarios usuarios = (Usuarios) unmarshaller.unmarshal(xmlFile);

        // Agrega el nuevo usuario a la lista de usuarios.
        usuarios.getUsuarioList().add(usuario);

        // Serializa el objeto actualizado (con el nuevo usuario agregado) de nuevo en un archivo XML.
        // Este paso convierte el objeto Java actualizado en un archivo XML que contiene la lista actualizada de usuarios.
        marshaller.marshal(usuarios, xmlFile);
    }
}
