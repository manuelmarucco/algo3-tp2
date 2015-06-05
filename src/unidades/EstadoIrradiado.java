package unidades;

import interfaces.ColocableEnMapa;
import interfaces.Daniable;
import jugabilidad.Mapa;
import jugabilidad.SingletonMapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public class EstadoIrradiado implements Estado {
    @Override
    public void update(ColocableEnMapa daniable) {
        Danio d=new Danio(10, 10, 1, 1);
        Mapa mapa =SingletonMapa.getInstance();
        Coordenadas c=mapa.getCoordenada(daniable);
        for (int i=-1;i<2;i++){
            for (int j=-1;j<2;j++){
                Coordenadas c1 = new Coordenadas(c.getX() + i, c.getY() + j);
                if(mapa.posicionAereaOcupada(c1))
                    ((Daniable)mapa.getAerea(c1)).recibirDanio(d);
                if(mapa.posicionTerrestreOcupada(c1))
                    ((Daniable)mapa.getTerrestre(c1)).recibirDanio(d);
            }
        }
    }
}