package unidades;

import excepciones.Unidades.ExcepcionAtacarAUnidadAliada;
import excepciones.Unidades.ExcepcionObjetivoFueraDeRango;
import interfaces.ColocableEnMapa;
import interfaces.Daniable;
import jugabilidad.Jugador;
import jugabilidad.ProxyMapa;
import jugabilidad.utilidadesMapa.Coordenada;

public class ProxiDeAtaque {
    private static Jugador jugador1;
    private static Jugador jugador2;

    public static void inicializar(Jugador j1,Jugador j2){
        jugador1=j1;
        jugador2=j2;
    }

    public static void atacarTierra(UnidadGuerrera atacante, Daniable defensor) throws ExcepcionObjetivoFueraDeRango, ExcepcionAtacarAUnidadAliada {
        ProxiDeAtaque.comprobarRangoTerrestre(atacante, defensor);
        ProxiDeAtaque.comprobarDuenioDeUnidad(atacante, defensor);
        ProxiDeAtaque.comprobarDuenioDeEdificio(atacante, defensor);
        defensor.recibirDanio(atacante.getDanioTerrestre());
    }

    public static void atacarAire(UnidadGuerrera atacante,Daniable defensor) throws ExcepcionObjetivoFueraDeRango, ExcepcionAtacarAUnidadAliada {
        ProxiDeAtaque.comprobarRangoAereo(atacante, defensor);
        ProxiDeAtaque.comprobarDuenioDeUnidad(atacante, defensor);
        defensor.recibirDanio(atacante.getDanioAereo());
    }

    public static void comprobarRangoAereo(UnidadGuerrera atacante,Daniable defensor) throws ExcepcionObjetivoFueraDeRango {
        ProxyMapa mapa = ProxyMapa.getInstance();
        Coordenada c1=mapa.getCoordenada(atacante);
        Coordenada c2=mapa.getCoordenada((ColocableEnMapa)defensor);
        if(c1.distancia(c2)> atacante.getRangoAereo()) throw new ExcepcionObjetivoFueraDeRango();

    }
    public static void comprobarRangoTerrestre(UnidadGuerrera atacante,Daniable defensor) throws ExcepcionObjetivoFueraDeRango {
        ProxyMapa mapa = ProxyMapa.getInstance();
        Coordenada c1=mapa.getCoordenada(atacante);
        Coordenada c2=mapa.getCoordenada((ColocableEnMapa)defensor);
        if(c1.distancia(c2)> atacante.getRangoTerrestre()) throw new ExcepcionObjetivoFueraDeRango();

    }
    public static void comprobarDuenioDeUnidad(Object atacante,Object defensor) throws ExcepcionAtacarAUnidadAliada {
        if(jugador1.buscarUnidad(atacante)&& jugador1.buscarUnidad(defensor)) throw new ExcepcionAtacarAUnidadAliada();
        if(jugador2.buscarUnidad(atacante)&& jugador2.buscarUnidad(defensor)) throw new ExcepcionAtacarAUnidadAliada();
    }

    public static void comprobarDuenioDeEdificio(Object atacante,Object defensor) throws ExcepcionAtacarAUnidadAliada {
        if(jugador1.buscarUnidad(atacante)&& jugador1.buscarConstruccion(defensor)) throw new ExcepcionAtacarAUnidadAliada();
        if(jugador2.buscarUnidad(atacante)&& jugador2.buscarConstruccion(defensor)) throw new ExcepcionAtacarAUnidadAliada();
    }

    public static void atacar(UnidadGuerrera atacante,Coordenada coordenada) throws ExcepcionAtacarAUnidadAliada, ExcepcionObjetivoFueraDeRango {
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
