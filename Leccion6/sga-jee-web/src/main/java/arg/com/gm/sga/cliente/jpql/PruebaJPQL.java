/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arg.com.gm.sga.cliente.jpql;

import arg.com.gm.sga.domain.Persona;
import arg.com.gm.sga.domain.Usuario;
import java.util.*;
import javax.persistence.*;
import org.apache.logging.log4j.*;

/**
 *
 * @author eri y nacho
 */
public class PruebaJPQL {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {

        String jpql = null;
        Query q = null;
        List<Persona> personas = null;
        Persona persona = null;
        Iterator iter = null;
        Object[] tupla = null;
        List<String> nombres = null;
        List<Usuario> usuarios = null;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();

        //1. consultas de todos los objetos de tipo persona
        log.debug("\n1. Consulta de todas las Personas ");
        jpql = "Select p from Persona p";
        personas=em.createQuery(jpql).getResultList();
        mostrarPersona(personas);
        em.close();
    }

    private static void mostrarPersona(List<Persona> personas) {
    for(Persona p:personas){
    log.debug(p);
    }    
    }
}
