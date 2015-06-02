package unidades;

import interfaces.Actuable;

import java.util.HashMap;

import unidades.comandos.Accion;
import unidades.comandos.AccionRegenerarEnergia;

public class UnidadMagica extends ClaseDeUnidad {


    private final Energia energia;

    public UnidadMagica(Energia energia) {
        super();
        this.energia=energia;
        this.accion.put(Accion.REGENERARENERGIA, new AccionRegenerarEnergia(energia));
    }

    @Override
    public HashMap<Parametros, Integer> getParametros() {
        HashMap<Parametros, Integer> parametros = new HashMap<Parametros, Integer>();
        parametros.put(Parametros.ENERGIAACTUAL,energia.getEnergiaActual());
        parametros.put(Parametros.ENERGIATOTAL,energia.getEnergiaTotal());
        parametros.put(Parametros.REGENERACIONDEENERGIA,energia.getRegeneracionEnergia());
        return parametros;
    }

    @Override
    public void agregarMetodosUpdate(HashMap<Accion, Actuable> poolDeAcciones) {
        poolDeAcciones.put(Accion.REGENERARENERGIA,accion.get(Accion.REGENERARENERGIA));
    }
}
