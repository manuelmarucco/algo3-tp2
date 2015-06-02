package unidades;

import interfaces.Actuable;

import java.util.HashMap;

import unidades.comandos.Accion;
import unidades.comandos.AccionAtacar;

public class UnidadGuerrera extends ClaseDeUnidad {

    private final Danio danio;

    public UnidadGuerrera(Danio danio) {
        super();
        this.accion.put(Accion.ATACAR, new AccionAtacar(danio));
        this.danio =danio;
    }

    @Override
    public HashMap<Parametros, Integer> getParametros() {
        HashMap<Parametros, Integer> parametros = new HashMap<Parametros, Integer>();
        parametros.put(Parametros.AEREO,danio.getDanioAire());
        parametros.put(Parametros.TERRESTRE, danio.getDanioTierra());
        parametros.put(Parametros.RANGOAEREO, danio.getRangoAereo());
        parametros.put(Parametros.RANGOTERRESTRE, danio.getRangoTerrestre());
        return parametros;
    }

    @Override
    public void agregarMetodosUpdate(HashMap<Accion, Actuable> poolDeAcciones) {
    }
}
