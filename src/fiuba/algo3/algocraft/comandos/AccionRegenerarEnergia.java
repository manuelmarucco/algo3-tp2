package fiuba.algo3.algocraft.comandos;

import fiuba.algo3.algocraft.unidades.parametros.Energia;
import interfaces.Actuable;
import interfaces.Targeteable;

public class AccionRegenerarEnergia implements Actuable {
    private final Energia energia;

    public AccionRegenerarEnergia(Energia energia) {
        super();
        this.energia=energia;
    }

    @Override
    public void actuar(Targeteable objetivo) {
        this.energia.regenerar();
    }

}
