package unidades.protoss;

import interfaces.ColocableEnMapa;
import unidades.*;

public class ClonMagico extends Clon implements ColocableEnMapa {
    private Energia energia;

    public ClonMagico(ResistenciaProtoss resistencia,Energia energia, int vision, Ubicacion ubicacion,int movilidad,int transporte) {
        super(resistencia,vision,ubicacion,movilidad,transporte);
        this.energia=energia;
    }
}
