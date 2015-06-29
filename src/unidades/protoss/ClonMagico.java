package unidades.protoss;

import interfaces.ColocableEnMapa;
import unidades.*;

public class ClonMagico extends Clon implements ColocableEnMapa {
    private Energia energia;

    public ClonMagico(ResistenciaProtoss resistencia,Energia energia, int vision, Ubicacion ubicacion,int movilidad,int transporte,Unidad unidad) {
        super(resistencia,vision,ubicacion,movilidad,transporte,unidad);
        this.energia=energia;
    }

    public Energia getEnergia() {
        return energia;
    }

    public int getEnergiaActual() {
        return energia.getEnergiaActual();
    }
}
