package fiuba.algo3.algocraft.comandos;

import fiuba.algo3.algocraft.unidades.Unidad;

public class AccionAtacar extends AccionesDeClasedeUnidad {
    @Override
    public void actuar(Unidad objetivo, Unidad actor) {
        objetivo.recibirDanio(actor);
    }
}
