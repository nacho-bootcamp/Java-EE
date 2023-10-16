/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import beans.HolaMundoEJBRemode;
import javax.naming.*;

/**
 *
 * 
 */
public class TestHolaMundoEJB {
    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el cliente");
        try {
            Context jndi= new InitialContext();
            HolaMundoEJBRemode holaMundoEJB=(HolaMundoEJBRemode) jndi.lookup("java:global/HolaMundoEJB/HolamundoEJBimp!beans.HolaMundoEJBRemode");
int resultado=holaMundoEJB.sumar(5, 3);
            System.out.println("Resultado "+ resultado);
        } catch (NamingException e) {
            e.printStackTrace(System.out);
        }
    }
}
