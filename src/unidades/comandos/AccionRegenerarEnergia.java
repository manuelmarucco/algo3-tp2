package unidades.comandos;

import unidades.Energia;
import unidades.Unidad;
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
