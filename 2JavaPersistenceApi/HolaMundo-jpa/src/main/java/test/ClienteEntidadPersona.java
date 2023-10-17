/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import arg.com.gm.sga.domain.Persona;
import javax.persistence.*;
import javax.persistence.Persistence;
import org.apache.logging.log4j.*;


public class ClienteEntidadPersona {
    
static Logger log= LogManager.getRootLogger();  
public static void main(String[] args){
//se trabaja con el entity manager factory para poder 
//abrir el objeto de la fabrica JPA 
EntityManagerFactory emf=Persistence.createEntityManagerFactory("PersonaPU");
EntityManager em= emf.createEntityManager();
EntityTransaction tx = em.getTransaction();
// Inicia la transaccion
tx.begin();
//no se debe especificar el id de la base de datos
Persona persona1 = new Persona ("maria","gutierrez","mgutierrez@gamil.com","65164651");
log.debug("Objeto a persistir "+ persona1);
//prsistir el objeto
em.persist(persona1);
        //termonamos la transaccion;
tx.commit();
log.debug("Objeto persistido "+persona1);
em.close();

}
}
