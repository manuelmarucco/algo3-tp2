package fiuba.algo3.algocraft.unidades;

import fiuba.algo3.algocraft.comandos.Accion;
import fiuba.algo3.algocraft.comandos.AccionDeClase;

import java.util.HashMap;

public abstract class ClaseDeUnidad {
    public HashMap<Accion, AccionDeClase> accion;

    public ClaseDeUnidad() {
        this.accion = new HashMap<>();
    }

    public void actuar(Accion accion, Unidad objetivo, Unidad actor) {
        this.accion.get(accion).actuar(objetivo, actor);
    }
}
