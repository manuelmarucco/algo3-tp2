package fiuba.algo3.algocraft.unidades;

import fiuba.algo3.algocraft.comandos.AccionesDeClasedeUnidad;

import java.util.HashMap;

public abstract class ClaseDeUnidad {

    public HashMap<String,AccionesDeClasedeUnidad> accion;

    public void actuar(String accion, Unidad objetivo,Unidad actor) {
        this.accion.get(accion).actuar(objetivo,actor);
    }
}
