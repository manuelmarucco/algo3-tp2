package fiuba.algo3.algocraft.unidades;

import fiuba.algo3.algocraft.comandos.Accion;
import fiuba.algo3.algocraft.comandos.AccionAtacar;

import java.util.HashMap;

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
        parametros.put(Parametros.AEREO,danio.getAire());
        parametros.put(Parametros.TERRESTRE, danio.getTierra());
        parametros.put(Parametros.RANGO, danio.getRango());
        return parametros;
    }
}
