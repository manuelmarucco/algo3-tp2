package unidades.terrran;

import interfaces.Atacante;
import interfaces.Cargable;
import interfaces.Daniable;
import jugabilidad.auxiliares.Costo;
import unidades.Danio;
import unidades.Terrestre;

public class Golliat extends UnidadTerran implements Atacante, Cargable {

    private static Danio Danio= new Danio(12,10,6,5);//por si agregan las mejoras a los atributos

    public Golliat(){
        super(125);
        this.vision = 8;
        this.ubicacion = new Terrestre();
        this.suministro = 2;
        this.costo=new Costo(100,50);
    }

    @Override
    public void update() {
        //TODO ver si hace algo entre turnos;
    }

    @Override
    public void recibirDanio(Danio danio) {
        this.vida.quitar(danio.getDanioTierra());
    }

    public void atacar(Daniable objetivo){
        objetivo.recibirDanio(Danio);
    }

    @Override
    public int getTransporte() {
        return 0;
    }

    @Override
    public void quitarse() {

    }
}
