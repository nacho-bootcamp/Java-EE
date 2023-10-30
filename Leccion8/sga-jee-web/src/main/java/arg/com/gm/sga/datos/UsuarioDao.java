/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package arg.com.gm.sga.datos;

import arg.com.gm.sga.domain.Usuario;
import java.util.List;

/**
 *
 * @author nacho
 */
public interface UsuarioDao {
    public List<Usuario>findUsuarios();
    
public Usuario findUsuarioById(Usuario usuario);

public void insertUsuario(Usuario usuario);

public void updateUsuario(Usuario usuario);

public void deleteUsuario(Usuario usuario);
}
