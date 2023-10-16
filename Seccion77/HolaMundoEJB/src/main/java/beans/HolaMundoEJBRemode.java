/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package beans;

import javax.ejb.Remote;

/*Remote es la notacion que va a permitir a Glassfish publicar 
este componente y vamos a poder acceder desde el cliente
*/
@Remote
public interface HolaMundoEJBRemode {
    public int sumar(int a , int b);
}
