package fiuba.algo3.algocraft.unidades;

import fiuba.algo3.algocraft.comandos.Accion;
import fiuba.algo3.algocraft.comandos.AccionesDeClasedeUnidad;

import java.util.HashMap;

public abstract class ClaseDeUnidad {
    public HashMap<Accion, AccionesDeClasedeUnidad> accion;

    public ClaseDeUnidad() {
        this.accion = new HashMap<>();
    }

    public void actuar(Accion accion, Unidad objetivo, Unidad actor) {
        this.accion.get(accion).actuar(objetivo, actor);
    }
}
