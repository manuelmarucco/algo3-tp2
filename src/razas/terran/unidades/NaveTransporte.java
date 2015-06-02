package razas.terran.unidades;

import jugabilidad.auxiliares.Costo;
import manejoDeUnidades.*;

public class NaveTransporte extends Unidad {
    public NaveTransporte() {
        super("Nave de transporte", new Vida(150), 8, new Aereo(), new UnidadTransporte(8), new Costo(100, 100), 2);
    }
}