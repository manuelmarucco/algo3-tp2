package unidades.protoss;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Vision;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Aereo;
import unidades.UnidadTransporte;

public class NaveTransporteProtoss extends UnidadTransporte {

    public NaveTransporteProtoss(){
        super(new ResistenciaProtoss(80,60),8,new Aereo(),2,new Costo(200,0),8,6);
    }

    public NaveTransporteProtoss(Vision visionJugador){
        super(new ResistenciaProtoss(80,60),8,new Aereo(),2,new Costo(200,0),8,6,visionJugador,0);
    }

    public ColocableEnMapa getClone() {
        return new ClonTransporte((ResistenciaProtoss)this.resistencia,this.vision,this.ubicacion,this.movilidad,this.transporte);
    }

    public int getEscudo() {
        return ((ResistenciaProtoss)resistencia).getEscudoActual();
    }

    @Override
    public void moverse(Coordenadas hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa {

        mapa.moverEnCapaAerea(this, hasta);

    }
}