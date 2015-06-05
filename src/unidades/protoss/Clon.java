package unidades.protoss;

import interfaces.ColocableEnMapa;
import unidades.*;

/**
 * Created by coco on 05/06/15.
 */
public class Clon extends UnidadProtoss implements ColocableEnMapa {

    public Clon(Vida vida, Escudo escudo, int vision, Ubicacion ubicacion) {
        super(0,0);
        this.vida= vida;
        this.escudo = escudo;
        this.vision=vision;
        this.ubicacion= ubicacion;
    }

    @Override
    public ColocableEnMapa getClone() {
        return null;
    }

    @Override
    public void recibirDanio(Danio danio) {
        this.matar();
    }
    @Override
    public void matar(){
        if(this.escudo.getEscudoActual()==0){
            //Mapa mapa =SingletonMapa.getInstance();
            //mapa.Quitar(this);
        }
    }

    public  void recibirEMP(){
        this.escudo.quitar(this.escudo.getEscudoActual());
        this.matar();
    }
}
