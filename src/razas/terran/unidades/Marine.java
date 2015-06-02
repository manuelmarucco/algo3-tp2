package razas.terran.unidades;

import jugabilidad.auxiliares.Costo;
import manejoDeUnidades.*;

public class Marine extends Unidad {

    public Marine(){
        super("Marine",new Vida(40), 7, new Terrestre(), new UnidadGuerrera(new Danio(6,6, 4,4)),new Costo(50,0),1);
    }
}
