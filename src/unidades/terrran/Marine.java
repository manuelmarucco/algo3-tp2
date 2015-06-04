package unidades.terrran;

import interfaces.Daniable;
import unidades.Danio;
import unidades.Terrestre;

public class Marine extends UnidadTerran {

    private static Danio Danio= new Danio(6,6,4,4);//por si agregan las mejoras a los atributos

    public Marine(){
        super(40);
        this.vision = 7;
        this.ubicacion = new Terrestre();
        this.suministro = 1;
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
