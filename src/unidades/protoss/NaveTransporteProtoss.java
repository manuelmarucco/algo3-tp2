package unidades.protoss;

import interfaces.ColocableEnMapa;
import jugabilidad.auxiliares.Costo;
import unidades.Aereo;
import unidades.Danio;
import unidades.UnidadTransporte;

public class NaveTransporteProtoss extends UnidadTransporte {

    public NaveTransporteProtoss(){
        super(new ResistenciaProtoss(80,60),8,new Aereo(),2,new Costo(200,0),8);
    }

    @Override
    public void recibirDanio(Danio danio) {
        this.resistencia.quitar(danio.getDanioAire());
    }

    public ColocableEnMapa getClone() {
        return null;// TODO:implementar
    }

    public int getEscudo() {
        return ((ResistenciaProtoss)resistencia).getEscudoActual();
    }
}