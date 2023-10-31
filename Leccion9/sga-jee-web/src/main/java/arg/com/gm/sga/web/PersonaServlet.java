/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arg.com.gm.sga.web;

import arg.com.gm.sga.domain.Persona;
import arg.com.gm.sga.servicio.PersonaService;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/persona")
public class PersonaServlet extends HttpServlet {
    //para hacer la llamada al EJB
    //Injectado por CDI
    @Inject
    PersonaService personaService;
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
   //acceder al listado de persona por medio de la instancia de EJB(personaService)
        List<Persona>personas=personaService.listarPersona();
        System.out.println("persona "+personas);
        //ponemos la variable en algun alcance en este caso de request
        request.setAttribute("personas", personas);
        //hacemos un requestDispatcher para redirigir hacia el JSP que va a desplegar el listado de persona
        //hacemos un forward reenviando los objetos de request y response para poder acceder a la informacion
        request.getRequestDispatcher("/listadoPersonas.jsp").forward(request, response);
    }
    
}
