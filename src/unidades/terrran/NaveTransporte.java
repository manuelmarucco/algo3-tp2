package unidades.terrran;

import unidades.Aereo;
import unidades.Danio;

public class NaveTransporte extends UnidadTerran {

    private static int TranporteMax = 8;

    public NaveTransporte(){
        super(150);
        this.vision = 8;
        this.ubicacion = new Aereo();
        this.suministro = 2;
    }

    @Override
    public void update() {
       //TODO:ver si hace algo
    }

    @Override
    public void recibirDanio(Danio danio) {
        this.vida.quitar(danio.getDanioAire());
    }

    public void cargar(){
        //TODO: implementar
    }

    public void descargar(){
        //TODO: implementar
    }
}