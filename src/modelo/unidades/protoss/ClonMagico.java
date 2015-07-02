package modelo.unidades.protoss;

import modelo.interfaces.ColocableEnMapa;
import modelo.unidades.Energia;
import modelo.unidades.Ubicacion;
import modelo.unidades.Unidad;

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
