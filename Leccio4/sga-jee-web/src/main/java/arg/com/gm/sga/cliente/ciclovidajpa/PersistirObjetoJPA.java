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
        Persona persona1 = new Persona("erica", "condorii", "econdori@mail.com", "165165165");
    }
}
