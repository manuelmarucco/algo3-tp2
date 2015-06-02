package unidades.protoss;

import unidades.*;
import jugabilidad.auxiliares.Costo;

public class AltoTemplario extends Unidad{
    public AltoTemplario(){
        super("Alto Templario",new VidaEscudo(40,40),7,new Terrestre(),new UnidadMagica(new Energia(200,50,15)),new Costo(50,150),2);
    }
}
