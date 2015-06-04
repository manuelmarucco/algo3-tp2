package unidades.protoss;

import interfaces.Daniable;
import unidades.Aereo;
import unidades.Danio;

public class Scout extends UnidadProtoss {

    private static Danio Danio= new Danio(8,14,4,4);//por si agregan las mejoras a los atributos

    public Scout(){
        super(100,150);
        this.vision=7;
        this.ubicacion= new Aereo();
        this.suministro = 3;
    }

    @Override
    public void update() {
        this.escudo.regenerar();
    }

    @Override
    public void recibirDanio(Danio danio) {
        this.vida.quitar(this.escudo.quitar(danio.getDanioAire()));
    }

    public void atacar(Daniable objetivo){
        objetivo.recibirDanio(this.Danio);
    }
}
