package fiuba.algo3.algocraft.unidades.terran;

import auxiliares.Costo;
import fiuba.algo3.algocraft.unidades.*;

public class NaveTransporte extends Unidad {
    public NaveTransporte() {
        super("NaveCiencia", new Vida(200), 8, new Aereo(), new UnidadTransporte(8), new Costo(100, 100), 2);
    }
}