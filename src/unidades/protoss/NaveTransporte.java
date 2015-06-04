package unidades.protoss;

import interfaces.ColocableEnMapa;
import jugabilidad.auxiliares.Costo;
import unidades.Aereo;
import unidades.Danio;

public class NaveTransporte extends UnidadProtoss {
    private static int TranporteMax = 8;

    public NaveTransporte(){
        super(60,80);
        this.vision = 8;
        this.ubicacion = new Aereo();
        this.suministro=2;
        this.costo=new Costo(200,0);
    }

    @Override
    public void update() {
        this.escudo.regenerar();
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

    @Override
    public ColocableEnMapa getClone() {
        return null;// TODO:implementar
    }
}