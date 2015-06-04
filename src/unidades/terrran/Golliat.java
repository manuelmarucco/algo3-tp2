package unidades.terrran;

import interfaces.Daniable;
import unidades.Danio;
import unidades.Terrestre;

public class Golliat extends UnidadTerran {

    private static Danio Danio= new Danio(12,10,6,5);//por si agregan las mejoras a los atributos

    public Golliat(){
        super(125);
        this.vision = 8;
        this.ubicacion = new Terrestre();
        this.suministro = 2;
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
        objetivo.recibirDanio(this.Danio);
    }

}
