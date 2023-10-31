/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arg.com.gm.sga.cliente.ciclovidajpa;

import arg.com.gm.sga.domain.Persona;
import javax.persistence.*;
import org.apache.logging.log4j.*;

/**
 *
 * @author eri y nacho
 */
public class ActualizarObjetoSesionLarga {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();

        //iniciamos la transaccion
        //Paso 1. Iniciar una transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //Paso 2.Ejecutamos el SQL de tipo select
        Persona persona1 = em.find(Persona.class, 1);
        
        log.debug("Objecto encontrado: " + persona1);

        //Paso 3.setValue()
        persona1.setEmail("jjerezemail.com");
        
        persona1.setEmail("J.Jerez@gmail.com");

        //Paso 4.Termina la transaccion
        tx.commit();

        //Objeto en estado detached
        log.debug("Objeto modificado:" + persona1);

        //Cerramos el entity manager
        em.close();
    }
    
}
