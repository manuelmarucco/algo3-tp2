package unidades.protoss;

import interfaces.ColocableEnMapa;
import unidades.Ubicacion;
import unidades.Unidad;

public class ClonTransporte extends Clon implements ColocableEnMapa {

    public ClonTransporte(ResistenciaProtoss resistencia, int vision, Ubicacion ubicacion,int movilidad,int transporte, Unidad unidad) {
        super(resistencia,vision,ubicacion,movilidad,transporte,unidad);
    }
}
