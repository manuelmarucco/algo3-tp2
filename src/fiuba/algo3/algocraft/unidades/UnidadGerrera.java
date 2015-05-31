package fiuba.algo3.algocraft.unidades;

import fiuba.algo3.algocraft.comandos.Accion;
import fiuba.algo3.algocraft.comandos.AccionAtacar;

public class UnidadGerrera extends ClaseDeUnidad {

    public UnidadGerrera(Danio danio) {
        super();
        this.accion.put(Accion.ATACAR, new AccionAtacar(danio));
    }
}
