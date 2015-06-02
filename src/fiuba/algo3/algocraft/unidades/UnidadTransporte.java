package fiuba.algo3.algocraft.unidades;

import fiuba.algo3.algocraft.comandos.Accion;
import interfaces.Actuable;

import java.util.HashMap;

public class UnidadTransporte extends ClaseDeUnidad {
    private final int CapacidadTransporte;
    private int CapacidadActual;

    public UnidadTransporte(int i) {
        this.CapacidadTransporte= i;

    }

    @Override
    public HashMap<Parametros, Integer> getParametros() {
        HashMap<Parametros, Integer> param= new HashMap<Parametros, Integer>();
        param.put(Parametros.CAPACIDADTRANSPORTE,CapacidadTransporte);
        param.put(Parametros.CAPACIDADACTUAL,CapacidadActual);
        return param;
    }

    @Override
    public void agregarMetodosUpdate(HashMap<Accion, Actuable> poolDeAcciones) {

    }
}
