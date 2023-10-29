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
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersona(personas);

        //2 consulta de la persona con id=1
        log.debug("\n1. Consulta de todas la Persona con id = 1 ");
        jpql = "Select p from Persona p where p.idpersona = 1";
        persona = (Persona) em.createQuery(jpql).getSingleResult();
        //log.debug(persona);

        //3.Consulta de la persona por nombre
        jpql = "Select p from Persona p where p.nombre='nacho'";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersona(personas);

        //4.Consulta de datos individuales se crea un arreglo(tupla) de tipo
        //object de 3 columnas
        log.debug("\n1. Consulta de datos individuales se crea un arreglo(tupla) de tipo object de 3 columnas");

        jpql = "select p.nombre as Nombre, p.apellido as Apellido , p.email as Email from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while (iter.hasNext()) {
            tupla = (Object[]) iter.next();
            String nombre = (String) tupla[0];
            String apellido = (String) tupla[1];
            String email = (String) tupla[2];
            //log.debug("nombre:"+nombre+",apellido:"+apellido+"email:"+email);
        }
        //5.obtiene el objeto persona y el id,
        //se crea un arreglo de tipo object condos columnas
        //log.debug("\n. obtiene el objeto persona y el id,se crea un arreglo de tipo object condos columnas");
        jpql = "select p,p.idpersona from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while (iter.hasNext()) {
            tupla = (Object[]) iter.next();
            persona = (Persona) tupla[0];
            int idpersona = (int) tupla[1];
            //log.debug("Objeto persona:"+persona);
            //log.debug("id persona:"+idpersona);
        }

        //6.Consulta de todas las personas
        //log.debug("\n. Consulta de todas las personas");
        jpql = "select new arg.com.gm.sga.domain.Persona(p.idpersona)from Persona p";
        personas = em.createQuery(jpql).getResultList();
        // mostrarPersona(personas);

        //7.Regresa el valor minimo y maximo de idpersona()
        System.out.println("\n Regresa el valor min y max de idpersona");
        jpql = "select min(p.idpersona) as MinId,max(p.idpersona) as MaxId,count(p.idpersona) as Contador from Persona p  ";
        iter = em.createQuery(jpql).getResultList().iterator();

        while (iter.hasNext()) {
            tupla = (Object[]) iter.next();
            Integer idMin = (Integer) tupla[0];
            Integer idMax = (Integer) tupla[1];
            Long count = (Long) tupla[2];
            // log.debug("idMin:" + idMin + " idMax:" + idMax + " Count:" + count);
        }
        //8.Cuenta los nombres de las presonas que son distintos
        System.out.println("Cuenta los nombres de las presonas que son distintos");
        jpql = "select count(distinct p.nombre) from Persona p";
        Long contador = (Long) em.createQuery(jpql).getSingleResult();
        log.debug("numero de personas con nombres distintos:" + contador);

        //9.Concatenar y convertir a mayusculas  el nombre y apellido
        log.debug("\n Concatenar y convertir a mayusculas  el nombre y apellido");
        jpql = "select upper(concat(p.nombre,' ',p.apellido)) as Nombre from Persona p";
        nombres = em.createQuery(jpql).getResultList();
        for (String nombreCompleto : nombres) {
            //log.debug(nombreCompleto);
        }

        //10.Obtiene el objeto persona con id igual al parametro porpocionado
        log.debug("\n. Obtiene el objeto persona con id igual al parametro porpocionado");

        int idPersona = 1;

        jpql = "select p from Persona p where p.idpersona = :id";
        q = em.createQuery(jpql);
        q.setParameter("id", idPersona);
        persona = (Persona) q.getSingleResult();
        // log.debug(persona);

        //11. Obtiene las ´personas que contengan una letra "a" en el nombre, sin
        //importar si es mayusculas o minusculas.
        log.debug("\n11 Obtiene las personas que contengan una letra a en el nombre, sin importar si es mayusculas o minusculas.");
        jpql = "select p from Persona p where upper(p.nombre) like upper(:parametro)";
        String parametroString = "%a%"; // es el caracter que utilizamos para el like
        q = em.createQuery(jpql);
        q.setParameter("parametro", parametroString);
        personas = q.getResultList();
        mostrarPersona(personas);

    }

    private static void mostrarPersona(List<Persona> personas) {
        for (Persona p : personas) {
            log.debug(p);
        }
    }
}
