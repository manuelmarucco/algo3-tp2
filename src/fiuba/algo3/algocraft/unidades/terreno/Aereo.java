package fiuba.algo3.algocraft.unidades.terreno;

import fiuba.algo3.algocraft.unidades.parametros.Danio;
import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public class Aereo implements Ubicacion {
    public int danioDe(Danio danio) {
        return danio.getAire();
    }

    @Override
    public void agregarse(ColocableEnMapa unidad,Mapa mapa, Coordenadas coordenadas) {
        mapa.agregarCapaAerea(unidad, coordenadas);
    }
}
