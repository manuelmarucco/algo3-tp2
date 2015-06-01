package construcciones.comandos;

import auxiliares.Costo;
import excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.unidades.Unidad;
import fiuba.algo3.algocraft.unidades.clase.UnidadGuerrera;
import fiuba.algo3.algocraft.unidades.parametros.Danio;
import fiuba.algo3.algocraft.unidades.parametros.Vida;
import fiuba.algo3.algocraft.unidades.terreno.Terrestre;
import interfaces.AccionConstruir;
import jugabilidad.Jugador;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public class ConstruirMarine implements AccionConstruir {
    private final Jugador jugador;
    private final Mapa mapa;

    public ConstruirMarine(Jugador jugador, Mapa mapa) {
        this.jugador=jugador;
        this.mapa=mapa;
    }

    @Override
    public void actuar(Coordenadas coordenadas) {
        Unidad marine = new Unidad(new Vida(40),7,new Terrestre(),new UnidadGuerrera(new Danio(6,6,4)));
        try {
            this.jugador.getRecursos().gastarRecursos(new Costo(50,0));
        } catch (ExcepcionRecursosInsuficientes excepcionRecursosInsuficientes) {
            excepcionRecursosInsuficientes.printStackTrace();
            return;
        }
        this.mapa.agregar(marine,coordenadas);
    }
}
