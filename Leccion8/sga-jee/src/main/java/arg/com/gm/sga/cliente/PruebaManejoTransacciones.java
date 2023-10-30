/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arg.com.gm.sga.cliente;

import arg.com.gm.sga.domain.Persona;
import arg.com.gm.sga.servicio.PersonaServiceRemote;
import javax.naming.*;
import org.apache.logging.log4j.*;

public class PruebaManejoTransacciones {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        try {
            Context jndi = new InitialContext();
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee-web/PersonaServiceImpl !arg.com.gm.sga.servicio.PersonaService");
            log.debug("Iniciando prueba Manejo transaccional PersonaService");

            //Buscar un objeto persona
            Persona persona1 = personaService.encontrarPersonaPorId(new Persona(1));
            log.debug("Persona recuperada " + persona1);

            //cambiar el apellido de la persona
            persona1.setApellido("CARDOZO");
        
            personaService.modificarPersona(persona1);
            log.debug("Objeto modificado: "+persona1);
            log.debug(" Fin de Prueba EJB transaccional");
        
        } catch (NamingException ex) {
            log.debug(ex.getMessage());
        }
    }
}
