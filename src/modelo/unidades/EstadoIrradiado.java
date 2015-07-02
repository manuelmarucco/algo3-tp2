package modelo.unidades;

import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.interfaces.ColocableEnMapa;
import modelo.interfaces.Daniable;
import modelo.jugabilidad.ProxyMapa;
import modelo.jugabilidad.utilidadesMapa.Coordenada;

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