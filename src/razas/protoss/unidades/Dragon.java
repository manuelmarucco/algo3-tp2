package razas.protoss.unidades;

import jugabilidad.auxiliares.Costo;
import manejoDeUnidades.*;

public class Dragon extends Unidad {

    public Dragon(){
        super("Dragon",new VidaEscudo(80,100),8,new Terrestre(),new UnidadGuerrera(new Danio(20,20,4,4)),new Costo(125,50),2);
    }
}
