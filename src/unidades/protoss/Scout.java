package unidades.protoss;

import interfaces.ColocableEnMapa;
import jugabilidad.auxiliares.Costo;
import unidades.Aereo;
import unidades.Danio;
import unidades.UnidadGuerrera;

public class Scout extends UnidadGuerrera {

    public Scout(){
        super(new ResistenciaProtoss(150,100),new Danio(8,14,4,4),7,new Aereo(),3,new Costo(300,150),9);
    }

    public ColocableEnMapa getClone() {
        return null;// TODO:implementar
    }

    public int getEscudo() {
        return ((ResistenciaProtoss)resistencia).getEscudoActual();
    }

}
