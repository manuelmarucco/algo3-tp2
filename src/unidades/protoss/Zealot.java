package unidades.protoss;

import interfaces.Atacante;
import interfaces.Cargable;
import interfaces.ColocableEnMapa;
import interfaces.Daniable;
import jugabilidad.auxiliares.Costo;
import unidades.Danio;
import unidades.Escudo;
import unidades.Terrestre;

public class Zealot extends UnidadProtoss implements Atacante , Cargable {

    private static Danio Danio= new Danio(8,0,1,0);//por si agregan las mejoras a los atributos

    public Zealot(){
        super(60,100);
        this.vision=7;
        this.ubicacion= new Terrestre();
        this.suministro = 2;
        this.costo=new Costo(100,0);
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
        objetivo.recibirDanio(Danio);
    }

    public Escudo getEscudo() {
        return escudo;
    }

    @Override
    public ColocableEnMapa getClone() {
        return null; // TODO:implementar
    }

    @Override
    public int getTransporte() {
        return 0;
    }

    @Override
    public void quitarse() {

    }
}
