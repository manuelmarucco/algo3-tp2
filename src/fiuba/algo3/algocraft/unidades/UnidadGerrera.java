package fiuba.algo3.algocraft.unidades;

import fiuba.algo3.algocraft.comandos.AccionAtacar;
import fiuba.algo3.algocraft.comandos.AccionesDeClasedeUnidad;

import java.util.HashMap;

public class UnidadGerrera extends ClaseDeUnidad {

    public UnidadGerrera(){
        this.accion=new HashMap<String, AccionesDeClasedeUnidad>();
        this.accion.put("atacar",new AccionAtacar());
    }
}
