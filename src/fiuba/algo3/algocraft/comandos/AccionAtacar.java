package fiuba.algo3.algocraft.comandos;

import fiuba.algo3.algocraft.unidades.Danio;
import fiuba.algo3.algocraft.unidades.Unidad;

public class AccionAtacar extends AccionDeClase {

    private final Danio danio;

    public AccionAtacar(Danio danio) {
        this.danio = danio;
    }
    @Override
    public void actuar(Unidad objetivo) {
        objetivo.recibirDanio(danio);
    }
}
