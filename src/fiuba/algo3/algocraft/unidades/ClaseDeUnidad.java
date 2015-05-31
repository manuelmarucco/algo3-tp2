package fiuba.algo3.algocraft.unidades;

import fiuba.algo3.algocraft.comandos.Accion;
import fiuba.algo3.algocraft.comandos.AccionDeClase;

import java.util.HashMap;
import java.util.Set;

public abstract class ClaseDeUnidad {
    public HashMap<Accion, AccionDeClase> accion;

    public ClaseDeUnidad() {
        this.accion = new HashMap();
    }

    public void setAccion(Accion nombre, AccionDeClase accion) {
        this.accion.put(nombre, accion);
    }

    public void actuar(Accion accion, Unidad objetivo) {
        this.accion.get(accion).actuar(objetivo);
    }

    public Set<Accion> getAcciones() {
        return this.accion.keySet();
    }
}
