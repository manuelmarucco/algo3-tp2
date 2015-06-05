package unidades.protoss;

import interfaces.ColocableEnMapa;
import unidades.Escudo;
import unidades.Unidad;
import unidades.Vida;

public abstract class UnidadProtoss extends Unidad {

    protected Escudo escudo;

    public UnidadProtoss(int vida, int escudo){
        super();
        this.vida= new Vida(vida);
        this.escudo = new Escudo(escudo);
    }

    public Escudo getEscudo() {
        return escudo;
    }

    public ColocableEnMapa getClone(){
        return new Clon(this.vida,this.escudo,this.vision,this.ubicacion);
    };

    public  void recibirEMP(){
        this.escudo.quitar(this.escudo.getEscudoActual());
    }
}
