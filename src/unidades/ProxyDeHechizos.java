package unidades;

import excepciones.Unidades.ExcepcionObjetivoFueraDeRango;
import interfaces.Cargable;
import interfaces.Hechizable;
import jugabilidad.Jugador;
import jugabilidad.ProxyMapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.terrran.NaveCiencia;

public class ProxyDeHechizos {
    private static Jugador jugador1;
    private static Jugador jugador2;

    public static void inicializar(Jugador j1,Jugador j2){
        jugador1=j1;
        jugador2=j2;
    }

    public static void EMP(NaveCiencia naveCiencia,Coordenadas coordenada) throws ExcepcionObjetivoFueraDeRango {
        ProxyMapa mapa = ProxyMapa.getInstance();
        if(naveCiencia.getVision()<coordenada.distancia(mapa.getCoordenada(naveCiencia))) throw new ExcepcionObjetivoFueraDeRango();
        for(int i =-1;i<2;i++){
            for(int j =-1;j<2;j++){

                // todo no devolver distintas colecciones para distintas cosas (aereas y terrestres)
                // todo en una segunda iteracion ver como quitar casteo
                Coordenadas coordenadas =new Coordenadas(coordenada.getX()+i, coordenada.getY()+j);
                Hechizable objetivoTerrestre = (Hechizable)mapa.obtenerDeCapaTerrestre(coordenadas);
                if(objetivoTerrestre!=null)
                    naveCiencia.EMP(objetivoTerrestre);
                Hechizable objetivoAereo = (Hechizable)mapa.obtenerDeCapaAerea(coordenadas);
                if(objetivoAereo!=null)
                    naveCiencia.EMP(objetivoAereo);
            }
        }
    }

    public static boolean esEnemigo(Unidad unidadTransporte, Cargable unidad) {
        if(jugador2.buscarUnidad(unidadTransporte)&&jugador2.buscarUnidad(unidad)) return false;
        if(jugador1.buscarUnidad(unidadTransporte)&&jugador1.buscarUnidad(unidad)) return false;
        return true;
    }
}
