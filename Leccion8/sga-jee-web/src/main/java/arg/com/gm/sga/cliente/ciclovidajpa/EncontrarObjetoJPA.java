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
public class EncontrarObjetoJPA {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        // iniciamos la fabrica
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        //obtenemos el objeto entity manager
        EntityManager em = emf.createEntityManager();

        //Inicia la transaccion
        //paso 1 .Iniciamos transaccion
        //solicitamos un objeto transaccion 
        EntityTransaction tx = em.getTransaction();
        //para iniciar
        tx.begin();

        //Paso2 Ejecutar SQL de tipo select
        //persona.class lo sacamos de que estan en persisten
        //<class>arg.com.gm.sga.domain.Usuario</class>
        //<class>arg.com.gm.sga.domain.Persona</class>
        Persona persona1 = em.find(Persona.class, 1);

        //paso3 termina la transaccion
        tx.commit();

        //Objet en estado de detached
        log.debug("Objeto recuperado: " + persona1);

        //Cerramos el entity manager
        em.close();
    }
}
