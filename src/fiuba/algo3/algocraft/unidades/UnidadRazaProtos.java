package fiuba.algo3.algocraft.unidades;

import java.util.HashMap;
import java.util.Map;

public class UnidadRazaProtos extends RazaDeUnidad {
    private int escudo;
    private int regeneracion;

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

    @Override
    public String nombre() {
        return "protos";
    }

    @Override
    public int recibirDanio(int danioParcial) {
        int danioALaVida= danioParcial-this.escudo;
        this.escudo-=danioParcial;
        if (this.escudo<=0){
            escudo=0;
            return danioALaVida;
        }
        return 0;
    }
}
