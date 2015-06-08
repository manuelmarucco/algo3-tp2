package unidades.terrran;

import jugabilidad.auxiliares.Costo;
import unidades.Aereo;
import unidades.UnidadTransporte;

public class NaveTransporteTerran extends UnidadTransporte {

    public NaveTransporteTerran(){
        super(new ResistenciaTerran(150),8,new Aereo(),2,new Costo(100,100),7);
    }

}