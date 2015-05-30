package fiuba.algo3.algocraft.unidades;

import java.util.HashMap;
import java.util.Map;

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
}
