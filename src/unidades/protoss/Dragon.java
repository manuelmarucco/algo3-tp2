package unidades.protoss;

import interfaces.Cargable;
import interfaces.ColocableEnMapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Vision;
import unidades.Danio;
import unidades.Terrestre;
import unidades.UnidadGuerrera;

public class Dragon extends UnidadGuerrera implements Cargable {

    public Dragon(){
        super(new ResistenciaProtoss(100, 80), new Danio(20, 20, 4, 4), 8, new Terrestre(), 2, new Costo(125, 50), 6,6);
    }

    public Dragon(Vision visionJugador){
        super(new ResistenciaProtoss(100, 80), new Danio(20, 20, 4, 4), 8, new Terrestre(), 2, new Costo(125, 50), 6,6,visionJugador);
    }

    public ColocableEnMapa getClone() {
        return null;// TODO:implementar
    }

    @Override
    public int getTransporte() {
        return 4;
    }

    @Override
    public void quitarse() {

    }

    public int getEscudo() {
        return ((ResistenciaProtoss)resistencia).getEscudoActual();
    }
}
