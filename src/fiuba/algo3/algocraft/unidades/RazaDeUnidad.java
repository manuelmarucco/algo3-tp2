package fiuba.algo3.algocraft.unidades;

import fiuba.algo3.algocraft.comandos.AccionesDeRazaDeUnidad;

import java.util.Map;
import java.util.Set;

public abstract class RazaDeUnidad {
    protected Map<String,AccionesDeRazaDeUnidad> acciones;

    public abstract Map<String,Integer> getAtributos();

    public abstract String nombre();

    public abstract int recibirDanio(int danioParcial);

    public abstract Set<String> getAcciones();

    public void actuar(String acciones){
            this.acciones.get(acciones).actuar(this);
    }
}
