package unidades;

import interfaces.ColocableEnMapa;
import interfaces.Daniable;
import jugabilidad.ProxyMapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public class EstadoIrradiado implements EstadoUnidad {
    @Override
    public void update(ColocableEnMapa daniable) {
        ProxyMapa mapa = ProxyMapa.getInstance();
        Coordenadas c=mapa.getCoordenada(daniable);
        for (int i=-1;i<2;i++){
            for (int j=-1;j<2;j++){
                Coordenadas c1 = new Coordenadas(c.getX() + i, c.getY() + j);
                if(mapa.posicionAereaOcupada(c1))
                    ((Daniable)mapa.obtenerDeCapaAerea(c1)).recibirDanio(10);
                if(mapa.posicionTerrestreOcupada(c1))
                    ((Daniable)mapa.obtenerDeCapaTerrestre(c1)).recibirDanio(10);
            }
        }
    }
}