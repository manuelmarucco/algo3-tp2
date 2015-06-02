package fiuba.algo3.algocraft.unidades.terran;

import auxiliares.Costo;
import fiuba.algo3.algocraft.unidades.*;

public class Golliat extends Unidad {

    public Golliat(){
        super("Golliat",new Vida(125),8,new Terrestre(),new UnidadGuerrera(new Danio(12,10,6,5)),new Costo(100,50),2);
    }
}
