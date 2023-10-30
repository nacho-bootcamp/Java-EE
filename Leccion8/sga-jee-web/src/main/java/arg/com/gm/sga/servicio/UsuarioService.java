/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package arg.com.gm.sga.servicio;

import arg.com.gm.sga.domain.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author eri y nacho
 */
@Local
public interface UsuarioService {
    public List<Usuario>listarUsuario();
    
    public Usuario encontrarUsuarioPorId(Usuario usuario);
    
    public void registrarUsuario(Usuario usuario);
    
    public void modificarUsuario(Usuario usuario);
    
    public void eliminarUsuario(Usuario usuario);
     
}
