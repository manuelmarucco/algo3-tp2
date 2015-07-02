package modelo.unidades.protoss;

import modelo.interfaces.ColocableEnMapa;
import modelo.unidades.Unidad;
import modelo.unidades.Ubicacion;

public class ClonTransporte extends Clon implements ColocableEnMapa {

    public ClonTransporte(ResistenciaProtoss resistencia, int vision, Ubicacion ubicacion,int movilidad,int transporte, Unidad unidad) {
        super(resistencia,vision,ubicacion,movilidad,transporte,unidad);
    }
}
