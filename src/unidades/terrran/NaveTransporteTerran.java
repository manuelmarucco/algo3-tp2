package unidades.terrran;

import jugabilidad.auxiliares.Costo;
import unidades.Aereo;
import unidades.Danio;
import unidades.UnidadTransporte;

public class NaveTransporteTerran extends UnidadTransporte {

    public NaveTransporteTerran(){
        super(new ResistenciaTerran(150),8,new Aereo(),2,new Costo(100,100),7);
    }

    @Override
    public void recibirDanio(Danio danio) {
        this.resistencia.quitar(danio.getDanioAire());
    }

}