package unidades.terrran;

import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Vision;
import unidades.Aereo;
import unidades.UnidadTransporte;

public class NaveTransporteTerran extends UnidadTransporte {

    public NaveTransporteTerran(){
        super(new ResistenciaTerran(150),8,new Aereo(),2,new Costo(100,100),7,6);
    }

    public NaveTransporteTerran(Vision visionJugador){
        super(new ResistenciaTerran(150),8,new Aereo(),2,new Costo(100,100),7,6,visionJugador);
    }
}