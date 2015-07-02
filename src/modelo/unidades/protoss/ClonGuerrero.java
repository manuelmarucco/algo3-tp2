package modelo.unidades.protoss;

import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.unidades.Unidad;
import modelo.unidades.Ubicacion;

public class ClonGuerrero extends Clon {
    public ClonGuerrero(ResistenciaProtoss resistencia, int vision, Ubicacion ubicacion, int movilidad,int trasnporte, Unidad unidad) {
        super(resistencia, vision, ubicacion, movilidad,trasnporte,unidad);
    }

    public void atacarAire(Coordenada c) {

    }

    public void atacarTierra(Coordenada c) {

    }

    public void atacar(Coordenada coordenada) {

    }
}
