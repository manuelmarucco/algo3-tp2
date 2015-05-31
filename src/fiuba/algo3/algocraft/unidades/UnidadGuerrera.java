package fiuba.algo3.algocraft.unidades;

import fiuba.algo3.algocraft.comandos.Accion;
import fiuba.algo3.algocraft.comandos.AccionAtacar;

public class UnidadGuerrera extends ClaseDeUnidad {

    public UnidadGuerrera(Danio danio) {
        super();
        this.accion.put(Accion.ATACAR, new AccionAtacar(danio));
    }
}
