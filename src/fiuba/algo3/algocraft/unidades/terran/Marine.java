package fiuba.algo3.algocraft.unidades.terran;

import auxiliares.Costo;
import fiuba.algo3.algocraft.unidades.*;

public class Marine extends Unidad {

    public Marine(){
        super("marine",new Vida(40), 7, new Terrestre(), new UnidadGuerrera(new Danio(6,6, 4,4)),new Costo(50,0),1);
    }
}
