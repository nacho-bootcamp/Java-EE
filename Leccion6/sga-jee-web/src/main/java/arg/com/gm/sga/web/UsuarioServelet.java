/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arg.com.gm.sga.web;

import arg.com.gm.sga.domain.Usuario;
import arg.com.gm.sga.servicio.UsuarioService;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJBTransactionRolledbackException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eri y nacho
 */
@WebServlet("/usuario")
public class UsuarioServelet extends HttpServlet {
    
  @Inject  
  UsuarioService usuarioService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException,EJBTransactionRolledbackException {
        List<Usuario>usuario=usuarioService.listarUsuario();
        System.out.println("usuario "+usuario);
        
        req.setAttribute("usuario",usuario);
        req.getRequestDispatcher("/listadoUsuario.jsp").forward(req, resp);
    }
  
  
    
}
