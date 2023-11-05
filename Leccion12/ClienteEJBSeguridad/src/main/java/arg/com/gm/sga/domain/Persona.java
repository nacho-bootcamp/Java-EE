/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arg.com.gm.sga.domain;

import java.io.Serializable;

public class Persona implements Serializable {

    private static final long serialVrsionUID = 1L;
    
     public Persona() {
    }

    public Persona(Integer idpersona) {
        this.idpersona = idpersona;
    }

    private Integer idpersona;
    private String apellido;
    private String email;

    public Integer getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Integer idpersona) {
        this.idpersona = idpersona;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    private String telefono;

    @Override
    public String toString() {
        return "Persona{" + "idpersona=" + idpersona + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + '}';
    }

   
}
