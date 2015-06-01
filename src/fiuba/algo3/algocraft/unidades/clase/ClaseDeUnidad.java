package fiuba.algo3.algocraft.unidades.clase;

import fiuba.algo3.algocraft.comandos.Accion;
import fiuba.algo3.algocraft.unidades.parametros.Parametros;
import fiuba.algo3.algocraft.unidades.Unidad;
import interfaces.Actuable;

import java.util.HashMap;
import java.util.Set;

public abstract class ClaseDeUnidad {
    public HashMap<Accion, Actuable> accion;

    public ClaseDeUnidad() {
        this.accion = new HashMap<Accion, Actuable>();
    }

    public void setAccion(Accion nombre, Actuable accion) {
        this.accion.put(nombre, accion);
    }

    public void actuar(Accion accion, Unidad objetivo) {
        this.accion.get(accion).actuar(objetivo);
    }

    public Set<Accion> getAcciones() {
        return this.accion.keySet();
    }

    public abstract HashMap<Parametros,Integer> getParametros();

    public abstract void agregarMetodosUpdate(HashMap<Accion, Actuable> poolDeAcciones);
}
