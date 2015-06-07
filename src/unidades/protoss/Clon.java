package unidades.protoss;

import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;
import jugabilidad.ProxyMapa;
import unidades.Danio;
import unidades.Escudo;
import unidades.Ubicacion;
import unidades.Vida;

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
        //this.escudo.quitar(this.ubicacion.);ver el tipo de danio q recibe
        this.matar();
    }
    @Override
    protected void matar(){
        if(this.escudo.getEscudoActual()==0){
            ProxyMapa mapa = ProxyMapa.getInstance();
            mapa.quitar(this);
        }
    }

    public  void recibirEMP(){
        this.escudo.quitar(this.escudo.getEscudoActual());
        this.matar();
    }
}
