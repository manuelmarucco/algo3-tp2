package unidades;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import interfaces.ColocableEnMapa;
import interfaces.Daniable;
import jugabilidad.ProxyMapa;
import jugabilidad.utilidadesMapa.Coordenada;

import java.util.ArrayList;

public class EstadoIrradiado implements EstadoUnidad {
    @Override
    public void update(ColocableEnMapa daniable) {
        ProxyMapa mapa = ProxyMapa.getInstance();
        Coordenada coordenada=mapa.getCoordenada(daniable);
        try {
            ArrayList<ColocableEnMapa> objetivos = mapa.obtenerUnidadesYConstruccionesEncerradasEnCircunferenciaDe(coordenada, 1);
            for(ColocableEnMapa unidad:objetivos){
                ((Daniable)unidad).recibirDanio(10);
            }
        } catch (ExcepcionNoSePudoAgregarAlMapa excepcionNoSePudoAgregarAlMapa) {
            excepcionNoSePudoAgregarAlMapa.printStackTrace();
        }

    }
}