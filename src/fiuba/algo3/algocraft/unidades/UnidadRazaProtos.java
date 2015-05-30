package fiuba.algo3.algocraft.unidades;

import fiuba.algo3.algocraft.comandos.AccionRegenerar;
import fiuba.algo3.algocraft.comandos.AccionesDeRazaDeUnidad;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UnidadRazaProtos extends RazaDeUnidad {
    private int escudo;
    private int regeneracion;

    public UnidadRazaProtos(int escudo, int regeneracion) {
        this.escudo=escudo;
        this.regeneracion=regeneracion;
        this.acciones=new HashMap<String, AccionesDeRazaDeUnidad>();
        this.acciones.put("regenerar",new AccionRegenerar());
    }

    public Map<String, Integer> getAtributos() {
        Map<String,Integer> atributos = new HashMap<String,Integer>();
        atributos.put("escudo",escudo);
        atributos.put("regeneracion",regeneracion);
        return atributos;
    }

    public String nombre() {
        return "protos";
    }

    public int recibirDanio(int danioParcial) {
        int danioALaVida= danioParcial-this.escudo;
        this.escudo-=danioParcial;
        if (this.escudo<=0){
            escudo=0;
            return danioALaVida;
        }
        return 0;
    }

    @Override
    public Set<String> getAcciones() {
        return this.acciones.keySet();
    }

}
