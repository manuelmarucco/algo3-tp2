package fiuba.algo3.algocraft.unidades.Protoss;

import auxiliares.Costo;
import fiuba.algo3.algocraft.unidades.*;

public class NaveTransporte extends Unidad {
    public NaveTransporte() {
        super("Nave de Transporte", new VidaEscudo(60,80), 8, new Aereo(), new UnidadTransporte(8), new Costo(200, 0), 2);
    }
}