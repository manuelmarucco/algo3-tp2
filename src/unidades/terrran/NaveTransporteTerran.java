package unidades.terrran;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Vision;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Aereo;
import unidades.UnidadTransporte;

public class NaveTransporteTerran extends UnidadTransporte {

    public NaveTransporteTerran(){
        super(new ResistenciaTerran(150),8,new Aereo(),2,new Costo(100,100),7,6);
    }

    public NaveTransporteTerran(Vision visionJugador){
        super(new ResistenciaTerran(150),8,new Aereo(),2,new Costo(100,100),7,6,visionJugador,0);
    }

    @Override
    public void moverse(Coordenadas hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa {

        mapa.moverEnCapaAerea(this, hasta);

    }
}