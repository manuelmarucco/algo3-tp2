package fiuba.algo3.algocraft.unidades;

import fiuba.algo3.algocraft.comandos.Accion;
import fiuba.algo3.algocraft.comandos.AccionRegenerarEnergia;

import java.util.HashMap;

public class UnidadMagica extends ClaseDeUnidad {


    private final Energia energia;

    public UnidadMagica(Energia energia) {
        super();
        this.energia=energia;
        this.accion.put(Accion.ATACAR, new AccionRegenerarEnergia(energia));
    }

    @Override
    public HashMap<Parametros, Integer> getParametros() {
        HashMap<Parametros, Integer> parametros = new HashMap<Parametros, Integer>();
        parametros.put(Parametros.ENERGIAACTUAL,energia.getEnergiaActual());
        parametros.put(Parametros.ENERGIATOTAL,energia.getEnergiaTotal());
        parametros.put(Parametros.REGENERACIONDEENERGIA,energia.getRegeneracionEnergia());
        return parametros;
    }
}
