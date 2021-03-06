package modelo.unidades;

import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.Unidades.ExcepcionDeAccionDeUnidad;
import modelo.excepciones.Unidades.ExcepcionObjetivoFueraDeRango;
import modelo.interfaces.Cargable;
import modelo.interfaces.ColocableEnMapa;
import modelo.interfaces.Hechizable;
import modelo.jugabilidad.Jugador;
import modelo.jugabilidad.ProxyMapa;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.unidades.terrran.NaveCiencia;

import java.util.ArrayList;

public class ProxyDeHechizos {
    private static ArrayList<Jugador> jugadores= new ArrayList<>();

    public static void inicializar(Jugador jugador){
        jugadores.add(jugador);
    }

    public static ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void agregarJugador(Jugador jugador){
        jugadores.add(jugador);
    }

    public static void EMP(NaveCiencia naveCiencia,Coordenada coordenada) throws ExcepcionDeAccionDeUnidad {
        ProxyMapa mapa = ProxyMapa.getInstance();
        if(naveCiencia.getVision()<coordenada.distancia(mapa.getCoordenada(naveCiencia))) throw new ExcepcionObjetivoFueraDeRango();
        /*
        for(int i =-1;i<2;i++){
            for(int j =-1;j<2;j++){

                Coordenada coordenadas =new Coordenada(coordenada.getX()+i, coordenada.getY()+j);
                Hechizable objetivoTerrestre = (Hechizable)mapa.obtenerDeCapaTerrestre(coordenadas);
                if(objetivoTerrestre!=null)
                    naveCiencia.EMP(objetivoTerrestre);
                Hechizable objetivoAereo = (Hechizable)mapa.obtenerDeCapaAerea(coordenadas);
                if(objetivoAereo!=null)
                    naveCiencia.EMP(objetivoAereo);
            }
        }
        */

        // Obtengo todas las unidades alcanzables por el EMP.
        ArrayList<ColocableEnMapa> unidadesYConstruccionesDentroDeRango = new ArrayList<>();

        try {
            unidadesYConstruccionesDentroDeRango = mapa.obtenerUnidadesYConstruccionesEncerradasEnCircunferenciaDe(coordenada, 2);
        } catch (ExcepcionNoSePudoAgregarAlMapa e) {
            e.printStackTrace();
        }

        // Les aplico el EMP.
        for(ColocableEnMapa unidadOConstruccion : unidadesYConstruccionesDentroDeRango ){

            Hechizable objetivo = ((Hechizable) unidadOConstruccion);
            naveCiencia.EMP(objetivo);
        }

    }

    @SuppressWarnings("all")
    public static boolean esEnemigo(Unidad unidadTransporte, Cargable unidad) {
        for(Jugador j: jugadores) {
            if (j.buscarUnidad(unidadTransporte) && j.buscarUnidad(unidad)) return false;
        }
        return true;
    }
    public static Jugador obtenerDuenio(Unidad unidad){
        for(Jugador j: jugadores) {
            if (j.buscarUnidad(unidad)) return j;
        }
        return null;
    }

    public static Jugador obtenerDuenio(ColocableEnMapa objetivo){
        if(objetivo==null) return null;
        for(Jugador j:jugadores) {
            if (j.buscarUnidad(objetivo)) return j;
            if (j.buscarConstruccion(objetivo)) return j;
        }
        return null;
    }
}
