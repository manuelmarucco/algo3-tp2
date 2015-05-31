package fiuba.algo3.algocraft.comandos;

import fiuba.algo3.algocraft.unidades.Danio;
import fiuba.algo3.algocraft.unidades.Unidad;
import interfaces.Actuable;

public class AccionAtacar implements Actuable  {

    private final Danio danio;

    public AccionAtacar(Danio danio) {
        this.danio = danio;
    }
    @Override
    public void actuar(Unidad objetivo) {
        objetivo.recibirDanio(danio);
    }
}
