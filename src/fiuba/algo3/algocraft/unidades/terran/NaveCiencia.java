package fiuba.algo3.algocraft.unidades.terran;

import auxiliares.Costo;
import fiuba.algo3.algocraft.unidades.*;

public class NaveCiencia extends Unidad{
    public NaveCiencia(){
        super("NaveCiencia",new Vida(200),8,new Aereo(),new UnidadMagica(new Energia(200,50,10)),new Costo(50,100),2);
    }
}
