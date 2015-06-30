package unidades;

import excepciones.Unidades.ExcepcionAtacarAUnidadAliada;
import excepciones.Unidades.ExcepcionDeAccionDeUnidad;
import excepciones.Unidades.ExcepcionObjetivoFueraDeRango;
import interfaces.ColocableEnMapa;
import interfaces.Daniable;
import jugabilidad.Jugador;
import jugabilidad.ProxyMapa;
import jugabilidad.utilidadesMapa.Coordenada;

import java.util.ArrayList;

public class ProxiDeAtaque {
    private static ArrayList<Jugador> jugadores= new ArrayList<>();

    public static void inicializar(Jugador jugador){
        jugadores.add(jugador);
    }

    public void agregarJugador(Jugador jugador){
        jugadores.add(jugador);
    }

    public static void atacarTierra(UnidadGuerrera atacante, Daniable defensor) throws ExcepcionDeAccionDeUnidad {
        ProxiDeAtaque.comprobarRangoTerrestre(atacante, defensor);
        ProxiDeAtaque.comprobarDuenioDeUnidad(atacante, defensor);
        ProxiDeAtaque.comprobarDuenioDeEdificio(atacante, defensor);
        defensor.recibirDanio(atacante.getDanioTerrestre());
    }

    public static void atacarAire(UnidadGuerrera atacante,Daniable defensor) throws ExcepcionDeAccionDeUnidad {
        ProxiDeAtaque.comprobarRangoAereo(atacante, defensor);
        ProxiDeAtaque.comprobarDuenioDeUnidad(atacante, defensor);
        defensor.recibirDanio(atacante.getDanioAereo());
    }

    public static void comprobarRangoAereo(UnidadGuerrera atacante,Daniable defensor) throws ExcepcionDeAccionDeUnidad {
        ProxyMapa mapa = ProxyMapa.getInstance();
        Coordenada c1=mapa.getCoordenada(atacante);
        Coordenada c2=mapa.getCoordenada((ColocableEnMapa)defensor);
        if(c1.distancia(c2)> atacante.getRangoAereo()) throw new ExcepcionObjetivoFueraDeRango();

    }
    public static void comprobarRangoTerrestre(UnidadGuerrera atacante,Daniable defensor) throws ExcepcionDeAccionDeUnidad {
        ProxyMapa mapa = ProxyMapa.getInstance();
        Coordenada c1=mapa.getCoordenada(atacante);
        Coordenada c2=mapa.getCoordenada((ColocableEnMapa)defensor);
        if(c1.distancia(c2)> atacante.getRangoTerrestre()) throw new ExcepcionObjetivoFueraDeRango();

    }
    public static void comprobarDuenioDeUnidad(Object atacante,Object defensor) throws ExcepcionDeAccionDeUnidad {
        for(Jugador j:jugadores){
            if(j.buscarUnidad(atacante)&& j.buscarUnidad(defensor)) throw new ExcepcionAtacarAUnidadAliada();
            if(j.buscarUnidad(atacante)&& j.buscarUnidad(defensor)) throw new ExcepcionAtacarAUnidadAliada();

        }
    }

    public static void comprobarDuenioDeEdificio(Object atacante,Object defensor) throws ExcepcionDeAccionDeUnidad {
        for (Jugador j : jugadores) {
            if (j.buscarUnidad(atacante) && j.buscarConstruccion(defensor))
                throw new ExcepcionAtacarAUnidadAliada();
            if (j.buscarUnidad(atacante) && j.buscarConstruccion(defensor))
                throw new ExcepcionAtacarAUnidadAliada();
        }
    }
    public static void atacar(UnidadGuerrera atacante,Coordenada coordenada) throws ExcepcionDeAccionDeUnidad {
        Daniable objetivoAereo = (Daniable) ProxyMapa.getInstance().obtenerDeCapaAerea(coordenada);
        Daniable objetivoTerreste = (Daniable) ProxyMapa.getInstance().obtenerDeCapaTerrestre(coordenada);
        if(objetivoAereo!=null){
            atacarAire(atacante,objetivoAereo);
        }
        else if(objetivoTerreste!=null){
            atacarTierra(atacante,objetivoTerreste);
        }
    }
}
