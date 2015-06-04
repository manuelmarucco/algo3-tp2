package unidades.protoss;

import interfaces.Daniable;
import unidades.Danio;
import unidades.Escudo;
import unidades.Terrestre;

public class Zealot extends UnidadProtoss {

    private static Danio Danio= new Danio(8,0,1,0);//por si agregan las mejoras a los atributos

    public Zealot(){
        super(60,100);
        this.vision=7;
        this.ubicacion= new Terrestre();
        this.suministro = 2;
    }

    @Override
    public void update() {
        this.escudo.regenerar();
    }

    @Override
    public void recibirDanio(Danio danio) {
        this.vida.quitar(this.escudo.quitar(danio.getDanioTierra()));
    }

    public void atacar(Daniable objetivo){
        objetivo.recibirDanio(this.Danio);
    }

    public Escudo getEscudo() {
        return escudo;
    }
}
