package fiuba.algo3.algocraft.comandos;

import fiuba.algo3.algocraft.unidades.Energia;
import fiuba.algo3.algocraft.unidades.Unidad;

public class AccionRegenerarEnergia extends AccionDeClase {
    private final Energia energia;

    public AccionRegenerarEnergia(Energia energia) {
        super();
        this.energia=energia;
    }

    @Override
    public void actuar(Unidad objetivo) {
        this.energia.regenerar();
    }
}
