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
 * @author nacho
 */
public class PersistirObjetoJPA {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction txt = em.getTransaction();

        //inicia la transaccion
        //paso 1. Crea nuevo objeto
        //Objeto en estado transitivo(no esta ligado con la base de datos ya que
        // esta transaccion todavia no inicio)
        Persona persona1 = new Persona("ericaa", "condorii", "econdori@mail.com", "165165165");
        //paso 2. Iniciar la transaccion
        txt.begin();

        //paso 3.Ejecutamos SQL(todavia no se inserta en la base de datos ni se
        // genera la llave primaria)
        em.persist(persona1);
        log.debug("Objeto persistido estado dtached: "+persona1);

        //paso 4.commit o rollback(cuando hacemos commit se guarda el 
        //objeto en la base de datos y se genera la pk)
        txt.commit();
        
        //objeto en estado detached 
        log.debug("Objeto persistido estado dtached: "+persona1);
        
        //cerramos el entytimanager
        em.close();

    }
}
