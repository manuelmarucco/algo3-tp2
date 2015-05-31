package fiuba.algo3.algocraft.unidades;

import fiuba.algo3.algocraft.comandos.AccionAtacar;
import fiuba.algo3.algocraft.comandos.AccionesDeClasedeUnidad;

import java.util.HashMap;

public class UnidadGerrera extends ClaseDeUnidad {

    public UnidadGerrera(){
        super();
        this.accion.put(Accion.ATACAR, new AccionAtacar());
    }
}
