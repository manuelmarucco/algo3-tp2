package manejoDeUnidades;

import interfaces.Actuable;

import java.util.HashMap;
import java.util.Set;

import manejoDeUnidades.comandos.Accion;

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
