package modelo.unidades.terrran;

import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.jugabilidad.Mapa;
import modelo.jugabilidad.auxiliares.Costo;
import modelo.jugabilidad.auxiliares.Vision;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.unidades.Aereo;
import modelo.unidades.UnidadTransporte;

public class NaveTransporteTerran extends UnidadTransporte {

    public NaveTransporteTerran(){
        super(new ResistenciaTerran(150),8,new Aereo(),2,new Costo(100,100),7,6);
    }

    public NaveTransporteTerran(Vision visionJugador){
        super(new ResistenciaTerran(150),8,new Aereo(),2,new Costo(100,100),7,6,visionJugador,0);
    }

    @Override
    public void moverse(Coordenada hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa {

        mapa.moverEnCapaAerea(this, hasta);

    }
}