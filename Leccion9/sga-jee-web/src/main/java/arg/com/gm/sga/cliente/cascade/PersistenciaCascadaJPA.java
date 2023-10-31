/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arg.com.gm.sga.cliente.cascade;

import arg.com.gm.sga.domain.Persona;
import arg.com.gm.sga.domain.Usuario;
import javax.persistence.*;
import org.apache.logging.log4j.*;

/**
 *
 * @author eri y nacho
 */
public class PersistenciaCascadaJPA {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //paso 1.Crear nuevo objeto
        //objeto en estado transitivo
        Persona persona1 = new Persona("nacho", "Cardozo", "ICardozo@gmail.com", "3884686043");

        //creamo objetp usuario(tiene dependencia con el objeto persona)
        Usuario usuario1 = new Usuario("ICardozo@gmail.com", "123456", persona1);

        //paso3 persistir el objeto usuario unicamente
        em.persist(usuario1);

        //paso4 commit transaccion
        tx.commit();

        //objetos en estado detached
        log.debug("Objeto persistido persona1:" + persona1);
        log.debug("Objeto persistido persona1:" + usuario1);

        em.close();
    }
}
