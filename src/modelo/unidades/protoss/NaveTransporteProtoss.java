package modelo.unidades.protoss;

import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.interfaces.Clonable;
import modelo.interfaces.ColocableEnMapa;
import modelo.jugabilidad.Mapa;
import modelo.jugabilidad.auxiliares.Costo;
import modelo.jugabilidad.auxiliares.Vision;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.unidades.Aereo;
import modelo.unidades.UnidadTransporte;

public class NaveTransporteProtoss extends UnidadTransporte implements Clonable {

    public NaveTransporteProtoss(){
        super(new ResistenciaProtoss(80,60),8,new Aereo(),2,new Costo(200,0),8,6);
    }

    public NaveTransporteProtoss(Vision visionJugador){
        super(new ResistenciaProtoss(80,60),8,new Aereo(),2,new Costo(200,0),8,6,visionJugador,0);
    }

    public ColocableEnMapa getClon() {
        ResistenciaProtoss resistenciaProtoss = new ResistenciaProtoss(resistencia.getVidaMaxima(),((ResistenciaProtoss) resistencia).getEscudoActual());

        return new ClonTransporte(resistenciaProtoss,this.vision,this.ubicacion,this.movilidad,this.transporte, this);
    }

    public int getEscudo() {
        return ((ResistenciaProtoss)resistencia).getEscudoActual();
    }

    @Override
    public void moverse(Coordenada hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa {

        mapa.moverEnCapaAerea(this, hasta);

    }

    @Override
    public  void recibirEMP(){
        this.resistencia.quitar(this.getEscudo());
    }
}