package unidades;

import excepciones.ExcepcionAtacarAUnidadAliada;
import excepciones.ExcepcionObjetivoFueraDeRango;
import jugabilidad.Jugador;
import jugabilidad.ProxyMapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public class ProxiDeAtaque {
    private static Jugador jugador1;
    private static Jugador jugador2;

    public static void inicializar(Jugador j1,Jugador j2){
        jugador1=j1;
        jugador2=j2;
    }

    public static void atacarTierra(UnidadGuerrera atacante,Unidad defensor) throws ExcepcionObjetivoFueraDeRango, ExcepcionAtacarAUnidadAliada {
        ProxiDeAtaque.comprobarRango(atacante, defensor);
        ProxiDeAtaque.comprobarDuenioDeUnidad(atacante,defensor);
        atacante.atacar(defensor);
    }

    public static void atacarAire(UnidadGuerrera atacante,Unidad defensor) throws ExcepcionObjetivoFueraDeRango, ExcepcionAtacarAUnidadAliada {
        ProxiDeAtaque.comprobarRango(atacante, defensor);
        ProxiDeAtaque.comprobarDuenioDeUnidad(atacante,defensor);
        atacante.atacar(defensor);
    }

    public static void comprobarRango(UnidadGuerrera atacante,Unidad defensor) throws ExcepcionObjetivoFueraDeRango {
        ProxyMapa mapa = ProxyMapa.getInstance();
        Coordenadas c1=mapa.getCoordenada(atacante);
        Coordenadas c2=mapa.getCoordenada(defensor);
        if(c1.distacina(c2)> atacante.getRangoAereo()) throw new ExcepcionObjetivoFueraDeRango();

    }
    public static void comprobarDuenioDeUnidad(UnidadGuerrera atacante,Unidad defensor) throws ExcepcionAtacarAUnidadAliada {
        if(jugador1.buscarUnidad(atacante)&& jugador1.buscarUnidad(defensor)) throw new ExcepcionAtacarAUnidadAliada();
        if(jugador2.buscarUnidad(atacante)&& jugador2.buscarUnidad(defensor)) throw new ExcepcionAtacarAUnidadAliada();
    }

}
