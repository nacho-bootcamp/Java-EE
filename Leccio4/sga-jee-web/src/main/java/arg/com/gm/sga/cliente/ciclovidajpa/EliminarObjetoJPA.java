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
public class EliminarObjetoJPA {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();

        //Iniciar Transaccion
        //paso 1.Iniciar una transaccion
        EntityTransaction tx = em.getTransaction();
        // con el begin iniciamos la transaccion
        tx.begin();

        //paso 2.Ejecutar UN SQL de tipo SELECT
        Persona persona1 = em.find(Persona.class, 2);

        //si estamos dentro de la misma transaccion lo de abajo sirve
        // em.remove(persona1);
        //tx.commit();
        //Cerramos el entity manager 
        // si no estamos en una misma transaccion entonces
        //paso 3.termina transaccion 1
        tx.commit();

        //objeto en estado detached
        log.debug("Objeto encontrado:" + persona1);

        //paso 4 Iniciamos Transaccion 2
        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();

        //paso 5 Ejecutar SQL que es un delete
        em.remove(em.merge(persona1));

        //paso 6 termina transaccion 2
        tx2.commit();

        //Objeto en estado detached ya eliminado en la base de datos
        log.debug("Objeto eliminado:" + persona1);
        em.close();
    }
    
}
