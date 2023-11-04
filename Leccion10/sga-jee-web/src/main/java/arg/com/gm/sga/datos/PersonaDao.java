/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package arg.com.gm.sga.datos;

import arg.com.gm.sga.domain.Persona;
import java.util.List;

public interface PersonaDao {
public List<Persona> findAllPersona();  

public Persona findPersonaById(Persona persona);

public Persona findPersonaByEmail(Persona persona);

public void insertPersona(Persona persona);

public void updatePersona(Persona persona);

public void deletePersona(Persona persona);
}
