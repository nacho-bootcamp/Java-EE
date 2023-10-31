/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arg.com.gm.sga.datos;

import arg.com.gm.sga.domain.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author eri y nacho
 */
@Stateless 
public class UsuarioDaoImpl implements UsuarioDao{
    
   // @PersistenceContext(unitName="PersonaPU")
    EntityManager em;

    @Override
    public List<Usuario> findUsuarios() {
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public Usuario findUsuarioById(Usuario usuario) {
       return em.find(Usuario.class, usuario.getIdUsuario());
    }

    @Override
    public Usuario findUsuarioByIdpersona(Usuario persona) {
        return em.find(Usuario.class, persona.getIdUsuario());
    }

    @Override
    public Usuario findUsuarioByUsername(Usuario usuario) {
        Query query=em.createQuery("from Usuario p where p.username=:username");
        query.setParameter("username", usuario.getUsername());
        return (Usuario) query.getSingleResult();
    }

    @Override
    public void insertUsuario(Usuario usuario) {
       em.persist(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        em.merge(usuario);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
      em.remove(em.merge(usuario));
    }
    
}
