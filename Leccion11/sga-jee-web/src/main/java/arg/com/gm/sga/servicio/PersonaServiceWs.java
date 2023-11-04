package arg.com.gm.sga.servicio;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import arg.com.gm.sga.domain.Persona;

@WebService
public interface PersonaServiceWs {
    
    @WebMethod
    public List<Persona> listarPersonas();
}
