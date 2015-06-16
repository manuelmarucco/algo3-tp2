package unidades.protoss;

import interfaces.ColocableEnMapa;
import unidades.Ubicacion;

public class ClonTransporte extends Clon implements ColocableEnMapa {

    public ClonTransporte(ResistenciaProtoss resistencia, int vision, Ubicacion ubicacion,int movilidad,int transporte) {
        super(resistencia,vision,ubicacion,movilidad,transporte);
    }
}
