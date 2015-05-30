package fiuba.algo3.algocraft.unidades;

import java.util.HashMap;
import java.util.Map;

public class UnidadRazaProtos implements RazaDeUnidad {
    private final int escudo;
    private final int regeneracion;

    public UnidadRazaProtos(int escudo, int regeneracion) {
        this.escudo=escudo;
        this.regeneracion=regeneracion;
    }

    @Override
    public Map<String, Integer> getAtributos() {
        Map<String,Integer> atributos = new HashMap<String,Integer>();
        atributos.put("escudo",escudo);
        atributos.put("regeneracion",regeneracion);
        return atributos;
    }
}
