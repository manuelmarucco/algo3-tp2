package fiuba.algo3.algocraft.unidades.Protoss;

import auxiliares.Costo;
import fiuba.algo3.algocraft.unidades.*;

public class Scout extends Unidad {

    public Scout(){
        super("Scout",new VidaEscudo(100,150),7,new Terrestre(),new UnidadGuerrera(new Danio(8,14,4,4)),new Costo(300,150),3);
    }
}
