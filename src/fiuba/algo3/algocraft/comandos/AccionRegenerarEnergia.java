package fiuba.algo3.algocraft.comandos;

import fiuba.algo3.algocraft.unidades.Energia;
import fiuba.algo3.algocraft.unidades.Unidad;
import interfaces.Actuable;

public class AccionRegenerarEnergia implements Actuable {
    private final Energia energia;

    public AccionRegenerarEnergia(Energia energia) {
        this.energia=energia;
    }

    @Override
    public void actuar(Unidad objetivo) {
        this.energia.regenerar();
    }

}
