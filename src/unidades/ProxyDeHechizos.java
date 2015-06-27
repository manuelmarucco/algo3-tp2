package unidades;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.Unidades.ExcepcionObjetivoFueraDeRango;
import interfaces.Cargable;
import interfaces.ColocableEnMapa;
import interfaces.Hechizable;
import jugabilidad.Jugador;
import jugabilidad.ProxyMapa;
import jugabilidad.utilidadesMapa.Coordenada;
import unidades.terrran.NaveCiencia;

import java.util.ArrayList;

public class ProxyDeHechizos {
    private static Jugador jugador1;
    private static Jugador jugador2;

    public static void inicializar(Jugador j1,Jugador j2){
        jugador1=j1;
        jugador2=j2;
    }

    public static void EMP(NaveCiencia naveCiencia,Coordenada coordenada) throws ExcepcionObjetivoFueraDeRango {
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

        // TODO:  Ver si se puede sacar el casteo.

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
        if(jugador2.buscarUnidad(unidadTransporte)&&jugador2.buscarUnidad(unidad)) return false;
        if(jugador1.buscarUnidad(unidadTransporte)&&jugador1.buscarUnidad(unidad)) return false;

        return true;
    }
    public static Jugador obtenerDuenio(Unidad unidad){
        if(jugador1.buscarUnidad(unidad)) return jugador1;
        else return jugador2;
    }
}
