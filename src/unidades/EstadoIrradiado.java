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
                ((Daniable)mapa.getAerea(new Coordenadas(c.getX()+i,c.getY()+j))).recibirDanio(d);
                ((Daniable)mapa.getTerrestre(new Coordenadas(c.getX() + i, c.getY() + j))).recibirDanio(d);
            }
        }
    }
}