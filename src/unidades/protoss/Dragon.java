package unidades.protoss;

import interfaces.Atacante;
import interfaces.Cargable;
import interfaces.ColocableEnMapa;
import interfaces.Daniable;
import jugabilidad.auxiliares.Costo;
import unidades.Danio;
import unidades.Terrestre;

public class Dragon extends UnidadProtoss implements Atacante , Cargable {

    private static Danio Danio= new Danio(20,20,4,4);//por si agregan las mejoras a los atributos

    public Dragon(){
        super(80,100);
        this.vision=8;
        this.ubicacion= new Terrestre();
        this.suministro=2;
        this.costo=new Costo(125,50);
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

    @Override
    public ColocableEnMapa getClone() {
        return null;// TODO:implementar
    }

    @Override
    public int getTransporte() {
        return 0;
    }

    @Override
    public void quitarse() {

    }
}
