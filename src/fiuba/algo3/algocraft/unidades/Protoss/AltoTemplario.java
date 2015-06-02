package fiuba.algo3.algocraft.unidades.Protoss;

import auxiliares.Costo;
import fiuba.algo3.algocraft.unidades.*;

public class AltoTemplario extends Unidad{
    public AltoTemplario(){
        super("Alto Templario",new VidaEscudo(40,40),7,new Terrestre(),new UnidadMagica(new Energia(200,50,15)),new Costo(50,150),2);
    }
}
