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
public class ActualizarObjetoJPA {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();

        //iniciamos la transaccion
        //paso 1 Iniciar una transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //paso 2.Ejecutamos Sql de tipo select
        Persona persona1 = em.find(Persona.class, 1);

        //paso3 Termina la transaccion1
        tx.commit();

        //Objeto en estado detache
        log.debug("Objeto recuperado: " + persona1);

        //Paso4 setValue(nuevoValor)
        persona1.setApellido("Jerez");

        //paso5 Iniciar transaccion 2
        EntityTransaction tx2 = em.getTransaction();
        tx.begin();

        //Paso 6 modificamos el objeto
        em.merge(persona1);

        //Paso 7 terminar la transaccion2
        tx2.commit();

        //Objeto en estado detached ya modificado
        log.debug("Objeto recuperado: " + persona1);
        
        //cerramos el entity manager
        em.close();
    }
}
