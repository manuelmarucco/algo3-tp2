package unidades.protoss;

import interfaces.ColocableEnMapa;
import unidades.Danio;
import unidades.Escudo;
import unidades.Unidad;
import unidades.Vida;

public abstract class UnidadProtoss extends Unidad {

    protected Escudo escudo;

    public UnidadProtoss(int escudo, int vida){
        super();
        this.vida= new Vida(vida);
        this.escudo = new Escudo(escudo);
    }

    public Escudo getEscudo() {
        return escudo;
    }

    public ColocableEnMapa getClone(){
        return new Clon(this.vida,this.escudo,this.vision,this.ubicacion);
    }

    public  void recibirEMP(){
        this.escudo.quitar(this.escudo.getEscudoActual());
    }

    public void recibirDanio(Danio danio) {
        this.vida.quitar(this.escudo.quitar(danio.getDanioTierra()));
    }
}
