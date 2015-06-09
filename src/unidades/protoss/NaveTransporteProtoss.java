package unidades.protoss;

import interfaces.ColocableEnMapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Vision;
import unidades.Aereo;
import unidades.UnidadTransporte;

public class NaveTransporteProtoss extends UnidadTransporte {

    public NaveTransporteProtoss(){
        super(new ResistenciaProtoss(80,60),8,new Aereo(),2,new Costo(200,0),8,6);
    }

    public NaveTransporteProtoss(Vision visionJugador){
        super(new ResistenciaProtoss(80,60),8,new Aereo(),2,new Costo(200,0),8,6,visionJugador);
    }

    public ColocableEnMapa getClone() {
        return null;// TODO:implementar
    }

    public int getEscudo() {
        return ((ResistenciaProtoss)resistencia).getEscudoActual();
    }
}