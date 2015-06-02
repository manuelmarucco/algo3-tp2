package razas.protoss.unidades;

import jugabilidad.auxiliares.Costo;
import manejoDeUnidades.*;

public class AltoTemplario extends Unidad{
    public AltoTemplario(){
        super("Alto Templario",new VidaEscudo(40,40),7,new Terrestre(),new UnidadMagica(new Energia(200,50,15)),new Costo(50,150),2);
    }
}
