package unidades;

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

    public static void EMP(NaveCiencia nc,Coordenadas c){
        ProxyMapa mapa = ProxyMapa.getInstance();
        for(int i =-1;i<2;i++){
            for(int j =-1;j<2;j++){
                Coordenadas coordenadas =new Coordenadas(c.getX()+i, c.getY()+j);
                Unidad objetivoTerrestre = (Unidad)mapa.obtenerDeCapaTerrestre(coordenadas);
                if(ProxyDeHechizos.esUnidad(objetivoTerrestre))nc.EMP(objetivoTerrestre);
                Unidad objetivoAereo = (Unidad)mapa.obtenerDeCapaTerrestre(coordenadas);
                if(ProxyDeHechizos.esUnidad(objetivoAereo))nc.EMP(objetivoAereo);
                nc.EMP((Unidad)mapa.obtenerDeCapaAerea(coordenadas));//aplicar emp
            }
        }
    }

    public static boolean esUnidad(Object objetivo){
        if(objetivo==null) return false;
        return(!jugador1.buscarConstruccion(objetivo)||!jugador2.buscarConstruccion(objetivo));
    }

}
