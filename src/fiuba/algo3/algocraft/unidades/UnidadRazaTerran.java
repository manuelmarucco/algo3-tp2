package fiuba.algo3.algocraft.unidades;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UnidadRazaTerran extends RazaDeUnidad {
    @Override
    public Map<String, Integer> getAtributos() {
        return new HashMap<String, Integer>();
    }

    @Override
    public String nombre() {
        return "terran";
    }

    @Override
    public int recibirDanio(int danioParcial) {
        return danioParcial;
    }

    @Override
    public Set<String> getAcciones() {
        return this.acciones.keySet();
    }

}
