/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arg.com.gm.sga.cliente;

import arg.com.gm.sga.domain.Persona;
import arg.com.gm.sga.servicio.PersonaServiceRemote;
import java.util.List;
import javax.naming.*;

public class ClientePersonaService {
    public static void main(String[] args) throws NamingException {
        System.out.println("Iniciando llamada al EJB desde el cliente \n");
        try {
        Context jndi=new InitialContext();
            PersonaServiceRemote personaService=(PersonaServiceRemote) jndi.lookup("java:global/sga-jee/PersonaServiceImpl!arg.com.gm.sga.servicio.PersonaServiceRemote");
       List<Persona> personas= personaService.listarPersona();
       
       for(Persona persona:personas){
           System.out.println(persona);
       }
            System.out.println("Fin de la llamada");
        } catch (NamingException e) {
        e.printStackTrace(System.out);
        }
    }
    
}
