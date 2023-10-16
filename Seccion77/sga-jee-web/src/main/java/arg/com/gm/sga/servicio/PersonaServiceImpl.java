/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arg.com.gm.sga.servicio;

import arg.com.gm.sga.domain.Persona;
import java.util.*;
import javax.ejb.Stateless;

@Stateless
public class PersonaServiceImpl implements  PersonaServiceRemote,PersonaService{
    @Override
    public List<Persona> listarPersona(){
    List<Persona> personas= new ArrayList<>();
    personas.add(new Persona(1,"nacho","Cardozo","ignacio@gmail.com","3884686043"));
     personas.add(new Persona(2,"Eri","Condori","eri@gmail.com","3884686042"));
    return personas;
    }
    
    @Override
    public Persona encontrarPersonaPorId(Persona persona){
    return null;}
    
    @Override
    public Persona encontrarPersonaPorEmail(Persona persona){
        return null;
    }
    
    @Override
    public void registarPrsona(Persona persona){}
    
    @Override
    public void modificarPersona(Persona persona){}
    
    @Override
    public void eliminarPersona(Persona persona){}
}
