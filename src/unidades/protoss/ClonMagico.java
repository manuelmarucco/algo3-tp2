package unidades.protoss;

import interfaces.ColocableEnMapa;
import unidades.Energia;
import unidades.Escudo;
import unidades.Ubicacion;
import unidades.Vida;

public class ClonMagico extends Clon implements ColocableEnMapa {
    private final Energia energia;

    public ClonMagico(Vida vida, Energia energia, Escudo escudo, int vision, Ubicacion ubicacion) {
        super(vida,escudo,vision,ubicacion);
        this.energia=energia;
    }
}
