/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arg.com.gm.sga.cliente.criteria;

import arg.com.gm.sga.domain.Persona;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;
import org.apache.logging.log4j.*;

/**
 *
 *
 */
public class PruebaApiCriteria {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();

        CriteriaBuilder cb = null;
        CriteriaQuery<Persona> criteriaQuery = null;
        Root<Persona> fromPersona = null;
        TypedQuery<Persona> query = null;
        Persona persona = null;
        List<Persona>personas=null;
        
        //query utilizando el API de Criteria 
        //1.Consulta de todas las personas
        
        //Paso1. El objeto EntityManager crea una instancia CriteriaBuilder
        cb = em.getCriteriaBuilder();
        
        //Paso2. Se crea un objeto CriteriaQuery
        criteriaQuery=cb.createQuery(Persona.class);
        
        //Paso3. Creamos el objeto raiz de query
        fromPersona=criteriaQuery.from(Persona.class);
        
        //Paso4 seleccionamos lo necesario del from
        criteriaQuery.select(fromPersona);
        
        //Paso5 Creamo el query typeSafe
        query=em.createQuery(criteriaQuery);
        
        //Paso6 Ejecutamos la consulta
       personas=query.getResultList();
        
        mostrarPersonas(personas);
        
        
    }

    private static void mostrarPersonas(List<Persona> personas) {
    for(Persona p : personas)
        log.debug(p);
    };
}
