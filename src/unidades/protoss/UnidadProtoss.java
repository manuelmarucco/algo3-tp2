package unidades.protoss;

import unidades.Escudo;
import unidades.Unidad;
import unidades.Vida;

public abstract class UnidadProtoss extends Unidad {

    protected Escudo escudo;

    public UnidadProtoss(int vida, int escudo){
        this.vida= new Vida(vida);
        this.escudo = new Escudo(escudo);
    }

    public Escudo getEscudo() {
        return escudo;
    }
}
