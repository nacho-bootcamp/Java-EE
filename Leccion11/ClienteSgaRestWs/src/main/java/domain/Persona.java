package domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Persona {

    private int idpersona;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    public Persona(int idPersona) {
        this.idpersona = idPersona;
    }

    public Persona() {

    }

    public int getIdPersona() {
        return idpersona;
    }

    public void setIdPersona(int idPersona) {
        this.idpersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idpersona + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + '}';
    }
    
}
