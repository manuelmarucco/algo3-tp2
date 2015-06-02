package razas.terran.unidades;

import jugabilidad.auxiliares.Costo;
import manejoDeUnidades.*;

public class NaveCiencia extends Unidad{
    public NaveCiencia(){
        super("NaveCiencia",new Vida(200),10,new Aereo(),new UnidadMagica(new Energia(200,50,10)),new Costo(50,100),2);
    }
}
