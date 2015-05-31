package fiuba.algo3.algocraft.unidades;

import fiuba.algo3.algocraft.comandos.Accion;
import fiuba.algo3.algocraft.comandos.AccionRegenerarEnergia;

public class UnidadMagica extends ClaseDeUnidad {


    private final Energia energia;

    public UnidadMagica(Energia energia) {
        super();
        this.energia=energia;
        this.accion.put(Accion.ATACAR, new AccionRegenerarEnergia(energia));
    }
}
