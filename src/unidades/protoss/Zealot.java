package unidades.protoss;

import interfaces.Cargable;
import interfaces.ColocableEnMapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Vision;
import unidades.Danio;
import unidades.Terrestre;
import unidades.UnidadGuerrera;

public class Zealot extends UnidadGuerrera implements Cargable {

    public Zealot(Vision visionJugador){
        super(new ResistenciaProtoss(100,60),new Danio(8,0,1,0),7,new Terrestre(),2,new Costo(100,0),4,5,visionJugador);
    }

    public Zealot(){
        super(new ResistenciaProtoss(100,60),new Danio(8,0,1,0),7,new Terrestre(),2,new Costo(100,0),4,5);
    }

    @Override
    public void update() {
        this.resistencia.regenerar();
    }

    public int getEscudo() {
        return ((ResistenciaProtoss)resistencia).getEscudoActual();
    }

    public ColocableEnMapa getClone() {
        return null; // TODO:implementar
    }

    @Override
    public int getTransporte() {
        return 0;
    }

    @Override
    public void quitarse() {

    }
}
