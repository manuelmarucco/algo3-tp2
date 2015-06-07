package unidades.protoss;

import interfaces.Atacante;
import interfaces.ColocableEnMapa;
import jugabilidad.auxiliares.Costo;
import unidades.Aereo;
import unidades.Danio;
import unidades.UnidadGuerrera;

public class Scout extends UnidadGuerrera implements Atacante {


    private ResistenciaProtoss escudo;

    public Scout(){
        super(new ResistenciaProtoss(100,150),new Danio(8,14,4,4),7,new Aereo(),3,new Costo(300,150),9);
    }

    @Override
    public void recibirDanio(Danio danio) {
        this.resistencia.quitar(danio.getDanioAire());
    }

    public ColocableEnMapa getClone() {
        return null;// TODO:implementar
    }

    public ResistenciaProtoss getEscudo() {
        return escudo;
    }
}
