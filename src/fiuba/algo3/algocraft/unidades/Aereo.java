package fiuba.algo3.algocraft.unidades;

import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public class Aereo implements Ubicacion {
    public int danioDe(Danio danio) {
        return danio.getDanioAire();
    }

    @Override
    public void agregarse(ColocableEnMapa unidad,Mapa mapa, Coordenadas coordenadas) {
        mapa.agregarEnAire(unidad,coordenadas);
    }
}
