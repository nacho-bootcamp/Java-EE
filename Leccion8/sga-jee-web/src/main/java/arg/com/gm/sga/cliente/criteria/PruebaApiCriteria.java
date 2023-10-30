/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arg.com.gm.sga.cliente.criteria;

import arg.com.gm.sga.domain.Persona;
import java.util.*;

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
        List<Persona> personas = null;

        //query utilizando el API de Criteria 
        //1.Consulta de todas las personas
        //Paso1. El objeto EntityManager crea una instancia CriteriaBuilder
        cb = em.getCriteriaBuilder();

        //Paso2. Se crea un objeto CriteriaQuery
        criteriaQuery = cb.createQuery(Persona.class);

        //Paso3. Creamos el objeto raiz de query
        fromPersona = criteriaQuery.from(Persona.class);

        //Paso4 seleccionamos lo necesario del from
        criteriaQuery.select(fromPersona);

        //Paso5 Creamo el query typeSafe
        query = em.createQuery(criteriaQuery);

        //Paso6 Ejecutamos la consulta
        personas = query.getResultList();

        //mostrarPersonas(personas);
        //2-a. Consulta de la Persona con id=1;
        log.debug("\n2-a Consulta de la persona con id=1");
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona).where(cb.equal(fromPersona.get("idpersona"), 1));
        persona = em.createQuery(criteriaQuery).getSingleResult();
        // log.debug(persona);

        //2-b. Consulta de la Persona con el id=1
        log.debug("\n2-b Consulta de la Persona con el id=1");
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona);

        //La clase  Predicate permite agregar varios criterios dinamicamente
        List<Predicate> criterios = new ArrayList<Predicate>();

        //Verificamos si tenemos criterios que agregar
        Integer idPersonaParam = 1;
        ParameterExpression<Integer> parameter = cb.parameter(Integer.class, "idpersona");
        criterios.add(cb.equal(fromPersona.get("idpersona"), parameter));

        //se agregan los criterios
        if (criterios.isEmpty()) {
            throw new RuntimeException("Sin criterios");
        } else if (criterios.size() == 1) {
            criteriaQuery.where(criterios.get(0));
        }else{
        criteriaQuery.where(cb.and(criterios.toArray(new Predicate[0])));
        }
        
        query=em.createQuery(criteriaQuery);
        query.setParameter("idpersona", idPersonaParam);
        
        //se ejecuta el query
        persona =query.getSingleResult();
        log.debug(persona);

    }

    private static void mostrarPersonas(List<Persona> personas) {
        for (Persona p : personas) {
            log.debug(p);
        }
    }
;
}
