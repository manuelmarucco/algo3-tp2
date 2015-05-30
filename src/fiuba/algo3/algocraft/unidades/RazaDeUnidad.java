package fiuba.algo3.algocraft.unidades;

import java.util.Map;

public abstract class RazaDeUnidad {
    public abstract Map<String, Integer> getAtributos();

    public abstract String nombre();

    public abstract int recibirDanio(int danioParcial);
}
