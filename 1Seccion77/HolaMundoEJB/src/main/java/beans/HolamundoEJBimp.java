/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import javax.ejb.Stateless;

/**
 *glassfish va a detectar este componente gracias a la notacion
 * por lo tanto poder acceder de manera remota desde un cliente
 *
 */
@Stateless
public class HolamundoEJBimp implements HolaMundoEJBRemode{

    @Override
    public int sumar(int a, int b) {
        System.out.println("Ejecutando el codigo");
        return a + b;
    }
    
}
