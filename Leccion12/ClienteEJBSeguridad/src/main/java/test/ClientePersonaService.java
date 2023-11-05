/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import arg.com.gm.sga.domain.Persona;
import arg.com.gm.sga.servicio.PersonaServiceRemote;
import com.sun.enterprise.security.ee.auth.login.ProgrammaticLogin;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ClientePersonaService {
    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el cliente");
    
    String authFile="login.conf";
    System.setProperty("java.security.auth.login.config", authFile);
    ProgrammaticLogin programmaticLogin=new ProgrammaticLogin();
    
    programmaticLogin.login("admin","admin".toCharArray());
    
        try {
            Context jndi=new InitialContext();
            PersonaServiceRemote personaService=(PersonaServiceRemote) jndi.lookup("java:global/sga-jee-web/PersonaServiceImpl!arg.com.gm.sga.servicio.PersonaServiceRemote");
       List<Persona> persona=personaService.listarPersonas();
       
       for(Persona p:persona){
           System.out.println("persona: "+p);
       }
            System.out.println("\nFin de la llamada al EJB desde el cliente");
       
        } catch (NamingException ex) {
         ex.printStackTrace(System.out);
        }
    
    }
 
}
